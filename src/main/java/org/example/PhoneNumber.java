package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneNumber {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        // phone_book.length에서 - 1 해주는 이유
        // phone_book의 값이 ["12","123","1235","567","88"] 이고 i의 값이 4인 경우
        // phone_book[4] == "88"이된다. 이때 17번 라인에서 phone_book[i + 1]을 통해
        // phone_book[5]의 값을 가져오려 하는데 phone_book의 5번 index는 존재 하지 않기 때문에
        // IndexOutBoundsException이라는 인덱스가 배열의 길이보다 클 경우 발생하는 에러가 발생하기 때문.
        for(int i = 0; i < phone_book.length-1; i++){ 
            String prefix = phone_book[i];
            if(phone_book[i+1].startsWith(prefix)){
                return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            
            System.out.print("값 입력(쉼표 구분) : ");
            String[] phone_book = sc.next().split(",");

            PhoneNumber phoneNumber = new PhoneNumber();
            System.out.println(phoneNumber.solution(phone_book));

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
