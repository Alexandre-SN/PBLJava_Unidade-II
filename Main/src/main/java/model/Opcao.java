package model;


public class Opcao {
    private String textoOpcao;
    private int proximaCenaId;
    private int efeitoConfianca;
    private int efeitoIntimidade;
    private int efeitoSanidade;
    private int proximoCapituloId;

    public Opcao(String texto, int proximaCenaId, int efeitoConfianca, int efeitoIntimidade, int efeitoSanidade, int proximoCapituloId) {
        this.textoOpcao = texto;
        this.proximaCenaId = proximaCenaId;
        this.efeitoConfianca = efeitoConfianca;
        this.efeitoIntimidade = efeitoIntimidade;
        this.efeitoSanidade = efeitoSanidade;
        this.proximoCapituloId = proximoCapituloId;
    }
    public String getTextoOpcao() {
        return textoOpcao;
    }

    public int getProximaCenaId() {
        return proximaCenaId;
    }

    public int getEfeitoSanidade() {
        return efeitoSanidade;
    }
    
    public int getProximoCapituloId() {
    return proximoCapituloId;
}
}
