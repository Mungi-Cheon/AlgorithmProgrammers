import java.util.*;

public class YearningPoint {
    
    public int[] solution(String[] name, int[] yearning, String[][] photo)
    {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> yearningByName = new HashMap<>();

        for(int i = 0; i < name.length; i++)
        {
            // Mapping
            yearningByName.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++)
        {
            int sum = 0;
            // 1행씩 List화
            List<String> arr = Arrays.asList(photo[i]);

            Iterator<String> ite = yearningByName.keySet().iterator();
            while(ite.hasNext())
            {
                String key = (String)ite.next();

                if(arr.contains(key)){
                    // key(이름)이 photo[i]의 List에 존재한다면 추억 점수를 더해주기
                    sum += yearningByName.get(key);
                }
            }

            answer[i] = sum;
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = null;
        try 
        {
            // 입력
            sc = new Scanner(System.in);
            System.out.print("이름 입력(쉼표 구분) : ");
            String[] name = sc.next().split(",");

            System.out.print("그리움 점수 입력 : ");
            int[] yearning = Arrays.stream(sc.next().split(",")).mapToInt(Integer :: parseInt).toArray();

            String[][] photo = {{"may", "kein", "kain", "radi"},
                                {"may", "kein", "brin", "deny"}, 
                                {"kon", "kain", "may", "coni"}};

            // String[][] photo = {{"kali", "mari", "don"},
            //                     {"pony", "tom", "teddy"}, 
            //                     {"con", "mona", "don"}};

            // String[][] photo = {{"may"},
            //                     {"kein", "deny", "may"}, 
            //                     {"kon", "coni"}};

            // 실행
            YearningPoint app = new YearningPoint();
            int[] result = app.solution(name, yearning, photo);

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
