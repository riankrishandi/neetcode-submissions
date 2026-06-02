class Solution {
    public int trap(int[] height) {
        int l = 0, maxHeightLeft = 0;
        int r = height.length - 1, maxHeightRight = 0;
        int res = 0;
        while (l <= r) {
            if (maxHeightLeft <= maxHeightRight) {
                maxHeightLeft = Math.max(maxHeightLeft, height[l]);
                res += maxHeightLeft - height[l];
                l++;
            } else {
                maxHeightRight = Math.max(maxHeightRight, height[r]);
                res += maxHeightRight - height[r];
                r--;
            }
        }
        return res;
    }
}
