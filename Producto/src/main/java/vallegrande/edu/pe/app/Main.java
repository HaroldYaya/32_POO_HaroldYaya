package vallegrande.edu.pe.app;

import vallegrande.edu.pe.app.Producto.Producto;

public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("Laptop HP", "P001", 2500.00, 10, "Electrónica");
        Producto p2 = new Producto("Mouse Logitech", "P002", 45.90, 30, "Accesorios");
        Producto p3 = new Producto("Escritorio de Oficina", "P003", 350.00, 5, "Muebles");

        p1.mostrarDatos();
        p2.mostrarDatos();
        p3.mostrarDatos();
    }
}