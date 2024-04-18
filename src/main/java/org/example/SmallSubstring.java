package org.example;

import java.util.*;
public class SmallSubstring {

    public int solution(String t, String p) {
        int answer = 0;
        for(int i = 0; i <= t.length()- p.length(); i++){
            int num = Integer.parseInt(t.substring(i, i + p.length()));
            
            if(num <= Integer.parseInt(p)){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            System.out.print("t의 값 : ");
            String t = sc.nextLine();
            
            System.out.print("p의 값 : ");
            String p = sc.nextLine();

            SmallSubstring smallSubstring = new SmallSubstring();
            System.out.println(smallSubstring.solution(t, p));

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
