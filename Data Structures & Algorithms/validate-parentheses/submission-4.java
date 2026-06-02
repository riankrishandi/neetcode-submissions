class Solution {
    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.add(s.charAt(i));
                continue;
            }

            if (stack.isEmpty()) return false;
            
            Character c = stack.pop();
            if (c != map.get(s.charAt(i))) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
