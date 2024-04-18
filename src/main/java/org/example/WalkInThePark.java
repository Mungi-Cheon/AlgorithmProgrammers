package org.example;

import java.util.*;
public class WalkInThePark {

    public int[] solution(String[] park, String[] routes) {
        int curCol = 0; // 현재 x좌표
        int curRow = 0; // 현재 y좌표

        // 공원의 행과 열 사이즈
        int rowNum = park.length;
        int colNum = park[0].length();

        // 2차원 배열로 변환
        char[][] map = new char[rowNum][colNum];
        for(int row = 0; row < rowNum; row++){
            for(int col = 0; col < colNum; col++){

                if(park[row].charAt(col) == 'S'){
                    // map에서 'S'의 위치 추출
                    curRow = row;
                    curCol = col;
                }
                map[row][col] = park[row].charAt(col);
            }
        }
        // 1. 이동할 방향과 좌표값을 map에 저장
        HashMap<Character, List<Integer>> moveMap = new HashMap<>();
        moveMap.put('N', List.of(-1,0));
        moveMap.put('S', List.of(1,0));
        moveMap.put('W', List.of(0, -1));
        moveMap.put('E', List.of(0, 1));

        // 2. routes를 " "로 구분해 이동할 방향(direction)과 이동할 칸의 수(moveIndex)를 추출
        for(String route : routes){
            char direction = route.charAt(0); // "S 1" 인경우 각 char의 인덱스는 'S' = 0 | ' ' = 1 | '1' = 2
            int moveIndex = route.charAt(2)-'0';

            // 롤백을 위한 변수와 장애물과 마주쳤는지 판정을 위한 boolean 변수 선언
            int tmpRow = curRow; 
            int tmpCol = curCol;
            boolean isImPossible = false;

            for(int moving = 0; moving < moveIndex; moving++){

                int moveRow = curRow + moveMap.get(direction).get(0);
                int moveCol = curCol + moveMap.get(direction).get(1);

                if(moveRow < 0 || moveRow >= rowNum || moveCol < 0 || moveCol >= colNum){
                    // 3. 이동할 칸의 수가 0보다 작거나 colNum(or rowNum)이상이라면
                    //    해당 명령을 무시하고 curRow와 curCol는 롤백.
                    isImPossible = true;
                    break;
                }
                if(map[moveRow][moveCol] =='X'){
                    // 4. 이동할 방향으로 이동 중에 'X'가 있다면 해당 명령을 무시하고 curRow와 curCol는 롤백.
                    isImPossible = true;
                    break;
                }

                if(!isImPossible){
                    curRow = moveRow;
                    curCol = moveCol;
                }
            }
            if(isImPossible){
                curRow = tmpRow;
                curCol = tmpCol;
            }
        }
        
        int[] answer = {curRow,curCol};
        return answer;
    }

    public static void main(String[] args) {
            
        // String[] park = {"SOO","OOO","OOO"};
        // String[] routes = {"E 2","S 2","W 1"};

        // String[] park = {"SOO","OXX","OOO"};
        // String[] routes = {"E 2","S 2","W 1"};

        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        WalkInThePark parkObj = new WalkInThePark();
        System.out.print("result : ");
        for(int el : parkObj.solution(park,routes)){
            System.out.print(el +" ");
        }
    }
}
