package paket;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPanel {
	private String konString = "jdbc:sqlite:C:\\Users\\Biohemija\\Desktop\\Deki.db";

	private java.sql.Connection connection;

	public AdminPanel() {
		super();
	}

	public void modifikujCene(double procenat) throws SQLException {

		String upit = "UPDATE Termin SET Cena = Cena + Cena * ?";
		connect();
		PreparedStatement stm = connection.prepareStatement(upit);
		stm.setDouble(1, procenat);
		stm.execute();
		stm.close();
		disconnect();

	}

	public void stampajOsobe(int idTer) throws SQLException {

		String upit = "SELECT Osoba.IdOsobe,Osoba.Ime,Osoba.Prezime, Osoba.Kontakt from Osoba JOIN Putuje USING ( IdOsobe ) WHERE IdTer = ?";
		connect();
		PreparedStatement stm = connection.prepareStatement(upit);
		stm.setInt(1, idTer);
		ResultSet rezultat = stm.executeQuery();

		while (rezultat.next()) {

			int Osoba = rezultat.getInt("IdOsobe");
			String ime = rezultat.getString("Ime");
			String prezime = rezultat.getString("Prezime");
			String kontakt = rezultat.getString("Kontakt");

			System.out.println("(" + Osoba + ") " + ime + " " + prezime + " - " + kontakt);

		}
		stm.close();
		disconnect();

	}

	public void ukloni(int idTer) throws SQLException {

		String upit = "DELETE FROM Termin WHERE IdTer = ?";
		connect();
		PreparedStatement stm = connection.prepareStatement(upit);
		stm.setInt(1, idTer);
		stm.execute();
		stm.close();
		disconnect();
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