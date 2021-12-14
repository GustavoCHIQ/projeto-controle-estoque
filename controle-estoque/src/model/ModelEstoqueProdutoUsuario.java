package model;

/**
 *
 * @author gustavo
 */
public class ModelEstoqueProdutoUsuario {
    
    private ModelEstoque modelEstoque;
    private ModelProduto modelProduto;
    private ModelUsuario modelUsuario;

    public ModelEstoque getModelEstoque() {
        return modelEstoque;
    }

    public void setModelEstoque(ModelEstoque modelEstoque) {
        this.modelEstoque = modelEstoque;
    }

    public ModelProduto getModelProduto() {
        return modelProduto;
    }

    public void setModelProduto(ModelProduto modelProduto) {
        this.modelProduto = modelProduto;
    }

    public ModelUsuario getModelUsuario() {
        return modelUsuario;
    }

    public void setModelUsuario(ModelUsuario modelUsuario) {
        this.modelUsuario = modelUsuario;
    } 
}
