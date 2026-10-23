package service;

import model.Capitulo;
import model.Cena;
import model.Jogo;
import model.Opcao;
import model.Protagonista;
import repository.CapituloRepository;


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

            // Aqui métodos para alterar a afinidade dos NPCs
            // jogoAtual.adicionarEscolha(opt.getTextoOpcao()); // Para salvar a escolha

            int idProximaCena = opt.getProximaCenaId();
            int idProximoCapitulo = opt.getProximoCapituloId();

            if (idProximoCapitulo > 0) {
                Capitulo novoCapitulo = capituloRepository.buscarCapitulo(idProximoCapitulo,protagonista);
                        
                if (novoCapitulo != null) {
                    jogoAtual.setCapituloAtual(novoCapitulo); // Atualiza o capítulo no Jogo
                    jogoAtual.setCenaAtual(novoCapitulo.getProximaCena(idProximaCena)); // Carrega a cena do novo capítulo
                } 
                
                else {
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
