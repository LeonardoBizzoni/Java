
public class ContoCorrente {
	private String nominativo;
	private int numerocc;
	private double saldo = 0;
	
	public ContoCorrente() {}
	public ContoCorrente(String nominativo, int numerocc, double saldo) {
		this.nominativo = nominativo;
		this.numerocc = numerocc;
		this.saldo = saldo;
	}
	public ContoCorrente(String nominativo) {
		this.nominativo = nominativo;
	}
	
	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public int getNumerocc() {
		return numerocc;
	}
	public void setNumerocc(int numerocc) {
		this.numerocc = numerocc;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void versa(double versamento) {
		this.saldo += versamento;
	}
	
	public boolean preleva(double prelievo) {
		if(this.saldo > prelievo) {
			this.saldo -= prelievo;
			return true;
		}
		return false;
	}
	
	public void stampaCC() {
		System.out.println("ContoCorrente [nominativo=" + nominativo + ", numerocc=" + numerocc + ", saldo=" + saldo + "]");
	}
}
