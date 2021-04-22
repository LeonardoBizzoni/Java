package Thread3;

public class Main {

    public static void main(String[] args) {
        Thread t0 = new Thread(new Contatore("Contatore 0"));
        Thread t1 = new Thread(new Contatore("Contatore 1"));
        Thread t2 = new Thread(new Contatore("Contatore 2"));

        Thread listener = new Thread(new InputListener());

        listener.start();
        t0.start();
        t1.start();
        t2.start();
    }
}
