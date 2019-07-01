package rs.itbootcamp.gen4.nedelja4.energija;

public abstract class Namirnica extends Energent {
	private static int nextId = 1;
	
	protected String ime;
	protected int id;
	
	protected Namirnica(String ime) {
		this.ime = ime;
		this.id = nextId++;
	}
	
	public String toString() {
		return String.format("%s[%d]", ime, id);
	}
	
	public int getId() {
		return id;
	}
	public String getIme() {
		return ime;
	}
}
