
public class ProvaHD {

	public static void main(String[] args) {
		final int MAX_HD = 2;

		Harddisk[] hd = new Harddisk[MAX_HD];
		double[] punteggi = new double[MAX_HD];
		double media = 0;
		int max = 0, min = 0;

		for(int i=0;i<hd.length;i++) {
			hd[i] = new Harddisk();
		}

		for(int i=0;i<hd.length;i++) {
			hd[i].leggiDati();
			hd[i].calcolaPunteggio();

			punteggi[i] = hd[i].getPunteggio();
		}

		for(int i=0;i<punteggi.length;i++) {
			media += punteggi[i] / MAX_HD;

				if(punteggi[i] > punteggi[max])
					max = i;
				else if(punteggi[i] < punteggi[min])
					min = i;
		}

		System.out.println("\nMedia: " + media);

		System.out.println(hd[max].getPunteggio());
		hd[max].stampaInfo();
		System.out.println("\n" + hd[min].getPunteggio());
		hd[min].stampaInfo();
	}

}
