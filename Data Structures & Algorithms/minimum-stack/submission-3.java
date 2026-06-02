class MinStack {
  private Stack<Long> stack;
  private long min;

  public MinStack() {
    stack = new Stack<>();
    min = 0L;
  }

  public void push(int x) {
    if (stack.isEmpty()) {
      stack.add(0L);
      min = (long) x;
      return;
    }

    stack.add(x - min);
    min = Math.min(min, x);
  }

  public void pop() {
    if (stack.isEmpty()) {
      return;
    }

    long popNum = stack.pop();
    if (popNum < 0) {
      min = min - popNum;
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