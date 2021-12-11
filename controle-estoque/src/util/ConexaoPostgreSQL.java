package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gustavo
 */
public class ConexaoPostgreSQL {

    private Connection conexao;

    public boolean conectar() {

        try {
            String url = "jdbc:postgresql://localhost/SisEstoque?user=postgres&password=chiquitin123";
            this.conexao = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean desconectar() {
        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Statement criarStatement() {
        try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }

    public PreparedStatement criarPreparedStatement(String pSQL, int RETURN_GENERATED_KEYS) {
        try {
            return conexao.prepareStatement(pSQL, RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Connection getConexao() {
        return this.conexao;
    }

    public PreparedStatement criarPreparedStatement(String sql) {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }
}
