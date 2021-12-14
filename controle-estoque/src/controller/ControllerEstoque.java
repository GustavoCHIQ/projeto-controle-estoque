package controller;

import DAO.DAOEstoque;
import model.ModelEstoque;

/**
 *
 * @author gustavo
 */
public class ControllerEstoque {

    DAOEstoque dAOEstoque = new DAOEstoque();

    public boolean salvarEstoqueController(ModelEstoque modelEstoque) {
        return this.dAOEstoque.salvarEstoqueDAO(modelEstoque);
    }
}
