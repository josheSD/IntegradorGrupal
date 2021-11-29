/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Usuario;

/**
 *
 * @author josec
 */
public class UsuarioDaoImp implements UsuarioDao {

    @Override
    public String grabar(Usuario usu) {
        String sql = "INSERT INTO usuario(Usuario,Contrasenia,FechaRegistro,IdTipoUsuario) VALUES('"+ usu.getUsuario()+"','"+usu.getContrasenia()+"','"+usu.getFechaRegistro()+"',"+usu.getIdTipoUsuario()+")";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String actualizar(Usuario usu) {
        String sql = "UPDATE usuario SET Usuario = '"+usu.getUsuario()+"', Contrasenia = '"+usu.getContrasenia()+"', IdTipoUsuario = '"+usu.getIdTipoUsuario()+"', FechaActualizacion = '"+usu.getFechaActualizacion()+"' WHERE IdUsuario = "+usu.getIdUsuario()+" ";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String eliminar(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE IdUsuario = "+idUsuario+"";
        return Operacion.ejecutar(sql);
    }

    @Override
    public Object[] iniciarSesion(String usu, String pass) {
        String sql = "SELECT U.*, TU.Nombre AS 'TipoUsuario' FROM Usuario AS U INNER JOIN TipoUsuario AS TU ON U.IdTipoUsuario = TU.IdTipoUsuario WHERE usuario='"+usu+"' AND contrasenia='"+pass+"'";
        return Operacion.buscar(sql);
    }

    @Override
    public List menu(int idTipoUsuario) {
        String sql = "SELECT M.* FROM TipoUsuario as TS INNER JOIN TipoUsuarioMenu as TSM ON TS.IdTipoUsuario = TSM.IdTipoUsuario INNER JOIN Menu as M ON M.IdMenu = TSM.IdMenu WHERE TS.IdTipoUsuario ="+idTipoUsuario+"";
        return Operacion.listar(sql);
    }

    @Override
    public List lista() {
        String sql = "SELECT U.*,TU.Nombre AS TipoUsuario FROM usuario AS U INNER JOIN tipousuario AS TU ON U.IdTipoUsuario = TU.IdTipoUsuario WHERE IdUsuario <> 1 ORDER BY IdUsuario DESC";
        return Operacion.listar(sql);
    }
    
}
