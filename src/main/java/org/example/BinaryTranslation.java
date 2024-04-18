package org.example;

import java.util.Scanner;

public class BinaryTranslation {

    public int[] solution(String s) {
        
        
        String tmp = ""; // 0을 제외한 s
        int c = s.length(); // s의 길이
        int zero_cnt = 0; // 제거할 0의 개수
        int round = 0; // 1이 될때까지 이진 변환한 회차
        
        while(!s.equals("1")){
            c = s.length();
            tmp = s.replaceAll("0", ""); // 0을 공백으로 치환 "0111010" -> "1111" 과정.
            zero_cnt += c - tmp.length(); // 변환전 s의 길이 - 변환 후 s의 길이 = 공백으로 치환한 0의 개수
            s = Integer.toBinaryString(tmp.length()); // 2진수로 변환

            round++; // 회차 카운트
        }

        int[] answer = {round, zero_cnt};
        return answer;
    }

    public static void main(String[] args) throws Exception {
        
        Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            System.out.print("s입력 : ");
            String s = sc.nextLine();
            
            BinaryTranslation app = new BinaryTranslation();
            int[] result = app.solution(s);
            System.out.println(result[0] + "," + result[1]);

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
