package cs.stackAndQueue;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueMadeByStack {

    //Stack 두개로 Queue를 구현하라
    public static void main(String[] args) {

        Queue q = new Queue();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }

    static class Queue {
        private final Stack<String> inStack;
        private final Stack<String> outStack;

        public Queue() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        void enqueue(String s) {
            inStack.push(s);
        }

        String dequeue() {
            if (outStack.size() == 0) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }

            try {
                return outStack.pop();
            } catch (EmptyStackException e) {
                return "No Data";
            }
        }

        int size(){
            return inStack.size() + outStack.size();
        }
    }
}
