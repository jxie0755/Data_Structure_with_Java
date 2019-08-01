package Java_Classes;

import java.util.Arrays;
import java.util.LinkedList;

public class A08cc_LinkedList {

    /*
     * Module java.base
     * Package java.util
     * Class LinkedList<E>
     */

    /*
     * LinkedList 是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。
     * LinkedList 实现 List 接口，能对它进行队列操作。
     * LinkedList 实现 Deque 接口，即能将LinkedList当作双端队列使用。
     * LinkedList 实现了Cloneable接口，即覆盖了函数clone()，能克隆。
     * LinkedList 实现java.io.Serializable接口，这意味着LinkedList支持序列化，能通过序列化去传输。
     * LinkedList 是非同步的
     */

    /*
     * LinkedList常用方法
     * 来自Iterable
     * forEach()
     * iterator()
     * 来自Collection
     * add​(E e)                     相当于append, 附带return boolean
     * remove​(Object o)             相当于del
     * addAll​(Collection<?> c)      类并集
     * removeAll​(Collection<?> c)   类差集
     * retainAll​(Collection<?> c)   类交集
     * contains​(Object o)           相当于x in lst
     * containsAll​(Collection<?> c) 相当于 c is a subList of this
     * size()                       相当于len
     * equals​(Object o)             相当于 == 但是更准确
     * clear()
     * isEmpty()
     * toArray()
     * hashcode()
     * 来自List
     * get                        相当于lst[i]
     * set                        相当于lst[i] = n
     * add​(int index, E element)       相当于insert(重载)
     * addAll​(idx, Collection<?>)      指定index(重载)
     * remove​(int index)                     相当于pop
     * subList​(int fromIndex, int toIndex)   相当于切片list[i:j]
     * indexOf​(Object o)
     * lastIndexOf​(Object o)
     * containsAll​(Collection<?> c)          判断是否subList
     * copyOf​(Collection<?> coll)           (inmutable)
     * of (build a tuple)
     * listIterator()
     * listIterator​(int index)                starting at a specific
     * 来自Queue
     * element()                           Retrieves, but does not remove, the head of this queue.
     * peek()	                         与element相同, 但是如果为空,则返回null而不会报错
     * poll()	                         在peek()基础上,再移除head, 安全型
     * offer​(E e)                         如Capacity允许就添加. 返回boolean指示是否成功
     * remove                             砍头(重载), 并返回head的value
     * 来自Deque
     * addFirst (E e)             insert at idx0    with capacity allowance
     * addLast(E e)               insert at the end with capacity allowance
     * push                       与addFirst完全相同
     * offerFirst                 addFirst with capacity allowance (boolean确认)
     * offerLast                  addLast with capacity allowance (boolean确认)
     * descendingIterator()
     * element()                  取head值,但是不去掉head   (non-empty)
     * getFirst()                 get the first elmement (non-empty) 与element()相同
     * getLast()                  get the last element   (non-empty)
     * peekFirst()                安全型getFirst, 防止空表
     * peekLast()                 安全型getLast, 防止空表
     * pollFirst()                在peekFirst()基础上,再移除head, 安全型
     * pollLast()                 在peekLast()基础上, 再移除tail, 安全型
     * pop()                      非安全型pollFirst
     * removeFirst()              非安全型pollFirst, 与pop完全相同
     * removeLast()               非安全型pollLast
     * removeFirstOccurrence​(Object o)    从头开始找,直接去值. boolean确认, 非安全型
     * removeLastOccurrence​(Object o)     从尾开始找,直接去值. boolean确认, 非安全型
     * 来自LinkedList
     * clone                      shallow copy
     */

    public static void main(String[] args) {

        // 构造方法
        LinkedList<Integer> li1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        LinkedList<Integer> empt = new LinkedList<>();
        System.out.println(li1);  // >>> [1, 2, 3, 4, 5, 6]  看起来是一样的

        // 来自List已经更上层接口的方法这里就跳过了, 参见ArrayList的用法

        // 测试LinkedList独有的功能
        // clone()
        // Returns a shallow copy of this LinkedList in Object type
        LinkedList<Integer> li2 = (LinkedList<Integer>) li1.clone();
        // STOF: https://stackoverflow.com/q/55170506/8435726
        // It is implementing the Cloneable interface,
        // which at one point someone must have thought was a good idea.
        // It's not a very useful interface
    }
}
