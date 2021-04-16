import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MyLinkedList<E> {
    private  Node head;
    private  int numNodes;
    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }
    private class Node {
        private Node next;
        private Object data;
        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return this.data;
        }
    }
    public void add(int index, E element) {
        if (index == 0) addFirst(element);
        else if (index >= numNodes) addLast(element);
        else {
            Node current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node temp = current.next;
            current.next = new Node(element);
            (current.next).next = temp;
            numNodes++;
        }
    }
    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }
    public void addLast(E e) {
        Node temp = head;
        if (numNodes<=1) {
            head = new Node(e);
        }else {
            for (int i=1;i<numNodes;i++){
                temp=temp.next;
            }
            temp.next = new Node(e);
        }
        numNodes++;
    }
    public E remove(int index){
        Node current;
        Node temp;
        if (index < 0 || index >= numNodes) return null;
        else if (index == 0){
            if (numNodes == 0) ensureCapacity(index++);
                current = head;
                head = head.next;
                numNodes--;
                if (numNodes == 0) head = null;
                return (E) current.data;
        }
        else if (index == numNodes - 1) {
            temp = head;
            for (int i=1; i<numNodes-1;i++){
                temp = temp.next;
            }
            current = temp.next.next;
            numNodes--;
            return (E) current.data;
        }
        else {
            temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }

            current = temp.next;
            temp.next = current.next;
            numNodes--;
            return (E) current.data;
        }
    }
    public int size(){
        return numNodes;
    }
    public MyLinkedList<E> clone(){
        return this;
    }
    public boolean contains(E o){
        Node current = head;
        for (int i = 0; i < numNodes - 1; i++) {
            if (current.data == o){
                return true;
            }else {
                current = current.next;
            }
        }
        if (current.data == o){
            return true;
        }
        return false;
    }
    public int indexOf(E o){
        Node current = head;
        for (int i=0;i<numNodes-1;i++){
            if (current.data == o){
                return i;
            }else {
                current = current.next;
            }
        }
        if (current.data == o){
            return numNodes-1;
        }
        return -1;
    }
    public boolean add(E e){
        Node current = head;
        for (int i=1;i<numNodes;i++){
            current = current.next;
        }
        current.next = new Node(e);
        numNodes++;
        return true;
    }
    private void ensureCapacity(int minCapacity) {
        if (numNodes < minCapacity) {
            numNodes = minCapacity;
        }
    }
    public E get(int i){
        if (i < 0 || i >= numNodes) return null;
        else if (i==0){
            return getFirst();
        }else if (i==numNodes-1){
            return getLast();
        }else {
            Node temp=head;
            for(int j=0; j<i; j++) {
                temp = temp.next;
            }
            return (E) temp.data;
        }
    }
    public E getFirst(){
        return (E) head.data;
    }
    public E getLast(){
        Node temp=head;
        for(int i=1; i<numNodes; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }
    public void clear(){
        numNodes = 0;
    }
}
