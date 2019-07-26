package collections;

import java.util.Objects;

public class SimpleTree<E> {

    private transient Node<E> root;

    private int size;

    private int modCount;

    public void add(E value) {

        Objects.requireNonNull(value, "null values are not allowed");

        if (root == null) {
            root = new Node<>(value, null);
            size++;
            modCount++;
        } else add(value, root);

    }

    public boolean contains(E obj){
        if (Objects.isNull(obj)) {
            return false;
        }
        return contains(obj, root);
    }

    @SuppressWarnings("unchecked")
    private boolean contains(E obj, Node<E> node) {
        if (node == null) {
            return false;
        }
        Comparable<E> comp = (Comparable<E>) obj;

        System.out.println("Visited node: " + node);

        int cmp = comp.compareTo(node.value);

        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return contains(obj, node.left);
        }
        return contains(obj, node.right);
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void add(E val, Node<E> node) {

        Comparable<E> comp = (Comparable<E>) val;

        int cmp = comp.compareTo(node.value);

        if ( cmp > 0) {

            if (node.right == null) {
                node.right = new Node<>(val, node);
                size++;
                modCount++;
                return;
            }

            //Recursively adding element to the right branch
            add(val, node.right);

        } else if (cmp < 0) {

            if (node.left == null){
                node.left = new Node<>(val, node);
                node.left.parent = node;
                size++;
                modCount++;
                return;
            }

            //Recursively adding element to the left branch
            add(val, node.left);
        }

    }

    private Node<E> rotateLeft(Node<E> node) {

        //Link to parent
        Node<E> tmp = node.right;

        //Left child of parent now right child of grand parent
        node.right = tmp.left;
        tmp.left.parent = node;

        //Grand parent now left child of parent
        tmp.left = node;

        tmp.parent = node.parent;
        node.parent = tmp;

        return tmp;
    }

    private Node<E> rotateRight(Node<E> node) {

        //Link to parent
        Node<E> tmp = node.left;

        //Right child of parent now left child of grand parent
        node.left = tmp.right;
        tmp.right.parent = node;

        //Grand parent now right child of parent
        tmp.right = node;

        tmp.parent = node.parent;
        node.parent = tmp;

        return tmp;
    }

    private Node<E> rotateLeftRight(Node<E> node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private Node<E> rotateRightLeft(Node<E> node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }


    public void traverseTree() {
        visit(root);
    }

    //This is In Order Traversal visiting
    private void visit(Node<E> node) {


        if (node == null) {
            return;
        }

        visit(node.left);

        System.out.println("Visited: " + node.value);

        visit(node.right);

    }


    private static class Node<E> {

        E value;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
        }

        Node(E value, Node<E> parent) {
            this.value = value;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", parent=" + parent +
                    '}';
        }
    }
}
