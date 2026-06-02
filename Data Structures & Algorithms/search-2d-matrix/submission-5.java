class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Find the correct wrapper array.
        int i = 0, j = matrix.length;
        int[] nestedArr = null;
        while (i < j) {
            int mid = (i + j) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                nestedArr = matrix[mid];
                break;
            } else if (target > matrix[mid][matrix[mid].length-1]) {
                i = mid+1;
            } else {
                j = mid;
            }
        }

        if (nestedArr == null) return false;

        int left = 0, right = nestedArr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nestedArr[mid] == target) return true;
            if (target > nestedArr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}
