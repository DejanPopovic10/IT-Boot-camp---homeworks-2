package paket;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Ponuda {
	private String konString;
	private java.sql.Connection connection;
	private int idTerm;
	private String naziv;
	private String Drzava;
	private int datumOd;
	private int datumDo;
	private int preostaloMesta;
	private int cena;

	public Ponuda(int idTerm, String naziv, String drzava, int datumOd, int datumDo, int cena, int preostaloMesta) {
		super();
		this.idTerm = idTerm;
		this.naziv = naziv;
		this.Drzava = drzava;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.preostaloMesta = preostaloMesta;
		this.cena = cena;
		konString = "jdbc:sqlite:C:\\Users\\123\\Desktop\\....db";
	}

	public boolean zakupi() throws SQLException {

		if (preostaloMesta > 0) {

			String upit = "UPDATE Termin SET PreostaloMesta = ? -1 WHERE idTer= ?";
			connection = DriverManager.getConnection(konString);
			PreparedStatement stm = connection.prepareStatement(upit);
			stm.setInt(1, preostaloMesta);
			stm.setInt(2, idTerm);
			stm.execute();
			stm.close();
			connection.close();
			return true;
		} else
			return false;
	}

	public String toString() {
		String s = "(" + idTerm + ")" + naziv + "(" + Drzava + ")";
		return s += datumOd + "-" + datumDo + "/" + cena + "€: " + preostaloMesta;
	}

	public void connect() throws SQLException {
		disconnect();
		connection = DriverManager.getConnection(konString);
	}

	public void disconnect() throws SQLException {
		if (connection != null && !(connection).isClosed()) {
			connection.close();
		}
	}

}