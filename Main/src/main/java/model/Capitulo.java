package model;

import java.util.ArrayList;
import java.util.List;


public class Capitulo {
    private int numero;
    private String titulo;
    private List<Cena> cenas;

    public Capitulo(int numero, String titulo) {
        this.numero = numero;
        this.titulo = titulo;
        this.cenas = new ArrayList<>();
    }

    public void addCena(Cena cena) {
        this.cenas.add(cena);
    }

    public String getTitulo() {
        return titulo;
    }

    public Cena getProximaCena(int idCena) {
        for (Cena cena : cenas) {
            if (cena.getIdCena() == idCena) return cena;
        }

        return null;
    }
}
