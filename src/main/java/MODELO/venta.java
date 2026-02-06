
package MODELO;

import java.util.Date;

public class venta {
    // inyección de dependencia
    private cliente id_cliente;
    
    int id;
    Date fecha;
    double total;
    
    // parámetro tipo clase
    public venta(cliente id_cliente, int id, Date fecha, double total) {
        this.id_cliente = id_cliente;
        this.id = id;
        this.fecha = fecha;
        this.total = total;
    }
        
    
    public cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
