package repository;

import model.Capitulo;
import model.Cena;
import model.Opcao;
import model.Protagonista;

public class CapituloRepository {

    public Capitulo buscarCapitulo(int numeroCapitulo, Protagonista protagonista) {
        if (numeroCapitulo == 1) {
           Capitulo cap1 = new Capitulo(1, "Prólogo");
 
            Cena cena1 = new Cena(1, "Detetive: Olá, bem-vindo.");
            cena1.getOpcoes().add(new Opcao("Bem-vindo? Bem-vindo ao que?", 2, 0, 0, 0,0));
 
            Cena cena2 = new Cena(2, "Detetive: Ao seu primeiro dia no planeta Terra, primeiros minutos, aliás. Me responda, por acaso se lembra de qualquer coisa que ocorreu antes deste momento?");
            cena2.getOpcoes().add(new Opcao("Não.", 3, 0, 0, 0,0));
 
            Cena cena3 = new Cena(3, "Detetive: Pois então seja bem-vindo à existência.");
            cena3.getOpcoes().add(new Opcao("pressione 1 para continuar",6 , 0, 0, 0,0));

            Cena cena6 = new Cena(6, "Detetive: Muito bem " + protagonista.getNome() + ", quero que veja isso.");
            cena6.getOpcoes().add(new Opcao("pressione 1 para continuar", 7, 0, 0, 0,0));
 
            Cena cena7 = new Cena(7, "O grande detetive retira de seu sobretudo uma pasta surrada, o couro da capa é velho e de baixa qualidade, manchas de gordura e álcool absorvidas pelo couro sintético são notórias. O homem joga o documento sob a mesa de forma desleixada, gerando um leve estalo. Em seguida, abre a pasta numa página específica, está escrito \"Caso N-037967\".");
            cena7.getOpcoes().add(new Opcao("Grande detetive?", 8, 0, 0, 0,0));
            cena7.getOpcoes().add(new Opcao("Por que está me mostrando isso?", 9, 0, 0, 0,0));
            cena7.getOpcoes().add(new Opcao("Espera, eu preciso que você me explique algumas coisas. (prosseguir)", 10, 0, 0, 0,0));
 
            Cena cena8 = new Cena(8, "Detetive: Isso. Grande detetive. Agora dê uma olhada.");
            cena8.getOpcoes().add(new Opcao("pressione 1 para continuar", 7, 0, 0, 0,0));
 
            Cena cena9 = new Cena(9, "Detetive: Não é óbvio? Vamos ter que resolver esse caso.");
            cena9.getOpcoes().add(new Opcao("pressione 1 para continuar", 7, 0, 0, 0,0));
 
              Cena cena10 = new Cena(10, "Detetive: Tipo o quê?");
            cena10.getOpcoes().add(new Opcao("Quem sou eu? O que sou eu?", 11, 0, 0, 0,0));
            cena10.getOpcoes().add(new Opcao("Você nem sequer me contou seu nome.", 12, 0, 0, 0,0));
            cena10.getOpcoes().add(new Opcao("Onde estamos?", 13, 0, 0, 0,0));
            cena10.getOpcoes().add(new Opcao("Já entendi o suficiente. (prosseguir)", 14, 0, 0, 0,0));
 
            Cena cena11 = new Cena(11, "Detetive: Você já me respondeu essa. Você é " + protagonista.getNome() + ".\n"
                    + protagonista.getNome() + ": Quem eu sou eu sei, mas o que sou eu?\n"
                    + "Detetive: " + protagonista.getNome() + ", eu não me importo o suficiente com o que é você, você também não devia. Vamos deixar assim.");
            cena11.getOpcoes().add(new Opcao("pressione 1 para continuar", 10, 0, 0, 0,0));
 
            Cena cena12 = new Cena(12, "Detetive: Bom, meu nome é Cesar, feliz?");
            cena12.getOpcoes().add(new Opcao("Pressione 1 para prosseguir", 10, 0, 0, 0,0));
 
            Cena cena13 = new Cena(13, "Detetive: Num bar. Não é o primeiro da noite, quando cheguei aqui já estava bêbado demais para prestar atenção no nome.\n\nO detetive pega um copo modelo rocks, cheio por pouco menos da metade de whisky e gelo, leva-o até a boca rapidamente e bebe de uma vez o que restava no copo. Em seguida, tira do bolso de sua camisa um maço de cigarro e um isqueiro, ele acende, traga o cigarro e deposita suas cinzas num cinzeiro de vidro com mais bitucas do que se esperaria de uma mesa com um cliente só.");
            cena13.getOpcoes().add(new Opcao("pressione 1 para continuar", 10, 0, 0, 0,0));
 
            // ----- Apresentação do caso -----
            Cena cena14 = new Cena(14, "Detetive: Bom, agora que suas dúvidas foram sanadas, vamos nos concentrar no que realmente importa, meu caso, nosso caso, agora.");
            cena14.getOpcoes().add(new Opcao("pressione 1 para continuar", 15, 0, 0, 0,0));
 
            Cena cena15 = new Cena(15, "Detetive: Durante a madrugada de ontem, uma pessoa foi assassinada em seu apartamento. A vítima foi encontrada com diversas marcas de contusão, além de perfurações por todo o corpo. Causa da morte ainda não identificada, vamos ter que trabalhar nisso.");
            cena15.getOpcoes().add(new Opcao("pressione 1 para continuar", 16, 0, 0, 0,0));
 
            Cena cena16 = new Cena(16, "Detetive: O prédio em questão se chama \"Paraíso Azul\", o apartamento da vítima é o 4B, vamos investigar o apartamento amanhã. O corpo ainda está na propriedade, vamos ter que analisá-lo também.");
            cena16.getOpcoes().add(new Opcao("pressione 1 para continuar", 17, 0, 0, 0,0));
 
            Cena cena17 = new Cena(17, "Detetive: Alguma dúvida?");
            cena17.getOpcoes().add(new Opcao("Qual o nome da vítima?", 18, 0, 0, 0,0));
            cena17.getOpcoes().add(new Opcao("A vítima possuía algum histórico suspeito?", 19, 0, 0, 0,0));
            cena17.getOpcoes().add(new Opcao("Alguma pessoa que possa ser um suspeito?", 20, 0, 0, 0,0));
            cena17.getOpcoes().add(new Opcao("Nenhuma dúvida. (prosseguir)", 21, 0, 0, 0,0));
 
            Cena cena18 = new Cena(18, "Detetive: Você vai aprender nesse serviço que de nada adianta conhecer o nome dos mortos, é só mais um nome para somar à sua contagem de desastres. Vai por mim, estou te fazendo um favor em não te contar.");
            cena18.getOpcoes().add(new Opcao("pressione 1 para continuar", 17, 0, 0, 0,0));
 
            Cena cena19 = new Cena(19, "Detetive: Ainda não sabemos, a investigação está num estado bem inicial. A vítima não possuía nenhum histórico na polícia, se é o que quer saber.");
            cena19.getOpcoes().add(new Opcao("pressione 1 para continuar", 17, 0, 0, 0,0));
 
            Cena cena20 = new Cena(20, "Detetive: Nada no momento, a vítima morava sozinha há 3 anos, e não há ninguém que dê para fazer uma ligação imediata. Vamos descobrir isso melhor amanhã, na investigação.");
            cena20.getOpcoes().add(new Opcao("pressione 1 para continuar", 17, 0, 0, 0,0));
 
            Cena cena21 = new Cena(21, "Detetive: E aí? Pronto para pegar esse assassino?");
            cena21.getOpcoes().add(new Opcao("Eu não acho que eu tenha muita escolha.", 22, 0, 0, 0,0));
            cena21.getOpcoes().add(new Opcao("E se eu não quiser?", 23, 0, 0, 0,0));
 
            Cena cena22 = new Cena(22, "Detetive: É assim que se fala, vamos descansar agora, está ficando tarde, e minha conta está ficando cara. Amanhã será um dia produtivo.");
            cena22.getOpcoes().add(new Opcao("pressione 1 para continuar", 24, 0, 0, 0,0));
 
            Cena cena23 = new Cena(23, "Você realmente não tem escolha. Esse é o seu destino.");
            cena23.getOpcoes().add(new Opcao("pressione 1 para continuar", 21, 0, 0, 0,0));
 
            Cena cena24 = new Cena(24, "O detetive pede a conta ao garçom. Na nota fiscal, todos os pedidos feitos foram de bebidas alcoólicas. Whisky, vodka, cachaça, esses nomes se repetem, quase como um loop.\n\nO detetive paga a conta, coleta sua pasta de casos, levanta da mesa e se dirige para fora do bar, onde ele anda cambaleando vagarosamente até sua casa, que não é muito longe dali. O detetive abre a porta, está escuro demais para que você perceba quaisquer detalhes relevantes, ele se joga no sofá imediatamente, como se seu corpo estivesse andando automaticamente, buscando qualquer lugar em que seja possível descansar.");
            cena24.getOpcoes().add(new Opcao("pressione 1 para continuar", 25, 0, 0, 0,0));
 
            Cena cena25 = new Cena(25, "Não corra.\nVocê está confortável agora, mas eu vou te alcançar.\nVou te alcançar e socar seu estômago. Vou fazer você vomitar sua esperança.\nNão corra.\nVocê vai se arrepender disso.\n\nFIM DO PRÓLOGO.");
            cena25.getOpcoes().add(new Opcao("pressione 1 para continuar", 1, 0, 0, 0,2)); // 0 encerra o capítulo
 
            cap1.addCena(cena1);
            cap1.addCena(cena2);
            cap1.addCena(cena3);
            cap1.addCena(cena6);
            cap1.addCena(cena7);
            cap1.addCena(cena8);
            cap1.addCena(cena9);
            cap1.addCena(cena10);
            cap1.addCena(cena11);
            cap1.addCena(cena12);
            cap1.addCena(cena13);
            cap1.addCena(cena14);
            cap1.addCena(cena15);
            cap1.addCena(cena16);
            cap1.addCena(cena17);
            cap1.addCena(cena18);
            cap1.addCena(cena19);
            cap1.addCena(cena20);
            cap1.addCena(cena21);
            cap1.addCena(cena22);
            cap1.addCena(cena23);
            cap1.addCena(cena24);
            cap1.addCena(cena25);
            return cap1;
        }

        else if (numeroCapitulo == 2) {
            Capitulo cap2 = new Capitulo(2, "Dia 1, Dia");
 
            Cena cena1 = new Cena(1, "Detetive: É aqui, apartamento 5B, a cena do crime.");
            cena1.getOpcoes().add(new Opcao("Você devia bater na porta.", 2, -1, 0, 0,0));
            cena1.getOpcoes().add(new Opcao("Entre de uma vez, a cena do crime é sua, afinal.", 3, 1, 0, 0,0));
            cena1.getOpcoes().add(new Opcao("Grite perguntando se tem alguém aí.", 4, 0, -1, -1,0));
 
            Cena cena2 = new Cena(2, "O detetive bate na porta 5 vezes, nenhuma resposta. Talvez seja porque o morador do local é um cadáver.\n\nO detetive decide bater novamente, mais 3 vezes. Surpreendentemente, o curto silêncio após as batidas é interrompido pelo ranger da porta velha se abrindo. De dentro do apartamento surge uma figura familiar.\n\nJorge: Sabe, você é o encarregado desse caso, não precisava bater. Aliás, quem você achou que poderia atender a porta?\nDetetive: Não sei, bati por costume, eu acho. Rotina.\nJorge: Costume, claro. Você é cheio deles.");
            cena2.getOpcoes().add(new Opcao("pressione 1 para continuar", 5, 0, 0, 0,0));
 
            Cena cena3 = new Cena(3, "O detetive segura a maçaneta, que está meio solta, gira-a para o lado e abre a porta, emitindo um ranger terrível. Dentro do apartamento é possível ver uma figura familiar que imediatamente virou seus olhos para a porta, graças ao barulho.\n\nJorge: Finalmente chegou, estava me deixando cansado de esperar.");
            cena3.getOpcoes().add(new Opcao("pressione 1 para continuar", 5, 0, 0, 0,0));
 
            Cena cena4 = new Cena(4, "Detetive: TEM ALGUÉM AÍ????? ALÔ????????\n\nContrariando as expectativas do senso comum, a porta se abre para revelar uma figura familiar que está dentro do apartamento, e ele não parece feliz com sua presença.");
            cena4.getOpcoes().add(new Opcao("pressione 1 para continuar", 5, 0, 0, 0,0));
 
            Cena cena5 = new Cena(5, "Jorge: Eu gostaria que o nosso detetive brilhante tivesse pelo menos um pouquinho de bom senso.\nDetetive: Bom senso é uma ferramenta para covardes.\nJorge: E para profissionais que não querem atrair atenção para uma cena de crime de assassinato brutal.");
            cena5.getOpcoes().add(new Opcao("pressione 1 para continuar", 6, 0, 0, 0,0));
 
            Cena cena6 = new Cena(6, "Detetive: Não lembro de a delegacia ter me avisado que você estaria aqui, posso saber por que veio?\nJorge: Você é talentoso, detetive, mas é instável, ainda mais nesses últimos dias. Eles me mandaram para avaliar se você está apto a continuar nesse serviço.\nJorge: Eu sei que faz parte da sua natureza, detetive, mas tente não me decepcionar, eu sou sua última chance.");
            cena6.getOpcoes().add(new Opcao("pressione 1 para continuar", 7, 0, 0, 0,0));
 
            Cena cena7 = new Cena(7, "Detetive: Claro que eles não confiam em mim, mas eu entrego resultados. Falando nisso, eu devia começar o meu trabalho.\nJorge: Vá em frente, o apartamento é todo seu.");
            cena7.getOpcoes().add(new Opcao("pressione 1 para continuar", 8, 0, 0, 0,0));
 
            Cena cena8 = new Cena(8, "O detetive adentra o apartamento, não é exatamente o apartamento mais sujo que você já viu, mas também não é o mais limpo. A residência é relativamente pequena, possui apenas 4 cômodos: quarto, banheiro, cozinha e sala de estar.\n\nNão foi preciso procurar muito para encontrar a vítima, o cadáver está estirado no tapete localizado no centro da sala de estar.");
            cena8.getOpcoes().add(new Opcao("pressione 1 para continuar", 9, 0, 0, 0,0));
 
            // ----- HUB de investigação -----
            Cena cena9 = new Cena(9, "Para onde vamos olhar?");
            cena9.getOpcoes().add(new Opcao("Vamos analisar a cozinha.", 10, 0, 0, 0,0));
            cena9.getOpcoes().add(new Opcao("Vamos analisar a sala de estar.", 11, 0, 0, 0,0));
            cena9.getOpcoes().add(new Opcao("Vamos analisar o banheiro.", 12, 0, 0, 0,0));
            cena9.getOpcoes().add(new Opcao("Vamos analisar o quarto.", 13, 0, 0, 0,0));
            cena9.getOpcoes().add(new Opcao("Vamos analisar o cadáver.(prosseguir)", 16, 0, 0, 0,0));
 
            Cena cena10 = new Cena(10, "A cozinha é bem estreita, não parece que seria confortável ter mais de uma pessoa ao mesmo tempo aqui. Algumas gavetas possuem maçanetas quebradas, a pintura dos móveis está gasta e surrada, com pequenos acúmulos de sujeira e poeira. As paredes da cozinha estão imundas, manchas de gordura transformam certos trechos da pintura branca em um amarelado nauseante, talvez utilizar azulejos tivesse sido uma melhor ideia.\n\nNa pia, diversos pratos e talheres sujos estão amontoados, parecem estar aqui por dias, o que não é surpreendente, visto que o dono não está em condições de lavar os pratos. O cheiro de comida velha acumulada entre a louça está levemente desagradável.\n\nPor fim, a geladeira está quase que vazia, dentre os itens armazenados, você avista um tubo de supercola, um limão cortado ao meio, algumas latas da cerveja mais barata do mercado e 2 potes de macarrão congelado. A vítima provavelmente não tinha um estilo de vida muito saudável. No topo da geladeira, um frasco de comprimidos antidepressivos quase vazio está caído.\n\n(Item \"Comprimidos antidepressivos\" adicionado ao inventário)");
            cena10.getOpcoes().add(new Opcao("pressione 1 para continuar", 9, 0, 0, 0,0));
 
            Cena cena11 = new Cena(11, "O detetive adentra a cena do crime, o cenário é de revirar o estômago, ou seria, se o detetive já não tivesse visto inúmeros casos tão grotescos como esse. O corpo da vítima está no chão, estirado, marcas de cortes por todo o corpo, alguns hematomas visíveis também. Os móveis, predominantemente brancos, são manchados pelo terror carmim dos espirros de sangue. No lado esquerdo da sala, um sofá marrom possui uma grande mancha avermelhada, de sangue velho absorvido pelo tecido.");
            cena11.getOpcoes().add(new Opcao("pressione 1 para continuar", 9, 0, 0, 0,0));
 
            Cena cena12 = new Cena(12, "O banheiro está relativamente limpo, o espelho é velho e possui diversos pontos cegos que não refletem mais. Abaixo, na pia, diversos frascos de produtos de higiene e um copo contendo duas escovas, uma aparentemente nova e outra claramente gasta, junto a um tubo quase vazio de pasta de dente. Nada de muito relevante está presente nesse cômodo.");
            cena12.getOpcoes().add(new Opcao("pressione 1 para continuar", 9, 0, 0, 0,0));
 
            Cena cena13 = new Cena(13, "Ao entrar no quarto, os olhos do detetive se veem perdidos em meio a tanta informação, é difícil conceber a ideia de existir alguém tão bagunceiro. A cama está cheia de lençóis amarrotados e roupas usadas jogadas. A porta do guarda-roupa está cheia de riscos e inclinada. Bom, não parece que o inquilino estava usando o guarda-roupa de qualquer forma.\n\nDetetive: Devo abrir o guarda-roupa?");
            cena13.getOpcoes().add(new Opcao("Abra, qualquer informação que conseguirmos obter vai ser útil.", 14, 0, 0, -1,0));
            cena13.getOpcoes().add(new Opcao("Não abra, estou com um mal pressentimento.", 15, 0, 0, 0,0));
 
            Cena cena14 = new Cena(14, "O detetive tenta abrir o guarda-roupa, segura na maçaneta e acidentalmente arranca a porta fora. É uma pena, mas não parece que o inquilino estava usando o guarda-roupa de qualquer forma. Lá dentro você consegue avistar um frasco de perfume, dois cintos e algumas poucas roupas; o detetive não se deu o trabalho de contar, mas provavelmente existem mais roupas do lado de fora do que dentro. Por último, bem escondido no fundo do guarda-roupa, o detetive avista um porta-retrato quebrado, a foto parece ter sido tirada há vários anos atrás e mostra a vítima sorrindo ao lado de uma outra pessoa.\n\n(Item \"Porta-retrato da vítima\" adicionado ao inventário)\n\nJorge: Adulterando a cena do crime, né?\nDetetive: Não foi de propósito.\nJorge: Mas adulterou. Tenha mais cuidado da próxima vez, não quero ter de continuar sendo a sua babá em outros casos.");
            cena14.getOpcoes().add(new Opcao("pressione 1 para continuar", 9, 0, 0, 0,0));
 
            Cena cena15 = new Cena(15, "Detetive: É, talvez não tenha nada de importante lá dentro mesmo, melhor focar em outras regiões.");
            cena15.getOpcoes().add(new Opcao("pressione 1 para continuar", 9, 0, 0, 0,0));
 
            Cena cena16 = new Cena(16, "Detetive: Chegou o momento. Hora de analisar o cadáver. Primeiro, vamos anotar as características físicas: cabelo marrom ondulado, nem muito grande, nem muito curto, pele branca, olhos verdes, sem pelo facial, ponte do nariz levemente avantajada. Parece ter em volta de 60 a 65 quilos, possui uma marca de nascença na região do trapézio.\n\nA vítima está utilizando uma calça jeans e uma camisa preta com a estampa do que parece ser uma banda de rock, não é possível ler o nome da banda pois os ferimentos possivelmente gerados por esfaqueamento rasgaram diversas partes da roupa, deixando a estampa ilegível.\n\nPor falar nos ferimentos, o tronco e os braços são a região mais afetada por golpes cortantes, já as pernas possuem mais hematomas. Existem cortes profundos na região do coração e dos pulmões. Por mais que a vítima tenha recebido diversos ferimentos cortantes, o cadáver não está tão sujo de sangue quanto se esperaria. O último ferimento relevante é um grande hematoma localizado na região traseira do pescoço da vítima.");
            cena16.getOpcoes().add(new Opcao("pressione 1 para continuar", 17, 0, 0, 0,0));
 
            // ----- Conclusão da investigação -----
            Cena cena17 = new Cena(17, "Jorge: E aí, detetive, como vai a investigação?\nDetetive: Já terminei a minha análise.\nJorge: Posso saber o que concluiu?\nDetetive: Claro, tenho algumas hipóteses.");
            cena17.getOpcoes().add(new Opcao("pressione 1 para continuar", 18, 0, 0, 0,0));
 
            Cena cena18 = new Cena(18, "Qual é a sua hipótese?");
            cena18.getOpcoes().add(new Opcao("A vítima morava sozinha e foi morta pelos cortes na região do coração e pulmão.", 19, 0, 0, 0,0));
            cena18.getOpcoes().add(new Opcao("A vítima morava sozinha e foi morta pelo grande hematoma na região do pescoço.", 19, 0, 0, 0,0));
            cena18.getOpcoes().add(new Opcao("A vítima morava com mais alguém e foi morta pelos cortes na região do coração e pulmão.", 19, 0, 0, 0,0));
            cena18.getOpcoes().add(new Opcao("A vítima morava com mais alguém e foi morta pelo grande hematoma na região do pescoço.", 20, 0, 0, 1,0));
 
            Cena cena19 = new Cena(19, "Jorge: É, pode ser, eu acho, ainda não dá para afirmar nada, mas esperava que você soubesse mais.");
            cena19.getOpcoes().add(new Opcao("pressione 1 para continuar", 21, 0, 0, -1,0));
 
            Cena cena20 = new Cena(20, "Jorge: É um bom palpite, ainda não dá pra ter certeza, mas era isso que eu estava pensando. Até que você faz um bom trabalho.");
            cena20.getOpcoes().add(new Opcao("pressione 1 para continuar", 21, 0, 0, 0,0));
 
            Cena cena21 = new Cena(21, "Jorge: Eu não acho que deveria, mas vou te dar uma dica: esse andar do prédio possui outros dois apartamentos, um deles está desocupado há 2 meses, mas o outro possui um morador, e ele voltará de viagem amanhã. Você deveria voltar aqui e descobrir se ele sabe de alguma coisa, talvez possa até ser um dos suspeitos.");
            cena21.getOpcoes().add(new Opcao("Obrigado, acho que já tenho meu próximo passo.", 22, 0, 0, 1,0));
            cena21.getOpcoes().add(new Opcao("Eu já ia atrás dos vizinhos de qualquer forma.", 23, 1, 0, -1,0));
            cena21.getOpcoes().add(new Opcao("Eu não preciso das suas dicas.", 24, 0, -1, -1,0));
 
            Cena cena22 = new Cena(22, "Jorge: Não agradeça, meio que era minha obrigação te contar isso, eu só estava decidindo se estava com vontade ou não.");
            cena22.getOpcoes().add(new Opcao("pressione 1 para continuar", 25, 0, 0, 0,0));
 
            Cena cena23 = new Cena(23, "Jorge: Você podia engolir esse seu orgulho infundado pelo menos uma vez.");
            cena23.getOpcoes().add(new Opcao("pressione 1 para continuar", 25, 0, 0, 0,0));
 
            Cena cena24 = new Cena(24, "Jorge: Eu trataria melhor o cara que está com a faca no seu pescoço. O seu emprego depende da minha avaliação sobre você, lembre disso.");
            cena24.getOpcoes().add(new Opcao("pressione 1 para continuar", 25, 0, 0, 0,0));
 
            Cena cena25 = new Cena(25, "Jorge: Você deveria ir para casa, temos muito a fazer amanhã. Quer dizer, você tem, mas eu vou estar aqui de qualquer maneira.\n\nFIM DO CAPÍTULO 2.");
            cena25.getOpcoes().add(new Opcao("pressione 1 para continuar", 0, 0, 0, 0,0)); // 0 encerra o capítulo
 
            
            cap2.addCena(cena1);
            cap2.addCena(cena2);
            cap2.addCena(cena3);
            cap2.addCena(cena4);
            cap2.addCena(cena5);
            cap2.addCena(cena6);
            cap2.addCena(cena7);
            cap2.addCena(cena8);
            cap2.addCena(cena9);
            cap2.addCena(cena10);
            cap2.addCena(cena11);
            cap2.addCena(cena12);
            cap2.addCena(cena13);
            cap2.addCena(cena14);
            cap2.addCena(cena15);
            cap2.addCena(cena16);
            cap2.addCena(cena17);
            cap2.addCena(cena18);
            cap2.addCena(cena19);
            cap2.addCena(cena20);
            cap2.addCena(cena21);
            cap2.addCena(cena22);
            cap2.addCena(cena23);
            cap2.addCena(cena24);
            cap2.addCena(cena25);
            return cap2;
        }

        else if (numeroCapitulo == 3) {
            Capitulo cap3 = new Capitulo(3, "Titulo 3");
            //Criação das cenas

            return cap3;
        }

        return null;
    }
}
