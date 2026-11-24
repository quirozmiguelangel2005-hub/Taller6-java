import javax.swing.JOptionPane;

public class Parte3 {
    public static void main(String[] args) {

        // 1. DECLARACIÓN Y CREACIÓN del arreglo de objetos
        Producto[] productos = new Producto[4];

        // 2. CREACIÓN de cada objeto con su constructor
        productos[0] = new Producto("Laptop",   850.00, 5);
        productos[1] = new Producto("Mouse",     25.50, 20);
        productos[2] = new Producto("Teclado",   45.00, 15);
        productos[3] = new Producto("Monitor",  320.00, 8);

        // 3. ACCESO y VISUALIZACIÓN de cada elemento
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== INVENTARIO DE PRODUCTOS ===\n");
        reporte.append(String.format("%-12s  %-9s  %-11s  %s\n",
            "Nombre", "Precio", "Stock", "Valor Total"));
        reporte.append("-".repeat(55)).append("\n");

        double valorTotalInventario = 0;
        Producto masEconomico  = productos[0];
        Producto masValioso    = productos[0];

        for (int i = 0; i < productos.length; i++) {
            reporte.append(productos[i].toString()).append("\n");

            valorTotalInventario += productos[i].valorTotal();

            if (productos[i].precio < masEconomico.precio) {
                masEconomico = productos[i];
            }
            if (productos[i].valorTotal() > masValioso.valorTotal()) {
                masValioso = productos[i];
            }
        }

        reporte.append("-".repeat(55)).append("\n");
        reporte.append(String.format("Valor total inventario: $%.2f\n", valorTotalInventario));
        reporte.append("Producto más económico : ").append(masEconomico.nombre).append("\n");
        reporte.append("Mayor valor inventario : ").append(masValioso.nombre).append("\n");

        // 4. MANIPULACIÓN: aplicar 10% de descuento al producto más caro
        Producto masCaro = productos[0];
        for (int i = 1; i < productos.length; i++) {
            if (productos[i].precio > masCaro.precio) {
                masCaro = productos[i];
            }
        }
        reporte.append("\n--- Descuento aplicado ---\n");
        reporte.append("Antes : ").append(masCaro.toString()).append("\n");
        masCaro.precio = masCaro.precio * 0.90;
        reporte.append("Después: ").append(masCaro.toString()).append("\n");

        JOptionPane.showMessageDialog(null, reporte.toString());
    }
}
