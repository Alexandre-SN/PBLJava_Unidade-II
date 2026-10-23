package view;
import java.util.Scanner;
public class ConfigView {
    
    private Scanner scanner = new Scanner(System.in);

    public void showConfig(){
          System.out.println("""
            =================================
                          Opções
            =================================
            1 - Alterar as cores do terminal
            2 - Save automático
            3 - Texto Rápido
            4 - Sair
            =================================
            """);
    }

    public String readOption(){
        return scanner.nextLine();
    }
}
