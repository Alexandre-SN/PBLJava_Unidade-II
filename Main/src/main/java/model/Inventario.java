package model;

import java.util.ArrayList;
import java.util.List;


public class Inventario {
    private List<String> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String item) {
        itens.add(item);
    }

    public boolean removerItem(String item) {
        return itens.remove(item);
    }

    public List<String> listarItens() {
        return itens;
    }
}
