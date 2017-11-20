package pedidoMongo.model;

/**
 * Created by daniel on 21/08/17.
 */
public class Soma {
    private Double preco;
    private Integer quantidade;

    public Soma(Double preco, Integer quantidade) {
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
