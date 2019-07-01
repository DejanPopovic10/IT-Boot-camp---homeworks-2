package paket;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram_verzija1 {
	public static void sortiraj(double[] x) {
		for (int i = 0; i < x.length - 1; i++) {
			double min = x[i];
			int pozicija = i;
			for (int j = i + 1; j < x.length; j++) {
				if (x[j] < min) {
					min = x[j];
					pozicija = j;
				}
			}
			x[pozicija] = x[i];
			x[i] = min;
		}
	}

	public static void egzekucija(int n) {
		Scanner s = new Scanner(System.in);
		double[] niz1 = new double[n];
		double[] niz2 = new double[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Unesite broj za niz1");
			niz1[i] = s.nextDouble();
			System.out.println("Unesite broj za niz2");
			niz2[i] = s.nextDouble();

		}
		System.out.println(Arrays.toString(niz1));
		System.out.println(Arrays.toString(niz2));
		sortiraj(niz1);
		sortiraj(niz2);
		proveri(niz1, niz2, n);

	}

	public static boolean proveri(double niz1[], double niz2[], int n) {

		int validacija = n;
		for (int i = 0; i < n; i++) {

			if (niz1[i] == niz2[i]) {
				validacija--;
			} else
				break;
		}

		if (validacija == 0)
			System.out.println("Jesu anagrami");

		else

			System.out.println("Nisu anagrami");

		return true;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Unesite broj za duzinu niza: ");
		int n = s.nextInt();
		if (n < 100) {
			egzekucija(n);
		} else
			System.out.println("Greska!!! Uneti broj mora da bude manji od 100");
	}
}
