package controller;

import DAO.DAOUsuario;
import java.util.ArrayList;
import model.ModelUsuario;

/**
 *
 * @author gustavo
 */
public class ControllerUsuario {

    private final DAOUsuario DAO_USUARIO = new DAOUsuario();

    public ArrayList<ModelUsuario> getListaUsuarioController() {
        return this.DAO_USUARIO.getListaUsuarioDAO();
    }

    public boolean salvarUsuarioController(ModelUsuario pModelUsuario) {

        ModelUsuario usuarioATestar = this.DAO_USUARIO.getUsuarioDAO(pModelUsuario.getUsuLogin());

        if (null == usuarioATestar) {
            return this.DAO_USUARIO.salvarUsuarioDAO(pModelUsuario);
        }
        return false;
    }

    public boolean atualizarUsuarioController(ModelUsuario modelUsuario) {
        return this.DAO_USUARIO.atualizarUsuarioDAO(modelUsuario);
    }

    public ModelUsuario getUsuarioController(int codigoUsuario) {
        return this.DAO_USUARIO.getUsuarioDAO(codigoUsuario);
    }

    public ModelUsuario getUsuarioController(String pLogin) {
        return this.DAO_USUARIO.getUsuarioDAO(pLogin);
    }

    public boolean excluirUsuarioController(int codigoUsuario) {
        return this.DAO_USUARIO.excluirUsuarioDAO(codigoUsuario);
    }

    public boolean validarUsuarioController(ModelUsuario modelUsuario) {
        return this.DAO_USUARIO.validarUsuarioDAO(modelUsuario);
    }

    public boolean validarUsuarioFormController(ModelUsuario modelUsuario) {
        if (null == modelUsuario) {
            return false;
        }

        if (null == modelUsuario.getUsuLogin() || modelUsuario.getUsuLogin().isEmpty()) {
            return false;
        }

        if (null == modelUsuario.getUsuSenha() || modelUsuario.getUsuSenha().isEmpty()) {
            return false;
        }
        return true;
    }
}
