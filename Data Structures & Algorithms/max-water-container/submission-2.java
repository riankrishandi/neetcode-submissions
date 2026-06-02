class Solution {
    // 
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0, r = heights.length-1;
        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            int width = r-l;
            res = Math.max(height * width, res);

            if (heights[l] < heights[r]) l++;
            else r--;
        }
        return res;
    }
}
