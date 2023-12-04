import java.util.ArrayList;

public class Jogo {

    public static Jogadores ordemJogada(Carta c1, Jogador j1, Carta c2, Jogador j2, Carta c3, Jogador j3){
        if(c1.numero < c2.numero && c1.numero < c3.numero && c2.numero < c3.numero){
            Jogadores ordem = new Jogadores(j1, j2, j3);
            return ordem;
        }
        if(c1.numero < c2.numero && c1.numero < c3.numero && c3.numero < c2.numero){
            Jogadores ordem = new Jogadores(j1, j3, j2);
            return ordem;
        }  
        if(c2.numero < c1.numero && c2.numero < c3.numero && c1.numero < c3.numero){
            Jogadores ordem = new Jogadores(j2, j1, j3);
            return ordem;
        }
        if(c2.numero < c1.numero && c2.numero < c3.numero && c3.numero < c1.numero){
            Jogadores ordem = new Jogadores(j2, j3, j1);
            return ordem;
        }
        if (c3.numero < c1.numero && c3.numero < c2.numero && c2.numero < c1.numero){
            Jogadores ordem = new Jogadores(j3, j2, j1);
            return ordem;
        }
        if (c3.numero < c1.numero && c3.numero < c2.numero && c1.numero < c2.numero){
            Jogadores ordem = new Jogadores(j3, j1, j2);
            return ordem;
        }
        return null;

    }

    public static Integer cartaDaRodada(ArrayList<Integer> lista) {
        int cEscolhida = 0;

        for (int num : lista) {
            if (num > cEscolhida) {
                cEscolhida = num;
            }
        }
        return cEscolhida;
    }

    public static Jogador vencedor(Jogador j1, Jogador j2, Jogador j3){
        if(j1.pontos > j2.pontos && j1.pontos > j3.pontos){
            return j1;
        }
        if(j2.pontos > j1.pontos && j2.pontos > j3.pontos){
            return j2;
        }
        if(j3.pontos > j2.pontos && j3.pontos > j1.pontos){
            return j3;
        }
        return null;
    }
}
