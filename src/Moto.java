public class Moto implements Runnable, Comparable<Moto>{

    Thread thread;
    private String nome;
    private static int pontos = 10;
    int totalPontos;

    public Moto(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        thread = new Thread(this, nome);
        thread.start();
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (pontos > 0) {
                totalPontos = totalPontos + pontos;
                pontos--;
            } else {
                pontos = 10;
                totalPontos = totalPontos + pontos;
                pontos--;
            }
            System.out.println(nome + " possui " + totalPontos + " pontos.");
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                System.out.println("Moto interrompida!");
            }
            Thread.yield();
        }
    }

    @Override
    public int compareTo(Moto outraMoto) {
        if(this.totalPontos > outraMoto.totalPontos) return -1;
        if(this.totalPontos < outraMoto.totalPontos) return 1;
        return 0;
    }
}