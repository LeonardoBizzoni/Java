package Thread3;

public class Contatore implements Runnable{
    private String nome;

    public Contatore(String nome){
        this.nome = nome;
    }

    public void run(){
        for (int i=1; i <= 1000000; i++){
            System.out.println(this.nome + ": " + i);
        }
    }
}
