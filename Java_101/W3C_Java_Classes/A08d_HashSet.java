package W3C_Java_Classes;

import java.util.Arrays;
import java.util.HashSet;

public class A08d_HashSet {

    /*
     * HashSet 最基本的操作
        * 来自Iterable:
            * forEach
            * iterator()

        * 来自Collection (所以Collection的方法不牵涉到任何index)
            * add​(E e)                     相当于append, 附带return boolean
            * remove​(Object o)             相当于del

            * addAll​(Collection<? extends E> c)    // 并集
            * removeAll​(Collection<?> c)           // 差集
            * retainAll​(Collection<?> c)           // 交集

            * contains​(Object o)           相当于x in Set
            * containsAll​(Collection<?> c) 相当于 lst A is a subList of B

            * size()                       相当于len
            * equals​(Object o)             相当于 == 但是更准确
            * clear()
            * isEmpty()
            * toArray()

        * 来自Set
            * of
            * copyOf

        * 来自HashSet
            * 没有特别特殊的方法
     */


    // 研究HashSet特有的方法
    // 没有特别特殊的方法 (但是有新理解)
    public static void main(String[] args) {

        // 构造方法
        HashSet<Integer> HS = new HashSet<>();  // 空
        HashSet<Integer> HS2 = new HashSet<>(Arrays.asList(1,2,3,4));
        System.out.println(HS2.getClass());  // class java.util.HashSet
        System.out.println(HS2 instanceof java.util.HashSet); // >>> true
    }
}

