package paket;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ponuda {
	private String konString;
	private java.sql.Connection connection;
	public int idTerm;
	private String naziv;
	private String Drzava;
	private int datumOd;
	private int datumDo;
	private int preostaloMesta;
	private int cena;

	public Ponuda(int idTerm) {
		
		this.idTerm = idTerm;
	}
	public Ponuda(int idTerm, String naziv, String drzava, int datumOd, int datumDo, int cena, int preostaloMesta) {
		super();
		this.idTerm = idTerm;
		this.naziv = naziv;
		this.Drzava = drzava;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.preostaloMesta = preostaloMesta;
		this.cena = cena;
		konString = "jdbc:sqlite:C:\\Users\\Biohemija\\Desktop\\Deki.db";
	}

	public int getIdTerm() {
		return idTerm;
	}

	public void setIdTerm(int idTerm) {
		this.idTerm = idTerm;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getDrzava() {
		return Drzava;
	}

	public void setDrzava(String drzava) {
		Drzava = drzava;
	}

	public int getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(int datumOd) {
		this.datumOd = datumOd;
	}

	public int getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(int datumDo) {
		this.datumDo = datumDo;
	}

	public int getPreostaloMesta() {
		return preostaloMesta;
	}

	public void setPreostaloMesta(int preostaloMesta) {
		this.preostaloMesta = preostaloMesta;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
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

	public boolean zakupi(int idOsobe) throws SQLException {
		
		if (preostaloMesta > 0) {

			String upit = "INSERT INTO Putuje VALUES (?,?)";
			connect();
			PreparedStatement stm = connection.prepareStatement(upit);
			stm.setInt(1, idOsobe);
			stm.setInt(2, idTerm);
			stm.execute();
			stm.close();
			disconnect();
			zakupi();
			return true;
		} else
			return false;
	}

	public boolean zakupi(String ime, String prezime, String tel) throws SQLException {

		if (preostaloMesta > 0) {
			String upit = "INSERT INTO Osoba  (Ime, Prezime, Kontakt) VALUES (?,?,?)";
			connect();
			PreparedStatement stm = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, ime);
			stm.setString(2, prezime);
			stm.setString(3, tel);
			stm.execute();

			ResultSet rs = stm.getGeneratedKeys();

			int id = -1;
			if (rs.next()) {
				id = rs.getInt(1);

			}
			stm.close();
			disconnect();

			return zakupi(id);
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