package Ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Interprete {
    private String nombre;
    private boolean enActivo;
    private List<Disco> discos;

    public Interprete(String nombre, boolean enActivo) {
        this.nombre = nombre;
        this.enActivo = enActivo;
        this.discos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public boolean isEnActivo() { return enActivo; }
    public List<Disco> getDiscos() { return discos; }

    public void agregarDisco(Disco disco) {
        discos.add(disco);
        Collections.sort(discos);
    }


    public void eliminarDisco(int index) {
        if (index >= 0 && index < discos.size()) {
            discos.remove(index);
        }
    }




    @Override
    public String toString() {
        return nombre + " (" + (enActivo ? "Activo" : "Inactivo") + ")";
    }
}
