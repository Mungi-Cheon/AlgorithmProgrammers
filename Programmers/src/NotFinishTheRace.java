import java.util.*;
public class NotFinishTheRace {
    
    public String solution(String[] participant, String[] completion){
        String answer="";

        HashMap<String, Integer> playerMap = new HashMap<>();
        for(String player : participant){
            // 동명이인이 없는 경우 디폴드 값(0)+1
            // 동명이인이 있는 경우 저장된 값에서 +1해주기
            playerMap.put(player, playerMap.getOrDefault(player, 0)+1);
        }

        for(String player : completion){
            // 완료된 선수가 있는 경우 저장된 값에서 -1해주기
            playerMap.put(player, playerMap.get(player) -1);
        }

        Iterator<String> ite = playerMap.keySet().iterator();
        while (ite.hasNext()) {
            String player = ite.next();

            if(playerMap.get(player) != 0){
                answer = player;
                break;
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        // String[] participant = {"leo", "kiki", "eden"};
        // String[] completion = {"eden", "kiki"};

        // String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        // String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        NotFinishTheRace race = new NotFinishTheRace();
        System.out.println(race.solution(participant, completion));
    }
}
