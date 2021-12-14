package controller;

import DAO.DAOEstoqueProdutoUsuario;
import java.util.ArrayList;
import model.ModelEstoqueProdutoUsuario;

/**
 *
 * @author gustavo
 */
public class ControllerEstoqueProdutoUsuario {

    DAOEstoqueProdutoUsuario dAOEstoqueProdutoUsuario = new DAOEstoqueProdutoUsuario();

    public ArrayList<ModelEstoqueProdutoUsuario> getListaEstoqueController() {
        return this.dAOEstoqueProdutoUsuario.getListaEstoqueDAO();
    }

    public ArrayList<ModelEstoqueProdutoUsuario> getListaEstoqueController(int pTipoMov) {
        return this.dAOEstoqueProdutoUsuario.getListaEstoqueDAO(pTipoMov);
    }

    public boolean produtoEstaNoEstoqueController(int produtoId) {
        return this.dAOEstoqueProdutoUsuario.produtoEstaNoEstoqueDAO(produtoId);
    }
}
