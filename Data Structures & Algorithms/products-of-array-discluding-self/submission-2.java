class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        // fill the prefix.
        // start from index 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}  
