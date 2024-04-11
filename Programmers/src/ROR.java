import java.util.LinkedList;
import java.util.Queue;

public class ROR {
    private final static int[][] DIRECTIONS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int solution(int[][] maps) {
        int answer = 0;
        
        int rowLength = maps.length;
        int colLength = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowLength][colLength];

        // 첫번째 vertex 방문
        visited[0][0] = true;
        queue.offer(new int[]{0,0,1}); // 0,0 : 위치 | 1 : 카운트

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(cur[0] == rowLength - 1 && cur[1] == colLength - 1){
                answer = cur[2];
                return answer;
            }

            for(int i = 0; i < DIRECTIONS.length; i++){
                int nextRow = DIRECTIONS[i][0] + cur[0];
                int nextCol = DIRECTIONS[i][1] + cur[1];

                if(isValid(rowLength, colLength, nextRow, nextCol)){
                    if(!visited[nextRow][nextCol]&& maps[nextRow][nextCol] == 1){
                        queue.offer(new int[]{nextRow,nextCol, cur[2]+1});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int rowLength, int colLength, int nextRow, int nextCol){
        return nextRow >= 0 && nextRow < rowLength && nextCol >= 0 && nextCol < colLength;
    }

    public static void main(String[] args) {

        int[][] maps = {
            {1,0,1,1,1}
            ,{1,0,1,0,1}
            ,{1,0,1,1,1}
            ,{1,1,1,0,1}
            ,{0,0,0,0,1}
        };

        // int[][] maps = {
        //     {1,0,1,1,1}
        //     ,{1,0,1,0,1}
        //     ,{1,0,1,1,1}
        //     ,{1,1,1,0,0}
        //     ,{0,0,0,0,1}
        // };
        
        ROR app = new ROR();
        System.out.println(app.solution(maps));
    }
}
