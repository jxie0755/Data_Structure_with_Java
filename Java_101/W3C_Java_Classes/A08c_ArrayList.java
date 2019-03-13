package W3C_Java_Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class A08c_ArrayList {

    /*
     * Module java.base
     * Package java.util
     * Class ArrayList<E>

     *ArrayList 最基本的操作
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

        * 来自ArrayList
            * clone()
     */


    // 研究ArrayList特有的方法
    public static void main(String[] args) {

        // 构造方法
        ArrayList<Integer> IAL = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // >>> [1, 2, 3, 4]
        System.out.println(IAL.getClass());  // class java.util.ArrayList
        System.out.println(IAL instanceof java.util.ArrayList); // >>> true

        // clone() return an Object as a shallow copy  // 注意正确使用转型.
        ArrayList<Integer> IAL2 = (ArrayList<Integer>) IAL.clone();
        IAL2.add(5);
        System.out.println(IAL2);
        System.out.println(IAL);

        // ensureCapacity​(int minCapacity) // 跳过

        // forEach
        // 子类必须实现超interface Iterable中的抽象方法
        // 详见Java_Basics.C10b_For_each_Loop
    }
}

