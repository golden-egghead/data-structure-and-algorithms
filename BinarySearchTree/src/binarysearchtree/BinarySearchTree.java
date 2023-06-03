
/**
 * Java program to demonstrate
 * basic operations in a Binary Search Tree (BST)
 * @author vinhvo
*/
import java.io.*;
import java.util.*;

class BinarySearchTree<E extends Comparable<E>> {

    // ------------------- nested Node class -----------------------
    protected static class Node<E> {
        private E element; // an element stored at this node
        // private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child (if any)
        private Node<E> right; // a reference to the right child (if any)

        /**
         * Constructors build a node with the given element and its children.
         *
         * @param e          the real data that each node stores
         * @param leftChild  left child of the current node
         * @param rightChild right child of the current node
         */
        public Node(E e, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            // parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public Node(E e) {
            this.element = e;
            // parent = above;
            this.left = null;
            this.right = null;
        }

        // getter, setter methods
        public E getElement() {
            return this.element;
        }

        /*
         * This method will be used later
         * public Node<E> getParent() {
         * return this.parent;
         * }
         */

        public Node<E> getLeft() {
            return this.left;
        }

        public Node<E> getRight() {
            return this.right;
        }

        // update methods
        public void setElement(E e) {
            this.element = e;
        }

        /*
         * This method will be used later
         * public void setParent(Node<E> parentNode) {
         * parent = parentNode;
         * }
         */

        public void setLeft(Node<E> leftChild) {
            this.left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            this.right = rightChild;
        }
    } // --------------- end of nested Node class -----------------

    // Root of BST
    /**
     * Each object belongs to BST has one root node
     */
    private Node<E> root;

    public Node<E> getRoot() {
        return this.root;
    }

    // Constructor
    BinarySearchTree() {
        this.root = null;
    }

    BinarySearchTree(E e) {
        this.root.setElement(e);
    }

    /**
     * Insert a node into the binary search tree
     * 
     * @param data data of type E that implements the Comparable interface
     * @return void
     */
    public void insert(E data) {
        this.root = insertRec(this.root, data);
    }

    /**
     * A recursive function to insert a new node with data (e) into BST
     * 
     * @param root : the root of the current sub-tree
     * @param e:   data field
     * @return root node of the tree after insertion
     */
    private Node<E> insertRec(Node<E> root, E data) {
        /* If the tree is empty, then return a new node */
        if (root == null) {
            return new Node<E>(data);
        }
        /**
         * If the value of the data being inserted is less than the value of the current
         * root node,
         * then traverse to the left node of the current root,
         * and set the current left node to whatever gets returned from the insert
         * method
         */
        else if (data.compareTo(root.getElement()) < 0) {
            // Write your code here, it should be:
            root.left = insertRec(root.left, data);
        }
        /**
         * If the value of the data being inserted is less than the value of the current
         * root node,,
         * then traverse to the right node of the current root,,
         * and set the current right node to whatever gets returned from the insert
         * method
         */
        else if (data.compareTo(root.getElement()) > 0) {

            // Write your code here, it should be:
            root.right = insertRec(root.right, data);
        } else {
            // This is emply to explicitly state that we do NOT
            // allow insert duplicate values into the tree.
            ;
        }
        /* return the (unchanged) node pointer */
        return root;
    }

    /**
     * This method finds the maximum value in the tree
     * 
     * @param root root node of the current subtree
     * @return maximum value in the tree
     */
    private E findMax(Node<E> root) {
        if (root == null)
            return null;

        while (root.getRight() != null) {
            root = root.getRight();
        }

        return root.getElement();
    }

    private E findMin(Node<E> root) {
        if (root == null)
            return null;

        while (root.getLeft() != null) {
            root = root.getLeft();
        }

        return root.getElement();
    }

    public boolean contains(E data) {
        return contains(this.root, data);
    }

    private boolean contains(Node<E> root, E data) {
        if (root == null) {
            return false;
        }

        else if (data.compareTo(root.getElement()) < 0) {
            // Write your code here, it should be:
            contains(root.left, data);

            return false;
        }
        // if the data being searched for is greater than the value of the current
        // root's data,
        // then we check if the data exists in the current root's right sub-tree
        else if (data.compareTo(root.getElement()) > 0) {
            // Write your code here, it should be:
            contains(root.right, data);
            return false;
        }
        // if the data being searched for is equal to the value of the current root's
        // data, then
        // the search was successful and the method should return true
        else {
            return true;
        }
    }

    /**
     * DFS to print the values stored in the BST via in-Order traversal
     * 
     * @param void
     * @return void
     */
    public void inorder() {
        System.out.print("In-order Traversal:");
        inorder(root);
        System.out.println();
    }

    // Sequence to be printed: Left, Node, Right
    // Traverses left as far as possible until a null node is reached,
    // then prints the root node and
    // then goes as far right as possible until a null node is reached.
    private void inorder(Node<E> root) {
        if (root == null)
            return;

        inorder(root.getLeft());
        System.out.print(" " + root.getElement().toString());
        inorder(root.getRight());
    }

    /**
     * DFS to print the values stored in the BST via pre-Order traversal
     * 
     * @param void
     * @return void
     */
    public void preorder() {
        System.out.print("Pre-order Traversal:");
        preorder(root);
        System.out.println();
    }

    // Sequence to be printed: Node, Left, Right
    // Prints the root node, then traverses left as far as possible until a null
    // node is reached,
    // then goes as far right as possible until a null node is reached.
    private void preorder(Node<E> root) {
        if (root == null)
            return;

        System.out.print(" " + root.getElement().toString());
        preorder(root.getLeft());
        preorder(root.getRight());
    }

    public void postorder() {
        System.out.print("Post-order Traversal:");
        postorder(root);
        System.out.println();
    }
    private void postorder(Node<E> root) {
        if (root == null)
            return;

        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(" " + root.getElement().toString());
    }

    public Node<E> deleteNode(Node<E> root, E data) {
        if (root == null)
            return root;
        if (data.compareTo(root.element) < 0)
            root.left = deleteNode(root.left, data);
        else if (data.compareTo(root.element) > 0)
            root.right = deleteNode(root.right, data);
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            E successor = findMin(root.right);
            root.element = successor;
            root.right = deleteNode(root.right, successor);
        }
        return root;
    }

    void printLevelOrder() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }

    public int height(Node<E> root) {
        if (root == null)
            return 0;
        else {
            /* compute height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    /* Print nodes at the current level */
    void printCurrentLevel(Node<E> root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.element + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public int calLeaf() {
        return calLeaf(root);
    }
    private int calLeaf(Node<E> root) {
        int result = 0;
        if (root == null)
            return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        result += calLeaf(root.getLeft());
        result += calLeaf(root.getRight());
        return result;
    }
    // Test the class's methods
    public static void main(String[] args) {
        BinarySearchTree<Integer> i_tree = new BinarySearchTree<Integer>();

        i_tree.insert(5);
        i_tree.insert(3);
        i_tree.insert(2);
        i_tree.insert(4);
        i_tree.insert(9);
        i_tree.insert(6);
        i_tree.insert(10);
        i_tree.insert(1);
        i_tree.insert(7);
        
        System.out.println("Number of leaf is: " + i_tree.calLeaf());

        System.out.println("Height of tree is: " + i_tree.height(i_tree.root));

        i_tree.deleteNode(i_tree.getRoot(), 10);

        System.out.print("Bread first traversal: ");
        i_tree.printLevelOrder();
        System.out.println();

        i_tree.inorder();

        i_tree.preorder();

        i_tree.postorder();

        System.out.println("Maximum values in BST = " + i_tree.findMax(i_tree.getRoot()));
        System.out.println("Minimum values in BST = " + i_tree.findMin(i_tree.getRoot()) + "\n");

        BinarySearchTree<String> s_tree = new BinarySearchTree<String>();

        s_tree.insert("m");
        s_tree.insert("d");
        s_tree.insert("c");
        s_tree.insert("b");
        s_tree.insert("g");
        s_tree.insert("r");
        s_tree.insert("o");
        s_tree.insert("t");
        s_tree.insert("q");

        System.out.println("Number of leaf is: " + s_tree.calLeaf());

        System.out.println("Height of tree is: " + s_tree.height(s_tree.root));

        s_tree.deleteNode(s_tree.getRoot(), "o");

        System.out.print("Bread first traversal");
        s_tree.printLevelOrder();
        System.out.println();

        s_tree.inorder();

        s_tree.preorder();

        s_tree.postorder();

        System.out.println("Maximum values in BST = " + s_tree.findMax(s_tree.getRoot()));
        System.out.println("Minimum values in BST = " + s_tree.findMin(s_tree.getRoot()));
    }
}
