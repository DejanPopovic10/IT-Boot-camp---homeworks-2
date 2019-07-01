package paket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ProblemSkakaca {

	private static boolean legalniIndeksi(int i, int j, char[][] matrix) {
		if (i >= 0 && i < matrix.length)
			if (j >= 0 && j < matrix[i].length)
				return true;
		return false;
	}

	private static char[][] ucitaj(char[][] matrix, String putanjaDoFajla) throws IOException {
		try (BufferedReader r = new BufferedReader(new FileReader(putanjaDoFajla))) {
			for (int i = 0; i < matrix.length; i++) {
				String line = r.readLine();
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = line.charAt(j);
				}

			}
		}
		return matrix;
	}

	private static void pojedi(char[][] matrix, int i, int j) {
		int[] broj = { 8, 7, 6, 5, 4, 3, 2, 1 };
		char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		int[][] pomeraji = { { -2, 1 }, { -2, -1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

	System.out.print("S" + "(" + alphabet[j] + broj[i] + ")" + ": ");
		for (int k = 0; k < pomeraji.length; k++) {
			int i2 = i + pomeraji[k][0];
			int j2 = j + pomeraji[k][1];

			if (legalniIndeksi(i2, j2, matrix) && matrix[i2][j2] != 'O') {
				System.out.print(matrix[i2][j2] + "(" + alphabet[j2]
						+ broj[i2] + ")");
				System.out.print(" ");
			}

		}System.out.println("");

	}

	public static void main(String[] args) throws IOException {

		char matrixBeli[][] = new char[8][8];
		char matrixCrni[][] = new char[8][8];
		ucitaj(matrixBeli, "beli.txt");
		ucitaj(matrixCrni, "crni.txt");

		for (int i = 0; i < matrixBeli.length; i++) {
			for (int j = 0; j < matrixBeli[i].length; j++) {
				if (matrixBeli[i][j] == 'S')
					pojedi(matrixCrni, i, j);

			}
		}
	}
}