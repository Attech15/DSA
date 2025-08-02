public class Stack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = - 1;

    public Stack(){
        this(DEFAULT_SIZE);
    }

    public Stack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }
    
    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot pop from the an empty stack!");
        }
        // int rem = data[ptr];
        // ptr--;
        // return removed
        return data[ptr--];
    }

    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot peek from an empty stack!");
        }
        return data[ptr];
    }

    public boolean isFull(){
        return ptr == data.length - 1;// ptr is at last index
    }
    public boolean isEmpty(){
        return ptr == -1;
    }

    public static void main(String[] args) throws StackException {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(0);
        stack.push(4);
        stack.push(8);
        stack.push(54);
        stack.push(66);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
