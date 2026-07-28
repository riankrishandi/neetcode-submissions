class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        
        // Init res.
        int maxLength = temperatures.length - 1;
        int i = maxLength;
        res[i--] = 0;
    
        while (i >= 0) {
            int dist = 1;
            while (i + dist <= maxLength) {
                if (temperatures[i] < temperatures[i+dist]) {
                    res[i] = dist;
                    break;
                }

                if (res[i+dist] == 0) {
                    res[i] = 0;
                    break;
                }

                dist = dist+res[i+dist];
            }
            i--;
        }
        return res;
    }
}
