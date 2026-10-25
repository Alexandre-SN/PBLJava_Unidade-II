package main;

import model.Conquista;
import view.MenuView;
import view.TerminalView;
import view.ConfigView;
import repository.CapituloRepository;
import service.JogoService;
import controller.JogoController;
import controller.MenuController;
import controller.ConfigController;
import model.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import repository.SaveRepository;
public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        SaveRepository save = new SaveRepository(mapper);
        Config config = save.readFile("saves/config.json",Config.class,new Config("0","0","0"));
        Conquista conquista = save.readFile("saves/conquistas.json", Conquista.class,new Conquista("0"));

        TerminalView terminalView = new TerminalView(config);
        MenuView menuView = new MenuView();
        ConfigView configView = new ConfigView();

        CapituloRepository capituloRepo = new CapituloRepository();

        JogoService jogoService = new JogoService(capituloRepo);

        ConfigController configController = new ConfigController(configView, config, save);
        JogoController jogoController = new JogoController(terminalView, jogoService, conquista, save, config);
        MenuController menuController = new MenuController(menuView, jogoService, jogoController, configController, save);

        menuController.startMenu(config,conquista);
    }
}
