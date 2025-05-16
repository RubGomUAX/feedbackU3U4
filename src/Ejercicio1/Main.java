package Ejercicio1;

import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ArbolInterpretes arbol = new ArbolInterpretes();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir nuevo intérprete");
            System.out.println("2. Añadir nuevo disco");
            System.out.println("3. Eliminar disco");
            System.out.println("4. Listar intérpretes");
            System.out.println("5. Discos de un intérprete");
            System.out.println("6. Discos editados en un año");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> agregarInterprete();
                case 2 -> agregarDisco();
                case 3 -> eliminarDisco();
                case 4 -> arbol.listarInterpretes();
                case 5 -> mostrarDiscosDeInterprete();
                case 6 -> listarDiscosPorAno();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void agregarInterprete() {
        System.out.print("Nombre del intérprete: ");
        String nombre = sc.nextLine();
        System.out.print("¿Está todavía en activo? (s/n): ");
        boolean activo = sc.nextLine().equalsIgnoreCase("s");
        arbol.agregarInterprete(new Interprete(nombre, activo));
    }

    private static void agregarDisco() {
        System.out.print("Nombre del intérprete: ");
        String nombre = sc.nextLine();
        Interprete i = arbol.buscar(nombre);
        if (i == null) {
            System.out.print("No existe. ¿Está todavía en activo? (s/n): ");
            boolean activo = sc.nextLine().equalsIgnoreCase("s");
            i = new Interprete(nombre, activo);
            arbol.agregarInterprete(i);
        }
        System.out.print("Título del disco: ");
        String titulo = sc.nextLine();
        System.out.print("Año de edición: ");
        int ano = sc.nextInt();
        System.out.print("Duración (min): ");
        int duracion = sc.nextInt(); sc.nextLine();
        i.agregarDisco(new Disco(titulo, ano, duracion));
    }

    private static void eliminarDisco() {
        System.out.print("Nombre del intérprete: ");
        String nombre = sc.nextLine();
        Interprete i = arbol.buscar(nombre);
        if (i == null) {
            System.out.println("Intérprete no encontrado.");
            return;
        }
        List<Disco> discos = i.getDiscos();
        for (int j = 0; j < discos.size(); j++) {
            System.out.println((j + 1) + ". " + discos.get(j));
        }
        System.out.print("Seleccione el número del disco a eliminar (0 para cancelar): ");
        int eleccion = sc.nextInt(); sc.nextLine();
        if (eleccion > 0 && eleccion <= discos.size()) {
            i.eliminarDisco(eleccion - 1);
            System.out.println("Disco eliminado.");
        } else {
            System.out.println("Cancelado.");
        }
    }

    private static void mostrarDiscosDeInterprete() {
        System.out.print("Nombre del intérprete: ");
        String nombre = sc.nextLine();
        Interprete i = arbol.buscar(nombre);
        if (i == null) {
            System.out.println("Intérprete no encontrado.");
        } else {
            for (Disco d : i.getDiscos()) {
                System.out.println(d);
            }
        }
    }

    private static void listarDiscosPorAno() {
        System.out.print("Año a buscar: ");
        int ano = sc.nextInt(); sc.nextLine();
        arbol.listarDiscosPorAno(ano);
    }
}