package rs.itbootcamp.gen4.nedelja6.agencija2;

import java.sql.SQLException;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        try {
            Agencija agencija = new Agencija("ZimoTurs");
            AdminPanel panel = agencija.login("admin", "admin");
            if(panel != null) {
                panel.modifikujCene(0.14);
                List<Ponuda> p = agencija.pretrazi("Bugarska");
                if(p.size() == 0)
                    throw new SQLException("Nema Bugarske u bazi!");
                System.out.println(p.get(0));
                panel.ukloni(p.get(0).idTerm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.closeQuietly();
        }
    }
}