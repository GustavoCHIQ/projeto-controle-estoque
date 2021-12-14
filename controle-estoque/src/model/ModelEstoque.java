package model;

import java.util.Date;

/**
 *
 * @author gustavo
 */
public class ModelEstoque {

    private int estId;
    private int estQuantidade;
    private double estPreco;
    private int estTipoMov;
    private Date estData;
    private int estIdProd;
    private int estIdUsu;

    public int getEstId() {
        return estId;
    }

    public void setEstId(int estId) {
        this.estId = estId;
    }

    public int getEstQuantidade() {
        return estQuantidade;
    }

    public void setEstQuantidade(int estQuantidade) {
        this.estQuantidade = estQuantidade;
    }

    public double getEstPreco() {
        return estPreco;
    }

    public void setEstPreco(double estPreco) {
        this.estPreco = estPreco;
    }

    public int getEstTipoMov() {
        return estTipoMov;
    }

    public void setEstTipoMov(int estTipoMov) {
        this.estTipoMov = estTipoMov;
    }

    public Date getEstData() {
        return estData;
    }

    public void setEstData(Date estData) {
        this.estData = estData;
    }

    public int getEstIdProd() {
        return estIdProd;
    }

    public void setEstIdProd(int estIdProd) {
        this.estIdProd = estIdProd;
    }

    public int getEstIdUsu() {
        return estIdUsu;
    }

    public void setEstIdUsu(int estIdUsu) {
        this.estIdUsu = estIdUsu;
    }

}
