package controller;

import model.Cena;
import model.Conquista;
import model.Jogo;
import repository.SaveRepository;
import service.JogoService;
import view.TerminalView;


public class JogoController {

    private TerminalView view;
    private JogoService jogoService;
    private Conquista conquista;
    private SaveRepository save;

    public JogoController(TerminalView view, JogoService jogoService, Conquista conquista, SaveRepository save) {
        this.view = view;
        this.jogoService = jogoService;
        this.conquista = conquista;
        this.save = save;
    }

    public void iniciarJogo() {
        Jogo jogo = jogoService.getJogoAtual();
        conquista.setVisit();

        while(jogo.getCenaAtual() != null) {
            Cena cenaAtual = jogo.getCenaAtual();

            view.exibirStatusProtagonista(jogo.getProtagonista());
            view.mostrarCena(cenaAtual.getTextoNarrativo(), cenaAtual.getFalas(),"1");
            view.mostrarOpcoes(cenaAtual.getOpcoes());

            int escolha = view.lerOpcao();

            boolean escolhaValida = jogoService.processarEscolha(escolha - 1,jogo.getProtagonista());
            conquista.exploradorCheck(jogo);
            save.writeFile("saves/conquistas.json",conquista);

            if (!escolhaValida) {
                view.exibirMensagem("Opção inválida!");
            }
        }
        view.exibirMensagem("Fim de Jogo!");
    }
}
