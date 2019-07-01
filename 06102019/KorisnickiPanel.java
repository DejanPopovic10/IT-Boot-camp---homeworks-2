package paket;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class KorisnickiPanel {
	private String konString = "jdbc:sqlite:C:\\Users\\Biohemija\\Desktop\\Deki.db";

	private java.sql.Connection connection;
	private int idKor;

	public KorisnickiPanel() {
		super();
	}

	public LinkedList<Ponuda> mojaPutovanja() throws SQLException {

		LinkedList<Ponuda> ponuda = new LinkedList();

		String upit = "SELECT Termin.IdTer, Skijaliste.Naziv, Skijaliste.Drzava, Termin.Od, Termin.Do, Termin.Cena, Termin.PreostaloMesta  FROM Korisnik JOIN Putuje USING (IdOsobe) JOIN Termin USING (IdTer) JOIN Skijaliste USING (IdSki) WHERE IdOsobe ?";
		connect();
		PreparedStatement stm = connection.prepareStatement(upit);
		stm.setInt(1, idKor);
		ResultSet rezultat = stm.executeQuery(upit);

		while (rezultat.next()) {
			int idTerm = rezultat.getInt(1);
			String naziv = rezultat.getString(2);
			String Drzava = rezultat.getString(3);
			int datumOd = rezultat.getInt(4);
			int datumDo = rezultat.getInt(5);
			int cena = rezultat.getInt(6);
			int preostaloMesta = rezultat.getInt(7);
			Ponuda x = new Ponuda(idTerm, naziv, Drzava, datumOd, datumDo, cena, preostaloMesta);

			ponuda.add(x);

		}
		stm.close();
		disconnect();

		return ponuda;
	}

	public void ukloni(Ponuda p) throws SQLException {
		p = new Ponuda(p.getIdTerm());
		String upit = "Delete * FROM  Putuje JOIN Korisnik USING (IdOsobe) WHERE IdTer=? AND IdOsobe ?";
		connect();
		PreparedStatement stm = connection.prepareStatement(upit);
		stm.setInt(1, p.getIdTerm());
		stm.setInt(2, idKor);
		stm.execute();
		upit = "Update Termin set PreostaloMesta = PreostaloMesta + 1 Where IdTer=?";
		stm.setInt(1, p.getIdTerm());

		stm.execute(upit);

		stm.close();
		stm.close();
		connection.close();
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
