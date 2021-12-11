package model;

/**
 *
 * @author gustavo
 */
public class ModelProduto {

    private int proId;
    private String proDescricao;
    private int proQuantidade;
    private double proValor;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public int getProQuantidade() {
        return proQuantidade;
    }

    public void setProQuantidade(int proQuantidade) {
        this.proQuantidade = proQuantidade;
    }

    public double getProValor() {
        return proValor;
    }

    public void setProValor(double proValor) {
        this.proValor = proValor;
    }
}
