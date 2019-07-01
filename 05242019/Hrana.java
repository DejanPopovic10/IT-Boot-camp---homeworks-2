package fitnes;

public class Hrana extends Namirnica {

	private double tezina;
	private double belancevine;
	private double masti;
	private double ugljHidrati;

	public Hrana(String ime, double tezina, double belancevine, double masti, double ugljHidrati) {
		super(ime);
		this.tezina = tezina;
		this.belancevine = belancevine;
		this.masti = masti;
		this.ugljHidrati = ugljHidrati;

	}

	public double getTezina() {
		return tezina;
	}

	public double energVr() {
		/*
		 * Probao sam ovde da postavim uslov da zbir ne prelazi 100 sa throw new
		 * Exception al mi nije polazilo za rukom
		 * 
		 */

		double m = 0;

		m += 16.7 * ((belancevine * tezina) / 100);
		m += 37.6 * ((masti * tezina) / 100);
		m += 17.2 * ((ugljHidrati * tezina) / 100);
		m = Math.round(m * 10) / 10.0;

		return m;

	}

	public String toString() {
		String s = "";
		if (belancevine + masti + ugljHidrati > 100) {
			s = "Greska";

		} else
			s = "[" + getId() + "] " + getIme() + "(" + tezina + "g, " + energVr() + "kJ)";
		return s;
	}

	public void setTezina(double tezina) {

		this.tezina = tezina;
	}

	public double getBelancevine() {
		return belancevine;
	}

	public void setBelancevine(double belancevine) {
		this.belancevine = belancevine;
	}

	public double getMasti() {
		return masti;
	}

	public void setMasti(double masti) {
		this.masti = masti;
	}

	public double getUgljHidrati() {
		return ugljHidrati;
	}

	public void setUgljHidrati(double ugljHidrati) {
		this.ugljHidrati = ugljHidrati;
	}

}
