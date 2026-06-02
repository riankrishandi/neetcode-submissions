class Solution {
    private static final Map<Character, Character> map = new HashMap<>(){{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};

    private Deque<Character> stack = new ArrayDeque<>();

    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.isEmpty()) return false;
            Character c = stack.pop();
            if (c == null || map.get(c) == null || !map.get(c).equals(s.charAt(i))) return false;
        }
        return stack.isEmpty();
    }
}
