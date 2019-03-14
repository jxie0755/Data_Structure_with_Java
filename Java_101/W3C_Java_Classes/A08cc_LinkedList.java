package W3C_Java_Classes;

public class A08cc_LinkedList {

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

                * addAll​(Collection<? extends E> c)    // 类并集
                * removeAll​(Collection<?> c)           // 类差集
                * retainAll​(Collection<?> c)           // 类交集

                * contains​(Object o)           相当于x in lst
                * containsAll​(Collection<?> c) 相当于 lst A is a subList of B

                * size()                       相当于len
                * equals​(Object o)             相当于 == 但是更准确
                * clear()
                * isEmpty()
                * toArray()

            * 来自List
                * get                        相当于lst[i]
                * set                        相当于lst[i] = n

                * add​(int index, E element)             相当于insert
                * addAll​(int index, Collection<? extends E> c)

                * remove​(int index)                     相当于pop
                * subList​(int fromIndex, int toIndex)   相当于切片list[i:j]

                * indexOf​(Object o)
                * lastIndexOf​(Object o)
                * containsAll​(Collection<?> c)          判断是否subList

                * copyOf​(Collection<? extends E> coll) (inmutable)
                * of (build a tuple)
     */
}

