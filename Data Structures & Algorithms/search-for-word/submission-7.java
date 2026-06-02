class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int charIdx, int i, int j) {        
        if (
            i < 0 || i >= board.length
                || j < 0 || j >= board[i].length
                || board[i][j] == '#'
                || board[i][j] != word.charAt(charIdx)
        ) {
            return false;
        }

        if (charIdx == word.length() - 1) {
            return true;
        }

        int[][] movements = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        charIdx++;
        board[i][j] = '#';
        for (var move : movements) {
            if (dfs(board, word, charIdx, i+move[0], j+move[1])) {
                return true;
            }
        }
        board[i][j] = word.charAt(charIdx - 1);
        return false; 
    }
}
