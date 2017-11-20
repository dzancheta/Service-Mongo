package pedidoMongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by daniel on 15/08/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFound extends RuntimeException{
    public ItemNotFound(){
        super("Item não encontrado!");
    }
}
