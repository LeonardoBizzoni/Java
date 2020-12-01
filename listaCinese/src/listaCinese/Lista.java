package listaCinese;

public class Lista {
	PuntoLista primo = null;

	public boolean aggiungi(PuntoLista p) {
		if (primo == null) {
			primo = p;
			return true;
		}
		PuntoLista pcorrente = primo;
		while (pcorrente.next != null) {
			pcorrente = pcorrente.next;
		}
		pcorrente.next = p;
		return true;
	}

	public boolean togli() {
		if (isEmpty())
			return false;
		if (primo.next == null) {
			primo = null;
			return true;
		}
		PuntoLista corrente, successivo;
		corrente = primo;
		successivo = primo.next;
		while (successivo.next != null) {
			corrente = successivo;
			successivo = successivo.next;
		}
		corrente.next = null;
		return true;
	}

	public boolean isEmpty() {
		if (primo == null)
			return true;
		return false;
	}

	public void stampaPunti() {
		if (isEmpty()) {
			System.out.println("lista vuota");
		}
		PuntoLista pcorrente = primo;
		while (pcorrente != null) {
			System.out.println(pcorrente.toString());
			pcorrente = pcorrente.next;
		}
	}
	
	public int lenght() {
		int len = 0;
		if (isEmpty())
			return 0;

		PuntoLista pcorrente = primo;
		while (pcorrente != null) {
			len++;
			pcorrente = pcorrente.next;
		}
		
		return len;
	}
}
