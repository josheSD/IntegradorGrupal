/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Venta;

/**
 *
 * @author josec
 */
public class VentaDaoImp implements VentaDao{

    @Override
    public Object[] grabar(Venta venta){
        String sql = "INSERT INTO venta(Serie,Estado,Senior,Dni,Direccion,Telefono,Total,FechaRegistro,IdUsuario) VALUES('"+ venta.getSerie()+"',"+venta.getEstado()+",'"+venta.getSenior()+"','"+venta.getDni()+"','"+venta.getDireccion()+"','"+venta.getTelefono()+"',"+venta.getTotal()+",'"+venta.getFechaRegistro()+"',"+venta.getIdUsuario()+")";
               Operacion.ejecutar(sql);
        String sqlId = "SELECT * FROM venta ORDER BY IdVenta DESC LIMIT 0,1;";
        return Operacion.buscar(sqlId);
    }

    @Override
    public String actualizar(Venta venta, int idVenta) {
        String sql = "UPDATE venta SET Senior = '"+venta.getSenior()+"', Dni = '"+venta.getDni()+"', Direccion = '"+venta.getDireccion()+"', Telefono = '"+venta.getTelefono()+"', Total = "+venta.getTotal()+", FechaActualizacion = '"+venta.getFechaActualizacion()+"', IdUsuario = "+venta.getIdUsuario()+" WHERE IdVenta = "+ idVenta +"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String eliminar(int idVenta) {
        String sql = "DELETE FROM venta WHERE IdVenta = "+idVenta+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public List lista() {
        String sql = "SELECT * FROM venta ORDER BY IdVenta DESC";
        return Operacion.listar(sql);
    }

}
