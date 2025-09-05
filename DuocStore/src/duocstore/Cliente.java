package duocstore;

public class Cliente {

    private String idCliente;
    private String nombre;
    private CarritoDeCompras carrito; // Colaboración: Cliente "tiene un" CarritoDeCompras

    //Construcctores

    //Getters y Setters

    //Método void seleccionarProducto(Producto p) que agrega un carrito a producto usando el método agregarProducto(Producto p) de carrito
    public void seleccionarProducto(Producto p) {
        if (carrito == null) {
            System.out.println("El cliente no tiene carrito asociado.");
            return;
        }
        ??;
    }
    
    //Método boolean pagar(double montoEntregado) que recibe un monto, comprueba que puede pagar el total e imprime un comprobante usando emitirComprobante() de más abajo
    //Si el monto alcanza devuelve true, sino false
    public boolean pagar(double montoEntregado) {
        if (carrito == null) return ??;

        double total = carrito.getTotal();
        if (??) {
            System.out.println("Pago rechazado. Faltan $" + ??);
            return ??
        }

        double vuelto = ??
        emitirComprobante(montoEntregado, vuelto, carrito.getProductos(), total);
        carrito.vaciar();
        return ??
    }

    //Método void emitirComprobante (double monto, double vuelto, String detalleProductos, double total) que solo imprime con System.out.println cada línea de la boleta
    private void emitirComprobante(double monto, double vuelto, String detalleProductos, double total){
        ??
    }
}
