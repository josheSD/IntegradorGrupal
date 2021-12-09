
package vista;

import java.util.ArrayList;
import java.util.List;

public class VentaPresentador {
    
    private String msg = "";
    private String tipoAccion = "";
    private Object[] venta = {"","","","","","","","","",""};
    private List listaVenta = new ArrayList();

    public VentaPresentador(){}

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public Object[] getVenta() {
        return venta;
    }

    public void setVenta(Object[] venta) {
        this.venta = venta;
    }

    public List getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List listaVenta) {
        this.listaVenta = listaVenta;
    }
    
}
