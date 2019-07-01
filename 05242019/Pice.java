package fitnes;

public class Pice extends Namirnica {

	private double kolicina;
	private double enVr;

	public Pice(String ime, double kolicina, double enVr) {
		super(ime);
		this.kolicina = kolicina;
		this.enVr = enVr;

	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public void setEnVr(double enVr) {
		this.enVr = enVr;
	}

	public String toString() {
		String s = "[" + getId() + "] " + getIme() + "(" + kolicina + "l, " + energVr() + "kJ)";
		return s;

	}

	public double energVr() {
		// TODO Auto-generated method stub
		Double m = enVr * kolicina;
		m = Math.round(m * 10) / 10.0;
		return m;
	}

}
