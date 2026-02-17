
package CONTROLADOR;

import MODELO.venta;
import java.util.List;

public class ReporteFinanServImpl implements ReporteFinancieroService{
    
    Conexion c = new Conexion();
    
    @Override
    public void generarReporte(List<venta> ventas) {
        
        consulta sql = ("(SELECT marca, SUM(precio_venta) AS total FROM venta JOIN celular ON venta.id_celular = celular.id GROUP BY marca;)");
        
        for (Detalle_venta dv : ventas) {
                    String reporte = """
                        ID Detalle : %s
                        Venta ID   : %s
                        Celular ID : %d
                        Modelo     : %s
                        Marca      : %s
                        Gama       : %s
                        Precio     : %s
                        Stock      : %s
                        Total Venta: %s
                        Cantidad   : %s
                        Subtotal   : %s
                        ----------------------------
                        """.formatted(
                            dv.getId(),
                            dv.getId_venta().getId(),
                            dv.getId_venta().getId_cliente().getNombre(),
                            dv.getId_venta().getFecha(),
                            dv.getId_venta().getTotal(),
                            dv.getId_celular().getId(),
                            dv.getId_celular().getModelo_id().getNombre_modelo(),
                            dv.getId_celular().getModelo_id().getMarca_id().getNombre_marca(),
                            dv.getId_celular().getSistema_operativo(),
                            dv.getId_celular().getGama() ,
                            dv.getId_celular().getPrecio(),
                            dv.getId_celular().getStock(),
                            dv.getCantidad(),
                            dv.getSubtotal()
                        );
        }
    }
    
}
