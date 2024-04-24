package org.example;

public class ThreeMusketeers {

    public int solution(int[] number) {
        int answer = 0;

        // number의 원소를 탐색해 3개의 원소 합이 0인 경우 카운트해 리턴.
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] number =
//            {-2, 3, 0, 2, -5};
//            {-3, -2, -1, 0, 1, 2, 3};
            {-1, 1, -1, 1};
        ThreeMusketeers app = new ThreeMusketeers();
        System.out.println(app.solution(number));
    }
}
