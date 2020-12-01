package listaCinese;

public class Main {

	public static void main(String[] args) {
		Lista lista = new Lista();
		PuntoLista p1 = new PuntoLista(3.3, 4.4);
		PuntoLista p2 = new PuntoLista(5.5, 6.6);
		PuntoLista p3 = new PuntoLista(7.7, 8.8);
		PuntoLista p4 = new PuntoLista(9.9, 10.1);
		
		boolean ok;
		
		ok = lista.aggiungi(p1);
		ok = lista.aggiungi(p2);
		ok = lista.aggiungi(p3);
		ok = lista.aggiungi(p4);
		System.out.println("lenght: " + lista.lenght());
		lista.stampaPunti();
		
		System.out.println("-- togli tutti: uno alla volta --");
		while (lista.togli() == true) {
			System.out.println("lenght: " + lista.lenght());
			lista.stampaPunti();
			System.out.println("-------------");
		}
		
		System.out.println(lista.lenght());
	}

}
