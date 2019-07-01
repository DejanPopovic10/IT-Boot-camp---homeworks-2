package rs.itbootcamp.gen4.nedelja4.energija;

public class Meni {
	private Namirnica[] niz;
	private int brNam;
	
	public Meni(int kapacitet) {
		this.niz = new Namirnica[kapacitet];
	}
	
	public boolean dodaj(Namirnica namirnica) {
		// da li je broj namirnica jednak kapacitetu? 
		if(brNam+1==niz.length)
			return false;
		
		niz[brNam++] = namirnica;
		return true;
	}
	
	double energVr() {
		double vrednost = 0;
		for(int i=0;i<brNam;i++)
			vrednost += niz[i].energVr();
		return vrednost;
	}
	
	public String toString() {
		String buffer = String.format("Meni (%.2fkJ):",energVr());
		for(int i=0;i<brNam;i++)
			buffer += "\n " + niz[i].toString();
		return buffer;
	}
}
