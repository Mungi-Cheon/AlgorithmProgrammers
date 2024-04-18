package org.example;

import java.util.Scanner;

public class CaesarCipher {

    public String solution(String s, int n) {
        String answer = "";
        
        for(char c : s.toCharArray()){
            if(c == 32) { // 스페이스
                answer += c;
                continue;
            }else if( c <= 90) { // 대문자 
                c += n; // n만큼 밀기
                
                if(c >= 91){ // Z의 아스키 코드를 초과했을때 26만큼 빼기
                    c -= 26;
                }
            }else{ // 소문자
                c += n; // n만큼 밀기
                
                if( c >= 123 ){ // z의 아스키 코드를 초과했을때 26만큼 빼기
                    c -= 26;
                }
            }
            answer += c;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            System.out.print("s : ");
            String s = sc.nextLine();
            
            System.out.print("n : ");
            int n = sc.nextInt();

            CaesarCipher app = new CaesarCipher();
            String result = app.solution(s, n);
            System.out.println(result);

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
