package W3C_Java_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class A08_Collections {

    /*
     * Collection的常用子接口
     * List接口
        * ArrayList、LinkedList、Vector、Stack
     * Set接口
        * HashSet、LinkedHashSet、TreeSet
     * Deque接口
     */

}


class Collections_zMethods {

    // 所有子接口都同样有这些方法
    public static void main(String[] args) {
        // 这里不实现这些方法,到子类具体再使用

        // 构造 也是要通过子类实现, 比如ArrayList
        // boolean add(E e) //向集合中添加一个元素，若添加元素后集合发生了变化就返回true，
        // 若没有发生变化，就返回false。 (用于Set)
        // boolean addAll(Collection<? extends E> c) //添加给定集合c中的所有元素到该集合中
        // void clear() //(optional operation).
        // boolean contains(Object o) //判断该集合中是否包含指定对象
        // boolean containsAll(Collection<?> c)
        // boolean equals(Object o)
        // int hashCode()
        // boolean isEmpty()//size==0?
        // Iterator<E> iterator()
        // boolean remove(Object o) //移除给定对象的一个实例（有的具体集合类型允许重复元素）
        // boolean removeAll(Collection<?> c) //移除元素集合c
        // boolean retainAll(Collection<?> c) //仅保留给定集合c中的元素
        // int size()
        // Object[] toArray()
        // <T> T[] toArray(T[] a)
    }
}




/*
 * List
 * List代表一个元素有序、可重复的集合，集合中每个元素都有其对应的顺序索引。
    * List是一个接口, 不能被直接实现, 需要通过其他子类实现, 常用子类
    * ArrayList
    * LinkedList
    * Stack
    * Vector (多线程, 一般不用)

* 注意：
    * List集合默认按元素的添加顺序设置元素索引，例如第一次添加元素索引为0，第二次添加索引为1…
    * List是Collection的子接口，可以使用Collection接口里的全部方法。
    * 因为List是有序集合，所以它有一些根据索引来操作集合元素的方法。
 */


class List_zMethods {


    public static void main(String[] args) {
        // 构造方法
        // List L1 = new ArrayList();  // 空列表   // 可以省略泛型,但是不规范:
        List<Object> L1 = new ArrayList();


        // 快速构建
        // List<Integer> L2 = [1, 2, 3, 2, 1];  不行
        // List<Integer> L2 = Arrays.asList(1,2,3,4,5);   // [1, 2, 3, 2, 1]
        // 可行但是这样是固定长度了(参见Arrays.asList)
        // 正确方法
        List<Integer> L2 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        List<Object> S1 = new ArrayList<>(Arrays.asList("a", "b", "c"));   // 不限定类型, List后不要<>



        // 通用方法
        System.out.println(L1.isEmpty());  // >>> true
        System.out.println(L1.add(5)); // >>> true  [5]
        S1.addAll(L2); // >>> [a, b, c, 1, 2, 3, 2, 1]

        // L2.clear();  // 清空
        System.out.println(L2.contains(3));  // >>> true
        System.out.println(S1.containsAll(L2)); // >>>  true

        List<Object> L3 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));   // 注意, L3和L2有一点点不同,L3不限类型
        System.out.println(L3.equals(L2)); // >>> true         // 只要内容相等即可, 不在乎类型

        S1.removeAll(L2);        //     [a, b, c, 1, 2, 3, 2, 1] 变成:
        System.out.println(S1);  // >>> [a, b, c]
        List<Object> S2 = new ArrayList<>(Arrays.asList("c", "d", "e"));
        S1.removeAll(S2);        //     [a, b]   // 只删S1中有的

        List<Object> S3 = new ArrayList<>(Arrays.asList("a", "b", "c","c", "d", "e"));
        List<Object> S4 = new ArrayList<>(Arrays.asList("c", "d"));
        S3.retainAll(S4);  // >>>  [c, c, d]

        L3.remove(new Integer(1));   // [1, 2, 3, 2, 1] 变成 [2, 3, 2, 1]  从头开始找

        System.out.println(L3.size()); // >>>  4



        // List接口的专有方法 (除了Collections通用方法多出来的方法)
        // remove 被重载了, 通用方法是remove object, 特殊方法是remove index
        List<Object> L4 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        L4.remove(1);                // [1, 3, 2, 1] 注意这里remove的是index

        // add    被重载了, 支持选择插入位置
        L4.add(2, 99);   // [1, 3, 99, 2, 1]

        // addAll 被重载了, 支持选择一个index位置加
        List<Object> S5 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<Object> S6 = new ArrayList<>(Arrays.asList(1, 2, 3));
        S5.addAll(1, S6);  // [a, 1, 2, 3, b, c]






    }
}


class List_toArray {
    public static void main(String[] args) {

        List l = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Object[] objs = l.toArray();     // 可以
        // String[] strs = l.toArray();  // 不行, throw ClassCastException

        // 或者使用转型?
        // String[] strs = (String[]) objs;
        // System.out.println(Arrays.toString(strs));  // 还是不行!

        // 正确做法, 分两步:
        String[] strs = new String[l.size()];
        l.toArray(strs);
        // 这样可以得到一个 String[]  [A, B, C]

        // 如果创建的额String[]比l还长很多会如何?
        String[] strs2 = new String[5];
        l.toArray(strs2);   // [A, B, C, null, null]  // 多出两个null
    }
}