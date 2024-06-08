package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Move {

    public int[] solution(int[][] arr) {

        // r+1행의 각 숫자별 위치마다 이동방향 거리를 구하기
        int[] answer = new int[arr[0].length];
        for (int target = 0; target < arr[0].length; target++) {

            List<Integer[]> moveList = new ArrayList<>();

            for (int row = 0; row < arr.length; row++) {
                for (int col = 0; col < arr[row].length; col++) {
                    if (arr[row][col] == target) {
                        moveList.add(new Integer[]{row, col});
                    }
                }
            }
            answer[target] = calcSum(moveList);
        }
        return answer;
    }

    private int calcSum(List<Integer[]> moveList) {
        // 구한 이동방향 거리를 연산하기
        int sum = 0;
        for (int i = 0; i < moveList.size() - 1; i++) {
            Integer[] cur = moveList.get(i);
            Integer[] next = moveList.get(i + 1);
            sum += (Math.max(cur[1], next[1]) - Math.min(cur[1], next[1]));
        }
        return sum;
    }

    public static void main(String[] args) {

        int[][] arr = {{1, 3, 2, 0}, {2, 0, 1, 3}, {1, 2, 0, 3}};

        Move app = new Move();
        Arrays.stream(app.solution(arr)).forEach(System.out::println);
    }
}
