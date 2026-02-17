package CONTROLADOR;
import MODELO.venta;
import java.util.List;

public interface ReporteFinancieroService {
    void generarReporte(List<venta> ventas);
}