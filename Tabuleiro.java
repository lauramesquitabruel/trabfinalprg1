public class Tabuleiro {

    public static Carta[][] preencherMatriz(Carta[][] matriz) {
        Carta c = new Carta(0, 0);
        for (int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz.length; j++){
                matriz[i][j] = c;
            }
        }
        return matriz;
    }

    public static void preencherPrimeiraColunaMatriz(Carta[][] matriz, Baralho b) {
        for (int i = 0; i < matriz.length; i++) {
            Carta c;
            try {
                c = b.pescar();
                matriz[i][0] = c;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }

    public static void imprimirTabuleiro(Carta[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j].numero + "\t");
                } 
            System.out.println();
        }
    }
}
