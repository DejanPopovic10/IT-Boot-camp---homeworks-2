package rs.itbootcamp.gen4.nedelja4.energija;

import java.sql.Time;
import java.time.LocalDate;

public class Program {
    public static void main (String[] varg) {
    
    	Meni meni = new Meni (10);
        
        meni.dodaj (new Hrana("Hleb",600,7.5,0.4,49));
        meni.dodaj (new Pice ("Sok", 0.2,18540));
        meni.dodaj (new Hrana("Sir", 200,17,1.2,4));
        
        System.out.println (meni);
    }
}