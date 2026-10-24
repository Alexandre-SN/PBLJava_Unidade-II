package model;

import java.util.List;

public class Conquista {
    private String explorador;
    private Integer visit;
    private List<Integer> rooms = List.of(10,11,12,13,16);

    public Conquista(String explorador){
        this.explorador = explorador;
        this.visit = 0;
    }
    public void exploradorCheck(Jogo jogoAtual){
        for(Integer room : rooms){
            if (jogoAtual.getCenaAtual().getIdCena() == room){
                this.visit += 1;
            }
        }
        if (visit >= 5){
            this.explorador = "1";
        }
    }
}
