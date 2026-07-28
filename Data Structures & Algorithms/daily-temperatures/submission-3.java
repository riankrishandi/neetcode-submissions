class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        int maxIdx = temperatures.length - 1; 
        int i = maxIdx;
        res[i--] = 0;
        while (i >= 0) {
            int nextIdxCheck = i + 1;
            if (temperatures[i] < temperatures[nextIdxCheck]) {
                res[i--] = 1;
                continue;
            }

            int nextIdxCheckVal = res[nextIdxCheck];
            if (nextIdxCheckVal == 0) {
                res[i--] = 0;
                continue;
            }

            nextIdxCheck += nextIdxCheckVal;
            while (nextIdxCheck <= maxIdx) {
                if (temperatures[i] < temperatures[nextIdxCheck]) {
                    res[i] = nextIdxCheck - i;
                    i--;
                    break;
                }

                if (res[nextIdxCheck] == 0) {
                    res[i--] = 0;
                    break;
                }

                nextIdxCheck += res[nextIdxCheck];
            }
        }
        return res;
    }
}
