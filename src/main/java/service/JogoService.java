package service;

import model.*;
import repository.CapituloRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class JogoService {
    private Jogo jogoAtual;
    private CapituloRepository capituloRepository;

    public JogoService(CapituloRepository capituloRepository) {
        this.capituloRepository = capituloRepository;
    }

    public void newGame(String nome, String genero) {
        Protagonista protagonista = new Protagonista(nome, genero,"");

        Capitulo cap1 = capituloRepository.buscarCapitulo(1,protagonista); // Busca do banco/repositório

        this.jogoAtual = new Jogo(protagonista, cap1);
        this.jogoAtual.setCenaAtual(cap1.getProximaCena(1)); // Seta a cena inicial
    }

    public Jogo getJogoAtual() {
        return this.jogoAtual;
    }

    public SaveData criarSave() {
        Protagonista p = jogoAtual.getProtagonista();
        return new SaveData(p.getNome(), p.getGenero(), p.getNomeDetetive(),
                p.getSanidade(), p.getAutoestima(),
                new ArrayList<>(p.getinventario().listarItens()),
                jogoAtual.getCapituloAtual().getNumero(),
                jogoAtual.getCenaAtual().getIdCena(),
                new HashSet<>(jogoAtual.getEscolhasFeitas()),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }

    public boolean carregarSave(SaveData data) {
        if (data == null || data.nome() == null || data.nome().isBlank()
                || data.genero() == null || data.genero().isBlank()) {
            return false;
        }
        try {
            return montarJogo(data);
        } catch (RuntimeException e) {
            System.err.println("Erro ao restaurar o save: " + e.getMessage());
            return false;
        }
    }

    public boolean montarJogo(SaveData data) {

        Protagonista p = new Protagonista(data.nome(), data.genero(), data.nomeDetetive());
        p.setSanidade(data.sanidade());
        p.setAutoestima(data.autoestima());

        if (data.itens() != null) {
            for (String item : data.itens()) {
                p.getinventario().adicionarItem(item);
            }
        }

        Capitulo cap = capituloRepository.buscarCapitulo(data.capituloId(), p);
        if (cap == null)
            return false;

        Cena cena = cap.getProximaCena(data.cenaId());
        if (cena == null)
            return false;

        Jogo jogo = new Jogo(p, cap);
        jogo.setCenaAtual(cena);

        Set<String> escolhasDoSave = data.escolhasFeitas();

        if (escolhasDoSave != null) {
            jogo.getEscolhasFeitas().addAll(escolhasDoSave);
        }

        this.jogoAtual = jogo;
        return true;
    }

    public boolean processarEscolha(int indexOpcao, Protagonista protagonista) {
        Cena cenaAtual = jogoAtual.getCenaAtual();

        if (indexOpcao >= 0 && indexOpcao < cenaAtual.getOpcoes().size()) {
            Opcao opt = cenaAtual.getOpcoes().get(indexOpcao);
            if (cenaAtual.getIdCena() == 10){
                protagonista.getinventario().adicionarItem("comprimidos antidepressivos");
            }
            else if (cenaAtual.getIdCena() == 14){
                protagonista.getinventario().adicionarItem("Retrato da vitima");
            }

            jogoAtual.getProtagonista().alterarSanidade(opt.getEfeitoSanidade());

            int idProximaCena = opt.getProximaCenaId();
            int idProximoCapitulo = opt.getProximoCapituloId();

            if (idProximoCapitulo > 0) {
                Capitulo novoCapitulo = capituloRepository.buscarCapitulo(idProximoCapitulo, protagonista);

                if (novoCapitulo != null) {
                    jogoAtual.setCapituloAtual(novoCapitulo); // Atualiza o capítulo no Jogo
                    jogoAtual.setCenaAtual(novoCapitulo.getProximaCena(idProximaCena)); // Carrega a cena do novo capítulo
                } else {
                    jogoAtual.setCenaAtual(null);
                }
            }

            if (idProximaCena <= 0) {
                jogoAtual.setCenaAtual(null); // Encerra o jogo
            }
            else {
                jogoAtual.setCenaAtual(jogoAtual.getCapituloAtual().getProximaCena(idProximaCena));
            }
            return true;
        }
        return false;
    }
}
