package algorithm_p1.week_2;

public class Stacks_and_Queues {

    /*
     * Stacks
        * Examine the items most recently added
        * Operation to the end
            * push (insert)
            * pop (remove)
            * 尾进尾出
     */

    /*
     * Queue
        * Examine the items least recently added
            * Enqueue (insert) add to the head
            * Dequeue (remove) remove the tail
            * 头进尾出
     */

}


class algor_LinkedStackOfStrings {

    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }


    public static void main(String[] args) {
        algor_LinkedStackOfStrings stk1 = new algor_LinkedStackOfStrings();
        System.out.println(stk1.isEmpty());
        stk1.push("A");
        stk1.push("B");
        stk1.push("C");
        System.out.println(stk1.pop());
        System.out.println(stk1.pop());
        System.out.println(stk1.pop());
    }
}

class algor_LinkedQueueOfStrings {

    private Node first = null;
    private Node last = null;


    private class Node {
        String item;
        Node next;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {

    }

    public String dequeue() {

    }


    public static void main(String[] args) {

    }
}
