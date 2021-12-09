/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Venta;
import persistencia.VentaDao;
import persistencia.VentaDaoImp;

/**
 *
 * @author josec
 */
public class VentaServicioImp implements VentaServicio {

    private VentaDao ventDao;
    
    public VentaServicioImp(){
        this.ventDao = new VentaDaoImp();
    }
    
    @Override
    public Object[] grabar(Venta venta) {
        Object[] ventaGrabado = ventDao.grabar(venta);
        return ventaGrabado;
    }

    @Override
    public String actualizar(Venta venta, int idVenta) {
        String msg = ventDao.actualizar(venta,idVenta);
        if(msg == null){
            msg = "Venta actualizado con éxito";
        }
        return msg;
    }

    @Override
    public String eliminar(int idVenta) {
        String msg = ventDao.eliminar(idVenta);
        if( msg == null){
            msg = "Boleta de Venta eliminado con éxito";
        }
        return msg;
    }

    @Override
    public List lista() {
        List listaVenta = ventDao.lista();
        return listaVenta;
    }
    
}
