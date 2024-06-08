package org.example;

public class WireCutting {

    public int solution(int n, int m, int[][] points) {
        int answer = 0;
        int[][] grid = new int[n + 1][m + 1];
        for (int[] point : points) {
            grid[point[0]][point[1]] = 1;
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 0) {
                    dfs(row, col, grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == 0) {
            grid[row][col] = 1;
            dfs(row + 1, col, grid);
            dfs(row - 1, col, grid);
            dfs(row, col + 1, grid);
            dfs(row, col - 1, grid);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int[][] points = {{3, 0}, {2, 1}, {1, 1}, {0, 2}, {2, 3}};

        WireCutting app = new WireCutting();
        System.out.println(app.solution(n, m, points));
    }
}
