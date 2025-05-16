package Ejercicio3;

import complejidad.MetodosPrueba;
import complejidad.Cronometro;

import java.lang.reflect.Method;

public class Analizador {
    public static void main(String[] args) {
        int[] tamanos = {2, 4, 8, 16};

        MetodosPrueba instancia = new MetodosPrueba();
        Method[] metodos = MetodosPrueba.class.getDeclaredMethods();

        for (Method metodo : metodos) {
            if (metodo.getParameterCount() == 1 &&
                    metodo.getParameterTypes()[0] == int.class &&
                    metodo.getName().startsWith("m")) {

                System.out.println("Análisis del método: " + metodo.getName());
                System.out.printf("%-10s %-15s\n", "Tamaño", "Tiempo (ms)");

                for (int n : tamanos) {
                    try {
                        Cronometro crono = new Cronometro();
                        crono.inicia();

                        metodo.invoke(instancia, n);

                        crono.termina();
                        System.out.printf("%-10d %-15d\n", n, crono.tiempo());
                    } catch (Exception e) {
                        System.out.println("Error al ejecutar " + metodo.getName() + ": " + e.getMessage());
                    }
                }
                System.out.println(); // Espacio entre métodos
            }
        }
    }
}


