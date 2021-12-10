/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import persistencia.DashboardDao;
import persistencia.DashboardDaoImp;

/**
 *
 * @author josec
 */
public class DashboardServicioImp implements DashboardServicio{

    private DashboardDao dashDao;
    
    public DashboardServicioImp(){
        this.dashDao = new DashboardDaoImp();
    }
    
    @Override
    public List ventaMayor() {
        List lista = dashDao.ventaMayor();
        return lista;
    }

    @Override
    public List ventaMenor() {
        List lista = dashDao.ventaMenor();
        return lista;
    }

    @Override
    public List ventaAnual() {
        List lista = dashDao.ventaAnual();
        return lista;
    }

    @Override
    public List ventaMensualActual() {
        List lista = dashDao.ventaMensualActual();
        return lista;
    }

    @Override
    public List ventaPorAnio() {
        List lista = dashDao.ventaPorAnio();
        return lista;
    }

    @Override
    public List ventaUltimoTrimestre() {
        List lista = dashDao.ventaUltimoTrimestre();
        return lista;
    }
    
}
