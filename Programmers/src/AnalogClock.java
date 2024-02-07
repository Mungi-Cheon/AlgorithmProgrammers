import java.util.HashMap;
import java.util.Scanner;

public class AnalogClock {

    /**
     * 문제 설명
     * 
     * 시침, 분침, 초침이 있는 아날로그시계가 있습니다. 
     * 시계의 시침은 12시간마다, 분침은 60분마다, 초침은 60초마다 시계를 한 바퀴 돕니다. 
     * 따라서 시침, 분침, 초침이 움직이는 속도는 일정하며 각각 다릅니다. 
     * 이 시계에는 초침이 시침/분침과 겹칠 때마다 알람이 울리는 기능이 있습니다. 
     * 당신은 특정 시간 동안 알람이 울린 횟수를 알고 싶습니다.
     * 
     * 다음은 0시 5분 30초부터 0시 7분 0초까지 알람이 울린 횟수를 세는 예시입니다.
     * 
     * 가장 짧은 바늘이 시침, 중간 길이인 바늘이 분침, 가장 긴 바늘이 초침입니다.
     * 알람이 울리는 횟수를 세기 시작한 시각은 0시 5분 30초입니다.
     * 이후 0시 6분 0초까지 초침과 시침/분침이 겹치는 일은 없습니다.
     * 
     * 약 0시 6분 0.501초에 초침과 시침이 겹칩니다. 이때 알람이 한 번 울립니다.
     * 이후 0시 6분 6초까지 초침과 시침/분침이 겹치는 일은 없습니다.
     * 
     * 약 0시 6분 6.102초에 초침과 분침이 겹칩니다. 이때 알람이 한 번 울립니다.
     * 이후 0시 7분 0초까지 초침과 시침/분침이 겹치는 일은 없습니다.
     * 
     * 0시 5분 30초부터 0시 7분 0초까지는 알람이 두 번 울립니다. 
     * 이후 약 0시 7분 0.584초에 초침과 시침이 겹쳐서 울리는 세 번째 알람은 횟수에 포함되지 않습니다.
     * 
     * 알람이 울리는 횟수를 센 시간을 나타내는 정수 h1, m1, s1, h2, m2, s2가 매개변수로 주어집니다. 
     * 이때, 알람이 울리는 횟수를 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * 솔루션
     * @return
     */
    public int solution (int h1, int m1, int s1, int h2, int m2, int s2){
        int answer = 0;

        // 시간과 각도가 증가하기 위한 변수
        int plus_H = h1;
        int plus_M = m1;
        int plus_S = s1;
        float plus_angleH = 0;
        float plus_angleM = 0;
        float plus_angleS = 0;

        // 임시 인스턴스
        int tmp_S = 0;
        int tmp_M = 0;
        int tmp_H = 0;
        float tmp_angleH = 0;
        float tmp_angleM = 0;
        float tmp_angleS = 0;
        HashMap<String, Float> tmpAnglesMap = getAngles(h1, m1, s1);
        
        plus_angleH = tmpAnglesMap.get("h");
        plus_angleM = tmpAnglesMap.get("m");
        plus_angleS = tmpAnglesMap.get("s");

        if((plus_angleH == plus_angleM) && (plus_angleM == plus_angleS)){
            // 시침 분침 초침이 00시 정각인 경우
            answer++;
        }
        while (true) {
            // 시간 증가
            tmp_S = (plus_S) % 60; // 60초인 경우 tmp_S는 0, 그외의 경우 1~59
            tmp_M = (plus_M + (plus_S + 1) / 60) % 60; // 60분인 경우 tmp_M은 0, 그외의 경우 1~59
            tmp_H = (plus_H + (plus_M + (plus_S + 1) / 60) / 60) % 24; // 24시인 경우 0, 그외의 경우 1~23

            // 시간이 증가한 만큼 각도 계산
            tmpAnglesMap = getAngles(tmp_H, tmp_M, tmp_S);
            tmp_angleH = tmpAnglesMap.get("h");
            tmp_angleM = tmpAnglesMap.get("m");
            tmp_angleS = tmpAnglesMap.get("s");

            if((plus_angleS < plus_angleM && tmp_angleS >= tmp_angleM) || (plus_angleS < plus_angleM && tmp_angleS == 0.0)){
                // 초침과 분침이 겹친 경우
                answer++;
            }

            if((plus_angleS < plus_angleH && tmp_angleS >= tmp_angleH) || (plus_angleS < plus_angleH && tmp_angleS == 0.0)){
                // 초침과 시침이 겹친 경우
                answer++;
            }
            if((tmp_angleH == tmp_angleM) && tmp_angleM == tmp_angleS){
                // 00시 정각인 경우 1빼기
                answer--;
            }

            if((tmp_H == h2) && (tmp_M == m2) && (tmp_S == s2)){
                break;
            }

            plus_H = tmp_H;
            plus_M = tmp_M;
            plus_S = tmp_S;
            plus_angleH = tmp_angleH;
            plus_angleM = tmp_angleM;
            plus_angleS = tmp_angleS;
        }

        return answer;
    }

    /**
     * 각도 계산
     * @param h
     * @param m
     * @param s
     * @return
     */
    private HashMap<String, Float> getAngles(float h, float m, float s){
        /**
         * 시간 단위별 움직이는 각도
         * 
         * 시침
         *  1시간 -> 30도    (360도 / 12)
         *  1분   -> 0.5도   (30도 / 60)
         *  1초   -> 1/120도 (0.5도 / 60 = 1도 / 120 )
         * 
         * 분침
         *  1분   -> 6도   (360도 / 60)
         *  1초   -> 0.1도 (6도 / 60)
         * 
         * 초침
         *  1분   -> 360초 (360도 * 60)
         *  1초   -> 6도 (360도 / 60)
         */
        HashMap<String, Float> result = new HashMap<String, Float>();

        float angle_S = s * 6; // 1초인경우 6도 2초인경우 12도.
        float angle_M = (float) ((m * 6) + (s * 0.1 )); // 1분 1초라면 6.1도 2분 10초라면 13도
        float angle_H = (float) (((h % 12) * 30) + (m * 0.5) + (s / 120)); // 13시 1분 10초라면 30.58333..

        result.put("h", angle_H);
        result.put("m", angle_M);
        result.put("s", angle_S);

        return result;
    }

    public static void main(String[] args) throws Exception {
        
        Scanner sc = null;
        try 
        {
            // 시간 값 입력
            sc = new Scanner(System.in);
            System.out.print("h1 : ");
            int h1 = sc.nextInt();
            System.out.print("m1 : ");
            int m1 = sc.nextInt();
            System.out.print("s1 : ");
            int s1 = sc.nextInt();
            System.out.print("h2 : ");
            int h2 = sc.nextInt();
            System.out.print("m2 : ");
            int m2 = sc.nextInt();
            System.out.print("s2 : ");
            int s2 = sc.nextInt();

            AnalogClock app = new AnalogClock();
            System.out.println(app.solution(h1, m1, s1, h2, m2, s2));

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
