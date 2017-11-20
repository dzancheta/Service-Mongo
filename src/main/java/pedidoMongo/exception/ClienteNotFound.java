package pedidoMongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by daniel on 15/08/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClienteNotFound extends RuntimeException{
    public ClienteNotFound(){super("Cliente não encontrado!");}
}
