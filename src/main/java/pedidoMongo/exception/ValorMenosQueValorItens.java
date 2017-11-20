package pedidoMongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by daniel on 21/08/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ValorMenosQueValorItens extends RuntimeException{
    public ValorMenosQueValorItens(){
        super("Forma de pagamento menor que valor total de itens!!!");
    }
}
