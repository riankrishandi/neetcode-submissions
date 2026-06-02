class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (var str : strs) {
            int[] arr = new int[26]; 
            for (var c : str.toCharArray()) {
                int arrIdx = c - 'a';
                arr[arrIdx]++;
            }

            // Aggregate to the group.
            String key = Arrays.toString(arr);
            group.computeIfAbsent(key, (k) -> new ArrayList<>());
            group.get(key).add(str);
        }

        // Return result.
        return group.values().stream().collect(Collectors.toList());
    }
}
