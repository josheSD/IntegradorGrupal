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
public class DashboardPresentador {
    
    private List listaVentaMayor = new ArrayList();
    private List listaVentaMenor = new ArrayList();
    private List listaVentaAnual = new ArrayList();
    private List listaVentaMensualActual = new ArrayList();
    private List listaVentaPorAnio = new ArrayList();
    private List listaVentaUltimoTrimestre = new ArrayList();

    public DashboardPresentador(){}
    
    public List getListaVentaMayor() {
        return listaVentaMayor;
    }

    public void setListaVentaMayor(List listaVentaMayor) {
        this.listaVentaMayor = listaVentaMayor;
    }

    public List getListaVentaMenor() {
        return listaVentaMenor;
    }

    public void setListaVentaMenor(List listaVentaMenor) {
        this.listaVentaMenor = listaVentaMenor;
    }

    public List getListaVentaAnual() {
        return listaVentaAnual;
    }

    public void setListaVentaAnual(List listaVentaAnual) {
        this.listaVentaAnual = listaVentaAnual;
    }

    public List getListaVentaMensualActual() {
        return listaVentaMensualActual;
    }

    public void setListaVentaMensualActual(List listaVentaMensualActual) {
        this.listaVentaMensualActual = listaVentaMensualActual;
    }

    public List getListaVentaPorAnio() {
        return listaVentaPorAnio;
    }

    public void setListaVentaPorAnio(List listaVentaPorAnio) {
        this.listaVentaPorAnio = listaVentaPorAnio;
    }

    public List getListaVentaUltimoTrimestre() {
        return listaVentaUltimoTrimestre;
    }

    public void setListaVentaUltimoTrimestre(List listaVentaUltimoTrimestre) {
        this.listaVentaUltimoTrimestre = listaVentaUltimoTrimestre;
    }
    
}
