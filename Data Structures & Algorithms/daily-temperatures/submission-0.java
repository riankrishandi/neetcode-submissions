class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }
        
        int[] res = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (i == 0) {
                s.add(0);
                continue;
            }
            
            // Check the stack.
            while (!s.isEmpty()) {
                int indexTop = s.peek();
                if (temperatures[indexTop] >= temperatures[i]) break;
                res[indexTop] = i - s.pop();
            }
            s.add(i);
        }

        return res;
    }
}
