/**
 * Clase que representa un producto de inventario.
 * Un arreglo de objetos Producto forma el inventario.
 */
public class Producto {

    // ATRIBUTOS del objeto
    String nombre;
    double precio;
    int    stock;

    // CONSTRUCTOR: inicializa el objeto con sus datos
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;   // "this." distingue el atributo del parámetro
        this.precio = precio;
        this.stock  = stock;
    }

    // MÉTODO: calcula el valor total en inventario
    public double valorTotal() {
        return precio * stock;
    }

    // MÉTODO: representación en texto del objeto
    public String toString() {
        return String.format("%-12s  $%7.2f   stock: %3d   valor: $%8.2f",
            nombre, precio, stock, valorTotal());
    }
}
