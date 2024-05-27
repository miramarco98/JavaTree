
public class Node {
    String name;
    Node parent;
    Node firstChild;
    Node nextSibling;

    // Constructor
    public Node(String name) {
        this.name = name;
        this.parent = null;
        this.firstChild = null;
        this.nextSibling = null;
    }
}
