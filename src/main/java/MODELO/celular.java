
package MODELO;

public class celular {
    private marca id_marca;
    
    int id, stock;
    String modelo, sistema_operativo, gama;
    double precio;

    public celular(marca id_marca, int id, int stock, String modelo, String sistema_operativo, String gama, double precio) {
        this.id_marca = id_marca;
        this.id = id;
        this.stock = stock;
        this.modelo = modelo;
        this.sistema_operativo = sistema_operativo;
        this.gama = gama;
        this.precio = precio;
    }
    

    public marca getId_marca() {
        return id_marca;
    }

    public void setId_marca(marca id_marca) {
        this.id_marca = id_marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
