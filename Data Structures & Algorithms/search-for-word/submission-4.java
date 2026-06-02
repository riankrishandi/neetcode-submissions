class Solution {
    // i = vertical
    // j = horizontal
    public boolean exist(char[][] board, String word) {
        if (word == null || board == null) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int charIdx, char[][] board, String word) {
        int[][] moves = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        if (
            i < 0 || i >= board.length 
                || j < 0 || j>= board[i].length
                || board[i][j] == '#'
                || board[i][j] != word.charAt(charIdx)
        ) {
            return false;
        }

        if (charIdx == word.length() - 1) {
            return true;
        }

        board[i][j] = '#';
        charIdx++;
        for (var move : moves) {
            if (dfs(i+move[0], j+move[1], charIdx, board, word)) {
                return true;
            }
        }
        board[i][j] = word.charAt(charIdx - 1);
        return false;
    }
}
