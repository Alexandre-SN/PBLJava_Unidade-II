package model;


public class Fala {
    private String nomePersonagem;
    private String texto;

    public Fala(String nomePersonagem, String texto) {
        this.nomePersonagem = nomePersonagem;
        this.texto = texto;
    }

    public String getNomePersonagem() { return nomePersonagem; }
    public String getTexto() { return texto; }
}
