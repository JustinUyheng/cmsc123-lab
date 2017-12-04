import java.util.Stack;

public class Heap implements HeapInterface {
    private int max;
    private int[] array;
    private int size;

    Heap(int maxCapacity){
        this.size = 0;
        this.max  = maxCapacity;
        this.array = new int[this.max];

    /*
        for(int i = 0; i < max; i++){
            this.array[i] = -1;
        }
    */

    }


    public void add(int value){
        if(this.size == this.max){
            System.out.println("The heap is full.");
        }else{
            array[this.size - 1] = value;
            this.size++;
            bubbleUp(this.size - 1);
        }

    }

    //index of ...
    //left child: 2 * i + 1
    //right child: 2 * i + 2
    //parent: (i - 1) / 2

    int parent(int index){
        return (index - 1) / 2;
    }

    int leftChild(int index){
        return 2 * index + 1;
    }

    int rightChild(int index){
        return 2 * index + 2;
    }

    void bubbleUp(int bubble){
        if(parent(bubble) < 0){
            return;
        }

        if(this.array[bubble] >= this.array[parent(bubble)]){
            return;
        }

        int temp;

        if(this.array[bubble] < this.array[parent(bubble)]) {
            temp = this.array[bubble];
            this.array[bubble] = this.array[parent(bubble)];
            this.array[parent(bubble)] = temp;
            bubbleUp(parent(bubble));
        }

    }

    public int remove(){
        if(this.size == 0){
            System.out.println("The heap is empty");
            return -1;
        }

        int removed = this.array[0];

        if (this.size > 1){
            this.array[0] = this.array[size];
            this.size--;

            trickleDown(0);
        }


        return removed;
    }

    void trickleDown(int cursor){
        int temp;

        while(
                (leftChild(cursor) == this.size ||
                rightChild(cursor) == this.size) &&
                (this.array[cursor] > this.array[leftChild(cursor)] &&
                this.array[cursor] > this.array[rightChild(cursor)])
        ){
            if(this.array[leftChild(cursor)] < this.array[rightChild(cursor)]){
                temp = this.array[cursor];
                this.array[cursor] = this.array[leftChild(cursor)];
                this.array[leftChild(cursor)] = temp;
                cursor = leftChild(cursor);
            }else{
                temp = this.array[cursor];
                this.array[cursor] = this.array[rightChild(cursor)];
                this.array[rightChild(cursor)] = temp;
                cursor = rightChild(cursor);
            }
        }
    }

    //visit the root
    //visit the left subtree
    //visit the right subtree
    public void preorder(int index){
        /*int printed = 0;
        int cursor = 0;

        while(cursor < this.size - 1){
            System.out.println(this.array[cursor]);
            printed++;
            cursor = leftChild(cursor);
        }

        while(printed < this.size){
            if(rightChild(cursor) < this.size - 1) {
                System.out.println(this.array[rightChild(cursor)]);
                printed++;
            }
                cursor = parent(cursor);

        }
    */
        if(index > this.size - 1){
            return;
        }

        System.out.println(this.array[index]);
        preorder(leftChild(index));
        preorder(rightChild(index));
    }

    //visit the left subtree
    //visit the root
    //visit the right subtree

    public void inorder(int index){
       /* int cursor = 0;
        int temp = cursor;
        while(temp <= this.size){
            cursor = temp;
            temp = leftChild(temp);

        }
        int i = 0;
        while(i < this.size){
            System.out.println(this.array[cursor]);
            i++;
            if(rightChild(cursor) < this.size){
                System.out.println(this.array[rightChild(cursor)]);
                i++;
            }
            cursor = parent(cursor);
        }
*/

    if(index > this.size - 1){
            return;
        }

    inorder(leftChild(index));
    System.out.println(this.array[index]);
    inorder(rightChild(index));
    }

    //visit the left subtree
    //visit the right subtree
    //visit the root

    public void postorder(int index){
     /*   int cursor = 0;
        int temp = cursor;
        while(temp <= this.size){
            cursor = temp;
            temp = leftChild(temp);

        }

        int i = 0;
        while(i < this.size){
            System.out.println(this.array[cursor]);
            i++;
            cursor = parent(cursor);
            if(rightChild(cursor) < this.size){
                System.out.println(this.array[rightChild(cursor)]);
                i++;
            }
        }
        System.out.println(this.array[cursor]);
        */
        postorder(leftChild(index));
        postorder(rightChild(index));
        System.out.println(this.array[index]);
    }
}

