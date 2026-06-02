class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Deque<Integer>> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int prevNum = nums[i] - 1;
            int nextNum = nums[i] + 1;

            if (tempMap.containsKey(currentNum)) {
                continue;
            }

            Deque newDeque = new ArrayDeque<Integer>();
            newDeque.add(currentNum);
            tempMap.put(currentNum, newDeque);

            // Handle prev number.
            if (tempMap.containsKey(prevNum)) {
                var existingDeque = tempMap.get(prevNum);
                existingDeque.addAll(newDeque);
        
                newDeque = existingDeque;
        
                tempMap.put(prevNum, newDeque);
                tempMap.put(currentNum, newDeque);
            }
      
            // Handle next number.
            if (tempMap.containsKey(nextNum)) {
                newDeque.addAll(tempMap.get(nextNum));

                tempMap.put(nextNum, newDeque);
                tempMap.put(currentNum, newDeque);
            }
        }

        int res = 0;
        for (var values : tempMap.values()) {
            res = Math.max(res, values.size());
        }
        return res;
    }
}
