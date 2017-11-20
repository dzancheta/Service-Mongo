package pedidoMongo.facade;

import pedidoMongo.model.ContratoFront;
import pedidoMongo.model.Item;
import pedidoMongo.model.Venda;
import pedidoMongo.service.ItemService;
import pedidoMongo.service.PedidoService;

/**
 * Created by daniel on 15/08/17.
 */
public class FacadeItem {

private ItemService itemService;
    private PedidoService pedidoService;

    public FacadeItem(PedidoService pedidoService, ItemService itemService) {
        this.itemService = itemService;
        this.pedidoService = pedidoService;
    }
    public Object findAllItem(){
        return itemService.findAllItem();
    }
    public Object findItem(String codigo, String item){
        if(item != null)
            return itemService.findByItem(item);
        else return itemService.findByCodigo(codigo);
    }
    public String insertItem(Item item){
        return itemService.insertItem(item);
    }
    public String deleteItem(String codigo){
        return itemService.delete(codigo);
    }
    public String updateItem(String codigo, Item item){
        return itemService.update(codigo, item);
    }
    public Venda venda(String cpf, ContratoFront codigoItens){
        return pedidoService.geraPedido(cpf, codigoItens);
    }
}
