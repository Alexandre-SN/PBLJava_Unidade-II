package view;

import model.Conquista;
import model.SaveData;

import java.util.Scanner;


public class MenuView {

    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println();
        System.out.println("""
            ====================
                    MENU
            ====================
            1 - Novo Jogo
            2 - Carregar Jogo
            3 - Créditos
            4 - Opções
            5 - Conquistas
            6 - Sair
            ====================
            """);
    }

    public void showSlot(String rotulo, SaveData data, Boolean arquivoExiste) {
        if (data == null) {
            if (arquivoExiste) {
                System.out.println(rotulo + " - (arquivo corrompido)");
            } else {
                System.out.println(rotulo + " - (vazio)");
            }
        } else {
            String info = rotulo + " - " + data.nome() + " | Capítulo " + data.capituloId() + " | " + data.dataHora();
            System.out.println(info);
        }
    }

    public void showConquista(Conquista conquista) {
        System.out.println("""
            ====================
                 Conquistas
            ====================
            """);
        if (conquista.getExplorador().equals("0")) {
            System.out.println("1 - ??????");
        }
        else {
            System.out.println("1 - Explorador: visitou todas as salas do apartamento");
        }
        System.out.println("""
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
