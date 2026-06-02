class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (var str : strs) {
            // Get key.
            int[] arr = new int[26];
            for (var c : str.toCharArray()) {
                int idx = c - 'a';
                arr[idx]++;
            }
            String key = Arrays.toString(arr);

            // Init list.
            map.computeIfAbsent(key, k -> new ArrayList<>());
            // Put into a map.
            map.get(key).add(str);
        }

        // Return map.
        return new ArrayList<>(map.values());
    }
}
