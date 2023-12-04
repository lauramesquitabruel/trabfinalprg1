import java.util.ArrayList;

public class Jogador {
    String nome;
    int pontos;
    ArrayList<Carta> maoJogador;

    public Jogador(String nome){
        this.maoJogador = new ArrayList<>();
        this.pontos = 0;
        this.nome = nome;
    }

    public void imprimirMao() {
        System.out.print("<");
        for (int i = 0; i < maoJogador.size(); i++) {
            Carta carta = maoJogador.get(i);
            System.out.print(carta.numero);
            
            if (i < maoJogador.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }

    public Carta getCarta(int n) throws Exception {
        Carta c = null;
        for (Carta carta : maoJogador) {
            if (carta.numero == n) {
                c = carta;
                break;
            }
        }
        if (c == null){
            throw new Exception("Essa carta não está na sua mão. Escolha outra:");
        } else {
            return c;
        }
    }

    public Carta[][] jogada(Carta[][] matriz, Carta carta_escolha){
        int cartasMenores[] = new int[25];
        for(int i = 0; i<5; i++){
            for(int r = 0; r < 5; r++){
                if(matriz[i][r].numero < carta_escolha.numero && matriz[i][r].numero > 0){
                    int index = i%5;
                    cartasMenores[index]= (matriz[i][r].numero);
                    System.out.println("Foi adicionada à lista: " + matriz[i][r].numero);
                }
            }
        }

        int cartaDaRodada1 = Jogo.cartaDaRodada(cartasMenores);
            System.out.println("Carta da Rodada " + cartaDaRodada1);
            for(int i = 0; i<5; i++){
                for(int r = 0; r<5; r++){
                    if(matriz[i][r].numero == cartaDaRodada1){
                        if(r+1 < 5){
                            matriz[i][r+1] = carta_escolha;
                        } else {
                            int pontos = 0;
                            int linha = i;
                            for(int coluna = 0; coluna < 5; coluna++){
                                pontos = pontos + matriz[linha][coluna].valor;
                                Carta c = new Carta(0, 0);
                                matriz[linha][coluna] = c;
                                if(coluna == 0){
                                    matriz[linha][coluna] = carta_escolha;
                                } 
                            }
                            this.pontos = pontos;
                        }
                    }
                }
            }
        
        Tabuleiro.imprimirTabuleiro(matriz);
        System.out.println(this.nome + "pontos: " + this.pontos);
        maoJogador.remove(carta_escolha);
        return matriz;

    }

}
