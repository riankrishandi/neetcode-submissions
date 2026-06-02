class Solution {
    Set<String> operators = new HashSet<>(){{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!operators.contains(tokens[i])) {
                stack.add(Integer.parseInt(tokens[i]));
                continue;
            }

            if (stack.size() < 2) {
                return 0;
            }

            int num2 = stack.pop(), num1 = stack.pop();
            int res = operate(num1, num2, tokens[i]);
            stack.add(res);
        }
        return stack.isEmpty() || stack.size() > 1 ? 0 : stack.pop();
    }

    public int operate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                return num1/num2;
        }
        return 0;
    }
}


