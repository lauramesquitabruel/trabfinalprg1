import java.util.ArrayList;

public class Jogador {
    int nome;
    int pontos;
    ArrayList<Carta> maoJogador;

    public Jogador(int nome){
        this.maoJogador = new ArrayList<>();
        this.pontos = 0;
        this.nome = nome;
    }

    public void imprimirMao() {
        System.out.print("<");
        for (int i = 0; i < maoJogador.size(); i++) {
            Carta carta = maoJogador.get(i);
            System.out.print(carta.numero);
            
            // Adiciona vírgula se não for a última carta
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
                    matriz[i][r+1] = carta_escolha;
                    }
                }
            }
        Tabuleiro.imprimirTabuleiro(matriz);
        maoJogador.remove(carta_escolha);
        return matriz;

    }

}
