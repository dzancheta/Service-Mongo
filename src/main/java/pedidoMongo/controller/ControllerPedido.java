package pedidoMongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pedidoMongo.model.ContratoFront;
import pedidoMongo.model.Venda;
import pedidoMongo.service.PedidoService;

/**
 * Created by daniel on 14/08/17.
 */
@RestController
public class ControllerPedido {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("pedidoMongo/geraPedido")
    public Venda venda(@RequestParam(value = "cpf")String cpf,
                       @RequestBody ContratoFront codigoItens){
        return pedidoService.geraPedido(cpf, codigoItens);
    }
    @GetMapping("pedidoMongo/findPedidoByCpf")
    public Object pedido(@RequestParam(value = "cpf")String cpf){
        return pedidoService.findPedidoByCpf(cpf);
    }

    @GetMapping("pedidoMongo/findPedido")
    public Object pedido() {
        return pedidoService.findPedido();
    }
}