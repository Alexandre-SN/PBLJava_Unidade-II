package model;

import repository.SaveRepository;

import java.util.List;

public class Conquista {
    private String explorador;
    private Integer visit;
    private List<Integer> rooms = List.of(10,11,12,13,16);

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
        // para desbloquear a conquista explorador o jogador precisa visitar todas as salas do apartamento
        for(Integer room : rooms){
            if (jogoAtual.getCenaAtual() != null) {
                if (jogoAtual.getCenaAtual().getIdCena() == room) {
                    if (jogoAtual.getCapituloAtual().getNumero() == 2) {
                        this.visit += 1;
                    }
                }
            }
        }
        System.out.println(visit);
        if (visit >= 5){
            this.explorador = "1";
        }
    }
}
