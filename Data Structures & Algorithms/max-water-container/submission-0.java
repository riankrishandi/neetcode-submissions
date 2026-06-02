class Solution {
    // 
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int height = Math.min(heights[i], heights[j]);
            int width = j - i;
            maxArea = Math.max(height * width, maxArea);

            // How to decide i or j should move?
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
