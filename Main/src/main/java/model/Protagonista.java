package model;


public class Protagonista {
    private String nome;
    private String nomeDetetive;
    private String genero;
    private int sanidade = 100;
    private int autoestima = 100;
    private Inventario inventario;

    public Protagonista(String nome, String genero, String nomeDetetive) {
        this.nome = nome;
        this.nomeDetetive = nomeDetetive;
        this.genero = genero;
        this.inventario = new Inventario();
    }

    public void alterarSanidade(int valor) {
        this.sanidade += valor;
    }

    public void alterarAutoestima(int valor) {
        this.autoestima += valor;
    }

    public String getNome() {
        return this.nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public int getAutoestima() {
        return autoestima;
    }

    public int getSanidade() {
        return sanidade;
    }
    public Inventario getinventario(){
        return inventario;
    }
}
