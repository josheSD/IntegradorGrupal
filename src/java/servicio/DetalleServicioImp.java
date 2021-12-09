/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Detalle;
import persistencia.DetalleDao;
import persistencia.DetalleDaoImp;

/**
 *
 * @author josec
 */
public class DetalleServicioImp implements DetalleServicio{

    private DetalleDao detaDao;
    
    public DetalleServicioImp(){
        this.detaDao = new DetalleDaoImp();
    }
    
    @Override
    public String grabar(Detalle detalle) {
        String msg = detaDao.grabar(detalle);
        if(msg == null){
            msg = "Venta grabado con éxito";
        }
        return msg;
    }

    @Override
    public String eliminar(int idVenta) {
        String msg = detaDao.eliminar(idVenta);
        if(msg == null){
            msg = "Venta eliminado con éxito";
        }
        return msg;
    }

    @Override
    public List buscar(int idVenta) {
        List productoBoletaVenta = detaDao.buscar(idVenta);
        return productoBoletaVenta;
    }
    
}
