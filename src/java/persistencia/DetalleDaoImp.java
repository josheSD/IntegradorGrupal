/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Detalle;

/**
 *
 * @author josec
 */
public class DetalleDaoImp implements DetalleDao{
    
    @Override
    public String grabar(Detalle detalle) {
        String sql = "INSERT INTO detalle(Importe,Cantidad,FechaRegistro,IdVenta,IdProducto) VALUES("+detalle.getImporte()+","+detalle.getCantidad()+",'"+detalle.getFechaRegistro()+"',"+detalle.getIdVenta()+","+detalle.getIdProducto()+")";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String eliminar(int idVenta) {
        String sql = "DELETE FROM detalle WHERE IdVenta = "+idVenta+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public List buscar(int idVenta) {
        String sql = "SELECT P.*, PBV.Cantidad AS PBVCantidad FROM venta AS BV INNER JOIN detalle AS PBV ON BV.IdVenta = PBV.IdVenta INNER JOIN producto AS P ON P.IdProducto = PBV.IdProducto WHERE BV.IdVenta = "+idVenta+"";
        return Operacion.listar(sql);
    }
    
}
