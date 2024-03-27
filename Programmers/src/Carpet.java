import java.util.Scanner;

public class Carpet {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int fullSize = brown + yellow;
        for( int i = 3; i < fullSize; i++){
            int row = i; // 행 사이즈
            int col = fullSize / row; // 열 사이즈
            
            if(col >= row){
                if((col - 2) * (row -2) == yellow){
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
    Scanner sc = null;
        try 
        {
            sc = new Scanner(System.in);
            System.out.print("brown : ");
            int brown = sc.nextInt();
            
            System.out.print("yellow : ");
            int yellow = sc.nextInt();

            Carpet app = new Carpet();
            int[] result = app.solution(brown, yellow);
            System.out.println("result = ["+result[0] + "," + result[1]+"]");

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
