package paket;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.LinkedList;

import com.sun.corba.se.pept.transport.Connection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Agencija {
	private String konString;
	private java.sql.Connection connection;
	private String naziv;

	public Agencija(String naziv) {
		this.naziv = naziv;
		konString = "jdbc:sqlite:C:\\Users\\123\\Desktop\\....db";
	}

	public AdminPanel login(String username, String pass) throws SQLException {

		String upit = "SELECT KorIme, Lozinka FROM Administrator";
		connection = DriverManager.getConnection(konString);
		Statement stm = connection.createStatement();

		ResultSet rezultat = stm.executeQuery(upit);

		AdminPanel panel = new AdminPanel();

		if (rezultat.getString(1).equals(username) && rezultat.getString(2).equals(pass)) {

			stm.close();
			connection.close();
			return panel;
		} else
			return null;

	}

	public LinkedList<Ponuda> pretrazi(int maxCena) throws SQLException {

		LinkedList<Ponuda> ponuda = new LinkedList();

		String upit = "SELECT Termin.IdTer, Skijaliste.Naziv, Skijaliste.Drzava, Termin.Od, Termin.Do, Termin.Cena, Termin.PreostaloMesta FROM Termin JOIN Skijaliste USING (IdSki) WHERE Cena<"
				+ maxCena + " ORDER by Cena ASC";
		connection = DriverManager.getConnection(konString);
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
		connection.close();
		return ponuda;
	}

	public LinkedList<Ponuda> pretrazi(String drzava) throws SQLException {
		LinkedList<Ponuda> ponuda = new LinkedList();

		String upit = "SELECT Termin.IdTer, Skijaliste.Naziv, Skijaliste.Drzava, Termin.Od, Termin.Do, Termin.Cena, Termin.PreostaloMesta  FROM Termin JOIN Skijaliste USING (IdSki) WHERE Skijaliste.Drzava = ? ORDER by Cena ASC";
		connection = DriverManager.getConnection(konString);
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
		connection.close();
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
