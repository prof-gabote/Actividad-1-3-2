package duocstore;

import java.util.Scanner;

public class DuocStoreMainMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Objetos base (sin colecciones)
        CarritoDeCompras carrito = new CarritoDeCompras();
        Cliente cliente = null;
        Producto p1 = null, p2 = null, p3 = null;

        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE TIENDA EN LINEA ===");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Productos");
            System.out.println("3. Agregar Producto al Carrito");
            System.out.println("4. Ver Carrito");
            System.out.println("5. Pagar");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("--- REGISTRO DE CLIENTE ---");
                    System.out.print("Ingrese ID Cliente: ");
                    String idC = sc.nextLine();
                    System.out.print("Ingrese nombre Cliente: ");
                    String nomC = sc.nextLine();
                    cliente = new Cliente(idC, nomC, carrito);
                    System.out.println("Cliente registrado con éxito.");
                    break;

                case 2:
                    System.out.println("--- REGISTRO DE PRODUCTOS ---");
                    System.out.print("Ingrese ID Producto 1: ");
                    String id1 = sc.nextLine();
                    System.out.print("Ingrese nombre Producto 1: ");
                    String nom1 = sc.nextLine();
                    System.out.print("Ingrese precio Producto 1: ");
                    double pre1 = sc.nextDouble();
                    sc.nextLine();
                    p1 = new Producto(id1, nom1, pre1);

                    System.out.print("Ingrese ID Producto 2: ");
                    String id2 = sc.nextLine();
                    System.out.print("Ingrese nombre Producto 2: ");
                    String nom2 = sc.nextLine();
                    System.out.print("Ingrese precio Producto 2: ");
                    double pre2 = sc.nextDouble();
                    sc.nextLine();
                    p2 = new Producto(id2, nom2, pre2);

                    System.out.print("Ingrese ID Producto 3: ");
                    String id3 = sc.nextLine();
                    System.out.print("Ingrese nombre Producto 3: ");
                    String nom3 = sc.nextLine();
                    System.out.print("Ingrese precio Producto 3: ");
                    double pre3 = sc.nextDouble();
                    sc.nextLine();
                    p3 = new Producto(id3, nom3, pre3);

                    System.out.println("Productos registrados con éxito.");
                    break;

                case 3:
                    if (cliente == null || p1 == null) {
                        System.out.println("Debe registrar cliente y productos primero.");
                        break;
                    }
                    System.out.println("--- AGREGAR PRODUCTO AL CARRITO ---");
                    System.out.println("1. " + p1.comoLinea());
                    System.out.println("2. " + p2.comoLinea());
                    System.out.println("3. " + p3.comoLinea());
                    System.out.print("Seleccione producto: ");
                    int prod = sc.nextInt();
                    sc.nextLine();

                    switch (prod) {
                        case 1:
                            cliente.seleccionarProducto(p1);
                            break;
                        case 2:
                            cliente.seleccionarProducto(p2);
                            break;
                        case 3:
                            cliente.seleccionarProducto(p3);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;

                case 4:
                    System.out.println("--- CARRITO DE COMPRAS ---");
                    System.out.println(carrito.resumen());
                    break;

                case 5:
                    if (cliente == null) {
                        System.out.println("Debe registrar cliente primero.");
                        break;
                    }
                    System.out.print("Ingrese monto a pagar: ");
                    double monto = sc.nextDouble();
                    sc.nextLine();
                    cliente.pagar(monto);
                    break;

                case 6:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            if (opcion != 6) {
                System.out.println("Presione Enter para continuar...");
                sc.nextLine();
            }

        } while (opcion != 6);

        sc.close();
    }
}
