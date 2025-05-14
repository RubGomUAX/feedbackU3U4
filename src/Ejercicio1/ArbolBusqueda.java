package Ejercicio1;

public class ArbolBusqueda {
    public Interprete interprete;
    public ArbolBusqueda izquierdo, derecho;

    public ArbolBusqueda(Interprete interprete) {
        this.interprete = interprete;
        this.izquierdo = this.derecho = null;
    }
}

