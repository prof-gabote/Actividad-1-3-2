package duocstore;

public class CarritoDeCompras {

    private String productos = "";   // ejemplo: "P01-Gorra($9.99) | P02-Polera($12.50)"
    private double total = 0.0;

    public void agregarProducto(Producto p) {
        if (p == null) {
            return;
        }

        if (productos == null || productos.isEmpty()) {
            productos = p.comoLinea();
        } else {
            productos += " | " + p.comoLinea();
        }
        total += p.getPrecio();
    }

    public String getProductos() {
        return productos == null ? "" : productos;
    }

    public double getTotal() {
        return total;
    }

    public void vaciar() {
        productos = "";
        total = 0.0;
    }

    public String resumen() {
        return "Productos: " + getProductos() + " | Total: $" + String.format("%.2f", total);
    }
}
