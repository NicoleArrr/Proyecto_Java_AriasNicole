# TECNOSTORE
_La empresa TecnoStore es una tienda minorista dedicada a la venta de teléfonos celulares de diferentes marcas y gamas. Actualmente, desea automatizar el control de ventas, inventario y clientes, ya que todos los registros se manejan de forma manual en hojas de cálculo._

## Estructura de Clases
1. MODELO
    1. Persona
    2. Celular
    3. Cliente
    4. Marca
    5. Venta
3. VISTA
    1. TecnoStore
5. CONTROLADOR
    1. GestionarMarcAbs
    2. GestionarMarca
    3. GestionarClienteAbs
    4. GestionarCliente
    5. GestionarCelularAbs
    6. GestionarCelular
    7. GestionarVentaAbs
    8. GestionarVenta

### SQL Script

```
// Creación de BBDD
DROP DATABASE IF EXISTS TecnoStore;
create database TecnoStore;
use TecnoStore;

// Creación de entidades y sus atributos
DROP TABLE IF EXISTS marca;

CREATE TABLE marca (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) UNIQUE NOT NULL
);

DROP TABLE IF EXISTS celular;

CREATE TABLE celular (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_marca INT NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    sistema_operativo VARCHAR(50) NOT NULL,
    gama ENUM('BAJA', 'MEDIA', 'ALTA') NOT NULL,
    precio DOUBLE NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    FOREIGN KEY (id_marca) REFERENCES marca(id)
);

DROP TABLE IF EXISTS persona;

CREATE TABLE persona (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    identificacion VARCHAR(20) UNIQUE NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15) NOT NULL
);

DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_persona INT UNIQUE NOT NULL,
    FOREIGN KEY (id_persona) REFERENCES persona(id)
);

DROP TABLE IF EXISTS venta;

CREATE TABLE venta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    fecha DATE NOT NULL,
    total DOUBLE NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE detalle_venta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_venta INT NOT NULL,
    id_celular INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DOUBLE NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES venta(id),
    FOREIGN KEY (id_celular) REFERENCES celular(id)
);
```
