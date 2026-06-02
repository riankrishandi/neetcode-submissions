class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int i = 0, j = heights.length - 1;
        do {
            int height = Math.min(heights[i], heights[j]);
            int width = j - i;
            int area = height * width;
            max = Math.max(max, area);

            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        } while(i < j);
        return max;
    }
}
