class MinStack {
  long min;
  Stack<Long> stack;

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int x) {
    if (stack.isEmpty()) {
      stack.push(0L);
      min = x;
    } else {
      stack.push(x-min);
      min = Math.min(x, min);
    }
  }

  public void pop() {
    if (stack.isEmpty()) return;
    var pop = stack.pop();
    if (pop < 0) min = min - pop;
  }

  public int top() {
    var top = stack.peek();
   if (top < 0) {
     return (int) min;
   }
   return (int) (min + top);
  }

  public int getMin() {
    return (int) min;
  }
}
