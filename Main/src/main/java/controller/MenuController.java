package controller;

import model.Config;
import model.Conquista;
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

    public MenuController(MenuView menuView, JogoService jogoService, JogoController jogoController, ConfigController configController) {
        this.menuView = menuView;
        this.jogoService = jogoService;
        this.jogoController = jogoController;
        this.configController = configController;
    }

    public void startMenu(Config config, Conquista conquista) {
        config.executeColor();
        String option = "0";
        while(!option.equals("5")){
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
                    //Exibe créditos
                    break;

                case "3":
                    //menu de opções
                    configController.option();
                    break;
                case "4":
                    menuView.showConquista(conquista);
                    break;
                case "5":
                    //Encerra o jogo
                    break;
        }
        }
    }
}
