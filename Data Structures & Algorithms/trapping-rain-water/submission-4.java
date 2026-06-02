class Solution {
  public int trap(int[] height) {
    if (height == null || height.length < 3) {
        return 0;
    }

    int i = 0, j = height.length - 1;
    int leftMax = height[i], rightMax = height[j];
    int res = 0;
    while (i < j) {
        // Handle left is smaller.
        if (leftMax < rightMax) {
            i++;
            leftMax = Math.max(leftMax, height[i]);
            res += leftMax - height[i];
            continue;
        }

        j--;
        rightMax = Math.max(rightMax, height[j]);
        res += rightMax - height[j];
    }
    return res;
  }
}