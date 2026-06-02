class Solution {
    private int[][] movements = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int time = 0;
        while (fresh != 0 && !queue.isEmpty()) {
            int length = queue.size(), i = 0;
            while (i < length) {
                // Get coord.
                int[] coord = queue.poll();
                int row = coord[0], col = coord[1];

                // Loop movements.
                for (var m : movements) {
                    // Validate.
                    // Mark as rot;
                    // Add to a queue.
                    // Minus fresh;
                    int rowNext = row + m[0], colNext = col + m[1];
                    if (
                        rowNext >= 0 && rowNext < grid.length
                            && colNext >= 0 && colNext < grid[0].length
                            && grid[rowNext][colNext] == 1
                    ) {
                        grid[rowNext][colNext] = 2;
                        queue.add(new int[]{rowNext, colNext});
                        fresh--;
                    }
                }
                i++;
            }
            time++;
        }
        return fresh != 0 ? -1 : time;
    }
}
