package pedidoMongo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pedidoMongo.exception.ClienteNotFound;
import pedidoMongo.service.ClientService;

/**
 * Created by daniel on 23/08/17.
 */
public class FindClientTest {
    @Autowired
    ClientService clientService;

    @Test(expected = ClienteNotFound.class)
    public void deveRetornarClienteNotFound(){
        String name = "daniel";
        String cpf = "0646";
        clientService.findCliente(name, cpf);
    }
}
