package org.example;

import java.util.Scanner;

public class Collatz {
    public int solution(long num) {
        int answer = 0;

        while(num != 1){
            if(num % 2 == 0){
                num /= 2;
            }else{
                num = (num*3)+1;
            }
            answer++;
        }

        return answer >= 500? -1 : answer;
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            System.out.print("n 입력 : ");
            int n = sc.nextInt();

            Collatz app = new Collatz();
            System.out.println(app.solution(n));
            

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 스캐너 클로즈
            if(sc != null){
                sc.close();
            }
        }
    }
}
