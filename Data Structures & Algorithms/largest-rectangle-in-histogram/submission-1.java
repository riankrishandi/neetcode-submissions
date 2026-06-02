class Solution {
    public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int maxArea = 0;
    Stack<Integer> s = new Stack<>();

    for (int i = 0; i <= n; i++) {
      while (
          !s.isEmpty()
              && (i == n || heights[s.peek()] >= heights[i])
      ) {
        int idxPop = s.pop();
        int height = heights[idxPop];
        int width = s.isEmpty() ? i : i - s.peek() - 1;
        maxArea = Math.max(maxArea, height * width);
      }
      s.add(i);
    }
    return maxArea;
  }
}
