package paket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class XiO {
	public static void print(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean proveriHORiVER(int n, int m, char[][] blok) {
		int brojacIstihZnakova = 0;
		char znak = '\0';

		for (int i = 0; i < n; i++) {
			brojacIstihZnakova = 0;
			znak = '\0';

			for (int j = 0; j < n; j++) {

				if (blok[i][j] == znak && znak != ' ') {
					brojacIstihZnakova++;
					znak = blok[i][j];
				} else
					brojacIstihZnakova = 1;

				znak = blok[i][j];
			}

			if (brojacIstihZnakova == m) {

				System.out.println("Igrac " + znak + " je pobednik");
				break;
			}
		}

		for (int j = 0; j < n; j++) {
			brojacIstihZnakova = 0;
			znak = '\0';

			for (int i = 0; i < n; i++) {

				if (blok[i][j] == znak && znak != ' ') {
					brojacIstihZnakova++;
					znak = blok[i][j];
				} else
					brojacIstihZnakova = 1;

				znak = blok[i][j];
			}

			if (brojacIstihZnakova == m) {

				System.out.println("Igrac " + znak + " je pobednik");
				break;
			}
		}

		for (int k = 0; k < n; k++) {

			znak = '\0';
			brojacIstihZnakova = 0;
			int i = k;
			int j = 0;

			while (i >= 0) {

				if (blok[i][j] == znak && znak != ' ') {
					brojacIstihZnakova++;
					znak = blok[i][j];

				} else if (blok[i][j] != znak) {
					brojacIstihZnakova = 1;

				}

				znak = blok[i][j];

				i--;
				j++;

			}
			if (brojacIstihZnakova == m) {

				System.out.println("Igrac " + znak + " je pobednik");
				break;
			}
		}

		for (int k = 1; k <= n - 1; k++) {
			znak = '\0';
			brojacIstihZnakova = 0;
			int i = n - 1;
			int j = k;

			while (j <= n - 1) {
				if (blok[i][j] == znak && znak != ' ') {
					brojacIstihZnakova++;
					znak = blok[i][j];

				} else if (blok[i][j] != znak) {
					brojacIstihZnakova = 1;

				}

				znak = blok[i][j];

				i--;
				j++;

			}
			if (brojacIstihZnakova == m) {

				System.out.println("Igrac " + znak + " je pobednik");
				break;
			}
		}

		for (int k = 0; k < n; k++) {
			znak = '\0';
			brojacIstihZnakova = 0;
			int i = k;
			int j = n - 1;

			while (i >= 0) {
				if (blok[i][j] == znak && znak != ' ') {
					brojacIstihZnakova++;
					znak = blok[i][j];

				} else if (blok[i][j] != znak) {
					brojacIstihZnakova = 1;

				}

				znak = blok[i][j];

				i--;
				j--;

			}
			if (brojacIstihZnakova == m) {

				System.out.println("Igrac " + znak + " je pobednik");
				break;
			}
		}

		for (int k = n - 2; k >= 0; k--) {
			znak = '\0';
			brojacIstihZnakova = 0;
			int i = n - 1;
			int j = k;

			while (j >= 0) {
				if (blok[i][j] == znak && znak != ' ') {
					brojacIstihZnakova++;
					znak = blok[i][j];

				} else if (blok[i][j] != znak) {
					brojacIstihZnakova = 1;

				}

				znak = blok[i][j];

				i--;
				j--;

			}
			if (brojacIstihZnakova == m) {

				System.out.println("Igrac " + znak + " je pobednik");
				break;
			}
			return true;
		}
		System.out.println("Nema pobednika");
		return false;
	}

	public static void main(String[] args) {

		BufferedReader b = null;
		try {
			b = new BufferedReader(new FileReader("xo2.txt"));
			String text = b.readLine();
			String[] splited = text.split(" ");
			int n = Integer.parseInt(splited[0]);
			int m = Integer.parseInt(splited[1]);

			char x[][] = new char[n][n];

			for (int i = 0; i < x.length; i++) {

				for (int j = 0; j < x[i].length; j++) {
					int c = b.read();
					
					while (c == '\r' || c == '\n')
						c = b.read();
					
					if (c == -1)
						throw new IOException("Preuranjen zavrsetak fajla");
				
					x[i][j] = (char) c;
				}
			}
			print(x);
			proveriHORiVER(n, m, x);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				b.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}