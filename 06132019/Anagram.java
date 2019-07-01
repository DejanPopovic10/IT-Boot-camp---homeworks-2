package rs.itbootcamp.gen4.nedelja7;

import java.util.Scanner;

public class Anagram {
	/**
	 * Ucitava niz duzine N sa standardnog ulaza
	 *
	 * @param sc	Scanner iz kojeg izvlacimo vrednost
	 * @param N		Broj elemenata koji izvlacimo sa standardnog ulaza
	 * @return		Kreiran i popunjen niz od N elemenata
	 */
	private static double[] ucitaj(Scanner sc, int N) {		
		double[] niz = new double[N];
		for (int i=0; i<N; i++) {
			niz[i] = sc.nextInt();
		}
		return niz;
	} 
	
	/**
	 * Pravi novi niz sa istim elementima kao i prosledjeni
	 *
	 * @param niz	Niz koji zelimo da kloniramo
	 * @return		Kreiran i popunjen niz
	 */
	private static double[] kloniraj(double[] niz) {		
		double[] klonirani = new double[niz.length];
		for (int i=0; i<niz.length; i++) {
			klonirani[i] = niz[i];
		}
		return klonirani;
	}
	
	/**
	 * Insertion sort algoritam za sortiranje niza. Pogledati 'https://en.wikipedia.org/wiki/Insertion_sort' i propratnu animaciju.
	 *
	 * @param niz	Validno popunjen niz koji zelimo da sortiramo
	 */	
	private static void sort(double[] niz) {
		for (int i = 1; i < niz.length; i++) {  
	         double key = niz[i];  
	         int j = i-1;  
	         while (j>=0 && niz[j]>key){  
	            niz [j+1] = niz[j];  
	            j--;  
	         }  
	         niz[j+1] = key;  
		}  
	}
	
	/**
	 * Proverava da li su dva niza anagrami bez bocnih efekata
	 *
	 * @param niz1 Prvi niz
	 * @param niz2 Drugi niz
	 * @return true ako jesu anagrami, false ako nisu anagrami
	 */
	private static boolean anagram(double[] niz1, double[]niz2) {
		// kako ne bismo imali bocne efekte prilikom sorta moramo nizove klonirati
		niz1 = kloniraj(niz1);
		niz2 = niz2.clone(); // nizovi imaju ugradjenu 'clone' metodu koja radi isto sto i kloniraj tj. pravi plitku kopiju sto je u slucaju inta dovoljno
		
		sort(niz1);
		sort(niz2);

		// ako imaju razlicite duzine sigurno nisu anagarami
		if(niz1.length != niz2.length)
			return false;
		
		// ukoliko postoji trenutak kada se elementi sortiranih nizova na istom indeksu ne gadjaju znaci da nizovi nisu anagrami
		for(int i=0; i<niz1.length; i++)
			if(niz1[i] != niz2[i])
				return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		double[] niz1 = ucitaj(sc, N);
		double[] niz2 = ucitaj(sc, N);
		
		if(anagram(niz1, niz2))
			System.out.println("Jesu anagrami");
		else
			System.out.println("Nisu anagrami");
	}
}
