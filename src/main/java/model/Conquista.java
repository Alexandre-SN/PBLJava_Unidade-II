package model;

import repository.SaveRepository;

import java.util.ArrayList;
import java.util.List;

public class Conquista {
    private String explorador;
    private Integer visit;
    private List<Integer> rooms = new ArrayList<>(List.of(10, 11, 12, 13, 16));

    public Conquista(){}

    public Conquista(String explorador){
        this.explorador = explorador;
    }

    public void setVisit() {
        this.visit = 0;
    }

    public String getExplorador() {
        return explorador;
    }

    public void exploradorCheck(Jogo jogoAtual){
        if (jogoAtual.getCenaAtual() != null && jogoAtual.getCapituloAtual() != null) {
            if (jogoAtual.getCapituloAtual().getNumero() == 2) {
                if (rooms.contains(jogoAtual.getCenaAtual().getIdCena())) {
                    this.visit += 1;
                    rooms.remove((Object)jogoAtual.getCenaAtual().getIdCena());
                }
            }
        }
        if (visit >= 5){
            this.explorador = "1";
        }
    }
}