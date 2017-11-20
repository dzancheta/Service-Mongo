package pedidoMongo.service;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pedidoMongo.exception.CodigoJaExistente;
import pedidoMongo.exception.ItemNotFound;
import pedidoMongo.model.Item;

/**
 * Created by daniel on 15/08/17.
 */
public class ItemService {

    private MongoDatabase mongoDatabase;

    public ItemService(MongoDatabase mongoDatabase){
        this.mongoDatabase = mongoDatabase;
    }

    public Object findAllItem(){

        return mongoDatabase.getCollection("item").find();
    }

    public Object findByCodigo(String codigo){
            Document test = new Document("codigo", codigo);
            if (mongoDatabase.getCollection("item").find(test).first() == null) throw new ItemNotFound();
            return mongoDatabase.getCollection("item").find(test);
    }

    public Object findByItem(String item){
            Document doc = new Document("nome", item);
            if (mongoDatabase.getCollection("item").find(doc).first() == null) throw new ItemNotFound();
            return mongoDatabase.getCollection("item").find(doc);
    }

    public String insertItem(Item item){
        Document documentoCodigo = new Document("codigo", item.getCodigo());
        validaItemExist(documentoCodigo);
        {
            Document itens = new Document("codigo", item.getCodigo())
                    .append("nome", item.getNome())
                    .append("preco", item.getPreco())
                    .append("categoria", item.getCategoria());
            mongoDatabase.getCollection("item").insertOne(itens);
            if (itens.getObjectId("_id") == null) return "Erro! Cliente não cadastrado!";
            return "Item salvo com sucesso!";
        }
    }
    public String delete(String codigo){
        Document doc = new Document("codigo", codigo);
        if(mongoDatabase.getCollection("item").findOneAndDelete(doc) == null) return "Item Não encontrado!";
        return "Item deletado com sucesso!";
    }

    public String update(String codigo, Item item){
        Document codigoItem = new Document("codigo", codigo);
        validaItemNaoEncontrado(codigoItem);
        {
            Document itemUpdate = new Document("codigo", item.getCodigo())
                    .append("nome", item.getNome())
                    .append("preco", item.getPreco())
                    .append("categoria", item.getCategoria());
            mongoDatabase.getCollection("item").findOneAndUpdate(codigoItem, new Document("$set", new Document(itemUpdate)));
            return "Item atualizado com sucesso!";
        }
    }

    private void validaItemExist(Document codigoItem){
        if (mongoDatabase.getCollection("item").find(codigoItem).first() != null) throw new CodigoJaExistente();
    }

    private void validaItemNaoEncontrado(Document codigoItem){
        if (mongoDatabase.getCollection("item").find(codigoItem).first() == null) throw new ItemNotFound();
    }
}
