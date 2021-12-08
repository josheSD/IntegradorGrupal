/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Producto;

/**
 *
 * @author josec
 */
public class ProductoDaoImp implements ProductoDao{
    
    @Override
    public String grabar(Producto prod) {
        String sql = "INSERT INTO producto(Nombre,PrecioUnitario,CantidadInicial,CantidadFinal,FechaRegistro) VALUES('"+ prod.getNombre()+"',"+prod.getPrecioUnitario()+","+prod.getCantidadInicial()+","+prod.getCantidadFinal()+",'"+prod.getFechaRegistro()+"')";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String actualizar(Producto prod) {
        String sql = "UPDATE producto SET Nombre = '"+prod.getNombre()+"', PrecioUnitario = "+prod.getPrecioUnitario()+", CantidadInicial = "+prod.getCantidadInicial()+", FechaActualizacion = '"+prod.getFechaActualizacion()+"' WHERE IdProducto = "+prod.getIdProducto()+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String eliminar(int idProducto) {
        String sql = "DELETE FROM producto WHERE IdProducto = "+idProducto+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public List lista() {
        String sql = "SELECT * FROM producto ORDER BY IdProducto DESC";
        return Operacion.listar(sql);
    }

    @Override
    public Producto buscar(int idProducto) {
        String sql = "SELECT * FROM producto WHERE IdProducto = "+idProducto+"";
        Object[] prodDB = Operacion.buscar(sql);
        Producto producto = new Producto();
        if( prodDB != null ){
            producto.setIdProducto(Integer.parseInt(prodDB[0].toString()));
            producto.setNombre(prodDB[1].toString());
            producto.setPrecioUnitario(Double.parseDouble(prodDB[2].toString()));
            producto.setCantidadInicial(Integer.parseInt(prodDB[3].toString()));
            producto.setCantidadFinal(Integer.parseInt(prodDB[4].toString()));
            return producto;
        }
        return null;
    }
}
