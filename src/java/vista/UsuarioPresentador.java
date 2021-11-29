/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josec
 */
public class UsuarioPresentador {
    private String msg = "";
    private String tipoAccion = "";
    private Object[] usuario = {"","","","","","",""};
    private List menu = new ArrayList();
    private List listaUsuario = new ArrayList();
    private List listaTipoUsuario = new ArrayList();

    public UsuarioPresentador() {
    }

    public List getListaTipoUsuario() {
        return listaTipoUsuario;
    }

    public void setListaTipoUsuario(List listaTipoUsuario) {
        this.listaTipoUsuario = listaTipoUsuario;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public List getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object[] getUsuario() {
        return usuario;
    }

    public void setUsuario(Object[] usuario) {
        this.usuario = usuario;
    }

    public List getMenu() {
        return menu;
    }

    public void setMenu(List menu) {
        this.menu = menu;
    }

}
