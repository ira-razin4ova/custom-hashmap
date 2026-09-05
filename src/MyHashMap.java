import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private Node<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int indexBucket = indexBucket(key);
        if (buckets[indexBucket] == null) {
            buckets[indexBucket] = createNode(key, value);
            size++;
        } else {
            Node<K, V> prev = null;
            for (
                    Node<K, V> current = buckets[indexBucket]; current != null; current = current.next) {
                prev = current;
                if (current.key.equals(key)) {
                    current.value = value;
                    return;

                }
            }

            Node<K, V> node = createNode(key, value);
            prev.next = node;
            size++;
        }

    }

    private Node createNode(K key, V value) {
        return new Node<K, V>(key, value, null);
    }

    private int indexBucket(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        return Math.abs(key.hashCode() % buckets.length);
    }

    public void remove(K key) {
        int indexBucket = indexBucket(key);
        int keyHash = key.hashCode();
        Node<K, V> prev = null;

        for (Node<K, V> current = buckets[indexBucket]; current != null; current = current.next) {

            if (keyHash == current.hash && current.key.equals(key)) {
                if (prev == null) {
                    buckets[indexBucket] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
        }
    }

    public V getValue(K key) {

        int keyHash = key.hashCode();
        int indexBucket = indexBucket(key);

        for (Node<K, V> current = buckets[indexBucket]; current != null; current = current.next) {
            if (keyHash == current.hash && current.key.equals(key)) {
                return current.value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public Set<String> getFormattedEntries() {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < buckets.length; i++) {
            Node<K, V> current = buckets[i];
            while (current != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("key = ").append(current.key).append(" - value = ").append(current.value);
                result.add(sb.toString());
                current = current.next;
            }
        }
        return result;
    }
}

