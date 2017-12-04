/*
void add(int value) - inserts the value into the heap
int remove() - removes the smallest value in the help and returns it
void preorder() - prints the values in preorder traversal
void inorder() - prints the values in inorder traversal
void postorder() - prints the values in postorder traversal

 */
public interface HeapInterface {
    void add(int value);
    int remove();
    void preorder();
    void inorder();
    void postorder();
}
