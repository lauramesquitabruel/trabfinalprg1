import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    ArrayList<Carta> pilhaCartas;

    public Baralho(){
        this.pilhaCartas = new ArrayList<>();
    }

    public void addCarta(Carta carta){
        this.pilhaCartas.add(carta);
    }

    public void embaralhar(){
        Collections.shuffle(pilhaCartas);
    }

    public Carta pescar() throws Exception {
        boolean r = pilhaCartas.isEmpty();
        if(r == true){
            throw new Exception("Baralho vazio, não é possível pescar mais cartas");
        } else {
            Carta carta_retirada = pilhaCartas.get(0);
            pilhaCartas.remove(carta_retirada);
            return carta_retirada; 
        }
    }

}


