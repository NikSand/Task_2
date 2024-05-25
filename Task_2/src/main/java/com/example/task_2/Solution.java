package com.example.task_2;

import java.util.Random;

public class Solution {
    public int[][] getRandomMatrix(int n, int m) {
        int[][] arr = new int[n][m];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(50);
            }
        }
        return arr;
    }

    public int[] rowMin( int [][] matrix) {
        int[] minrows = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            for (int j = 0; j < matrix[i].length; j++) {
                if (min > matrix[i][j]) min = matrix[i][j];
            }
            minrows[i] = min;
        }
        return minrows;
    }

    public int[] colMax( int [][] matrix) {
        int[] maxcols = new int[matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            int max = matrix[0][i];
            for (int[] aMatrix : matrix) {
                if (max < aMatrix[i]) max = aMatrix[i];
            }
            maxcols[i] = max;
        }
        return maxcols;
    }
}
