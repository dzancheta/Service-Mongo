package pedidoMongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pedidoMongo.facade.FacadeItem;
import pedidoMongo.model.Item;

/**
 * Created by daniel on 14/08/17.
 */
@RestController
public class ControllerItem {
    @Autowired
    private FacadeItem facadeItem;

    @GetMapping("pedidoMongo/findAllItem")
    public Object gteAllItem(){
        return facadeItem.findAllItem();
    }

    @GetMapping("pedidoMongo/findItem")
    public Object getItem(@RequestParam(value = "item", required = false)String item,
                          @RequestParam(value = "codigo", required = false)String codigo){
        return facadeItem.findItem(codigo, item);
    }

    @PostMapping("pedidoMongo/insertItem")
    public String insertItem(@RequestBody Item item){
        return facadeItem.insertItem(item);
    }

    @DeleteMapping("pedidoMongo/deleteItem")
    public String deleteItem(@RequestParam(value = "codigo")String codigo){
        return facadeItem.deleteItem(codigo);
    }

    @PutMapping("pedidoMongo/updateItem")
    public String updateItem(@RequestParam(value = "codigo")String codigo,
                             @RequestBody Item item){
        return facadeItem.updateItem(codigo, item);
    }
}
