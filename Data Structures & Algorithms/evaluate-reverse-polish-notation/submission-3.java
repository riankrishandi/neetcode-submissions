class Solution {
    Set<String> operators = new HashSet<>(){{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    public int evalRPN(String[] tokens) {        
        Deque<String> stack = new ArrayDeque<String>();
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.add(token);
                continue;
            }

            if (stack.size() < 2) {
                return -1;
            }

            int b = Integer.parseInt(stack.pollLast());
            int a = Integer.parseInt(stack.pollLast());

            int res = 0;
            switch(token) {
                case "+":
                    res = a+b;
                    break;
                case "-":
                    res = a-b;
                    break;
                case "*":
                    res = a*b;
                    break;
                case "/":
                    res = a/b;
                    break;
                default:
                    return - 1;
            }
            stack.add(String.valueOf(res));
        }

        if (stack.size() == 1) return Integer.parseInt(stack.pollLast());
        return -1;
    }
}