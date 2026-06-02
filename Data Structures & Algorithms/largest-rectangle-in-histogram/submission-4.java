class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (
                !stack.isEmpty()
                    && (i == heights.length || heights[stack.peek()] > heights[i]) 
            ) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height * width);
            }
            stack.add(i);
        }
        return area;
    }
}



