class Solution {
  public boolean isValidSudoku(char[][] board) {
    Set<Character> tempSet = new HashSet<>();
    Map<Integer, Set<Character>> squareSet = new HashMap<>();

    // Check rows.
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          continue;
        }

        // Check if element already exists in row set.
        if (tempSet.contains(board[i][j])) {
          return false;
        }
        // Check if element already exists in square set.
        // Get square index first between 1 - 9.
        int squareIndex = 3 * (i / 3) + (j / 3 + 1);
        if (squareSet.get(squareIndex) != null && squareSet.get(squareIndex).contains(board[i][j])) {
          return false;
        }

        // Put into the sets.
        tempSet.add(board[i][j]);
        if (!squareSet.containsKey(squareIndex)) {
          squareSet.put(squareIndex, new HashSet<>());
        }
        squareSet.get(squareIndex).add(board[i][j]);
      }
      tempSet.clear();
    }

    // Check columns.
    for (int i = 0; i < 9; i++) { // Column.
      for (int j = 0; j < 9; j++) { // Row.
        if (board[j][i] == '.') {
          continue;
        }

        // Check if element already exists in row set.
        if (tempSet.contains(board[j][i])) {
          return false;
        }

        // Put into the sets.
        tempSet.add(board[j][i]);
      }
      tempSet.clear();
    }
    return true;
  }
}
