package view;
import java.util.Scanner;
public class ConfigView {
    
    private Scanner scanner = new Scanner(System.in);

    public void showConfig(){
          System.out.println("""
            ==============================================
                             Configurações
            ==============================================
            1 - Alterar as cores do terminal para vermelho
            2 - Sair
            ==============================================
            """);
    }

    public String readOption(){
        return scanner.nextLine();
    }
}
