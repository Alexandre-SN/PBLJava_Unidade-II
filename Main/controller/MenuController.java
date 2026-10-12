package controller;

import view.MenuView;
import service.JogoService;
import view.ConfigView;
import controller.ConfigController;
import controller.JogoController;


public class MenuController {
    private MenuView menuView;
    private JogoService jogoService;
    private JogoController jogoController;
    private ConfigController configController;
    private ConfigView configView;

    public MenuController(MenuView menuView, JogoService jogoService, JogoController jogoController, ConfigController configController, ConfigView configView) {
        this.menuView = menuView;
        this.jogoService = jogoService;
        this.jogoController = jogoController;
        this.configController = configController;
        this.configView = configView;
    }

    public void startMenu() {
        menuView.showMenu();
        String option = menuView.readOption();

        switch(option) {
            case "1":
                String nome = menuView.pedirNome();
                String genero = menuView.pedirGenero();

                if (genero.equals("1")){
                    genero = "Masculino";
                }
                else {
                    genero = "Feminino";
                }

                jogoService.newGame(nome, genero);
                jogoController.iniciarJogo();
                break;

            case "2":
                //Exibe créditos
                break;

            case "3":
                //menu de opções
                configView.showConfig();
                String configOption = configView.readOption();
                configController.option(configOption);

            case "4":
                //Encerra o jogo
                break;
        }
    }
}
