class Solution {
    public boolean isValid(String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        }
        
        Map<Character, Character> tempMap = new HashMap<>();
        tempMap.put('}', '{');
        tempMap.put(')', '(');
        tempMap.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character pair = tempMap.get(s.charAt(i));
            if (pair == null) {
                stack.addFirst(s.charAt(i));
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            // Validate the pair.
            var stackChar = stack.pop();
            if (stackChar != pair) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
