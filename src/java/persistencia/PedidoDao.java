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
public interface PedidoDao {
    public List vaciarCesta();
    public List agregarProducto(Producto prod,int cant);
    public List quitarProducto(int IdProducto);
    public List actualizarProducto(Producto prod,int cant,int indice);
}
