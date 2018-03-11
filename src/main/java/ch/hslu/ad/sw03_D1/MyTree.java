package ch.hslu.ad.sw03_D1;

import org.apache.logging.log4j.LogManager;

import java.util.NoSuchElementException;

public class MyTree<T extends Comparable<T>> implements Tree<T>{
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(MyTree.class);
    private Node<T> root;
    private int size;

    public MyTree() {
        this.size = 0;
    }

    @Override
    public T search(T data) {
        if (isEmpty()){
            throw new NoSuchElementException();
        } else {
            return searchRec(root, data);
        }
    }

    private T searchRec(Node<T> node, T data){
        if (node == null) {
            throw new NoSuchElementException();
        }
        if (data.compareTo(node.getData()) == 0){
            return node.getData();
        } else if (data.compareTo(node.getData()) < 0 ){
           return searchRec(node.getLeftChildNode(), data);
        } else { //grösser
           return searchRec(node.getRightChildNode(), data);
        }
    }

    @Override
    public void remove(T data) {
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            removeRec(root, data);
        }
    }

    private Node<T> removeRec(Node<T> node, T data){
        if (node == null) {
            throw new NoSuchElementException();
        }

        if (data.compareTo(node.getData()) < 0 ){
            node.leftChildNode = removeRec(node.getLeftChildNode(), data);
        } else if(data.compareTo(node.getData()) > 0) {
            node.rightChildNode = removeRec(node.getRightChildNode(), data);
        } else {
            if (node.getLeftChildNode() == null && node.getRightChildNode() == null){
                return null;
            }
            if (node.getLeftChildNode() == null) {
                return node.getRightChildNode();
            }
            if (node.getRightChildNode() == null) {
                return node.getLeftChildNode();
            }
            T smallestNodeRightSide = findSmallestNodeRightSide(node.getRightChildNode());
            node.data = smallestNodeRightSide;
            node.rightChildNode = removeRec(node.getRightChildNode(), smallestNodeRightSide);
        }
        return node;
    }

    private T findSmallestNodeRightSide(Node<T> node){
        if (node.getLeftChildNode() == null) {
            return node.getData();
        } else {
           return findSmallestNodeRightSide(node.getLeftChildNode());
        }
    }

    @Override
    public void add(T data) {
        Node newNode = new Node(data);

        if (isEmpty()){
            root = newNode;
            size++;
        }else{
            addRec(root, newNode);
        }
    }

    private void addRec(Node<T> node, Node<T> newNode) {
        if (newNode.getData().compareTo(node.getData()) == 0){
            throw new DuplicateElementException("Element already exists");
        } else if (newNode.getData().compareTo(node.getData()) < 0){
            if (node.getLeftChildNode() == null) {
                node.setLeftChildNode(newNode);
                size ++;
            } else {
                addRec(node.getLeftChildNode(), newNode);
            }
        } else if (newNode.getData().compareTo(node.getData()) > 0){
            if (node.getRightChildNode() == null) {
                node.setRightChildNode(newNode);
                size ++;
            } else {
                addRec(node.getRightChildNode(), newNode);
            }
        }
    }


    @Override
    public void inOrderTraversal(Node node) {
        if (node == null){
            return;
        }
        inOrderTraversal(node.getLeftChildNode());
        LOG.info(node.toString());
        inOrderTraversal(node.getRightChildNode());
    }

    @Override
    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        LOG.info(node.toString());
        preOrderTraversal(node.getLeftChildNode());
        preOrderTraversal(node.getRightChildNode());
    }

    @Override
    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.getLeftChildNode());
        postOrderTraversal(node.getRightChildNode());
        LOG.info(node.toString());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
