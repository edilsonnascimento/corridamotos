import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MotorTest {

    public static int pontos=10;
    public static List<Moto> motos = new ArrayList<>();

    public static void main(String[] args) {

        iniciaCampeonato();
        esperaCampeonatoTerminar();
        mostraClassificacao();
    }

    private static void iniciaCampeonato(){
        Moto moto1 = new Moto("Moto01", pontos);
        Moto moto2 = new Moto("Moto02", pontos);
        Moto moto3 = new Moto("Moto03", pontos);
        Moto moto4 = new Moto("Moto04", pontos);
        Moto moto5 = new Moto("Moto05", pontos);
        Moto moto6 = new Moto("Moto06", pontos);
        Moto moto7 = new Moto("Moto07", pontos);
        Moto moto8 = new Moto("Moto08", pontos);
        Moto moto9 = new Moto("Moto09", pontos);
        Moto moto10 = new Moto("Moto10", pontos);
        motos.add(moto1);
        motos.add(moto2);
        motos.add(moto3);
        motos.add(moto4);
        motos.add(moto5);
        motos.add(moto6);
        motos.add(moto7);
        motos.add(moto8);
        motos.add(moto9);
        motos.add(moto10);

    }

    private static boolean todasMotosTerminaram(){
        boolean teste = false;
        for (int i = 0; i < motos.size(); i++) {
            if(motos.get(i).thread.isAlive()){
                return true;
            }
        }
        return teste;
    }

    private static void mostraClassificacao(){
        int posicao = 1;
        String campeao = "Campeão!!!";

        System.out.println();
        Collections.sort(motos);
        for (int i = 0; i < motos.size(); i++) {
            if(posicao == 1){
                campeao = " Campeão!!!";
            }else campeao = "";

            System.out.println( posicao + "º " + motos.get(i).thread.getName() + " com " + motos.get(i).totalPontos + campeao);
            posicao++;
        }

    }

    public static void esperaCampeonatoTerminar(){
        do {
            try {
                Thread.sleep(10);
            } catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        } while (todasMotosTerminaram());
    }
}
