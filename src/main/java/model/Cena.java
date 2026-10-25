package model;

import java.util.ArrayList;
import java.util.List;


public class Cena {
    private int idCena;
    private String textoNarrativo;
    private List<Fala> falas;
    private List<Opcao> opcoes; // 1 possui N

    public Cena(int idCena, String textoNarrativo) {
        this.idCena = idCena;
        this.textoNarrativo = textoNarrativo;
        this.falas = new ArrayList<>();
        this.opcoes = new ArrayList<>();
    }

    public String getTextoNarrativo() { return textoNarrativo; }
    public List<Fala> getFalas() { return falas; }
    public List<Opcao> getOpcoes() { return opcoes; }
    public int getIdCena() { return idCena; }
}
