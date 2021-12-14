package sistema;

import java.util.ResourceBundle;

/**
 *
 * @author gustavo
 */
public class Mensagens {

    private static final ResourceBundle MENSAGENS_SISTEMA = ResourceBundle.getBundle("sistema.mensagens");

    public static String getMessage(String mensagem) {
        if (MENSAGENS_SISTEMA.containsKey(mensagem)) {
            return MENSAGENS_SISTEMA.getString(mensagem);
        }
        return "";
    }
}
