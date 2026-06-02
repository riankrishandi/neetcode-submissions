class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> horizontalMap = new HashMap<>();
        Map<Integer, Set<Character>> verticalMap = new HashMap<>();
        Map<Integer, Set<Character>> subBoxMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Character c = board[i][j];
                if (c == '.') {
                    continue;
                }

                // Horizontal.
                horizontalMap.computeIfAbsent(i, (key) -> new HashSet<>());
                if (horizontalMap.get(i).contains(c)) {
                    return false;
                }
                horizontalMap.get(i).add(c);

                // Vertical.
                verticalMap.computeIfAbsent(j, (key) -> new HashSet<>());
                if (verticalMap.get(j).contains(c)) {
                    return false;
                }
                verticalMap.get(j).add(c);

                // Sub box.
                int nSubBox = (i/3) * 3 + (j / 3);
                subBoxMap.computeIfAbsent(nSubBox, (key) -> new HashSet<>());
                if (subBoxMap.get(nSubBox).contains(c)) {
                    return false;
                }
                subBoxMap.get(nSubBox).add(c);
            }
        }
        return true;
    }
}
