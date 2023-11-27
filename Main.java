import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Carta[][] matriz = new Carta[5][5];

        Baralho baralho = new Baralho();
        for (int n =1; n <= 109; n++){
            int valorExtra = 0;

            if(n%10 == 5){
                valorExtra +=1;
            }

            if(n%10 == 0){
                valorExtra +=1;
            }

            if(n%11 == 0){
                valorExtra +=4;
            }

            int valorTotal = valorExtra + 1;
            Carta c = new Carta(n, valorTotal);
            baralho.addCarta(c);      
        }
        baralho.embaralhar();

        Jogador j1 = new Jogador(1); Jogador j2 = new Jogador(2); Jogador j3 = new Jogador(3);

        for(int i = 0; i < 12; i++){
            Carta carta_nova = baralho.pescar();
            j1.maoJogador.add(carta_nova);
            Carta carta_nova2 = baralho.pescar();
            j2.maoJogador.add(carta_nova2);
            Carta carta_nova3 = baralho.pescar();
            j3.maoJogador.add(carta_nova3);

        }
        Tabuleiro.preencherMatriz(matriz);
        Tabuleiro.preencherPrimeiraColunaMatriz(matriz, baralho);
        Tabuleiro.imprimirTabuleiro(matriz);

        Scanner sc = new Scanner(System.in);
        int rodada = 0;
        while(rodada < 12){
            j1.imprimirMao();
            j2.imprimirMao();
            j3.imprimirMao();
            
            System.out.println("Jogador 1, escolha uma carta: ");
            int n = sc.nextInt();
            Carta carta1_escolha = j1.getCarta(n);

            System.out.println("Jogador 2, escolha uma carta: ");
            n = sc.nextInt();
            Carta carta2_escolha = j2.getCarta(n);

            System.out.println("Jogador 3, escolha uma carta: ");
            n = sc.nextInt();
            Carta carta3_escolha = j3.getCarta(n);

            Jogadores ordemDeJogada = Jogo.ordemJogada(carta1_escolha, j1, carta2_escolha, j2, carta3_escolha, j3);
            System.out.println("Ordem de Jogada: " + ordemDeJogada.primeiro.nome + "" + ordemDeJogada.segundo.nome + "" + ordemDeJogada.terceiro.nome);
            j1.jogada(matriz, carta1_escolha);

            if(ordemDeJogada.primeiro == j1 && ordemDeJogada.segundo == j2 && ordemDeJogada.terceiro == j3){
                j1.jogada(matriz, carta1_escolha);
                j2.jogada(matriz, carta2_escolha);
                j3.jogada(matriz, carta3_escolha);
            }
                
            if(ordemDeJogada.primeiro == j1 && ordemDeJogada.segundo == j3 && ordemDeJogada.terceiro == j2){
                j1.jogada(matriz, carta1_escolha);
                j3.jogada(matriz, carta3_escolha);
                j2.jogada(matriz, carta2_escolha);
            }
            if(ordemDeJogada.primeiro == j2 && ordemDeJogada.segundo == j1 && ordemDeJogada.terceiro == j3){
                j2.jogada(matriz, carta2_escolha);
                j1.jogada(matriz, carta1_escolha);
                j3.jogada(matriz, carta3_escolha);
            }
            if(ordemDeJogada.primeiro == j2 && ordemDeJogada.segundo == j3 && ordemDeJogada.terceiro == j1){

                j2.jogada(matriz, carta2_escolha);
                j3.jogada(matriz, carta3_escolha);
                j1.jogada(matriz, carta1_escolha);
            }
            if(ordemDeJogada.primeiro == j3 && ordemDeJogada.segundo == j1 && ordemDeJogada.terceiro == j2){
                j3.jogada(matriz, carta3_escolha);
                j1.jogada(matriz, carta1_escolha);
                j2.jogada(matriz, carta2_escolha);
            }
            if(ordemDeJogada.primeiro == j3 && ordemDeJogada.segundo == j2 && ordemDeJogada.terceiro == j1){
                j3.jogada(matriz, carta3_escolha);
                j2.jogada(matriz, carta2_escolha);
                j1.jogada(matriz, carta1_escolha);
            }
            rodada++;
        }    
    }
}
