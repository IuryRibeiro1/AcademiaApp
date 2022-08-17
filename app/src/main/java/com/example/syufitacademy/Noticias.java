package com.example.syufitacademy;

public class Noticias {

    private String titulo;
    private String noticia;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public Noticias(String titulo, String noticia) {
        this.titulo = titulo;
        this.noticia = noticia;
    }
}
