package org.example;

public class Usuario {
    private Integer id;
    private String nombre_usuario;
    private String contraseña;

    public Usuario() {}

    public Usuario(int id, String nombre_usuario, String contraseña) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
