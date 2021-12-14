package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.ModelEstoque;
import util.ConexaoPostgreSQL;

/**
 *
 * @author gustavo
 */
public class DAOEstoque extends ConexaoPostgreSQL {

    public boolean salvarEstoqueDAO(ModelEstoque modelEstoque) {
        this.conectar();
        String sql
                = "INSERT "
                + " INTO tbl_estoque ("
                + "est_quantidade,"
                + "est_preco,"
                + "fk_uso_id,"
                + "fk_pro_id,"
                + "est_data,"
                + "est_tipo_mov "
                + ") VALUES (?,?,?,?,?,?);";

        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setInt(1, modelEstoque.getEstQuantidade());
            preparedStatement.setDouble(2, modelEstoque.getEstPreco());
            preparedStatement.setInt(3, modelEstoque.getEstIdUsu());
            preparedStatement.setInt(4, modelEstoque.getEstIdProd());
            preparedStatement.setDate(5, (Date) modelEstoque.getEstData());
            preparedStatement.setInt(6, modelEstoque.getEstTipoMov());
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
