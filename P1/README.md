*Universidad de San Carlos de Guatemala*  
*Facultad de Ingenieria*  
*Escuela de Ciencias y Sistemas*  
*Software Avanzado*  
*Primer Semestre 2025*  
___
**201908355 - Danny Hugo Bryan Tejaxún Pichiyá**  
___
## **Práctica 1**  

### Principios SOLID

#### 1. Single Responsability Principle (SRP) - Principio de Responsabilidad Única
Cada clase debe tener un único propósito. Si una clase hace distintas cosas es posible que haya más dificultad para entender su funcionamiento. Por ejemplo:

```java
public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, int cantidad, double precio) {
        setNombre(nombre);
        setCantidad(cantidad);
        setPrecio(precio);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}
```

La clase Producto se encarga únicamente de gestionar la información de un producto determinado.

#### 2. Open/Closed Principle (OCP) - Principio de Abierto/Cerrado
Las clases deben estar disponibles para su extensión sin modificar el código existente. Esto sería posible si se utilizara Herencia para implementar nuevas funcionalidades en subclases sin modificar las clases existentes. Por ejemplo:

```java
public class Perecedero extends Producto {
    private Date fechaCaducidad;

    public Perecedero(String nombre, int cantidad, double precio, Date fechaCaducidad) {
        super(nombre, cantidad, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}

public class Enlatado extends Producto {
    private int capacidadMililitros;

    public Enlatado(String nombre, int cantidad, double precio, int capacidadMililitros) {
        super(nombre, cantidad, precio);
        this.capacidadMililitros = capacidadMililitros;
    }

    public int getCapacidadMililitros() {
        return capacidadMililitros;
    }

    public void setCapacidadMililitros(int capacidadMililitros) {
        this.capacidadMililitros = capacidadMililitros;
    }
}
```
Si se implementaran dos nuevos tipos de productos hijos extendidos de Producto tendrían sus propios atributos e implementaciones distintivas sin afectar a la clase Producto.

#### 3. Liskov Substitution Principle (LSP) - Principio de Substitución de Liskov
Los objetos de una subclase pueden ser reemplazadas por objetos de la clase base sin afectar el funcionamiento del programa. Por ejemplo:

```java
public class App {
    public static void main(String[] args) {
        Producto[] productos = {
            new Perecedero("Leche", 10, 1.5, new Date(2025, 8, 15)),
            new Enlatado("Sopa", 20, 2.0, 500)
        };
    }
}
```
Es posible tener una lista o vector de objetos de la clase Producto y llamar al método `getNombre()` sin esperar fallas por el tipo del objeto.

#### 4. Interface Segregation Principle (ISP) - Principio de Segregación de la Interfaz
Una clase no debe implementar interfaces que no va a utilizar, o interfaces que tienen métodos que no va a utilizar. Es mejor tener varias interfaces pequeñas que una sola, pero grande. Por ejemplo:

```java
public interface ProductoPerecedero {
    void verificarCaducidad();
}

public interface ProductoElectronico {
    void encender();
    void apagar();
}

public class Perecedero extends Producto implements ProductoPerecedero {
    private Date fechaCaducidad;

    public Perecedero(String nombre, int cantidad, double precio, Date fechaCaducidad) {
        super(nombre, cantidad, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public void verificarCaducidad() {
        Date hoy = new Date();
        if (fechaCaducidad.before(hoy)) {
            System.out.println("Este producto está caducado.");
        } else {
            System.out.println("Este producto está en buen estado.");
        }
    }
}

public class Electronico extends Producto implements ProductoElectronico {
    private String marca;

    public Electronico(String nombre, int cantidad, double precio, String marca) {
        super(nombre, cantidad, precio);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public void encender() {
        System.out.println("El producto electrónico está encendido.");
    }

    @Override
    public void apagar() {
        System.out.println("El producto electrónico está apagado.");
    }
}
```
Sería la forma efectiva de implementar el principio ya que si se implementara una sola interfaz hay métodos como `encender()` y `apagar()` que un Perecedero no va a implementar y, métodos como `verificarCaducidad()` que Electronico no va a implementar.

#### 5. Dependency Inversion Principle (DIP) - Principio de Inversión de Dependencias
Las clases de alto nivel no deben depender de una clase de bajo nivel. Sino que ambas deben depender de una interfaz o una clase abstracta. Por ejemplo:

* Sin aplicar el principio
```java
public class Producto {
    private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public void imprimir() {
        Impresora impresora = new Impresora();
        impresora.imprimirDetalle(nombre);
    }
}

public class Impresora {
    public void imprimirDetalle(String detalle) {
        System.out.println("Imprimiendo: " + detalle);
    }
}
```
La clase producto está dependiendo de que se cree un objeto Impresora para poder imprimir.

* Aplicando el principio
```java
public interface ServicioImpresion {
    void imprimirDetalle(String detalle);
}

public class Impresora implements ServicioImpresion {
    public void imprimirDetalle(String detalle) {
        System.out.println("Imprimiendo: " + detalle);
    }
}

public class Producto {
    private String nombre;
    private ServicioImpresion servicioImpresion;

    public Producto(String nombre, ServicioImpresion servicioImpresion) {
        this.nombre = nombre;
        this.servicioImpresion = servicioImpresion;
    }

    public void imprimir() {
        servicioImpresion.imprimirDetalle(nombre);
    }
}
```
La clase Impresora implementa la interfaz ServicioImpresion. La clase Producto recibe como parámetro en su constructor un objeto del tipo de la interfaz ServicioImpresion, lo que hace que el objeto no se cree dentro de la clase Producto y no dependa directamente si no que es enviada de forma externa.