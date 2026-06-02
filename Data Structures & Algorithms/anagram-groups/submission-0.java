class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> tempMap = new HashMap<>();
        for (var str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                arr[idx]++;
            }
            String key = Arrays.toString(arr);
            tempMap.computeIfAbsent(key, k -> new ArrayList<>());
            tempMap.get(key).add(str);
        }
        return new ArrayList<>(tempMap.values());
    }
}
