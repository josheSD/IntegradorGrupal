/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Venta;

/**
 *
 * @author josec
 */
public interface VentaServicio {
    public Object[] grabar(Venta venta);
    public String actualizar(Venta venta,int idVenta);
    public String eliminar(int idVenta);
    public List lista();
}
