package pedidoMongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by daniel on 16/08/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteJaExistente extends RuntimeException{
    public ClienteJaExistente(){
        super("CPF de Cliente ja existente!");
    }

}
