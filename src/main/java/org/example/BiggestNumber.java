package org.example;

import java.util.*;

public class BiggestNumber {

    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        boolean isAllZero = true;
        
        for(int i = 0; i < numbers.length; i++){

            if(numbers[i] != 0){
                isAllZero = false;
            }

            nums[i] = String.valueOf(numbers[i]);
        }

        if(isAllZero){
            return "0";
        }

        Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                // 비교 값이 양수인 경우 자리 교환, 음수인 경우 교환하지 않음.
                // String으로 비교시 아스키 코드 값으로 비교.
                return (o2+o1).compareTo((o1+o2));
            }
        });
        
        for(String num : nums){
            answer += num;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            
            System.out.print("값 입력(쉼표 구분) : ");
            int[] numbers = Arrays.stream(sc.next().split(",")).
            mapToInt(Integer :: parseInt).toArray();

            BiggestNumber bigNum = new BiggestNumber();
            System.out.println(bigNum.solution(numbers));

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
