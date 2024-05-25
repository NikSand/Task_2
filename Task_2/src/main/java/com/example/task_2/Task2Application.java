package com.example.task_2;

import java.util.Arrays;
import java.util.Random;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task2Application {


    public static void main(String[] args) {

        int nmax = 6;
        int mmax = 6;
        int matrix[][] = new int [nmax][mmax]; //[1 2 3] [ 4 5 6] [7 8 9] -> 1 точка, число 3

        int maxst[] = new int [nmax];
        int maxsr[] = new int [mmax];
        int minst[] = new int [nmax];
        int minsr[] = new int [mmax];
        int k = 0;

        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix [i][j] = random.nextInt(50);
            }
        }


        System.out.println("Наша матрица:");
        System.out.println(" ");

        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

        System.out.println(" ");

        for (int i = 0; i < mmax; i++) {
            minsr[i] = matrix[i][0];
            maxsr[i] = matrix[i][0];
            for (int j=1; j < nmax; j++){
                if (matrix[i][j] < minsr[i]){
                    minsr[i] = matrix[i][j];
                }
                if (matrix[i][j] > maxsr[i]) {
                    maxsr[i] = matrix[i][j];
                }
            }
        }

        for (int j = 0; j < mmax; j++) {
            minst[j] = matrix[0][j];
            maxst[j] = matrix[0][j];
            for (int i = 0; i < nmax; i++){
                if (matrix[i][j] < minst[j]) {
                    minst[j] = matrix[i][j];
                }
                if (matrix[i][j] > maxst[j]){
                    maxst[j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < nmax; i++) {
            for (int j = 0; j < mmax; j++) {
                if (((matrix[i][j] == maxsr[i]) && (matrix[i][j] == minst[j])) || ((matrix[i][j] == maxst[j]) && (matrix[i][j]== minsr[i]))) {
                    k++;
                }
            }
        }
        if (k==0) {
            System.out.println("Таких точек нет");
        } else {
            System.out.println("Всего седлых точек в матрице: "+ k / 2);
        }
    }
}

