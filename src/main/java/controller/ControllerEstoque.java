/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOEstoque;
import model.ModelEstoque;

/**
 *
 * @author gustavo
 */
public class ControllerEstoque {

    DAOEstoque dAOEstoque = new DAOEstoque();

    /**
     * Registar movimentação do estoque
     *
     * @param modelEstoque
     * @return
     */
    public boolean salvarEstoqueController(ModelEstoque modelEstoque) {
        return this.dAOEstoque.salvarEstoqueDAO(modelEstoque);
    }
}
