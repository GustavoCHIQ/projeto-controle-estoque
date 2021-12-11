package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ModelUsuario;
import util.ConexaoPostgreSQL;

/**
 *
 * @author gustavo
 */

public class DAOUsuario extends ConexaoPostgreSQL {

    public ArrayList<ModelUsuario> getListaUsuarioDAO() {
        ModelUsuario modelUsuario = new ModelUsuario();
        ArrayList<ModelUsuario> listaModelUsuarios = new ArrayList<>();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_usu_id, "
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha "
                + " FROM tbl_usuario";

        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setUsuId(resultSet.getInt("pk_usu_id"));
                modelUsuario.setUsuNome(resultSet.getString("usu_nome"));
                modelUsuario.setUsuLogin(resultSet.getString("usu_login"));
                modelUsuario.setUsuSenha(resultSet.getString("usu_senha"));
                listaModelUsuarios.add(modelUsuario);
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
        return listaModelUsuarios;
    }

    public boolean salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        this.conectar();

        String sql
                = "INSERT "
                + " INTO tbl_usuario ("
                + "usu_nome,"
                + "usu_login,"
                + "usu_senha "
                + ") VALUES (?,?,?);";

        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelUsuario.getUsuNome());
            preparedStatement.setString(2, pModelUsuario.getUsuLogin());
            preparedStatement.setString(3, pModelUsuario.getUsuSenha());
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

    public boolean atualizarUsuarioDAO(ModelUsuario modelUsuario) {
        this.conectar();
        String sql
                = "UPDATE tbl_usuario"
                + " SET "
                + "usu_nome = ?, "
                + "usu_senha = ? "
                + "WHERE pk_usu_id = '" + modelUsuario.getUsuId() + "';";

        PreparedStatement preparedStatement = this.criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, modelUsuario.getUsuNome());
            preparedStatement.setString(2, modelUsuario.getUsuSenha());
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

    public ModelUsuario getUsuarioDAO(int codigo) {
        ModelUsuario modelUsuario = new ModelUsuario();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_usu_id, "
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha "
                + " FROM tbl_usuario "
                + " WHERE pk_usu_id = '" + codigo + "'";

        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setUsuId(resultSet.getInt("pk_usu_id"));
                modelUsuario.setUsuNome(resultSet.getString("usu_nome"));
                modelUsuario.setUsuLogin(resultSet.getString("usu_login"));
                modelUsuario.setUsuSenha(resultSet.getString("usu_senha"));
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
        return modelUsuario;
    }

    public ModelUsuario getUsuarioDAO(String pLogin) {
        ModelUsuario modelUsuario = null;
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_usu_id, "
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha "
                + " FROM tbl_usuario "
                + " WHERE usu_login = '" + pLogin + "'";

        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setUsuId(resultSet.getInt("pk_usu_id"));
                modelUsuario.setUsuNome(resultSet.getString("usu_nome"));
                modelUsuario.setUsuLogin(resultSet.getString("usu_login"));
                modelUsuario.setUsuSenha(resultSet.getString("usu_senha"));
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
        return modelUsuario;
    }

    public boolean excluirUsuarioDAO(int codigoUsuario) {
        conectar();
        String sql = "DELETE FROM tbl_usuario WHERE pk_usu_id = '" + codigoUsuario + "';";
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

    public boolean validarUsuarioDAO(ModelUsuario modelUsuario) {
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT "
                + "pk_usu_id,"
                + "usu_nome,"
                + "usu_login,"
                + "usu_senha"
                + " FROM"
                + " tbl_usuario"
                + " WHERE"
                + " usu_login = '" + modelUsuario.getUsuLogin() + "' AND usu_senha = '" + modelUsuario.getUsuSenha() + "'"
                + ";";

        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
