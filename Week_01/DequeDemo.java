import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.push("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        System.out.println(deque.peek());
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst());
        }

    }
}
