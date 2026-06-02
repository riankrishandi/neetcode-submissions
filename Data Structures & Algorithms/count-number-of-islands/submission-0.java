class Solution {
    private int[][] movements = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = 0;
        for (var move : movements) {
            int nextI = i + move[0], nextJ = j + move[1];
            if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[i].length || grid[nextI][nextJ] != '1') {
                continue;
            }
            dfs(grid, nextI, nextJ);
        }
    }
}
