package algorithm_p1.week_2;

import java.util.Arrays;
import java.util.Iterator;

public class Alg_Lecture_03_Stacks_and_Queues {

    /*
     * Stacks
         * Examine the items most recently added
         * Operation to the end
         * push (insert)
         * pop (remove)
         * 尾进尾出
     * Implementation
         * Linked list
            * Every operation takes constant time in the worst case
            * Uses extra time and time to deal with the links
         * Array
            * Every operation takes constant amortized time
            * Less wasted space
     */

    /*
     * Queue
     * Examine the items least recently added
     * Enqueue (insert) push to the head
     * Dequeue (remove) remove the tail
     * 头进尾出
     */


    /*
     * Generics
        * Different implementation for each class -- before java 1.5
        * Casting - create object container then cast into different types - unsatisfactory
        * Generics - Discover type in the beginning - prefer compile error over runtime error
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
        System.out.println(stk1.isEmpty());
    }
}


class algor_ArrayStackOfStrings {

    /*
     * This for now does not handle:
        * Underflow (pop from empty) - Need to throw an excepttion
        * Overflow (push beyond the capacity) - Need to implement re-size
     */

    private String[] stack;
    private int idx;

    public algor_ArrayStackOfStrings(int capacity) {
                                    // can not always rely on user to give a capacity
                                    // this will be solved in the future
        stack = new String[capacity];
        idx = 0;
    }

    public boolean isEmpty() {
        return idx == 0;
    }

    public void push(String item) {
        stack[idx++] = item;  // assign the item to this index first hen increase idx by 1

    }

    public String pop() {
        // return stack[--idx]; // special operation decrease by 1 first then return the item at index
        // Above does not actually pop item, just move the index.
        String item = stack[--idx];
        stack[idx] = null;  // this will clear the stack
        return item;
    }

    public static void main(String[] args) {
        algor_ArrayStackOfStrings stk2 = new algor_ArrayStackOfStrings(10);
        System.out.println(stk2.isEmpty());
        stk2.push("A");
        stk2.push("B");
        stk2.push("C");
        System.out.println(Arrays.toString(stk2.stack));
        System.out.println(stk2.pop());
        System.out.println(stk2.pop());
        System.out.println(stk2.pop());
        System.out.println(Arrays.toString(stk2.stack));
        System.out.println(stk2.isEmpty());
    }
}


class algor_ArrayStackOfStringsResizable {

    /*
     * This is to solve:
        * Overflow by growing the size of the array
        * increase and decrease by 1 is not acceptable
        * use 'repeated doubling' skill, create a new array doublig the size of the original.
        * also shrink the array by pop() if the array is too empty
     */

    private String[] stack;
    private int idx;

    public algor_ArrayStackOfStringsResizable() {
                                    // can not always rely on user to give a capacity
                                    // this is solved by resizing, constructor needs no capacity assignment
        stack = new String[1];
        idx = 0;
    }

    public boolean isEmpty() {
        return idx == 0;
    }

    public void resize(int N) {  // push resize method to double the array size
        String[] new_stack = new String[N];
        for (int i = 0; i < idx; i++) {
            new_stack[i] = this.stack[i];
        }
        this.stack = new_stack;
    }

    public void push(String item) {
        if (idx == stack.length) {  // check the idx to avoid overflow by resizing
            resize(2 * stack.length);
        }
        stack[idx++] = item;  // assign the item to this index first hen increase idx by 1

    }

    public String pop() {
        // shrink the size of array when it is a quarter full, to half full
        String item = stack[--idx];
        stack[idx] = null;  // this will clear the stack
        if (idx > 0 && idx == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    public static void main(String[] args) {
        algor_ArrayStackOfStringsResizable stk3 = new algor_ArrayStackOfStringsResizable();
        stk3.push("A");
        stk3.push("B");
        stk3.push("C");
        System.out.println(Arrays.toString(stk3.stack));
        System.out.println(stk3.pop());
        System.out.println(stk3.pop());
        System.out.println(stk3.pop());
        System.out.println(Arrays.toString(stk3.stack));
        System.out.println(stk3.isEmpty());
    }
}


class algor_LinkedQueueOfStrings {

    private Node first;
    private Node last;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;

    }

    public static void main(String[] args) {
        algor_LinkedQueueOfStrings q1 = new algor_LinkedQueueOfStrings();
        q1.enqueue("A");
        q1.enqueue("B");
        q1.enqueue("C");
        q1.enqueue("D");
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.isEmpty());
    }
}


// Additional: self implementation using array
class algor_ArrayQueueOfStringsResizable {

    private String[] q;
    private int head;
    private int tail;

    public algor_ArrayQueueOfStringsResizable() {
        // also resizing
        q = new String[1];
    }

    public boolean isEmpty() {
        return head - tail == 0;
    }

    public void resize(int N) {  // push resize method to double the array size
        String[] new_q = new String[N];
        for (int i = 0; i < tail-head; i++) {
            new_q[i] = this.q[i+head];
        }
        this.q = new_q;
    }

    public void enqueue(String item) {
        if (tail == q.length) {  // check the idx to avoid overflow by resizing
            resize(2 * q.length);
        }
        q[tail++] = item;  // assign the item to this index first hen increase idx by 1

    }

    public String dequeue() {
        // shrink the size of array when it is a quarter full, to half full
        String item = q[head];
        q[head] = null;  // this will clear the stack
        head++;
        if (tail - head > 0 && tail - head == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    public static void main(String[] args) {
        algor_ArrayQueueOfStringsResizable q2 = new algor_ArrayQueueOfStringsResizable();
        q2.enqueue("A");
        q2.enqueue("B");
        q2.enqueue("C");
        q2.enqueue("D");
        q2.enqueue("E");
        System.out.println(Arrays.toString(q2.q));
        System.out.println(q2.dequeue());
        System.out.println(q2.dequeue());
        System.out.println(Arrays.toString(q2.q));
        System.out.println(q2.dequeue());
        System.out.println(Arrays.toString(q2.q));
        System.out.println(q2.head);
        System.out.println(q2.tail);
    }
}


// generic linkedlist
class genericLinkedStack<Item> {
    // then use Item to replace all the typing in the following codes
    private class Node {
        Item item;
        Node next;
    }
}

class genericArrayStack<Item> {
    private Item[] s;
    // Difficulty: Java does not allow generic array
    // have to be solved by casting
    public genericArrayStack(int capacity) {
        this.s = (Item[]) new Object[capacity];
    }
}


// Use iterator to make stack
// do not use remove in iterator (not recommending)
// iterable data type can use for-each loop ( for (type s : iterable) {} )

class IterableArrayStack<Item> implements Iterable<Item> {

    Object[] s;
    int idx;

    public IterableArrayStack(int N){
        this.s = (Item[]) new Object[N];
    }

    public int size() {
        return s.length;
    }

    public boolean isEmpty() {
        return idx == 0;
    }

    public void push(Item item) {
        this.s[idx] = item;
        idx ++;
    }

    public Item pop() {
        return (Item) s[--idx];
    }

    @Override
    public Iterator<Item> iterator() {
        return new BIterator();
    }

    // 创建一个BIterator的内部类
    private class BIterator implements Iterator<Item> {
        private int idx = 0;

        @Override
        public boolean hasNext() {
            return idx != s.length;
        }

        @Override
        public Item next() {
            return (Item) s[idx++];
        }

        @Override
        public void remove() {

        }

    }

    public static void main(String[] args) {

        IterableArrayStack<Integer> b1 = new IterableArrayStack<>(10);
        b1.push(1);
        b1.push(2);
        b1.push(3);
        b1.push(4);
        System.out.println(Arrays.toString(b1.s));
        for (Integer i : b1) {  // now this is iterable
            if (i != null) {
                System.out.println(i);
            }
        }
        System.out.println(b1.pop());
        System.out.println(b1.pop());
    }
}
