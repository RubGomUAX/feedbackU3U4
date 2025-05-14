package Ejercicio1;

public class Disco implements Comparable<Disco> {
    private String titulo;
    private int ano;
    private int duracion;

    public Disco(String titulo, int ano, int duracion) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracion = duracion;
    }

    public String getTitulo() { return titulo; }
    public int getAno() { return ano; }
    public int getDuracion() { return duracion; }

    @Override
    public int compareTo(Disco otro) {
        return Integer.compare(this.ano, otro.ano);
    }

    @Override
    public String toString() {
        return String.format("%s (%d)-%d min", titulo, ano, duracion);
    }
}
