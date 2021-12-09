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
public interface DetalleDao {
    public String grabar(Detalle detalle);
    public String eliminar(int idVenta);
    public List buscar(int idVenta);
}
