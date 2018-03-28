package cn.algo.clockwiseprintmatrix;

import java.util.ArrayList;

import cn.algo.utils.MatrixUtils;

public class ClockwisePrintMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = MatrixUtils.createMatrix(4, 2);
		MatrixUtils.printMatrix(matrix);
		
		ArrayList<Integer> list = print(matrix);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
	}
	
	public static ArrayList<Integer> print(int [][] matrix) {
        int width = matrix[0].length;
        int high = matrix.length;
        int count = high * width;
        int xDire = 1, yDire = 1;
        int x = 0, y = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(count != 0){
            
            for(int i = 0; i < width; i++){
                list.add(matrix[y][x]);
                x += xDire;
                count--;
            }
            x -= xDire;
            high--;
            y += yDire;
            xDire *= -1;

            for(int i = 0; i < high; i++){
                list.add(matrix[y][x]);
                y += yDire;
                count--;
            }
            y -= yDire;
            width--;
            x += xDire;
            yDire *= -1;
        }
        
        return list;
    }

}
