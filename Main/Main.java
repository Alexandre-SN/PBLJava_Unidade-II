import view.MenuView;
import view.TerminalView;
import view.ConfigView;
import repository.CapituloRepository;
import service.JogoService;
import controller.JogoController;
import controller.MenuController;
import controller.ConfigController;

import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        TerminalView terminalView = new TerminalView();
        MenuView menuView = new MenuView();
        ConfigView configView = new Configview();

        CapituloRepository capituloRepo = new CapituloRepository();

        JogoService jogoService = new JogoService(capituloRepo);

        ConfigController configController = new ConfigController();
        JogoController jogoController = new JogoController(terminalView, jogoService);
        MenuController menuController = new MenuController(menuView, jogoService, jogoController,configController);

        menuController.startMenu();
    
    }
}
