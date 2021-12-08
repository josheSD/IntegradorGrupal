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
public class Producto {
    
    private int idProducto;
    private String nombre;
    private Double precioUnitario;
    private int cantidadInicial;
    private int cantidadFinal;
    private String fechaRegistro;
    private String fechaActualizacion;
    
    public Producto(){}
    
    public Producto(String nombre, Double precioUnitario, int cantidadInicial, int cantidadFinal, String fechaRegistro) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadInicial = cantidadInicial;
        this.cantidadFinal = cantidadFinal;
        this.fechaRegistro = fechaRegistro;
    }
    
    public Producto(int idProducto, String nombre, Double precioUnitario, int cantidadInicial, int cantidadFinal, String fechaActualizacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadInicial = cantidadInicial;
        this.cantidadFinal = cantidadFinal;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Producto(int idProducto, String nombre, Double precioUnitario, int cantidadInicial, int cantidadFinal, String fechaRegistro, String fechaActualizacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadInicial = cantidadInicial;
        this.cantidadFinal = cantidadFinal;
        this.fechaRegistro = fechaRegistro;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public int getCantidadFinal() {
        return cantidadFinal;
    }

    public void setCantidadFinal(int cantidadFinal) {
        this.cantidadFinal = cantidadFinal;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
}
