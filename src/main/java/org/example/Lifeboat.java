package org.example;

import java.util.*;

public class Lifeboat {
    // 사용 알고리즘 : Greedy 알고리즘
    
    public int solution(int[] people, int limit){
        
        Arrays.sort(people);
        int answer = 0;
        int j = 0;
        for(int i = people.length - 1; i >= j; i--){
            if(people[i] + people[j] <= limit){
                // 무게가 많은 사람(i)과 적은 사람(j)의 합이 무게 제한보다 같거나 적은 경우. 같이 승선
                answer++;
                j++;
            }else{
                // 무게 제한보다 클 경우. 혼자 구명보트 승선
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = null;
        try 
        {
            // 입력
            sc = new Scanner(System.in);
            System.out.print("사람 입력(쉼표 구분) : ");
            String[] peopleStr = sc.next().split(",");
            // Stream을 이용하여 int로 타입 변환 한뒤 배열 생성
            int[] people = Arrays.stream(peopleStr).mapToInt(Integer :: parseInt).toArray();

            System.out.print("무게 제한 입력 : ");
            int limit = sc.nextInt();

            // 실행
            Lifeboat app = new Lifeboat();
            int result = app.solution(people, limit);

            // 출력
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
