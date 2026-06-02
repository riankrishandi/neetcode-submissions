class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int[] res = new int[nums.length - k + 1];
        int l = 0, r = l;
        Deque<Integer> temp = new ArrayDeque<>();
        while (r < nums.length) {
            if (l > 0 && temp.peekFirst() < l) temp.removeFirst(); 

            while (!temp.isEmpty() && nums[temp.peekLast()] < nums[r]) {
                temp.removeLast();
            }
            temp.addLast(r);

            if (r >= k-1) {
                res[l] = nums[temp.getFirst()];
                l++;
            }
            r++;
        }
        return res; 
    }
}

// Queue.

