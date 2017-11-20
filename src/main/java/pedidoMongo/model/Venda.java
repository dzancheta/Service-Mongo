package pedidoMongo.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by daniel on 15/08/17.
 */
public class Venda {
    private Client client;
    private List<Item> itens;
    private Double formaPagamento;
    private Double troco;
    private Double valorTotal;
    private Integer dia = LocalDate.now().getDayOfMonth();
    private Integer mes = LocalDate.now().getMonthValue();
    private Integer ano = LocalDate.now().getYear();

    public Venda(Client client, List<Item> itens, Double formaPagamento, Double troco, Double valorTotal) {
        this.client = client;
        this.itens = itens;
        this.formaPagamento = formaPagamento;
        this.troco = troco;
        this.valorTotal = valorTotal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

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

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }
}
