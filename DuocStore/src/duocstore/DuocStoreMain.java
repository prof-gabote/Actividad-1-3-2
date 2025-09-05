package duocstore;

public class DuocStoreMain {

    public static void main(String[] args) {
        // 1) Instanciar objetos EN MAIN (requisito)
        CarritoDeCompras carritoCliente = new CarritoDeCompras();
        Cliente cliente = new Cliente("C001", "María López", carritoCliente);

        Producto p1 = new Producto("P01", "Gorra", 9.99);
        Producto p2 = new Producto("P02", "Polera", 12.50);
        Producto p3 = new Producto("P03", "Botella", 5.25);

        // 2) Colaboración: Cliente → Carrito (pasando Producto)
        cliente.seleccionarProducto(p1);
        cliente.seleccionarProducto(p2);
        cliente.seleccionarProducto(p3);

        // 3) Ver estado del carrito (sin colecciones, todo en String + total acumulado)
        System.out.println("Estado del carrito:");
        System.out.println(carritoCliente.resumen());

        // 4) Proceso de pago (Cliente ↔ Carrito)
        boolean ok = cliente.pagar(30.00); // prueba con monto suficiente
        if (!ok) {
            // Si fallara, el carrito seguiría intacto
            System.out.println("Intentar nuevamente con un monto suficiente.");
        }

        // 5) Comprobar que se vació el carrito tras pagar
        System.out.println("Carrito tras pago:");
        System.out.println(carritoCliente.resumen());
    }
}