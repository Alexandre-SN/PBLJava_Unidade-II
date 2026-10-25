package model;
import java.util.List;
import java.util.Set;

public record SaveData(String nome, String genero, String nomeDetetive,
                       int sanidade, int autoestima, List<String> itens,
                       int capituloId, int cenaId, Set<String> escolhasFeitas, String dataHora) {

}
