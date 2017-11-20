package pedidoMongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by daniel on 15/08/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CpfExistente extends RuntimeException{
    public CpfExistente(){super("Cpf ja existente!");}
}
