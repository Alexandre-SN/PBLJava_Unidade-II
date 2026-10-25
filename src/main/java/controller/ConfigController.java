package controller;

import repository.SaveRepository;
import view.ConfigView;
import model.Config;

public class ConfigController {
    private ConfigView configview;
    private Config config;
    private SaveRepository save;

    public ConfigController(ConfigView view, Config config, SaveRepository save){
        this.configview = view;
        this.config = config;
        this.save = save;
    }
    
    public void option(){
        String option = "0";
        while (!option.equals("4")) {
            configview.showConfig();
            option = configview.readOption();
            switch (option) {
                case "1":
                    if (config.getColor().equals("0")) {
                        System.out.println("\u001B[31m");
                        // se cor é igual a 1, o terminal está vermelho
                        // se cor é igual a 0, o terminal está na cor normal
                        config.changeColor("1");
                    }
                    else{
                        System.out.println("\u001B[0m");
                        config.changeColor("0");
                    }
                    break;
                case "2":
                    if (config.getsave().equals("0")) {
                        config.changeSave("1");
                        System.out.println("Save automático LIGADO.");
                    } else {
                        config.changeSave("0");
                        System.out.println("Save automático DESLIGADO.");
                    }
                    break;
                case "3":
                    if (config.getIntervalo().equals("0")) {
                        config.changeIntervalo("1");
                    } else {
                        config.changeIntervalo("0");
                    }
                    break;
                case "4":
                    System.out.println("Salvando as configurações...");
                    this.save.writeFile("saves/config.json", this.config);
                    break;
            }
        }
    }
}
