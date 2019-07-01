package fitnes;

public abstract class Namirnica extends Energent {

	private String ime;
	private int id;
	private static int idGlobal = 1;

	public Namirnica(String ime) {
		super();

		this.ime = ime;
		this.id = idGlobal++;

	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		String s = "[ " + id + "] " + ime;
		return s;
	}

}
