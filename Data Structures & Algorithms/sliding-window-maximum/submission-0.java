class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> d = new LinkedList<>();

        int l = 0, r = 0;
        while (r < nums.length) {
            while (!d.isEmpty() && nums[r] >= nums[d.getLast()]) {
                d.removeLast();
            }
            d.addLast(r);

            while (d.getFirst() < l) {
                d.removeFirst();
            }
            
            if (r + 1 >= k) {
                res[l] = nums[d.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
