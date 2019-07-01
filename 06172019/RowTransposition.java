package rs.itbootcamp.gen4.nedelja8;

import java.util.Scanner;

public class RowTransposition {
	
	public static void print(char[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++)
				System.out.print(matrix[i][j]);
			System.out.println();
		}
	}
	
	// vraca indeks niza na kome se nalazi prosledjena vrednost
	public static int findIndex(int[] arr, int value) {
		for(int i=0; i<arr.length; i++)
			if(arr[i] == value)
				return i;
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int key[] = new int[N];
		for(int i = 0; i < N; i++)
			key[i] = sc.nextInt();
		
		String text = sc.next();
		
		int M = text.length() / N + 1;
		
		char[][] matrix = new char[M][N];
		
		for(int i=0; i<M; i++)
			for(int j=0; j<N && i*N + j < text.length(); j++)
					matrix[i][j] = text.charAt(i*N + j);
		
		for(int j=0; j<N; j++)
			for(int i=0; i<M; i++)
				System.out.print(matrix[i][findIndex(key,j+1)]);
	}
}
