import java.util.LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }
    // insert before the head of linkedList;
    public void insertlist(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        
        if(tail == null){
            tail = head;
        }
        size+=1;
    }
    public void insertLast(int val){
        if(tail == null){
            insertlist(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val,int index){
        if(index == 0){
            insertlist(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }
    //insert using recursion
    public void insertRec(int val, int index){
        head = insertRec(val,index,head);
    }
    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index - 1, node.next);
        return node;
    }
    public int deletelist(){
        int x = head.value;
        head = head.next;
        if(head == null) tail = null;
        size--;
        return x;
    }

    public int deleteLast(){
        if(size <= 1){
            return deletelist();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }
    public int delete(int index){
        if(index == 0) return deletelist();
        if(index == size - 1) return deleteLast();
        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }
    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value) return node;
            node = node.next;
        }
        return null;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);
        list.insertLast(8);

        list.display();
        list.delete(3);
        list.insert(10,2);
        list.display();

    }
}
