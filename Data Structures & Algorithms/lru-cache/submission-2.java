class LRUCache {
    int capacity = 0;
    Map<Integer, Record> map;
    Record head;
    Record tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Init head and tail.
        this.head = new Record(-1, -1);
        this.tail = new Record(-1, -1);

        head.next = tail;
        tail.prev = head; 
    }
    
    public int get(int key) {
        // Get from map.
        if (!map.containsKey(key)) return -1;
        Record record = map.get(key);

        if (head.next != record) {
            // Remove existing connection.
            record.prev.next = record.next;
            record.next.prev = record.prev;

            // Add new connection.
            head.next.prev = record;
            record.next = head.next;
            head.next = record;
            record.prev = head;
        }
        return record.value;
    }
    
    public void put(int key, int value) {
        // Check if exists.
        Record record = null;
        if (map.containsKey(key)) {
            record = map.get(key);
            // Remove existing connection.
            if (head.next != record) {
                record.prev.next = record.next;
                record.next.prev = record.prev;
            }
            record.value = value;
        }

        // Handle new.
        if (record == null) {
            record = new Record(key, value);
            // Check capacity.
            if (map.size() == capacity) {
                // Get last record.
                var lastRecord = tail.prev;

                // Remove from map.
                map.remove(lastRecord.key);

                // Remove from list.
                lastRecord.prev.next = lastRecord.next;
                lastRecord.next.prev = lastRecord.prev;
            }
        }

        // Add to the front of the list and update the map.
        map.put(key, record);
        
         // Add new connection.
        head.next.prev = record;
        record.next = head.next;
        head.next = record;
        record.prev = head;
    }

    private static class Record {
        int key;
        int value;
        Record prev;
        Record next;

        public Record(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
