package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Formatador {
    
    public double converterVirgulaParaPonto(String pString) {
        String retorno = new String();
        int tamanhoString = pString.length();
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == ',') {
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return Double.parseDouble(retorno);
    }
    
    public java.sql.Date formatarData(Date pData) throws Exception {
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = formatarDate.format(pData);
        if (pData == null || pData.equals("")) {
            return null;
        }
        
        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date(((java.util.Date) formatter.parse(dataString)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    
    public String formatarDataBR(Date pData) {
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatarDate.format(pData);
    }
}
