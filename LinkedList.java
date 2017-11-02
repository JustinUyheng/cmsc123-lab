public class LinkedList<E> implements Collection {


    Node head = null;
    private int size = 0;

    LinkedList(){}

    //add accepts an item of type E and an index of type int and should add the item at the given index
    public void add(E item, int index){

        if(index == 0 || this.size == 0){
            Node newNode = new Node(item, this.head);
            this.head = newNode;
            this.size++;

        } else if(index == this.size){
            Node current = this.head;
            while(current.next != null){
                current = current.next;
            }

            current.next = new Node(item, null);

            this.size++;

        } else {
            Node previous = this.head;
            Node current = this.head.next;

            int cursor = 1;

            while(current != null){
                if(cursor == index){

                    current = new Node(item, current);
                    previous.next = current;

                    this.size++;

                }

                previous = previous.next;
                current = current.next;

                cursor++;
            }
        }
    }

    //remove accepts an index of type int and it should remove the item at the given index
    public Node remove(int index){

        if (this.size == 0) {
            System.out.println("The list is empty.");
        }

        //traverse to find item
        //reference of previous node
        Node previous = this.head;
        Node current = this.head.next;

        int cursor = 0;

        while(current != null){
            if(cursor == index){

                previous.next = current.next;
                current.next = null;

                this.size--;
                return current;
            }

            previous = previous.next;
            current = current.next;

            cursor++;
        }

    }

    public Node get(int index){

        if (this.size == 0) {
            System.out.println("The list is empty.");
        }

        //traverse to find item
        //reference of previous node
        Node previous = this.head;
        Node current = this.head.next;

        int cursor = 0;

        while(current != null){
            if(cursor == index){

                return current;
            }

            previous = previous.next;
            current = current.next;

            cursor++;
        }

    }

    //size should return the size of the list
    public int size(){
        return this.size;
    }

    //iterator should return an instance of the LinkedListIterator
    public Iterator iterator(){
        return new LinkedListIterator();
    }
}




class Node<E> {

    private E data;
    Node next;

    Node(E data, Node next) {
        this.data = data;
        this.next = next;
    }

    public E getData(){
        return this.data;
    }

}