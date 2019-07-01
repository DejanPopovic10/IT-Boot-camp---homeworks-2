package rs.itbootcamp.gen4.nedelja4.energija;

public class Hrana extends Namirnica{
	private double tezina;
	private double belancevine;
	private double ugljHidrati;
	private double masti;
	
	public Hrana(String ime, double tezina, double belancevine, double masti, double ugljHidrati) {
		super(ime);
		this.tezina = tezina;
		this.belancevine = belancevine;
		this.ugljHidrati = ugljHidrati;
		this.masti = masti;
	}

	public double getTezina() {
		return tezina;
	}

	public double getBelancevine() {
		return belancevine;
	}

	public double getUgljHidrati() {
		return ugljHidrati;
	}

	public double getMasti() {
		return masti;
	}
	
	public String toString() {
		return String.format("[%d] %s(%.1fg, %.1fkJ)", id, ime, tezina, energVr());
	}

	@Override
	public double energVr() {
		return tezina*(belancevine*16.7 + masti*37.6 + ugljHidrati*17.2)/100;
	}
}
