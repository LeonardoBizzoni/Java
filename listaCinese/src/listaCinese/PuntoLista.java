package listaCinese;

public class PuntoLista {
	private double x;
	private double y;
	PuntoLista next = null;

	public PuntoLista() {
	}

	public PuntoLista(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		String s = "(" + x + ", " + y + ")";
		return s;
	}
}
