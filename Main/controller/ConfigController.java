package controller;
import view.ConfigView;

public class ConfigController {
    private ConfigView configview;
    
    public void configView(ConfigView view){

        this.configview = view;
    }
    
    public void option(){

        configview.showConfig();
        String option = configview.readOption();
        
        switch(option){
            case "1":
                System.out.println("teste");
            case "2":
                System.out.println("teste2");
        }

    }
}
