class Solution {
    private int[][] movements = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res = Math.max(res, dfs(grid, i, j));    
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (
            i < 0 || i >= grid.length
                || j < 0 || j >= grid[i].length
                || grid[i][j] == 0
        ) {
            return 0;
        }
        grid[i][j] = 0;

        int area = 1;
        for (var move : movements) {
            area += dfs(grid, i + move[0], j + move[1]);
        }
        return area;
    }
}
