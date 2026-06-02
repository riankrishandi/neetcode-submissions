class Solution {
    private int[][] explores = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Deque<int[]> rottens = new ArrayDeque<>(); // 0 -> y, 1 -> x.
        
        // Deep scan.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } 
                if (grid[i][j] == 2) {
                    rottens.addLast(new int[]{i, j});
                }
            }
        }

        // Execute rotting.
        int time = 0;
        while (fresh != 0 && !rottens.isEmpty()) {
            if (time == 4) {
                System.out.println("Size: " + rottens.size());
                System.out.println(rottens.peek()[0] + ", " + rottens.peek()[1]);
            }

            time++;
            int batch = rottens.size();
            for (int i = 0; i < batch; i++) {
                int[] coordinates = rottens.pollFirst();
                int toRotten = bfs(coordinates, grid, rottens);
                fresh -= toRotten;
            }
        }
        return fresh == 0 ? time : -1;
    }

    // Return found fresh;
    public int bfs(int[] coordinates, int[][] grid, Deque<int[]> rottens) {
        int fresh = 0;
        for (var explore : explores) {
            int y = coordinates[0] + explore[0];
            int x = coordinates[1] + explore[1];
            
            if (y < 0 || y >= grid.length) continue;
            if (x < 0 || x >= grid[0].length) continue;
            if (grid[y][x] != 1) continue;

            // Update fresh, rottens, and grid.
            fresh++;
            rottens.addLast(new int[]{y, x});
            grid[y][x] = 2;
        }
        return fresh;
    }
}
