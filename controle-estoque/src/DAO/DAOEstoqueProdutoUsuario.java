package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ModelEstoque;
import model.ModelEstoqueProdutoUsuario;
import model.ModelProduto;
import model.ModelUsuario;
import util.ConexaoPostgreSQL;

/**
 *
 * @author gustavo
 */
public class DAOEstoqueProdutoUsuario extends ConexaoPostgreSQL {

    public ArrayList<ModelEstoqueProdutoUsuario> getListaEstoqueDAO() {
        ModelProduto modelProduto = new ModelProduto();
        ModelUsuario modelUsuario = new ModelUsuario();
        ModelEstoque modelEstoque = new ModelEstoque();
        ModelEstoqueProdutoUsuario modelEstoqueProdutoUsuario = new ModelEstoqueProdutoUsuario();
        ArrayList<ModelEstoqueProdutoUsuario> listaModelEstoqueProdutoUsuarios = new ArrayList<>();
        this.conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT "
                + "tbl_estoque.pk_est_id, "
                + "tbl_estoque.est_quantidade, "
                + "tbl_estoque.est_preco, "
                + "tbl_estoque.est_data,"
                + "tbl_estoque.est_tipo_mov,"
                + "tbl_produto.pk_pro_id,"
                + "tbl_produto.pro_descricao,"
                + "tbl_produto.pro_quantidade,"
                + "tbl_produto.pro_valor,"
                + "tbl_usuario.pk_usu_id,"
                + "tbl_usuario.usu_nome,"
                + "tbl_usuario.usu_login,"
                + "tbl_usuario.usu_senha "
                + " FROM tbl_estoque INNER JOIN tbl_produto ON tbl_produto.pk_pro_id = tbl_estoque.fk_pro_id "
                + " INNER JOIN tbl_usuario on tbl_usuario.pk_usu_id = tbl_estoque.fk_uso_id "
                + ";";
        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelProduto = new ModelProduto();
                modelUsuario = new ModelUsuario();
                modelEstoque = new ModelEstoque();
                modelEstoqueProdutoUsuario = new ModelEstoqueProdutoUsuario();
                modelEstoque.setEstId(resultSet.getInt(1));
                modelEstoque.setEstQuantidade(resultSet.getInt(2));
                modelEstoque.setEstPreco(resultSet.getDouble(3));
                modelEstoque.setEstData(resultSet.getDate(4));
                modelEstoque.setEstTipoMov(resultSet.getInt(5));
                modelProduto.setProId(resultSet.getInt(6));
                modelProduto.setProDescricao(resultSet.getString(7));
                modelProduto.setProQuantidade(resultSet.getInt(8));
                modelProduto.setProValor(resultSet.getDouble(9));
                modelUsuario.setUsuId(resultSet.getInt(10));
                modelUsuario.setUsuNome(resultSet.getString(11));
                modelUsuario.setUsuLogin(resultSet.getString(12));
                modelUsuario.setUsuSenha(resultSet.getString(13));
                modelEstoqueProdutoUsuario.setModelProduto(modelProduto);
                modelEstoqueProdutoUsuario.setModelUsuario(modelUsuario);
                modelEstoqueProdutoUsuario.setModelEstoque(modelEstoque);
                listaModelEstoqueProdutoUsuarios.add(modelEstoqueProdutoUsuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaModelEstoqueProdutoUsuarios;
    }

    public ArrayList<ModelEstoqueProdutoUsuario> getListaEstoqueDAO(int pTipoMov) {
        ModelProduto modelProduto = new ModelProduto();
        ModelUsuario modelUsuario = new ModelUsuario();
        ModelEstoque modelEstoque = new ModelEstoque();
        ModelEstoqueProdutoUsuario modelEstoqueProdutoUsuario = new ModelEstoqueProdutoUsuario();
        ArrayList<ModelEstoqueProdutoUsuario> listaModelEstoqueProdutoUsuarios = new ArrayList<>();
        this.conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT "
                + "tbl_estoque.pk_est_id, "
                + "tbl_estoque.est_quantidade, "
                + "tbl_estoque.est_preco, "
                + "tbl_estoque.est_data,"
                + "tbl_estoque.est_tipo_mov,"
                + "tbl_produto.pk_pro_id,"
                + "tbl_produto.pro_descricao,"
                + "tbl_produto.pro_quantidade,"
                + "tbl_produto.pro_valor,"
                + "tbl_usuario.pk_usu_id,"
                + "tbl_usuario.usu_nome,"
                + "tbl_usuario.usu_login,"
                + "tbl_usuario.usu_senha "
                + " FROM tbl_estoque INNER JOIN tbl_produto ON tbl_produto.pk_pro_id = tbl_estoque.fk_pro_id "
                + " INNER JOIN tbl_usuario on tbl_usuario.pk_usu_id = tbl_estoque.fk_uso_id "
                + " WHERE tbl_estoque.est_tipo_mov = '" + pTipoMov + "';";
        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelProduto = new ModelProduto();
                modelUsuario = new ModelUsuario();
                modelEstoque = new ModelEstoque();
                modelEstoqueProdutoUsuario = new ModelEstoqueProdutoUsuario();
                modelEstoque.setEstId(resultSet.getInt(1));
                modelEstoque.setEstQuantidade(resultSet.getInt(2));
                modelEstoque.setEstPreco(resultSet.getDouble(3));
                modelEstoque.setEstData(resultSet.getDate(4));
                modelEstoque.setEstTipoMov(resultSet.getInt(5));
                modelProduto.setProId(resultSet.getInt(6));
                modelProduto.setProDescricao(resultSet.getString(7));
                modelProduto.setProQuantidade(resultSet.getInt(8));
                modelProduto.setProValor(resultSet.getDouble(9));
                modelUsuario.setUsuId(resultSet.getInt(10));
                modelUsuario.setUsuNome(resultSet.getString(11));
                modelUsuario.setUsuLogin(resultSet.getString(12));
                modelUsuario.setUsuSenha(resultSet.getString(13));
                modelEstoqueProdutoUsuario.setModelProduto(modelProduto);
                modelEstoqueProdutoUsuario.setModelUsuario(modelUsuario);
                modelEstoqueProdutoUsuario.setModelEstoque(modelEstoque);
                listaModelEstoqueProdutoUsuarios.add(modelEstoqueProdutoUsuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaModelEstoqueProdutoUsuarios;
    }

    public boolean produtoEstaNoEstoqueDAO(int produtoId) {
        int produtosEncontrados = 0;
        this.conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT "
                + " tbl_estoque.pk_est_id"
                + " FROM tbl_estoque"
                + " INNER JOIN tbl_produto ON tbl_produto.pk_pro_id = tbl_estoque.fk_pro_id "
                + " INNER JOIN tbl_usuario on tbl_usuario.pk_usu_id = tbl_estoque.fk_uso_id "
                + " WHERE tbl_produto.pk_pro_id = '" + produtoId + "';";

        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                produtosEncontrados++;
                break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != resultSet) {
                    resultSet.close();
                    preparedStatement.close();
                }
                desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        if (produtosEncontrados > 0) {
            return true;
        }
        return false;
    }
}
