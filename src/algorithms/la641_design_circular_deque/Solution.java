package algorithms.la641_design_circular_deque;

/**
 * source: https://leetcode-cn.com/problems/design-circular-deque/
 * date: 2019-08-08
 */
class MyCircularDeque {

    private int[] items;
    private int n = 0;
    private int head;
    private int tail;
    private int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        items = new int[k];
        n = k;
        head = 0;
        tail = n - 1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        // is full
        if (size == n) return false;
        if (head >= 1) {
            head = (head - 1) % n;
        } else {
            head = n - 1;
        }
        items[head] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == n) return false;
        tail = (tail + 1) % n;
        items[tail] = value;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        // is empty
        if (size == 0) return false;
        head = (head + 1) % n;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) return false;
        if (tail >= 1) {
            tail = (tail - 1) % n;
        } else {
            tail = n - 1;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) return -1;
        return items[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) return -1;
        return items[tail];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == n;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
