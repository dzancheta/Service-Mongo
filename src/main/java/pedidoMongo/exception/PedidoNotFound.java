package pedidoMongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by daniel on 23/08/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidoNotFound extends RuntimeException{
    public PedidoNotFound(){
        super("Nenhum pedido encontrado pro cliente!");
    }
}
