class TimeMap {
    private Map<String, List<Pair<Integer, String>>> storage;

    public TimeMap() {
        this.storage = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        storage.computeIfAbsent(key, k -> new ArrayList<>());
        storage.get(key).add(new Pair<Integer, String>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // Get list.
        List<Pair<Integer, String>> list = storage.get(key);
        if (list == null || list.isEmpty()) return "";

        // Use BST to search the value;
        String value = "";
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (timestamp >= list.get(mid).getKey()) {
                value = list.get(mid).getValue();
                l = mid + 1;
                continue;
            }
            r = mid - 1;
        }
        return value;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
