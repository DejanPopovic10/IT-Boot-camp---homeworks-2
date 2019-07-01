package paket;

import java.util.Arrays;
import java.util.Scanner;

public class Kriptografija {

	public static void main(String[] args) {

		/*
		 * ovde sam postavku prilagodio System.exit-u, svakako bih trebao da vise
		 * prilagodim unos korisniku u slucaju pogresnog unosa
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite N: ");
		int N = sc.nextInt();
		int[] kljuc = new int[N];
		System.out.println("Unesite elemente kljuca, moraju da budu od 1 do N: ");
		for (int i = 0; i < kljuc.length; i++) {
			kljuc[i] = sc.nextInt();
			
			if (kljuc[i] < 1 || kljuc[i] > N) {
				System.out.println("Broj mora da bude veci od nule i manji ili jednak kao N!!!");

				System.exit(kljuc[i]);
			}
			if (i > 0) {
				for (int j = 0; j < i; j++) {
					if (kljuc[i] == kljuc[j] || kljuc[j] < 1 || kljuc[j] > N) {
						System.out.println("Uneli ste kljuc koji se ponavlja");
						System.exit(kljuc[i]);

					}

				}
			}

		}
		System.out.println("Unesite originalni tekst: ");
		String tekst = sc.next();

		/*
		 * unapred se radujem kritikama zbog ovoga sto sledi. 
		 */
		kriptuj(ucitaj(tekst, N), kljuc);
	}

	private static char[][] ucitaj(String x, int N) {

		int M = x.length() / N;
		if (x.length() % N != 0)
			M++;
		int PraznaPolja = (N - (x.length() % N));

		for (int i = 0; i < PraznaPolja; i++) {
			x = x + " ";
		}

		char A[][] = new char[M][N];
		int k = 0;
		while (k < x.length()) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					A[i][j] = x.charAt(k);
					k++;

				}

			}
		}
		return A;
	}

	private static void kriptuj(char[][] matrix, int[] kljuc) {

		char K[][] = new char[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {

			int l = 0;
			for (int j = 0; j < matrix[i].length; j++) {

				K[i][kljuc[l] - 1] = matrix[i][j];
				l++;

			}

		}
		for (int j = 0; j < matrix[0].length; j++) {

			for (int i = 0; i < matrix.length; i++) {
				System.out.print(K[i][j]);
			}
		}
	}

}
