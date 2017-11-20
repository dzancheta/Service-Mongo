package pedidoMongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pedidoMongo.model.Client;
import pedidoMongo.service.ClientService;

/**
 * Created by daniel on 16/08/17.
 */
@RestController
public class ControllerClient {

    @Autowired
    private ClientService clientService;

    @GetMapping("pedidoMongo/findAllClient")
    public Object getall(){
        return clientService.findAllient();
    }
    @GetMapping("pedidoMongo/findClient")
    public Object getClient(@RequestParam(value = "name", required = false)String name,
                            @RequestParam(value = "cpf", required = false)String cpf){
        return clientService.findCliente(name, cpf);
    }
    @PostMapping("pedidoMongo/insertClient")
    public String insertClient(@RequestBody Client client){
        return clientService.insert(client);
    }
    @DeleteMapping("pedidoMongo/deleteCliente")
    public String deleteCliente(@RequestParam(value = "cpf")String cpf){
        return clientService.delete(cpf);
    }
    @PutMapping("pedidoMongo/updateCliente")
    public String updateCliente(@RequestParam(value = "cpfCliente")String cpf,
                                @RequestBody Client client){
        return clientService.update(cpf, client);
    }
}
