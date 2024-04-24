package org.example;

public class Fibonacci {

    public int solution(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;

        // 피보나치 수를 1234567로 나눈 값들 중에서 n번째의 값을 리턴
        for (int i = 2; i <= n; i++) {
            int sum = array[i - 1] + array[i - 2];
            array[i] = sum % 1234567;
        }
        return array[n];
    }

    public static void main(String[] args) {

        Fibonacci app = new Fibonacci();
        System.out.println(app.solution(3));
        System.out.println();
        System.out.println(app.solution(5));
    }
}
