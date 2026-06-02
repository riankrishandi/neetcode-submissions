class MinStack {
    private Deque<Long> stack = new ArrayDeque<Long>();
    private long min = 0L;

    public MinStack() {
        stack = new ArrayDeque<Long>();
        min = 0L;
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = (long) val;
            return;
        }
        stack.push(val - min);
        min = Math.min(val, min);
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        Long removed = stack.pop();
        if (removed < 0L) {
            min = min - removed;
        }
    }
    
    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }

        long topNum = stack.peek();
        if (topNum >= 0) {
            return (int) (min + topNum);
        }
        return (int) min;
    }
    
    public int getMin() {
        return (int) min;
    }
}
