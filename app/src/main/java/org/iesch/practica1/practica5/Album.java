package org.iesch.practica1.practica5;

public class Album {
    private int foto;
    private String titulo;
    private String cantante;
    private String ano;

    public Album(int foto, String titulo, String cantante, String ano) {
        this.foto = foto;
        this.titulo = titulo;
        this.cantante = cantante;
        this.ano = ano;
    }

    public int getFoto() {
        return foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCantante() {
        return cantante;
    }

    public String getAno() {
        return ano;
    }
}
