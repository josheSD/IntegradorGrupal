/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;

/**
 *
 * @author josec
 */
public class Usuario {
    private int idUsuario;
    private String usuario;
    private String contrasenia;
    private String FechaRegistro;
    private String FechaActualizacion;
    private int idTipoUsuario;

    public Usuario(int idUsuario, String usuario, String contrasenia, String FechaRegistro, String FechaActualizacion, int idTipoUsuario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.FechaRegistro = FechaRegistro;
        this.FechaActualizacion = FechaActualizacion;
        this.idTipoUsuario = idTipoUsuario;
    }
    
    public Usuario(String usuario, String contrasenia, String FechaRegistro, int idTipoUsuario) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.FechaRegistro = FechaRegistro;
        this.idTipoUsuario = idTipoUsuario;
    }
    
    public Usuario(int idUsuario,String usuario, String contrasenia, String FechaActualizacion, int idTipoUsuario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.FechaActualizacion = FechaActualizacion;
        this.idTipoUsuario = idTipoUsuario;
    }
    
    public Usuario(String usuario, String contrasenia, String FechaRegistro, String FechaActualizacion, int idTipoUsuario) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.FechaRegistro = FechaRegistro;
        this.FechaActualizacion = FechaActualizacion;
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(String FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getFechaActualizacion() {
        return FechaActualizacion;
    }

    public void setFechaActualizacion(String FechaActualizacion) {
        this.FechaActualizacion = FechaActualizacion;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    
    
    
}
