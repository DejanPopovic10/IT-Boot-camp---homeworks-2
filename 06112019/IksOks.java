package rs.itbootcamp.gen4.nedelja7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IksOks {
	public static void print(char[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();				
		}		
	}
	
	// provera da li su indeksi u legalnom opsegu (ne idu izvan matrice)	
	private static boolean legalniIndeksi(int i, int j, char[][] matrix) {
		if(i>=0 && i<matrix.length)
			if(j>=0 && j<matrix[i].length)
				return true;
		return false;
	}
	
	public static boolean proveriDesnuDijagonalu(char karakter,int i,int j,char[][] matrix, int M) {
		int brojac = 0;
		while(legalniIndeksi(i,j,matrix) && matrix[i][j]==karakter) {
			i++;
			j++;
			brojac++;
		}
		return brojac>=M;
	}
	
	public static boolean proveriLevuDijagonalu(char karakter,int i,int j,char[][] matrix, int M) {
		int brojac = 0;
		while(legalniIndeksi(i,j,matrix) && matrix[i][j]==karakter) {
			i++;
			j--;
			brojac++;
		}
		return brojac>=M;
	}
	
	public static boolean proveriHorizontalu(char karakter,int i,int j,char[][] matrix, int M) {
		int brojac = 0;
		while(legalniIndeksi(i,j,matrix) && matrix[i][j]==karakter) {
			j++;
			brojac++;
		}
		return brojac>=M;
	}
	
	public static boolean proveriVertikalu(char karakter,int i,int j,char[][] matrix, int M) {
		int brojac = 0;
		while(legalniIndeksi(i,j,matrix) && matrix[i][j]==karakter) {
			i++;
			brojac++;
		}
		return brojac>=M;
	}
	
	public static boolean proveri(char karakter,int i,int j, char[][] matrix,int M) {
		return proveriVertikalu(karakter,i, j, matrix, M) || proveriHorizontalu(karakter, i, j, matrix, M)
				|| proveriLevuDijagonalu(karakter,i, j, matrix, M) || proveriDesnuDijagonalu(karakter, i, j, matrix, M);
	}
	
	public static void main(String[] args) {
		try(BufferedReader r = new BufferedReader(new FileReader("iksoks.txt"))){
			String[] nums = r.readLine().split(" ");
			int N = Integer.parseInt(nums[0]);
			int M = Integer.parseInt(nums[1]);
			
			char matrix[][] = new char[N][N];
			
			for(int i = 0; i < matrix.length; i++) {
				String line = r.readLine();
				for(int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = line.charAt(j);
				}
			}
				
			print(matrix);
			
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					if(proveri('X', i,j,matrix, M)) {
						System.out.println("Igrac X je pobednik");
						return;
					}else if(proveri('O',i,j,matrix, M)) {
						System.out.println("Igrac O je pobednik");
						return;
					}
				}
			}
			System.out.println("Nereseno");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}