class Solution {
    Set<String> operators = new HashSet<>(){{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    public int evalRPN(String[] tokens) {        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.add(Integer.parseInt(token));
                continue;
            }

            if (stack.size() < 2) {
                return -1;
            }

            int b = stack.pollLast();
            int a = stack.pollLast();

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
            stack.add(res);
        }

        if (stack.size() == 1) return stack.pollLast();
        return -1;
    }
}