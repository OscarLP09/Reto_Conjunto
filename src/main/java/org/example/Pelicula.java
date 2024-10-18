package org.example;

public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private int año;
    private String descripcion;
    private String director;

    // Constructor
    public Pelicula(int id, String titulo, String genero, int año, String descripcion, String director) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.año = año;
        this.descripcion = descripcion;
        this.director = director;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAño() {
        return año;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDirector() {
        return director;
    }
}
