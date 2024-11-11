package redblacktree;

public class RedBlackTree<K, V> {
    private Node<K, V> root;
    private Node<K, V> TNULL;

    // Constructor to initialize the Red-Black Tree with a TNULL Node<K, V>
    public RedBlackTree() {
        TNULL = new Node<>(null, null, Color.BLACK, null);
        root = TNULL;
    }

    // Helper function to perform left rotation
    private void leftRotate(Node<K, V> x) {
        Node<K, V> y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node<K, V> y) {
        Node<K, V> x = y.left;
        y.left = x.right;
        if (x.right != TNULL) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }

    public void insert(int key, Object value) {
        Node<K, V> node = new Node<K, V>(key, value, Color.RED, null);
        node.left = TNULL;
        node.right = TNULL;

        Node<K, V> y = null;
        Node<K, V> x = root;

        while (x != TNULL) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        Node<K, V>.parent = y;
        if (y == null) {
            root = Node<K, V>;
        } else if (Node<K, V>.key < y.key) {
            y.left = Node<K, V>;
        } else {
            y.right = Node<K, V>;
        }

        // Fix any Red-Black Tree property violations
        fixInsert(Node<K, V>);
    }

    // Fixing the tree after insertion to maintain Red-Black properties
    private void fixInsert(Node<K, V> k) {
        while (k.parent != null && k.parent.color == Color.RED) {
            if (k.parent == k.parent.parent.left) {
                Node<K, V> u = k.parent.parent.right; // Uncle Node<K, V>
                if (u.color == Color.RED) {
                    u.color = Color.BLACK;
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    rightRotate(k.parent.parent);
                }
            } else {
                Node<K, V> u = k.parent.parent.left;
                if (u.color == Color.RED) {
                    u.color = Color.BLACK;
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    leftRotate(k.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }
}
