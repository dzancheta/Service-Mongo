package pedidoMongo.service;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import pedidoMongo.exception.ClienteJaExistente;
import pedidoMongo.exception.ClienteNotFound;
import pedidoMongo.model.Client;

/**
 * Created by daniel on 14/08/17.
 */
public class ClientService {
    private MongoDatabase mongoDatabase;

    public ClientService(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public Object findAllient(){
        return mongoDatabase.getCollection("cliente").find();
    }

    public Object findCliente(String name, String cpf) {
        Document docName = new Document("firstName", name);
        Document docCpf = new Document("cpf", cpf);
        if (name != null) return mongoDatabase.getCollection("cliente").find(docName);
        return mongoDatabase.getCollection("cliente").find(docCpf);
    }


    public String insert(Client client) {
        validaClienteExist(client.getCpf());
        Document document = new Document("firstName", client.getFirstName())
                    .append("lastName", client.getLastName())
                    .append("cpf", client.getCpf())
                    .append("state", client.getState())
                    .append("city", client.getCity())
                    .append("date", client.getDate());
        mongoDatabase.getCollection("cliente").insertOne(document);
            if (document.getObjectId("_id") == null) return "Erro! Cliente não cadastrado!";
            return "Cliente salvo com sucesso!";
    }

    public String delete(String cpf){
        Document doc = new Document("cpf", cpf);
        if(mongoDatabase.getCollection("cliente").findOneAndDelete(doc) == null) return "Cliente Não encontrado!";
        return "Cliente deletado com sucesso!";
    }

    public String update(String cpf, Client client){
        Document clienteCpf = new Document("cpf", cpf);
        validaClienteNãoExistente(cpf);
        Document clienteUpdate = new Document("firstName", client.getFirstName())
                .append("lastName", client.getLastName())
                .append("cpf", client.getCpf())
                .append("state", client.getState())
                .append("city", client.getCity())
                .append("date", client.getDate());
        mongoDatabase.getCollection("cliente").findOneAndUpdate(clienteCpf, new Document("$set", new Document(clienteUpdate)));
       return "Cliente atualizado com sucesso!";
    }

    private void validaClienteExist(String  cpf){
        if (mongoDatabase.getCollection("cliente")
                .find(new Document("cpf", cpf)).first() != null) throw  new ClienteJaExistente();
    }

    private void validaClienteNãoExistente(String cpf){
        if(mongoDatabase.getCollection("cliente")
                .find(new Document("cpf",cpf)).first() == null) throw new ClienteNotFound();
    }

}


