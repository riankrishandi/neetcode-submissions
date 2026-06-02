class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (var str : strs) {
            int[] arr = new int[26];
            for (var c : str.toCharArray()) {
                arr[c - 'a']++;
            }
            String key = Arrays.toString(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.getOrDefault(key, new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
