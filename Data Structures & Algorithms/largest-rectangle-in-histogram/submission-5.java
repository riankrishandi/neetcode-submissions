class Solution {
    Stack<Integer> s = new Stack<>();

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (
                !s.isEmpty()
                    && (i == heights.length || heights[s.peek()] >= heights[i])
            ) {
                int height = heights[s.pop()];
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                res = Math.max(res, height * width);
            }
            s.add(i);
        }
        return res;
    }
}
