package main;

import view.MenuView;
import view.TerminalView;
import view.ConfigView;
import repository.CapituloRepository;
import service.JogoService;
import controller.JogoController;
import controller.MenuController;
import controller.ConfigController;
import view.ConfigView;
import model.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import repository.SaveRepository;
public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        SaveRepository save = new SaveRepository(mapper);
        Config config = save.ReadConfig();



        TerminalView terminalView = new TerminalView(config);
        MenuView menuView = new MenuView();
        ConfigView configView = new ConfigView();

        CapituloRepository capituloRepo = new CapituloRepository();

        JogoService jogoService = new JogoService(capituloRepo);

        ConfigController configController = new ConfigController(configView, config, save);
        JogoController jogoController = new JogoController(terminalView, jogoService);
        MenuController menuController = new MenuController(menuView, jogoService, jogoController,configController);

        menuController.startMenu(config);
    }
}
