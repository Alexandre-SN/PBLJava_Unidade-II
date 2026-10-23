package model;

import java.util.HashSet;
import java.util.Set;


public class Jogo {
    private Protagonista protagonista;
    private Capitulo capituloAtual;
    private Cena cenaAtual;
    private Set<String> escolhasFeitas;

    public Jogo(Protagonista protagonista, Capitulo capituloAtual) {
        this.protagonista = protagonista;
        this.capituloAtual = capituloAtual;
        this.escolhasFeitas = new HashSet<>();
    }

    public void setCapituloAtual(Capitulo capituloAtual) {
    this.capituloAtual = capituloAtual;
}
    public Protagonista getProtagonista() {
        return protagonista;
    }

    public Capitulo getCapituloAtual() {
        return capituloAtual;
    }

    public Cena getCenaAtual() {
        return cenaAtual;
    }

    public void setCenaAtual(Cena cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    public void adicionarEscolha(String escolha) {
        this.escolhasFeitas.add(escolha);
    }

    public boolean fezEscolha(String escolha) {
        return this.escolhasFeitas.contains(escolha);
    }
}
