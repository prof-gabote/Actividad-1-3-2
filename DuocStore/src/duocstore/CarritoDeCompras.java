package duocstore;

public class CarritoDeCompras {

    private String productos; ??   // ejemplo: "P01-Gorra($9.99) | P02-Polera($12.50)"
    private double total; ??

    //Constructores

    //Getters y Setters

    //Método void agregarProducto(Producto p)
    public void agregarProducto(Producto p) {
        if (p == null) {
            ??
        }

        productos = ??

    }
    // Método para "vaciar" el carrito
    public void vaciar() {
        productos = ??
        total = ??
    }

    //Método String resumen() que devuelve los productos y el total como una sola cadena
    public String resumen() {
        return "Productos: " + getProductos() + " | Total: $" + String.format("%.2f", total);
    }

}
