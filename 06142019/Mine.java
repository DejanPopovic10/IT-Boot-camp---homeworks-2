package paket;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Mine {

	private static boolean legalniIndeksi(int i, int j, int[][] matrix) {
		if (i >= 0 && i < matrix.length)
			if (j >= 0 && j < matrix[i].length)
				return true;
		return false;
	}

	public static boolean vidiPoziciju(int[][] matrix, int i, int j) {

		if (matrix[i][j] == 1) {
			return true;
		}
		return false;
	}

	public static int proveriDesnuDijagonalu(int i, int j, int[][] matrix) {
		int brojac = 0;
		if (legalniIndeksi(i + 1, j + 1, matrix) && vidiPoziciju(matrix, i + 1, j + 1)) {

			brojac++;
		}
		if (legalniIndeksi(i - 1, j - 1, matrix) && vidiPoziciju(matrix, i - 1, j - 1)) {

			brojac++;
		}
		return brojac;
	}

	public static int proveriLevuDijagonalu(int i, int j, int[][] matrix) {
		int brojac = 0;
		if (legalniIndeksi(i + 1, j - 1, matrix) && vidiPoziciju(matrix, i + 1, j - 1)) {

			brojac++;
		}
		if (legalniIndeksi(i - 1, j + 1, matrix) && vidiPoziciju(matrix, i - 1, j + 1)) {

			brojac++;
		}
		return brojac;
	}

	public static int proveriHorizontalu(int i, int j, int[][] matrix) {
		int brojac = 0;
		if (legalniIndeksi(i, j + 1, matrix) && vidiPoziciju(matrix, i, j + 1)) {

			brojac++;
		}
		if (legalniIndeksi(i, j - 1, matrix) && vidiPoziciju(matrix, i, j - 1))
			brojac++;
		return brojac;
	}

	public static int proveriVertikalu(int i, int j, int[][] matrix) {
		int brojac = 0;
		if (legalniIndeksi(i + 1, j, matrix) && vidiPoziciju(matrix, i + 1, j)) {

			brojac++;
		}
		if (legalniIndeksi(i - 1, j, matrix) && vidiPoziciju(matrix, i - 1, j))
			brojac++;
		return brojac;
	}

	public static int proveri(int i, int j, int[][] matrix) {
		int y = proveriVertikalu(i, j, matrix) + proveriHorizontalu(i, j, matrix) + proveriLevuDijagonalu(i, j, matrix)
				+ proveriDesnuDijagonalu(i, j, matrix);
		return y;

	}

	public static void citaj_Kreiraj_Kastovani_Niz() throws IOException {
		BufferedReader b = null;

		b = new BufferedReader(new FileReader("maps.txt"));
		String text = b.readLine();
		String[] splited = text.split(" ");
		int n = Integer.parseInt(splited[0]);
		int m = Integer.parseInt(splited[1]);

		char k[][] = new char[n][n];
		int x[][] = new int[n][n];

		for (int i = 0; i < x.length; i++) {
			String line = b.readLine();
			for (int j = 0; j < x[i].length; j++) {
				k[i][j] = line.charAt(j);
				// x[i][j] = k[i][j]- '0' (moze i ovakav cast)
				x[i][j] = Character.getNumericValue(k[i][j]);

			}
		}

		b.close();
		ucitaj_Fajl_Sa_Novim_Podacima(x);
	}

	public static void ucitaj_Fajl_Sa_Novim_Podacima(int[][] matrix) throws IOException {

		int A[][] = new int[matrix.length][matrix.length];
		FileWriter fw = new FileWriter("C:\\Users\\123\\eclipse-workspace\\Minesweeper\\bombs.txt");
		try {
			for (int i = 0; i < matrix.length; i++) {
				fw.write('\n');
				for (int j = 0; j < matrix.length; j++) {

					int y = proveri(i, j, matrix);
					A[i][j] = y;
					fw.write(Integer.toString(y));
				}
				fw.write('\n');
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {

		citaj_Kreiraj_Kastovani_Niz();

	}
}