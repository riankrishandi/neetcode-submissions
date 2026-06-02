class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion(n, res, new Stack<Boolean>(), new StringBuilder(""));
        return res;
    }

    public void recursion(int n, List<String> res, Stack<Boolean> stack, StringBuilder sb) {
        if (n == 0) {
            // Finalize build.
            while(!stack.isEmpty()) {
                stack.pop();
                sb.append(")");
            }
            res.add(sb.toString());
            return;
        }

        if (!stack.isEmpty()) {
            Stack<Boolean> newStack = (Stack<Boolean>) stack.clone();
            StringBuilder copy = new StringBuilder(sb.toString());

            newStack.pop();
            copy.append(")");
            recursion(n, res, newStack, copy);
        }

        Stack<Boolean> newStack = (Stack<Boolean>) stack.clone();
        StringBuilder copy = new StringBuilder(sb.toString());

        newStack.add(true);
        copy.append("(");
        recursion(n-1, res, newStack, copy);
    }
}
