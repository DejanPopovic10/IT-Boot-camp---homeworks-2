package fitnes;

public class Meni {

	private Namirnica[] gajbica;
	private int brNam;
	private int brPopunjenih;

	public Meni(int kapacitet) {

		this.brNam = brNam;
		brPopunjenih = 0;
		gajbica = new Namirnica[kapacitet];
	}

	public boolean dodaj(Namirnica x) {
		if (brPopunjenih < gajbica.length) {

			gajbica[brPopunjenih] = x;
		brPopunjenih++;

		return true;
	}

	else return false;
		

	}

	public double energVr() {
		double m = 0;

		for (int i = 0; i < brPopunjenih; i++) {

			m += gajbica[i].energVr();
		}

		m = Math.round(m * 10) / 10.0;
		return m;

	}

	public int getBrNam() {
		return brNam;
	}

	public void setBrNam(int brNam) {
		this.brNam = brNam;
	}

	public String toString() {
		String s = "Meni (" + energVr() + "):\n";
		for (int i = 0; i < brPopunjenih; i++) {

			s += gajbica[i].toString() + "\n";
		}
		return s;
	}

}
