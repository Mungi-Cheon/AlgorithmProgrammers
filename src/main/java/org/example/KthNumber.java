package org.example;

import java.util.*;

public class KthNumber {
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            // 자르는 기준이 0부터 시작하는 배열의 인덱스가 아닌 n번째 숫자이므로 -1해서 배열을
            // 지정한 범위만큼 복사
            int[] copyArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(copyArray);
            // 위와 동일하게 -1
            answer[i] = copyArray[commands[i][2]-1];
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        KthNumber k = new KthNumber();
        for(int number : k.solution(array, commands)){
            System.out.print(number+" ");
        }
    }
}
