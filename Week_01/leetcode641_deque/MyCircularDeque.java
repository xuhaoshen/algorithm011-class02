package leetcode641_deque;

public class MyCircularDeque {

    int[] arr;
    int head = 0;
    int rear = 0;
    int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(arr.length == size) return false;
        if(head == 0) {
            head = arr.length - 1;
        } else {
            head--;
        }
        arr[head] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(arr.length == size) return false;
        arr[rear] = value;
        if(rear == arr.length - 1) {
            rear = 0;
        } else {
            rear++;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0) return false;
        head = head == arr.length - 1 ? 0 : head + 1;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0) return false;
        if(rear == 0) {
            rear = arr.length - 1;
        } else {
            rear--;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0) return -1;
        return arr[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0) return -1;
        if(rear == 0) {
            return arr[arr.length - 1];
        } else {
            return arr[rear - 1];
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(10);
        myCircularDeque.insertFront(1);
        myCircularDeque.insertFront(2);
        myCircularDeque.insertLast(3);
        System.out.println(myCircularDeque.getRear());
    }
}
