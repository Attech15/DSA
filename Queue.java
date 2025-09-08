public class Queue{

    private int[] data;

    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public Queue(){
        this(DEFAULT_SIZE);
    }

    public Queue(int size){
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) {
        if(isFull()) return false;
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()) throw new Exception("Queue is empty");
        int rem = data[0];

        // shirft the elements to left
        for(int i = 0; i < end - 1; i++) {
            data[i] = data[i + 1];
        }
        end--;
        return rem;
    }

    public int front() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        queue.display();
        System.out.println(queue.front());
        System.out.println(queue.remove());
        queue.display();
    }
}