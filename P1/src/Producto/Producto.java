package Producto;

public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    /*
     * Constructor de la clase Producto
     * 
     * @param nombre el nombre del producto
     * @param cantidad la cantidad de unidades del producto
     * @param precio el precio por unidad del producto
     */
    public Producto(String nombre, int cantidad, double precio) {
        setNombre(nombre);
        setCantidad(cantidad);
        setPrecio(precio);
    }

    /*
     * Asigna el valor del atributo de clase "nombre" con el valor del parámetro
     * 
     * @param nombre el valor entrante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
     * Asigna el valor del atributo de clase "cantidad" con el valor del parámetro
     * 
     * @param cantidad el valor entrante
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /*
     * Asigna el valor del atributo de clase "precio" con el valor del parámetro
     * 
     * @param precio el valor entrante
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /*
     * Devuelve el valor del atributo de clase "nombre"
     * 
     * @return el valor de nombre
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Devuelve el valor del atributo de clase "cantidad"
     * 
     * @return el valor de cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /*
     * Devuelve el valor del atributo de clase "precio"
     * 
     * @return el valor de precio
     */
    public double getPrecio() {
        return precio;
    }
}