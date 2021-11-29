/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josec
 */
public class Pedido {
    
    private List<LineaVenta> ces = new ArrayList<LineaVenta>();

    public void vaciarCesta(){
        ces = new ArrayList<LineaVenta>();
    }
    
    public void agregarLinea(Producto prod, int cant){
        LineaVenta lin = new LineaVenta(prod,cant);
        ces.add(lin);
    }
    
    public void quitarLinea(int IdProducto){
        for(int i=0; i<ces.size();i++){
            LineaVenta lin = (LineaVenta) ces.get(i);
            if(lin.getProd().getIdProducto() == IdProducto){
                ces.remove(i);
            };
        }
    }
    
    public void actualizarLinea(Producto prod,int cant,int indice){
        ces.get(indice).setProd(prod);
        ces.get(indice).setCant(cant);
    }
    
    public double getTot(){
        double tot = 0;
        for(int i=0; i<ces.size();i++){
            LineaVenta lin = (LineaVenta) ces.get(i);
            tot += lin.getImp();
        }
        return tot;
    }

    public List<LineaVenta> getCes() {
        return ces;
    }

    public void setCes(List<LineaVenta> ces) {
        this.ces = ces;
    }
}
