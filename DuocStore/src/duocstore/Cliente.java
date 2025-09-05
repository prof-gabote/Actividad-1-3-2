package duocstore;

public class Cliente {

    private String idCliente;
    private String nombre;
    private CarritoDeCompras carrito; // Colaboración: Cliente "tiene un" CarritoDeCompras

    public Cliente(String idCliente, String nombre, CarritoDeCompras carrito) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.carrito = carrito; // Se inyecta desde main (no se instancia aquí)
    }

    public void seleccionarProducto(Producto p) {
        if (carrito == null) {
            System.out.println("El cliente no tiene carrito asociado.");
            return;
        }
        carrito.agregarProducto(p);
    }
    
/**
     * Simula el pago. Devuelve true si el monto cubre el total.
     * Al pagar con éxito, se emite comprobante y se vacía el carrito.
     */
    public boolean pagar(double montoEntregado) {
        if (carrito == null) return false;

        double total = carrito.getTotal();
        if (montoEntregado < total) {
            System.out.println("Pago rechazado. Faltan $" + String.format("%.2f", (total - montoEntregado)));
            return false;
        }

        double vuelto = montoEntregado - total;
        emitirComprobante(montoEntregado, vuelto, carrito.getProductos(), total);
        carrito.vaciar();
        return true;
    }

    private void emitirComprobante(double monto, double vuelto, String detalleProductos, double total) {
        System.out.println("\n=== COMPROBANTE DE COMPRA ===");
        System.out.println("Cliente: " + nombre + " (ID: " + idCliente + ")");
        System.out.println("Detalle: " + detalleProductos);
        System.out.println("Total:   $" + String.format("%.2f", total));
        System.out.println("Pagado:  $" + String.format("%.2f", monto));
        System.out.println("Vuelto:  $" + String.format("%.2f", vuelto));
        System.out.println("=============================\n");
    }
}
