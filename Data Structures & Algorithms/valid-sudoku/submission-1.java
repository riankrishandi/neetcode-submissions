class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                // Get item.
                char item = board[row][col];
                if (item == '.') continue;

                // Check row.
                rowMap.computeIfAbsent(row, (k) -> new HashSet<>());
                if (rowMap.get(row).contains(item)) return false;
                rowMap.get(row).add(item);

                // Check col.
                colMap.computeIfAbsent(col, (k) -> new HashSet<>());
                if (colMap.get(col).contains(item)) return false;
                colMap.get(col).add(item);

                // Check box.
                // Get box index.
                // Col = 0, 1, 2
                // Box = 0, 3, 6
                // 0 - 2, 3 - 5, 6 - 8
                int boxIdx = (row / 3) * 3 + (col / 3);
                boxMap.computeIfAbsent(boxIdx, k -> new HashSet<>());
                if (boxMap.get(boxIdx).contains(item)) return false;
                boxMap.get(boxIdx).add(item);
            }
        }
        return true;
    }
}
