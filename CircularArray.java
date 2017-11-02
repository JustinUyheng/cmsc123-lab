public class CircularArray {
    private int[] array;
    private int front;
    private int rear;
    private int max;

    public CircularArray(int initialSize){
        max = initialSize;
        array = new int[max];
        front = rear = 0;
    }

    private void expand() {
        int x = size();
        max = max * 2;
        int end = x + 1;
        int[] newArray = new int[max];
        int i = 0;

        while (x > 0) {
            x--;
            newArray[i++] = array[front++];

            if(front == end) {
                front = 0;
            }
        }
    }

    public void enqueue(int item) {
        int x = size();
        if (x == max - 1) {
            expand();
        }

        array[rear++] = item;
        if(rear == max) {
            rear = 0;
        }

    }

    public Integer dequeue() {
        if(isEmpty()) {
            return null;
        }

        int x = array[front++];
        if(front == max) {
            front = 0;
        }

        return x;
    }

    public int size() {
        return (max - front + rear) % max;
    }

    public boolean isEmpty() {
        return front == rear;
    }
}
