package org.example;

import java.util.*;
public class Tuple {

    public int[] solution(String s) {

        
        int[] nums = Arrays.stream(s.replaceAll("[{}]", "").split(","))
        .mapToInt(Integer :: parseInt).toArray();

        HashMap<Integer, Integer> tupleMap = new HashMap<>();
        for(int num : nums){
            tupleMap.put(num, tupleMap.getOrDefault(num, 0) +1);
        }

        List<Integer> keySet = new ArrayList<>(tupleMap.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return tupleMap.get(o2).compareTo(tupleMap.get(o1));
            }
        });

        int[] answer = new int[keySet.size()];
        for(int i = 0; i < keySet.size(); i++){
            answer[i] = keySet.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            
            System.out.print("값 입력 : ");
            String s = sc.nextLine();
            Tuple tuple = new Tuple();
            for(int el : tuple.solution(s)){
                System.out.print(el +" ");
            }
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
