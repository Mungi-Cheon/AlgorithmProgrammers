package org.example;

import java.util.*;

public class Phonekemon {

    public int solution(int[] nums){
        int answer = 0;
        // 데려갈 수 있는 폰켓몬의 수는 N / 2마리.
        int max = nums.length / 2;  

        HashSet<Integer> numSet = new HashSet<>(); // Set으로 중복 제거
        for(int num : nums){
            numSet.add(num);
        }

        if(numSet.size() > max){
            answer = max; // 폰켓몬의 종류가 많더라도 결국 데려 갈 수 있는 마리 수는 max의 값이 최대.
        }else{
            answer = numSet.size();
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            System.out.print("nums 입력(쉼표 구분) : ");
            String[] input = sc.next().split(",");
            int[] nums = Arrays.stream(input).mapToInt(Integer :: parseInt).toArray();

            Phonekemon app = new Phonekemon();
            int result = app.solution(nums);
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
