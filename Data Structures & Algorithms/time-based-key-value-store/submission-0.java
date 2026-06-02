class TimeMap {
    private Map<String, List<Pair<Integer, String>>> storage;

    public TimeMap() {
        storage = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        storage.computeIfAbsent(key, k -> new ArrayList<>());
        Pair<Integer, String> p = new Pair<>(timestamp, value);
        storage.get(key).add(p);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> arr = storage.get(key);
        if (arr == null || arr.size() == 0) return "";

        int l = 0, r = arr.size() - 1;
        Pair<Integer, String> res = null;
        while (l <= r) {
            int mid = (int) Math.ceil((l + r) / 2);
            if (timestamp >= arr.get(mid).getKey()) {
                l = mid + 1;
                if (res == null || res.getKey() < arr.get(mid).getKey()) {
                    res = arr.get(mid);
                }
                continue;
            }
            r = mid - 1;
        }
        return res == null ? "" : res.getValue();
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
