
package app;


public class AVLNode<T> {
    T key;
    int height;
    AVLNode<T> left, right;

    AVLNode(T key) {
        this.key = key;
        this.height = 1;
    }
}
