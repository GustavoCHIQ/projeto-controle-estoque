package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ModelProduto;
import util.ConexaoPostgreSQL;

/**
 *
 * @author gustavo
 */
public class DAOProduto extends ConexaoPostgreSQL {

    public ArrayList<ModelProduto> getListaProdutosDAO() {
        ModelProduto modelProduto = new ModelProduto();
        ArrayList<ModelProduto> listaModelProdutos = new ArrayList<>();
        this.conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT "
                + "pk_pro_id, "
                + "pro_descricao, "
                + "pro_quantidade, "
                + "pro_valor "
                + " FROM tbl_produto";
        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelProduto = new ModelProduto();
                modelProduto.setProId(resultSet.getInt("pk_pro_id"));
                modelProduto.setProDescricao(resultSet.getString("pro_descricao"));
                modelProduto.setProQuantidade(resultSet.getInt("pro_quantidade"));
                modelProduto.setProValor(resultSet.getDouble("pro_valor"));
                listaModelProdutos.add(modelProduto);
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
        return listaModelProdutos;
    }

    public boolean salvarProdutoDAO(ModelProduto pModelProduto) {
        this.conectar();
        String sql
                = "INSERT "
                + " INTO tbl_produto ("
                + "pro_descricao,"
                + "pro_quantidade,"
                + "pro_valor "
                + ") VALUES (?,?,?);";

        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelProduto.getProDescricao());
            preparedStatement.setInt(2, pModelProduto.getProQuantidade());
            preparedStatement.setDouble(3, pModelProduto.getProValor());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
        }
        this.desconectar();
        return true;
    }

    public boolean alterarProdutoDAO(ModelProduto modelProduto) {
        this.conectar();
        String sql
                = "UPDATE tbl_produto"
                + " SET "
                + "pro_descricao = ?, "
                + "pro_valor = ? "
                + "WHERE pk_pro_id = '" + modelProduto.getProId() + "';";

        PreparedStatement preparedStatement = this.criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, modelProduto.getProDescricao());
            preparedStatement.setDouble(2, modelProduto.getProValor());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
        }
        this.desconectar();
        return true;
    }

    public ModelProduto getProdutoDAO(int codigoProduto) {
        ModelProduto modelProduto = new ModelProduto();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_pro_id, "
                + "pro_descricao, "
                + "pro_quantidade, "
                + "pro_valor "
                + " FROM tbl_produto "
                + " WHERE pk_pro_id = '" + codigoProduto + "'";

        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelProduto = new ModelProduto();
                modelProduto.setProId(resultSet.getInt("pk_pro_id"));
                modelProduto.setProDescricao(resultSet.getString("pro_descricao"));
                modelProduto.setProQuantidade(resultSet.getInt("pro_quantidade"));
                modelProduto.setProValor(resultSet.getDouble("pro_valor"));
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
        return modelProduto;
    }

    public ModelProduto getProdutoDAO(String pDescricao) {
        ModelProduto modelProduto = new ModelProduto();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_pro_id, "
                + "pro_descricao, "
                + "pro_quantidade, "
                + "pro_valor "
                + " FROM tbl_produto "
                + " WHERE pro_descricao = '" + pDescricao + "'";

        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelProduto = new ModelProduto();
                modelProduto.setProId(resultSet.getInt("pk_pro_id"));
                modelProduto.setProDescricao(resultSet.getString("pro_descricao"));
                modelProduto.setProQuantidade(resultSet.getInt("pro_quantidade"));
                modelProduto.setProValor(resultSet.getDouble("pro_valor"));
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
        return modelProduto;
    }

    public boolean excluirProdutoDAO(int codigoProduto) {
        this.conectar();
        String sql = "DELETE FROM tbl_produto WHERE pk_pro_id = '" + codigoProduto + "';";
        PreparedStatement preparedStatement = this.criarPreparedStatement(sql, Statement.NO_GENERATED_KEYS);

        try {
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
        }
        this.desconectar();
        return true;
    }
}
