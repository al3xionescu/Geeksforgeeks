/*
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as 
previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. 
The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
*/

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}
public class BinaryTree {
    Node root;
    Node head;
    static Node prev = null;
    void bToDLL(Node root) {
        if (root == null) {
            return;
        }
        bToDLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        bToDLL(root.right);
    }
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(7);
        tree.root.left = new Node(12); 
        tree.root.right = new Node(17); 
        tree.root.left.left = new Node(23); 
        tree.root.left.right = new Node(30); 
        tree.root.right.left = new Node(33);
        tree.bToDLL(tree.root);
        tree.printList(tree.head);
    }
}
