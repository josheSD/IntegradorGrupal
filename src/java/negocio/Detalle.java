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
public class Detalle {
    private Double importe;
    private int cantidad;
    private Date fechaRegistro;
    private Date fechaActualizacion;
    private int idProductoVenta;
    private int idProducto;

    public Detalle(){}

    public Detalle(Double importe, int cantidad, Date fechaRegistro, Date fechaActualizacion, int idProductoVenta, int idProducto) {
        this.importe = importe;
        this.cantidad = cantidad;
        this.fechaRegistro = fechaRegistro;
        this.fechaActualizacion = fechaActualizacion;
        this.idProductoVenta = idProductoVenta;
        this.idProducto = idProducto;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getIdProductoVenta() {
        return idProductoVenta;
    }

    public void setIdProductoVenta(int idProductoVenta) {
        this.idProductoVenta = idProductoVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

}