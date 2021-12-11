package controller;

import DAO.DAOProduto;
import java.util.ArrayList;
import model.ModelProduto;

/**
 *
 * @author gustavo
 */
public class ControllerProduto {

    private final DAOProduto daoProduto = new DAOProduto();

    public ArrayList<ModelProduto> getListaProdutoController() {
        return this.daoProduto.getListaProdutosDAO();
    }

    public boolean salvarProdutoController(ModelProduto modelProduto) {
        return this.daoProduto.salvarProdutoDAO(modelProduto);
    }

    public boolean alterarProdutoController(ModelProduto modelProduto) {
        return this.daoProduto.alterarProdutoDAO(modelProduto);
    }

    public ModelProduto getProdutoController(int codigoProduto) {
        return this.daoProduto.getProdutoDAO(codigoProduto);
    }

    public ModelProduto getProdutoController(String pDescricao) {
        return this.daoProduto.getProdutoDAO(pDescricao);
    }

    public boolean excluirProdutoController(int codigoProduto) {
        return this.daoProduto.excluirProdutoDAO(codigoProduto);
    }

    public boolean validarProdutoFormController(ModelProduto modelProduto) {
        if (null == modelProduto) {
            return false;
        }
        if (null == modelProduto.getProDescricao() || modelProduto.getProDescricao().isEmpty()) {
            return false;
        }
        if (modelProduto.getProValor() < 0) {
            return false;
        }
        if (modelProduto.getProQuantidade() < 0) {
            return false;
        }
        return true;
    }

}
