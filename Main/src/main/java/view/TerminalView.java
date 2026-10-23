package view;

import model.Fala;
import model.Opcao;
import model.Protagonista;
import model.Config;

import java.util.List;
import java.util.Scanner;


public class TerminalView {
    private Scanner scanner;
    private Config config;
    public TerminalView(Config config) {
        this.scanner = new Scanner(System.in);
        this.config = config;
    }

    public void escreverGradual(String texto){
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            try{
                //pausa a escrita no terminal pelo tempo definido
                if (this.config.getIntervalo().equals("0")) {
                    Thread.sleep(50);
                }
                else{
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("A animação foi interrompida.");
            }
        }
    }

    public void exibirStatusProtagonista(Protagonista protagonista) {
        System.out.println(
                "\n--- [ Sanidade: " + protagonista.getSanidade()
                + " ] --- [ Autoestima: " + protagonista.getAutoestima()
                + " ] ---"
        );
    }

    public void mostrarCena(String textoNarrativo, List<Fala> falas, String intervalo) {
        escreverGradual("\n" + textoNarrativo);
        for (Fala fala : falas) {
            System.out.println(fala.getNomePersonagem() + ": " + fala.getTexto());
        }
    }

    public void mostrarOpcoes(List<Opcao> opcoes) {
        System.out.println("\n");
        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i + 1) + ". " + opcoes.get(i).getTextoOpcao());
        }
        System.out.print("\n");
    }

    public int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println("\n" + mensagem);
    }
}
