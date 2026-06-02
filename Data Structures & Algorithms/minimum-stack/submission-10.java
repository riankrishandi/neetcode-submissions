class MinStack {
    private Deque<Long> deque = new ArrayDeque<>();
    private long min = 0L;

    public MinStack() {
        deque = new ArrayDeque<>();
        min = 0L;
    }
    
    public void push(int val) {
        if (deque.isEmpty()) {
            deque.push(0L);
            min = val;
            return;
        }

        deque.push((long) val - min);
        min = Math.min((long) val, min);
    }
    
    public void pop() {
        if (deque.isEmpty()) return;

        Long removed = deque.pop();
        if (removed < 0L) {
            min = min - removed;
        }
    }
    
    public int top() {
        if (deque.isEmpty()) return 0;

        Long top = deque.peek();
        if (top >= 0L) return (int) (top + min);
        return (int) min;
    }
    
    public int getMin() {
        return (int) min;
    }
}
