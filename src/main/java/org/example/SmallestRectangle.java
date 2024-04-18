package org.example;

public class SmallestRectangle {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int width = 0;
        int height = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        for(int[] size : sizes){
            // 가로 사이즈와 세로 사이즈를 교환
            width = Math.max(size[0],size[1]);
            height = Math.min(size[0],size[1]);
            
            // 더 큰 값으로 계속 교환
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        answer = maxWidth * maxHeight;
        return answer;
    }
    public static void main(String[] args) {

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        
        // int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}   
        // int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}

        SmallestRectangle rectangle = new SmallestRectangle();
        System.out.println("result = " +rectangle.solution(sizes));
    }
}
