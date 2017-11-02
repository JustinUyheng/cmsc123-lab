public class Stack {
    private LinkedList listStack;

    public Stack() {
        listStack = new LinkedList();
    }

    public void push(Object item) {
        listStack.add(item, 0);
    }

    public Node pop() {
        return listStack.remove(0);
    }

    public Node peek() {
        return listStack.get(0);
    }

    public boolean isEmpty() {
        if(listStack.size() == 0)
            return true;
        return false;

    }

    public int size() {
        return listStack.size();
    }
}

