/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Usuario;

/**
 *
 * @author josec
 */
public interface UsuarioServicio {
    public List lista();
    public String grabar(Usuario usu);
    public String actualizar(Usuario usu);
    public String eliminar(int idUsuario);
    public Object[] iniciarSesion(String usu,String pass);
    public List menu(int idTipoUsuario);
}
