/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;

/**
 *
 * @author josec
 */
public class DashboardDaoImp implements DashboardDao{

    @Override
    public List ventaMayor() {
        String sql = "SELECT MONTHNAME(FechaRegistro) AS Mes, MAX(total) as ventaMaxima FROM venta GROUP BY total ORDER BY total DESC LIMIT 0,1;";
        return Operacion.listar(sql);
    }

    @Override
    public List ventaMenor() {
        String sql = "SELECT MONTHNAME(FechaRegistro) AS Mes, MIN(total) as ventaMinima FROM venta GROUP BY total ORDER BY total ASC LIMIT 0,1;";
        return Operacion.listar(sql);
    }

    @Override
    public List ventaAnual() {
        String sql = "SELECT YEAR(FechaRegistro) AS Anio, SUM(total) AS total FROM venta WHERE YEAR(FechaRegistro) = YEAR(CURDATE()) GROUP BY YEAR(FechaRegistro);";
        return Operacion.listar(sql);
    }

    @Override
    public List ventaMensualActual() {
        String sql = "SELECT MONTHNAME(FechaRegistro) AS Mes, SUM(total) AS total FROM venta WHERE YEAR(FechaRegistro) = YEAR(CURDATE()) AND MONTH(FechaRegistro) = MONTH(CURDATE()) GROUP BY MONTH(FechaRegistro);";
        return Operacion.listar(sql);
    }

    @Override
    public List ventaPorAnio() {
        String sql = "SELECT YEAR(FechaRegistro) AS Anio, MONTHNAME(FechaRegistro) AS Mes, SUM(total) AS Total FROM venta WHERE YEAR(FechaRegistro) = YEAR(CURDATE()) GROUP BY MONTH(FechaRegistro) ORDER BY MONTH(FechaRegistro) DESC;";
        return Operacion.listar(sql);
    }

    @Override
    public List ventaUltimoTrimestre() {
        String sql = "SELECT YEAR(FechaRegistro) AS Anio, MONTHNAME(FechaRegistro) AS Mes, SUM(total) AS Total FROM venta GROUP BY MONTH(FechaRegistro) ORDER BY MONTH(FechaRegistro) DESC LIMIT 0,3;";
        return Operacion.listar(sql);
    }
    
}
