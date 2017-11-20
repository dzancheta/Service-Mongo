package pedidoMongo.model;

import java.util.List;

/**
 * Created by daniel on 21/08/17.
 */
public class ContratoFront {
    private List<Item> itens;
    private Double formaPagamento;

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Double getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Double formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
