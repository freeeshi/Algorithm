package cn.algo.utils;

public class MatrixUtils {
	
	public static int[][] createMatrix(int width, int high, int max){
		int [][] matrix = new int[high][width];
		
		for(int i = 0; i < high; i++) {
			for(int j = 0; j < width; j++) {
				matrix[i][j] = (int) (Math.random()*max);
			}
		}
		
		return matrix;
	}
	
	public static int[][] createMatrix(int width, int high){
		return createMatrix(width, high, 100);
	}
	
	public static void printMatrix(int[][] matrix) {
		int width = matrix[0].length;
		int high = matrix.length;
		
		for(int i = 0; i < high; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
