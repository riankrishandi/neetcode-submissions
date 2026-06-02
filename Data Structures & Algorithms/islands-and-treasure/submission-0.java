class Solution {
    private int[][] movements = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    public void dfs(int[][] grid, int i, int j, int count) {
        if (
            i < 0 || i >= grid.length
                || j < 0 || j >= grid[i].length 
                || grid[i][j] == -1
                || grid[i][j] < count
        ) {
            return;
        }
        
        grid[i][j] = Math.min(count, grid[i][j]);
        for (var move : movements) {
            dfs(grid, i + move[0], j + move[1], count + 1);
        }
    }
}
