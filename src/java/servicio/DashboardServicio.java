/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;

/**
 *
 * @author josec
 */
public interface DashboardServicio {
    public List ventaMayor();
    public List ventaMenor();
    public List ventaAnual();
    public List ventaMensualActual();
    public List ventaPorAnio();
    public List ventaUltimoTrimestre();
}
