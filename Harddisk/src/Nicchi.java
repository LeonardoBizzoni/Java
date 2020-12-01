
public class Nicchi {
	public static void main(String[] args) {
		final int MAX_HD = 2;

		Harddisk[] hd = new Harddisk[MAX_HD];

		double media = 0;
		int max = 0, min = 0;

		for(int i=0;i<hd.length;i++) {
			hd[i] = new Harddisk();
		}

		for(int i=0;i<hd.length;i++) {
			hd[i].leggiDati();
			hd[i].calcolaPunteggio();

			media += hd[i].getPunteggio()/MAX_HD;

			if(hd[i].getPunteggio() > hd[max].getPunteggio())
				max = i;
			else if(hd[i].getPunteggio() < hd[min].getPunteggio())
				min = i;
		}

		System.out.println("\nMedia: " + media);

		System.out.println(hd[max].getPunteggio());
		hd[max].stampaInfo();
		System.out.println("\n" + hd[min].getPunteggio());
		hd[min].stampaInfo();
	}
}
