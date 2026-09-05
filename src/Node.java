import java.util.Objects;

public class Node<K, V> {

    final int hash;
    final K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value, Node<K,V> next) {
        this.hash = key.hashCode();
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return hash == node.hash && Objects.equals(key, node.key) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, key, value);
    }
}
