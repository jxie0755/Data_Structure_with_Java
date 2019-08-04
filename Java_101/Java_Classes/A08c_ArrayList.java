package Java_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * remove​(Object o)             相当于del (注意这里操作）
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
     * copyOf​(Collection<? extends E> coll) (inmutable)
     * of (build a tuple)
     * listIterator()
     * listIterator​(int index)                starting at a specific *
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
        // STOF: https://stackoverflow.com/q/55170506/8435726
        // It is implementing the Cloneable interface,
        // which at one point someone must have thought was a good idea.
        // It's not a very useful interface


        // remove(element) or remove(idx)??
        List<String> SAL1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        SAL1.remove("A");
        System.out.println(SAL1); // >>> [B, C]
        SAL1.remove("B"); // 注意这里直接remove String很方便
        System.out.println(SAL1); // >>> [BC]

        // 但是如果ArrayList本身就是Integer，如何区分remove的是idx还是元素本身？
        List<Integer> IAL3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        IAL3.remove(1);  // 这里remove的是
        System.out.println(IAL3); // >>> [1, 3, 4]
        IAL3.remove(new Integer(1)); // 这样才是remove元素
        System.out.println(IAL3); // >>> [3, 4]

        // ensureCapacity​(int minCapacity) // 跳过

        // forEach
        // 子类必须实现超interface Iterable中的抽象方法
        // 详见Java_Basics.C10b_For_each_Loop


    }
}
