package paket;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.LinkedList;



public class Agencija {
	private String konString;
	private java.sql.Connection connection;
	private String naziv;

	public Agencija(String naziv) {
		this.naziv = naziv;
		konString = "jdbc:sqlite:C:\\Users\\Biohemija\\Desktop\\Deki.db";
	}

	public AdminPanel loginAdmin(String username, String pass) throws SQLException {

		String upit = "SELECT KorIme, Lozinka FROM Administrator WHERE KorIme= '" + username + "' AND Lozinka = '"
				+ pass + "'";
		connect();
		Statement stm = connection.createStatement();

		ResultSet rezultat = stm.executeQuery(upit);

		AdminPanel panel = new AdminPanel();

		if (rezultat.next()) {

			stm.close();
			disconnect();
			return panel;
		} else
			return null;

	}
	public KorisnickiPanel loginKorisnik(String username, String pass) throws SQLException {

		String upit = "SELECT KorIme, Lozinka FROM Korisnik WHERE KorIme= '" + username + "' AND Lozinka = '"
				+ pass + "'";
		connect();
		Statement stm = connection.createStatement();

		ResultSet rezultat = stm.executeQuery(upit);

		KorisnickiPanel panel = new KorisnickiPanel();

		if (rezultat.next()) {

			stm.close();
			disconnect();
			return panel;
		} else
			return null;

	}

	public LinkedList<Ponuda> pretrazi(int maxCena) throws SQLException {

		LinkedList<Ponuda> ponuda = new LinkedList();

		String upit = "SELECT Termin.IdTer, Skijaliste.Naziv, Skijaliste.Drzava, Termin.Od, Termin.Do, Termin.Cena, Termin.PreostaloMesta FROM Termin JOIN Skijaliste USING (IdSki) WHERE Cena<"
				+ maxCena + " ORDER by Cena ASC";
		connect();
		Statement stm = connection.createStatement();
		ResultSet rezultat = stm.executeQuery(upit);

		while (rezultat.next()) {
			int idTerm = rezultat.getInt("IdTer");
			String naziv = rezultat.getString("Naziv");
			String Drzava = rezultat.getString("Drzava");
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

	public LinkedList<Ponuda> pretrazi(String drzava) throws SQLException {
		LinkedList<Ponuda> ponuda = new LinkedList();

		String upit = "SELECT Termin.IdTer, Skijaliste.Naziv, Skijaliste.Drzava, Termin.Od, Termin.Do, Termin.Cena, Termin.PreostaloMesta  FROM Termin JOIN Skijaliste USING (IdSki) WHERE Skijaliste.Drzava = ? ORDER by Cena ASC";
		connect();
		PreparedStatement stm = connection.prepareStatement(upit);

		stm.setString(1, drzava);
		ResultSet rezultat = stm.executeQuery();

		while (rezultat.next()) {

			int idTerm = rezultat.getInt("IdTer");
			String naziv = rezultat.getString("Naziv");
			String Drzava = rezultat.getString("Drzava");
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

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
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
