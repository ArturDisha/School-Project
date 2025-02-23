public class LeakyStack<T> {
    private Object[] array;
    private int capacity;
    private int size;
    private int top; 
    public LeakyStack(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
        this.top = 0;
    }
    
    public void push(T item) {
        if (size < capacity) {
            size++;
        } else {
            
            top = (top + 1) % capacity;
        }
        
        array[top] = item;
        top = (top + 1) % capacity;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        
        top = (top - 1 + capacity) % capacity;
        size--;
        return (T) array[top];
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        
        int index = (top - 1 + capacity) % capacity;
        return (T) array[index];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        LeakyStack<Integer> stack = new LeakyStack<>(3);
        stack.push(3);
        stack.push(42);
        stack.push(53);
        
        System.out.println("Top element: " + stack.peek()); 
        
        stack.push(34);
        
        System.out.println("Top element after pushing 4: " + stack.peek()); 
        
        stack.pop();
        
        System.out.println("Top element after popping: " + stack.peek()); 
    }
}
