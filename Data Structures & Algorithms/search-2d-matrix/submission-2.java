class Solution {
   public boolean searchMatrix(int[][] matrix, int target) {
    int[] row = findRow(matrix, target, 0, matrix.length);
    if (row.length == 0) return false;
    return findItem(row, target, 0, row.length);
  }

  public int[] findRow(int[][] matrix, int target, int sIdx, int eIdx) {
    if (sIdx == eIdx) return new int[]{};
    if (eIdx - sIdx < 2) {
      return matrix[sIdx][0] <= target && target <= matrix[sIdx][matrix[sIdx].length - 1] ? matrix[sIdx] : new int[]{};
    }

    int midIdx = (sIdx + eIdx) / 2;
    if (matrix[midIdx][0] > target) return findRow(matrix, target, sIdx, midIdx);
    else if (matrix[midIdx][matrix[midIdx].length - 1] < target) return findRow(matrix, target, midIdx + 1, eIdx);
    else return matrix[midIdx];
  }

  public boolean findItem(int[] row, int target, int sIdx, int eIdx) {
    if (sIdx == eIdx) return false;
    if (eIdx - sIdx < 2) return row[sIdx] == target;
    int midIdx = (sIdx + eIdx) / 2;
    if (target > row[midIdx]) return findItem(row, target, midIdx + 1, eIdx);
    if (target < row[midIdx]) return findItem(row, target, sIdx, midIdx);
    return true;
  }
}
