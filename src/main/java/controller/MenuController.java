package controller;

import model.Config;
import model.Conquista;
import model.SaveData;
import repository.SaveRepository;
import view.MenuView;
import service.JogoService;


public class MenuController {
    private MenuView menuView;
    private JogoService jogoService;
    private JogoController jogoController;
    private ConfigController configController;
    private SaveRepository save;

    public MenuController(MenuView menuView, JogoService jogoService, JogoController jogoController, ConfigController configController, SaveRepository save) {
        this.menuView = menuView;
        this.jogoService = jogoService;
        this.jogoController = jogoController;
        this.configController = configController;
        this.save = save;
    }

    public void startMenu(Config config, Conquista conquista) {
        config.executeColor();
        String option = "0";
        while(!option.equals("6")){
            menuView.showMenu();
            option = menuView.readOption();
            switch(option) {
                case "1":
                    String nome = menuView.pedirNome();
                    String genero = menuView.pedirGenero();

                    if (genero.equals("1")) {
                        genero = "Masculino";
                    } else {
                        genero = "Feminino";
                    }

                    jogoService.newGame(nome, genero);
                    jogoController.iniciarJogo();
                    break;

                case "2":
                    carregarJogo();
                    break;

                case "3":
                    //mostrar créditos
                    break;
                case "4":
                    //mostrar opções
                    configController.option();
                    break;
                case "5":
                    menuView.showConquista(conquista);
                    break;
                case "6":
                    //Encerra o jogo
                    break;
            }
        }
    }

    private void carregarJogo() {
        System.out.println();

        String[] slots = {"auto", "1", "2", "3"};

        for (String slot : slots) {
            String caminhoArquivo = JogoController.caminhoSlot(slot);
            SaveData data = null;

            if (save.existe(caminhoArquivo)) {
                data = save.readFile(caminhoArquivo, SaveData.class, null);
            }

            String rotulo;
            if (slot.equals("auto")) {
                rotulo = "A";
            } else {
                rotulo = slot;
            }

            menuView.showSlot(rotulo, data, save.existe(caminhoArquivo));
        }

        System.out.println("\nEscolha o slot (A, 1, 2, 3) ou 0 para voltar:");

        String entrada = menuView.readOption().trim().toLowerCase();
        String slot;

        if (entrada.equals("a")) {
            slot = "auto";
        } else {
            slot = entrada;
        }

        if (!slot.matches("auto|[1-3]"))
            return;

        String caminho = JogoController.caminhoSlot(slot);

        if (!save.existe(caminho)) {
            System.out.println("Slot vazio!"); return;
        }

        SaveData data = save.readFile(caminho, SaveData.class, null);

        if (data != null && jogoService.carregarSave(data)) {
            jogoController.iniciarJogo();
        } else {
            System.out.println("Save corrompido ou incompatível.");
        }
    }
}
