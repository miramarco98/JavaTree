public class FileSystem {
    Node root;

    public FileSystem() {
        root = null;
    }

    // Funzione di ricerca
    private Node searchNode(Node root, String name) {
        if (root == null) {
            return null;
        }
        if (root.name.equals(name)) {
            return root;
        }
        Node res = searchNode(root.firstChild, name);
        if (res != null) {
            return res;
        }
        return searchNode(root.nextSibling, name);
    }

    // Inserimento di file/directory
    public void insert(String parentName, String name) {
        if (root == null) {
            root = new Node(name);
        }
        else {
            Node parentNode = searchNode(root, parentName);
            if (parentNode != null) {
                Node newNode = new Node(name);
                newNode.parent = parentNode;
                if (parentNode.firstChild == null)
                {
                    parentNode.firstChild = newNode;
                }
                else
                {
                    Node current = parentNode.firstChild;
                    while (current.nextSibling != null) {
                        current = current.nextSibling;
                    }
                    current.nextSibling = newNode;
                }
            }
            else {
                System.out.println("Parent folder '" + parentName + "' not found.");
            }
        }
    }

    // Metodo ricerca
    public boolean search(String name) {
        return searchNode(root, name) != null;
    }

    // Stampa del file system in ordine
    public void printInOrder() {
        printInOrderRec(root, 0);
    }

    // Funzione ricorsiva di stampa
    private void printInOrderRec(Node root, int level) {
        if (root != null) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(root.name);
            printInOrderRec(root.firstChild, level + 1);
            printInOrderRec(root.nextSibling, level);
        }
    }
}
