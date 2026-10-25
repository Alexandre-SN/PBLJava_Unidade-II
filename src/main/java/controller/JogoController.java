package controller;

import model.*;
import repository.SaveRepository;
import service.JogoService;
import view.TerminalView;


public class JogoController {

    private TerminalView view;
    private JogoService jogoService;
    private Conquista conquista;
    private SaveRepository save;
    private Config config;

    public JogoController(TerminalView view, JogoService jogoService, Conquista conquista, SaveRepository save, Config config) {
        this.view = view;
        this.jogoService = jogoService;
        this.conquista = conquista;
        this.save = save;
        this.config = config;
    }

    public void iniciarJogo() {
        Jogo jogo = jogoService.getJogoAtual();
        conquista.setVisit();

        while(jogo.getCenaAtual() != null) {
            Cena cenaAtual = jogo.getCenaAtual();

            view.exibirStatusProtagonista(jogo.getProtagonista());
            view.mostrarCena(cenaAtual.getTextoNarrativo(), cenaAtual.getFalas(),"1");
            view.mostrarOpcoes(cenaAtual.getOpcoes());

            String entrada = view.lerEntrada();

            if (entrada.equalsIgnoreCase("s")) {          // SAVE MANUAL
                if (menuPausa())
                    return;                  // true = voltar ao menu principal
                continue;
            }

            int escolha;

            try {
                escolha = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                escolha = -1;
            }

            boolean escolhaValida = jogoService.processarEscolha(escolha - 1, jogo.getProtagonista());
            conquista.exploradorCheck(jogo);
            save.writeFile("saves/conquistas.json", conquista);

            if (!escolhaValida) {
                view.exibirMensagem("Opção inválida!");
            } else if (jogo.getCenaAtual() != null && config.getsave().equals("1")) {   // SAVE AUTOMÁTICO
                save.writeFile(caminhoSlot("auto"), jogoService.criarSave());
            }
        }

        view.exibirMensagem("\nFim de Jogo!");
    }

    private boolean menuPausa() {
        while (true) {
            view.exibirMensagem("""
            ===== PAUSA =====
            
            1 - Salvar jogo
            2 - Voltar ao jogo
            3 - Sair para o menu principal
            """);

            switch (view.lerEntrada()) {
                case "1":
                    salvarManual();
                    break;
                case "2":
                    return false;
                case "3":
                    return true;
            }
        }
    }

    private void salvarManual() {
        String slot;
        do {
            for (int i = 1; i <= 3; i++) {
                String caminho = caminhoSlot(String.valueOf(i));
                view.mostrarSlot(String.valueOf(i), lerSlot(caminho), save.existe(caminho));
            }
            view.exibirMensagem("Em qual slot salvar? (1-3, 0 = cancelar)");
            slot = view.lerEntrada();
        } while (!slot.equals("0") && !slot.equals("1") && !slot.equals("2") && !slot.equals("3"));

        if (slot.equals("0"))
            return;

        String caminho = caminhoSlot(slot);

        if (save.existe(caminho)) {
            String confirm;
            do {
                view.exibirMensagem("O slot " + slot + " já tem um save. Deseja sobrescrever? (S/N)");
                confirm = view.lerEntrada();
            } while (!confirm.equalsIgnoreCase("s") && !confirm.equalsIgnoreCase("n"));

            if (confirm.equalsIgnoreCase("n")) {
                view.exibirMensagem("Save cancelado.");
                return;
            }
        }

        boolean ok = save.writeFile(caminho, jogoService.criarSave());
        if (ok) {
            view.exibirMensagem("Jogo salvo no slot " + slot + "!");
        } else {
            view.exibirMensagem("Falha ao salvar.");
        }
    }

    private SaveData lerSlot(String caminho) {
        if (save.existe(caminho)) {
            return save.readFile(caminho, SaveData.class, null);
        } else {
            return null;
        }
    }

    public static String caminhoSlot(String slot) {
        return "saves/slot_" + slot + ".json";
    }
}
