import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<Integer> cartasMenores = new ArrayList<>();
        for(int i = 0; i<5; i++){
            for(int j = 0; j < 5; j++){
                if(matriz[i][j].numero < carta_escolha.numero && matriz[i][j].numero > 0){
                    cartasMenores.add(matriz[i][j].numero);
                    System.out.println("Foi adicionada à lista de cartas menores: " + matriz[i][j].numero);
                }
            }
        }

        Collections.sort(cartasMenores);

        if (!cartasMenores.isEmpty()) {
            int cartaDaRodada1 = Jogo.cartaDaRodada(cartasMenores);
            System.out.println("Carta da Rodada: " + cartaDaRodada1);

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (matriz[i][j].numero == cartaDaRodada1) {
                        if (j + 1 < 5) {
                            matriz[i][j + 1] = carta_escolha;
                        } else {
                            int pontos = 0;
                            int linha = i;

                            for (int coluna = 0; coluna < 5; coluna++) {
                                pontos += matriz[linha][coluna].valor;
                                matriz[linha][coluna] = new Carta(0, 0);
                                if (coluna == 0) {
                                    matriz[linha][coluna] = carta_escolha;
                                }
                            }
                            this.pontos += pontos;
                        }
                    }
                }
            }
        } else {
            int maiorNumero = 0;
            int linhaMaiorNumero = 0;

            for (int i = 0; i < 5; i++) {
                int ultimoNumero = matriz[i][4].numero;
                if (ultimoNumero > maiorNumero) {
                    maiorNumero = ultimoNumero;
                    linhaMaiorNumero = i;
                }
            }

            int pontos = 0;
            for (int coluna = 0; coluna < 5; coluna++) {
                pontos += matriz[linhaMaiorNumero][coluna].valor;
                matriz[linhaMaiorNumero][coluna] = new Carta(0, 0);
                if (coluna == 0) {
                    matriz[linhaMaiorNumero][coluna] = carta_escolha;
                }
            }
            this.pontos += pontos;
        }

        Tabuleiro.imprimirTabuleiro(matriz);
        System.out.println(this.nome + " pontos: " + this.pontos);
        maoJogador.remove(carta_escolha);

        return matriz;
    }
}
