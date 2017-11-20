package pedidoMongo.binder;

import org.bson.Document;
import pedidoMongo.model.Client;
import pedidoMongo.model.Item;
import pedidoMongo.model.Soma;
import pedidoMongo.model.Venda;

import java.util.List;

/**
 * Created by daniel on 16/08/17.
 */
public class Binders {

    public static Document binderItem(Item recebeItem) {
        return new Document("nome", recebeItem.getNome())
                .append("preco", recebeItem.getPreco())
                .append("categoria", recebeItem.getCategoria())
                .append("codigo", recebeItem.getCodigo())
                .append("quantidade", recebeItem.getQuantidade());
    }

    public static Client binderClient(Document cliente) {
        Client client = new Client();
        client.setFirstName(cliente.getString("firstName").toString());
        client.setLastName(cliente.getString("lastName").toString());
        client.setCpf(cliente.getString("cpf").toString());
        client.setState(cliente.getString("state").toString());
        client.setCity(cliente.getString("city").toString());
        return client;
    }

    public static Soma bonderSoma(List<Item> listaItem){
        Soma soma = new Soma(listaItem.get(1).getPreco(), listaItem.get(1).getQuantidade());
        return soma;
    }

    public static Document binderVenda(Venda recebeVenda){
        return new Document("cpf", recebeVenda.getClient().getCpf())
                .append("firstName", recebeVenda.getClient().getFirstName())
                .append("lastName", recebeVenda.getClient().getLastName())
                .append("formaPagamneto", recebeVenda.getFormaPagamento())
                .append("troco", recebeVenda.getTroco())
                .append("valorTotal", recebeVenda.getValorTotal());
    }

    public static Document binderDatavenda(Venda venda){
        return new Document("dia", venda.getDia())
        .append("mes", venda.getMes())
        .append("ano", venda.getAno());
    }
}
