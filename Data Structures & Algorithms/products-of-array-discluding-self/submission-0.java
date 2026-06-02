class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Get product all.
        int product = 1;
        Set<Integer> setZero = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                setZero.add(i);
                continue;
            }
            product *= nums[i];
        }

        // Get res;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (setZero.size() >= 2) {
                res[i] = 0;
                continue;
            }

            if (setZero.contains(i)) {
                res[i] = product;
                continue;
            }

            if (!setZero.isEmpty()) {
                res[i] = 0;
                continue;
            }

            res[i] = product / nums[i];
        }
        return res;
    }
}  
