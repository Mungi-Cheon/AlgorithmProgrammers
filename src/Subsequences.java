import java.util.*;
public class Subsequences {

    /* 문제 이름 : 연속된 부분 수열의 합 
    비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
    ・기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
    ・부분 수열의 합은 k입니다.
    ・합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
    ・길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
    수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 
    위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요. 
    이때 수열의 인덱스는 0부터 시작합니다. 
    5 ≤ sequence의 길이 ≤ 1,000,000
    1 ≤ sequence의 원소 ≤ 1,000
    sequence는 비내림차순으로 정렬되어 있습니다.
    5 ≤ k ≤ 1,000,000,000
    k는 항상 sequence의 부분 수열로 만들 수 있는 값입니다. 

    입출력 예
    sequence                k           result
    [1, 2, 3, 4, 5] 	    7	        [2, 3]
    [1, 1, 1, 2, 3, 4, 5]	5	        [6, 6]
    [2, 2, 2, 2, 2]	        6	        [0, 2]
    */

    public int[] solution(int[] sequence, int k) {
        // two pointer 알고리즘 선택 이유
        /* 연속된 ◯◯의 합 또는 가짓수 = 대부분 two pointer로 인덱스 증가시키면서 출력하라는 공식 단어 */
        int start_index = 0;
        int end_index = 1;
        int[] answer = new int[]{start_index, sequence.length-1};

        int sum = sequence[0];
        while(start_index < end_index){
            if(sum == k){
                // 합이 부분 수열의 합과 동일한 경우
                if((end_index - 1) - start_index < answer[1] - answer[0]){
                    // 기존 인덱스간의 거리보다 현재 인덱스간의 길이가 짧은 경우 answer값 갱신
                    answer[0] = start_index;
                    answer[1] = end_index - 1;
                }
                sum -= sequence[start_index++];
            }else if(sum > k){
                // 합이 부분 수열의 합보다 적은 경우
                // 현재 start인덱스값을 합에서 제거후 start인덱스 이동
                sum -= sequence[start_index];
                start_index++;
            }else if(end_index < sequence.length){
                // end인덱스 위치가 sequence의 길이보다 낮은 경우
                // 현재 end인덱스의 값을 더하고 end인덱스 이동
                sum += sequence[end_index];
                end_index++;
            }else{
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        
        Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            System.out.print("sequence의길이 : ");
            int size = sc.nextInt();
            
            System.out.print("값 입력(쉼표 구분) : ");
            String[] inputs = sc.next().split(",");
            int[] sequence = new int[size];
            for(int i = 0; i < size; i++){
                sequence[i] = Integer.parseInt(inputs[i]);
            }

            System.out.print("부분 수열의 합 : ");
            int k = sc.nextInt();

            Subsequences app = new Subsequences();
            int[] result = app.solution(sequence, k);
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
