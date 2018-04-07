package ch.hslu.ad.sw03_D2.Hashcode;

import ch.hslu.ad.sw03_D2.DuplicateElementException;
import org.apache.logging.log4j.LogManager;

import java.util.NoSuchElementException;

public class MyHashTree<K extends Comparable,V> implements Tree<K,V>{
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(MyHashTree.class);
    private Node<K,V> root;
    private int size;

    public MyHashTree() {
        this.size = 0;
    }

    @Override
    public V search(K key) {
        if (isEmpty()){
            throw new NoSuchElementException();
        } else {
            return searchRec(root, key);
        }
    }

    private V searchRec(Node<K,V> node, K key) {
        if (node == null) {
            throw new NoSuchElementException();
        }
        if (key.compareTo(node.getKey()) == 0){
            return node.getData();
        } else if (key.compareTo(node.getKey()) < 0 ){
            return searchRec(node.getLeftChildNode(), key);
        } else { //grösser
            return searchRec(node.getRightChildNode(), key);
        }
    }

    @Override
    public void remove(K key) {
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            removeRec(root, key);
        }
        size--;
    }

    private Node<K, V> removeRec(Node<K,V> node, K key){
        if (node == null) {
            throw new NoSuchElementException();
        }
        if (key.compareTo(node.getKey()) < 0 ){
            node.leftChildNode = removeRec(node.getLeftChildNode(), key);
        } else if(key.compareTo(node.getKey()) > 0) {
            node.rightChildNode = removeRec(node.getRightChildNode(), key);
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
            Node<K, V> smallestNodeRightSide = findSmallestNodeRightSide(node.getRightChildNode());
            node.data = smallestNodeRightSide.getData();
            node.rightChildNode = removeRec(node.getRightChildNode(), smallestNodeRightSide.getKey());
        }
        return node;
    }

    private Node<K, V> findSmallestNodeRightSide(Node<K, V> node){
        if (node.getLeftChildNode() == null) {
            return node;
        } else {
            return findSmallestNodeRightSide(node.getLeftChildNode());
        }
    }

    @Override
    public void add(K key, V data) {
        Node newNode = new Node(key, data);

        if (isEmpty()){
            root = newNode;
        }else{
            addRec(root, newNode);
        }
        size++;
    }

    private void addRec(Node<K,V> node, Node<K,V> newNode) {
        if (newNode.getKey().compareTo(node.getKey()) == 0){
            throw new DuplicateElementException("Element already exists");
        } else if (newNode.getKey().compareTo(node.getKey()) < 0){
            if (node.getLeftChildNode() == null) {
                node.setLeftChildNode(newNode);
            } else {
                addRec(node.getLeftChildNode(), newNode);
            }
        } else if (newNode.getKey().compareTo(node.getKey()) > 0){
            if (node.getRightChildNode() == null) {
                node.setRightChildNode(newNode);
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

    public Node<K,V> getRoot() {
        return root;
    }

    public void setRoot(Node<K,V> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
