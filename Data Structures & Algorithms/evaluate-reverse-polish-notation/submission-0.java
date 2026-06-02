class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Stack<Integer> stack = new Stack<>();
        for (var t : tokens) {
            if (!operators.contains(t)) {
                stack.add(Integer.parseInt(t));
                continue;
            }

            if (stack.size() < 2) {
                return 0;
            }

            Integer num2 = stack.pop();
            Integer num1 = stack.pop();

            switch (t.charAt(0)) {
                case '+':
                    stack.push(num1 + num2);
                    break;

                case '-':
                    stack.push(num1 - num2);
                    break;

                case '*':
                    stack.push(num1 * num2);
                    break;

                case '/':
                    stack.push(num1 / num2);
                    break;
            }
        }

        if (stack.size() == 1) {
            return stack.pop();
        }
        return 0;
    }
}
