package redblacktree;

public class Node<K, V> {
	
    K key;
    V value;
    Color color;
    Node<K, V> left, right, parent;

    public Node(K key, V value, Color color, Node<K, V> parent) {
        this.key = key;
        this.value = value;
        this.color = color;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}