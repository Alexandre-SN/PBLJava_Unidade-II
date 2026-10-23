package view;

import java.util.Scanner;


public class MenuView {

    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("""
            ====================
                    MENU
            ====================
            1 - Novo Jogo
            2 - Créditos
            3 - Opções
            4 - Sair
            ====================
            """);
    }

    public String pedirNome() {
        System.out.print("\nDigite o seu nome: ");
        return scanner.nextLine();
    }

    public String pedirGenero() {
        String opcaoGenero;

        System.out.println("""
            \nQual o gênero do seu personagem?
            
            1 - Masculino
            2 - Feminino
            """);

        opcaoGenero = scanner.nextLine();

        while (!opcaoGenero.equals("1") && !opcaoGenero.equals("2")){
            System.out.println("Digite uma opção válida!");

            opcaoGenero = scanner.nextLine();
        }

        return opcaoGenero;
    }

    public String readOption() {
        return scanner.nextLine();
    }
}
