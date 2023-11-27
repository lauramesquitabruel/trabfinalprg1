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

    public static Integer cartaDaRodada(int lista[]){
        int c_escolhida = 0;
        for(int num : lista){
            if(num > c_escolhida){
                c_escolhida = num;
            }
        }
        return c_escolhida;
    }
}
