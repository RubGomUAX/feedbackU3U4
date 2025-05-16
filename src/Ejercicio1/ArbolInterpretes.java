package Ejercicio1;

public class ArbolInterpretes {
    private ArbolBusqueda raiz;

    public void agregarInterprete(Interprete interprete) {
        raiz = insertar(raiz, interprete);
    }

    private ArbolBusqueda insertar(ArbolBusqueda nodo, Interprete interprete) {
        if (nodo == null) return new ArbolBusqueda(interprete);
        int cmp = interprete.getNombre().compareToIgnoreCase(nodo.interprete.getNombre());
        if (cmp < 0) nodo.izquierdo = insertar(nodo.izquierdo, interprete);
        else if (cmp > 0) nodo.derecho = insertar(nodo.derecho, interprete);
        return nodo;
    }

    public Interprete buscar(String nombre) {
        return buscarRec(raiz, nombre);
    }

    private Interprete buscarRec(ArbolBusqueda nodo, String nombre) {
        if (nodo == null) return null;
        int cmp = nombre.compareToIgnoreCase(nodo.interprete.getNombre());
        if (cmp == 0) return nodo.interprete;
        if (cmp < 0) return buscarRec(nodo.izquierdo, nombre);
        return buscarRec(nodo.derecho, nombre);
    }

    public void listarInterpretes() {
        inOrden(raiz);
    }

    private void inOrden(ArbolBusqueda nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println(nodo.interprete);
            inOrden(nodo.derecho);
        }
    }

    public void listarDiscosPorAno(int ano) {
        listarDiscosPorAnoRec(raiz, ano);
    }

    private void listarDiscosPorAnoRec(ArbolBusqueda nodo, int ano) {
        if (nodo != null) {
            listarDiscosPorAnoRec(nodo.izquierdo, ano);
            for (Disco d : nodo.interprete.getDiscos()) {
                if (d.getAno() == ano) {
                    System.out.println(d + " - " + nodo.interprete.getNombre());
                }
            }
            listarDiscosPorAnoRec(nodo.derecho, ano);
        }
    }
}
