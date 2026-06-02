class Solution {
    private int[][] movements = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int idx, int i, int j) {
        if (idx == word.length()) return true;
        if (
            i < 0 || i >= board.length 
                || j < 0 || j >= board[i].length
                || board[i][j] == '#' 
                || board[i][j] != word.charAt(idx)
        ) {
            return false;
        }

        board[i][j] = '#';
        for (var move : movements) {
            if (dfs(board, word, idx + 1, i + move[0], j + move[1])) {
                return true;
            }
        }
        board[i][j] = word.charAt(idx);
        return false;
    }
}
