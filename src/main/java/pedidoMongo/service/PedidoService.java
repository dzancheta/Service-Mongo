package pedidoMongo.service;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pedidoMongo.binder.Binders;
import pedidoMongo.exception.PedidoNotFound;
import pedidoMongo.exception.ValorMenosQueValorItens;
import pedidoMongo.model.Client;
import pedidoMongo.model.ContratoFront;
import pedidoMongo.model.Item;
import pedidoMongo.model.Venda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by daniel on 16/08/17.
 */
public class PedidoService {
    private MongoDatabase mongoDatabase;

    public PedidoService(MongoDatabase mongoDatabase){
        this.mongoDatabase = mongoDatabase;
    }

    public Venda geraPedido(String cpf, ContratoFront contratoFront) {
        Document documentCliente = new Document("cpf", cpf);
        Document documentBinderClient = mongoDatabase.getCollection("cliente").find(documentCliente).first();
        Client montaClient =  Binders.binderClient(documentBinderClient);
        List<Item> montaListaItem = contratoFront.getItens();
        Double valorItens = montaListaItem.stream().mapToDouble(i -> i.getPreco() * i.getQuantidade()).sum();
        Double formaPagamento = contratoFront.getFormaPagamento();
        if(valorItens > formaPagamento)throw new ValorMenosQueValorItens();
        BigDecimal bigDecimal = new BigDecimal(formaPagamento - valorItens).setScale(2, BigDecimal.ROUND_HALF_UP);
        Venda pedidoFinal = new Venda(montaClient, montaListaItem, formaPagamento, bigDecimal.doubleValue(), valorItens);
        Binders.binderDatavenda(pedidoFinal);
        salvaPedido(pedidoFinal);
        return pedidoFinal;
    }

    private String salvaPedido(Venda venda){
        Document pedido = new Document(Binders.binderVenda(venda))
                .append("date", Binders.binderDatavenda(venda))
                .append("itens", Arrays.asList(venda.getItens().stream().map(Binders::binderItem).toArray()));
        mongoDatabase.getCollection("pedido").insertOne(pedido);
        return "ok";
    }

    public Object findPedidoByCpf(String cpf){
        Document documentoCpf = new Document("cpf", cpf);
        if(mongoDatabase.getCollection("pedido").find(documentoCpf).first() == null)throw new PedidoNotFound();
        return mongoDatabase.getCollection("pedido").find(documentoCpf);
    }

    public Object findPedido(){
        return mongoDatabase.getCollection("pedido").find();
    }
}