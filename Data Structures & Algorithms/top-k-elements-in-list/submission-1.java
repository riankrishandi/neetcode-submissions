class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      // Loop through nums.
      Map<Integer, Integer> countNum = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        countNum.put(nums[i], countNum.getOrDefault(nums[i], 0) + 1);
      }

      // Put into a heap.
      var heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
      // Loop through countNum.
      for (var entry : countNum.entrySet()) {
        heap.offer(new int[]{entry.getValue(), entry.getKey()});
        if (heap.size() > k) {
          heap.poll();
        }
      }

      // Get items.
      var res = new int[k];
      for (int i = 0; i < k; i++) {
        res[i] = heap.poll()[1];
      }
      return res;
    }
}
