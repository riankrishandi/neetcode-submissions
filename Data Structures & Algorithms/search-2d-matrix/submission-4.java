class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Find the right matrix first.
        int[] targetArr = null;
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int mid = (l+r+1)/2;

            // Check the matrix.
            int[] row = matrix[mid];
            if (target >= row[0] && target <= row[row.length-1]) {
                targetArr = row;
                break;
            }

            // Adjust left.
            if (target > row[row.length-1]) {
                l = mid+1;
                continue;
            }
            r = mid-1;
        }

        if (targetArr == null) return false;

        for (var num : targetArr) {
            if (num == target) return true;
        }
        return false;
    }
}
