package cs.stackAndQueue;

public class StackMadeByQueue {

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static class Stack {

        private QueueMadeByStack.Queue q1 = new QueueMadeByStack.Queue();
        private QueueMadeByStack.Queue q2 = new QueueMadeByStack.Queue();

        private void push(String s){
            q1.enqueue(s);
        }

        private String pop(){

            while(q1.size() > 1){
                q2.enqueue(q1.dequeue());
            }

            QueueMadeByStack.Queue tmp = q1;
            q1 = q2;
            q2 = tmp;

            return q2.dequeue();
        }

    }
}
