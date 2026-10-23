package controller;

import model.Cena;
import model.Jogo;
import service.JogoService;
import view.TerminalView;


public class JogoController {

    private TerminalView view;
    private JogoService jogoService;

    public JogoController(TerminalView view, JogoService jogoService) {
        this.view = view;
        this.jogoService = jogoService;
    }

    public void iniciarJogo() {
        Jogo jogo = jogoService.getJogoAtual();

        while(jogo.getCenaAtual() != null) {
            Cena cenaAtual = jogo.getCenaAtual();

            view.exibirStatusProtagonista(jogo.getProtagonista());
            view.mostrarCena(cenaAtual.getTextoNarrativo(), cenaAtual.getFalas(),"1");
            view.mostrarOpcoes(cenaAtual.getOpcoes());

            int escolha = view.lerOpcao();

            boolean escolhaValida = jogoService.processarEscolha(escolha - 1,jogo.getProtagonista());

            if (!escolhaValida) {
                view.exibirMensagem("Opção inválida!");
            }
        }
        view.exibirMensagem("Fim de Jogo!");
    }
}
