package org.example;

public class VisitedLength {

    public int solution(String dirs) {
        int answer = 0;
    
        boolean[][][][] visited = new boolean[11][11][11][11];
        int curRow = 5, curCol = 5;
        
        for(char ch : dirs.toCharArray()) {
            
            int nextRow = curRow , nextCol = curCol;

            if(ch == 'U'){
                nextRow = curRow + 1; 
            }else if(ch == 'D'){
                nextRow = curRow - 1;
            }else if(ch == 'R'){
                nextCol = curCol + 1;
            }else{
                nextCol = curCol - 1;
            }

            if(isValid(visited,curRow, curCol, nextRow,nextCol) && 
            isVisited(visited, curRow, curCol, nextRow, nextCol)){
                visited[nextRow][nextCol][curRow][curCol] = true;
                visited[curRow][curCol][nextRow][nextCol] = true;                
                answer++;
            }

            if(isValid(visited, curRow, curCol, nextRow, nextCol)){
                curRow = nextRow;
                curCol = nextCol;
            }
        }

        return answer;
    }

    private boolean isVisited(boolean[][][][]visited, int curRow, int curCol, int nextRow, int nextCol){
        return !visited[curRow][curCol][nextRow][nextCol] && !visited[nextRow][nextCol][curRow][curCol];
    }

    private boolean isValid(boolean[][][][]visited, int curRow, int curCol, int nextRow, int nextCol){
        return nextRow >= 0 && nextRow < visited.length && nextCol >= 0 && nextCol < visited[0].length;
    } 

    public static void main(String[] args) {
        // String dirs="ULURRDLLU";
        // String dirs="LULLLLLLU";
        String dirs = "UDU";
        VisitedLength app = new VisitedLength();
        System.out.println(app.solution(dirs));
    }
}
