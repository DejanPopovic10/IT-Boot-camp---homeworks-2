package paket;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminPanel {
	private String konString = "jdbc:sqlite:C:\\Users\\123\\Desktop\\....db";
	private java.sql.Connection connection;

	public void modifikujCene(double procenat) throws SQLException {

		String upit = "UPDATE Termin SET Cena = Cena + Cena * ?";
		connection = DriverManager.getConnection(konString);
		PreparedStatement stm = connection.prepareStatement(upit);
		stm.setDouble(1, procenat);
		stm.execute();
		stm.close();
		connection.close();

	

	}
	public void ukloni(int idTer) throws SQLException {

		String upit = "DELETE FROM Termin WHERE IdTer = ?";
		connection = DriverManager.getConnection(konString);
		PreparedStatement stm = connection.prepareStatement(upit);
		stm.setDouble(1, idTer);
		stm.execute();
		stm.close();
		connection.close();
	}

}
