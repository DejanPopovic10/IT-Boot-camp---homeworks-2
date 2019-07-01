package rs.itbootcamp.gen4.nedelja4.energija;

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

	@Override
	public double energVr() {
		return kolicina*enVr;
	}
	
	public String toString() {
		return String.format("[%d] %s(%.1fl, %.1fkJ)", id, ime, kolicina, energVr());
	}

	
}
