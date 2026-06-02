class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (i == res.length - 1) res[i] = 0;

            int j = i+1;
            while (j < temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j-i;
                    break;
                }

                if (res[j] == 0) {
                    res[i] = 0;
                    break;
                } else {
                    j += res[j];
                }
            }
        }
        return res;
    }
}
