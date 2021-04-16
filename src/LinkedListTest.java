public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList arr = new MyLinkedList(7);
        arr.add(9);
        arr.add(12);
        arr.add(45);
        arr.add(12);
        arr.add(12);
        arr.clear();
        System.out.println(arr.get(0));
    }


}
