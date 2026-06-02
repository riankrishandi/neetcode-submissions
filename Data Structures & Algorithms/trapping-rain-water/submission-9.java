class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int tempRes = 0;
            if (height[i] < height[j]) {
                int iSub = i+1;
                
                while (iSub < j && height[iSub] < height[i]) {
                    tempRes += height[i] - height[iSub];
                    iSub++;
                }

                i = iSub;
            } else {
                int jSub = j-1;

                while (i < jSub && height[jSub] < height[j]) {
                    tempRes += height[j] - height[jSub];
                    jSub--;
                }

                j = jSub;
            }
            res += tempRes;
        }
        return res;
    }
}
