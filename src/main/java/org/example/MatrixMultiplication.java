package org.example;

public class MatrixMultiplication {

    public int[][] solution(int[][] arr1, int[][] arr2) {    
        // N = arr1.length;
        // M = arr1[0].length; // == arr2.length
        // K = arr2[0].length;
        
        // arr1      arr2        answer
        // 1, 4      3, 3        15, 15
        // 3, 2      3, 3        15, 15
        // 4, 1                  15, 15
        
        // answer의 크기 = N * K
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int n = 0; n < arr1.length; n++) { // N은 answer의 행과 동일하므로 가장 밖에서 루프
            for(int m = 0; m < arr1[n].length; m++) { // M은 arr1[0].length와 arr2.length의 길이가 동일하므로 고정 
                for(int k = 0; k < arr2[m].length; k++) { // K는 answer의 열과 동일하므로 가장 안에서 루프
                    answer[n][k] += arr1[n][m] * arr2[m][k];
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        
    }
    
}
