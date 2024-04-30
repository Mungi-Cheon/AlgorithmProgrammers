package org.example;

import java.util.Scanner;

public class KnightWeapons {

    public int solution(int number, int limit, int power) {
        int answer = 1; // 1의 약수 개수를 초기값으로 설정
        for (int i = 2; i <= number; i++) {
            int cnt = 2; // 2부터는 약수가 최소 2개
            double sqrt = Math.sqrt(i);
            for (int j = 2; j <= sqrt; j++) {
                // 36의 약수는 1,2,3,4,6,9,12,18,36이고 제곱근은 6.
                // 6을 기준으로 [1,36],[2,18],[3,12],[4,9]로 짝이 지어지므로 cnt+=2로 2개씩 카운트
                // 그외의 경우 즉, 6은 짝을 이룰수 없으므로 cnt++로 1개 카운트.
                if (i % j == 0) {
                    if (j == sqrt) {
                        cnt++;
                    } else {
                        cnt += 2;
                    }
                }
            }
            if (cnt > limit) {
                answer += power;
            } else {
                answer += cnt;
            }
        }
        return answer;
    }

//    public int solution(int number, int limit, int power) {
//        int answer = 0;
//        for (int i = 1; i <= number; i++) {
//            int cnt = 0;
//            for (int j = 1; j <= number; j++) {
//                cnt++;
//                if (i % j == 0) {
//                    cnt++;
//                }
//            }
//            if (cnt > limit) {
//                answer += power;
//            } else {
//                answer += cnt;
//            }
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("num : ");
        int num = sc.nextInt();
        System.out.print("limit : ");
        int limit = sc.nextInt();
        System.out.print("power : ");
        int power = sc.nextInt();

        KnightWeapons app = new KnightWeapons();
        System.out.println(app.solution(num, limit, power));
    }
}
