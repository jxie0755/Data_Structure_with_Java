package W3C_Java_Classes;

import java.util.*;

public class A08_Collection {

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

        // 构造 也是要通过子类实现, 比如ArrayList, 但没必要, 这个interface太抽象了
        Collection<Object> objBox = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));

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

// 还有一个Module java.base / Package java.util / Class Collections
// 属于工具方法

class java_util_Collections {

    public static void main(String[] args) {

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
        List<Object> LO1 = new ArrayList();


        // 快速构建
        // List<Integer> L2 = [1, 2, 3, 2, 1];  不行
        // List<Integer> L2 = Arrays.asList(1,2,3,4,5);   // [1, 2, 3, 2, 1]
        // 可行但是这样是固定长度了(参见Arrays.asList)
        // 正确方法
        List<Integer> L2 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        List<Object> LO2 = new ArrayList<>(Arrays.asList("a", "b", "c"));   // 不限定类型, List后不要<>

        // 通用方法
        System.out.println(LO1.isEmpty());  // >>> true

        // L2.clear();  // 清空

        // contains 和 containsAll (代替in)
        System.out.println(L2.contains(3));  // >>> true
        System.out.println(LO2.containsAll(L2)); // >>>  true

        List<Object> LO3 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));   // 注意, L3和L2有一点点不同,L3不限类型
        System.out.println(LO3.equals(L2)); // >>> true         // 只要内容相等即可, 不在乎类型



        // List接口的专有方法 (除了Collections通用方法多出来的方法)

        // retainAll
        List<Object> LO4 = new ArrayList<>(Arrays.asList("a", "b", "c","c", "d", "e"));
        List<Object> LO5 = new ArrayList<>(Arrays.asList("c", "d"));
        LO4.retainAll(LO5);  // >>>  [c, c, d]

        // get and set
        List<Object> LO6 = new ArrayList<>(Arrays.asList("c", "d", "e"));
        LO6.set(1, "x");  // [c, x, e]
        System.out.println(LO6.get(1)); // >>>  x  (this is a copy)


        // indexOf and lastIndexOf 从两端找index
        List<Object> LO7 = new ArrayList<>(Arrays.asList("c", "d", "e", "d"));
        System.out.println(LO7.indexOf("d"));          // >>> 1
        System.out.println(LO7.lastIndexOf("d"));   // >>> 3

        // subList
        List<Object> LO8 = LO7.subList(1, 4);
        System.out.println(LO8);  // >>>  [d, e, d]

        // 	sort​(Comparator<? super E> c)
        // 使用List.sort()传入自己实现Commparator接口的类的对象，实现自定义排序
        // 这里涉及到自行设计一个Comparator所以此方法不常用, 更多的是用java.util.Collections.sort

        // iterator 把list变成一个iterator()

        // for loop
        List<Integer> IL1 = new ArrayList<>(Arrays.asList(1,2,1,3,1,4));
        for (Integer i: IL1) {
            // System.out.print(i);
        }

    }
}

class List_add {
    public static void main(String[] args) {

        List<Object> LO7 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        // add    被重载了, 支持选择插入位置
        LO7.add(99);                   // [1, 2, 3, 2, 1, 99]  // 默认是末尾
        LO7.add(2, 99);   // [1, 2, 99, 3, 2, 1, 99]

        // addAll 被重载了, 支持选择一个index位置加
        List<Object> LO8 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<Object> LO9 = new ArrayList<>(Arrays.asList(1, 2, 3));
        LO7.addAll(LO8);   // [1, 2, 99, 3, 2, 1, 99, a, b, c]  // 默认是末尾
        LO8.addAll(1, LO9);  // [a, 1, 2, 3, b, c]

        // List能否直接相加?
        // List<Object> LO10 = LO7 + LO8;   // 不行
    }

}

class List_remove {
    public static void main(String[] args) {

        List<Object> L2 = new ArrayList<>(Arrays.asList("a", "b", "c", 1, 2, 3, 2, 1));
        List<String> LO2 = new ArrayList<>(Arrays.asList("a", "b", "c", "c", "c"));
        List<String> LO3 = new ArrayList<>(Arrays.asList("c", "d", "e"));
        List<Integer> LO4 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 1, 4, 1, 5, 1, 6));

        // remove (object)
        LO4.remove(Integer.valueOf(1)); // [2, 1, 3, 1, 4, 1, 5, 1, 6] 从头开始找, 只删1个
        // 特殊方法是remove index, remove (重载)
        LO4.remove(0);            //     [1, 3, 1, 4, 1, 5, 1, 6]


        // removeAll
        LO2.removeAll(L2);        //     [a, b, c, 1, 2, 3, 2, 1] 变成: [a, b, c]
        LO2.removeAll(LO3);        //     [a, b]   // 只删LO3中有的, 但是会全删(比如"c")
        // 删掉所有1?
        LO4.removeAll(Arrays.asList(1));  // [3, 4, 5, 6]   //巧用Arrays.asList
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

class List_copy {
    public static void main(String[] args) {

        // CopyOf  // 注意,这个copy是imutable
        List<Object> LO1 = new ArrayList<>(Arrays.asList("a", 1, 2, 3, "b", "c"));
        List<Object> LO10 = List.copyOf(LO1);  // [a, 1, 2, 3, b, c]
        // 解决方案, 直接代入到new instance (相当于浅copy)
        List<Object> LO11 = new ArrayList<>(LO1);  // [a, 1, 2, 3, b, c]
        System.out.println(LO11.equals(LO1)); // >>> true

        // 若是多维数组可以吗?
        List<Integer> LL1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> LL2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> LL3 = new ArrayList<>(Arrays.asList(7, 8, 9));

        List<List<Integer>> Lgrid = new ArrayList(Arrays.asList(LL1, LL2, LL3));
        System.out.println(Lgrid);  // >>> [[1, 2], [4, 5, 6], [7, 8, 9]]
        LL1.add(3);
        System.out.println(Lgrid);  // >>> [[1, 2, 3], [4, 5, 6], [7, 8, 9]]  // impacted by LL1

        List<List<Integer>> Lgrid2 = new ArrayList<>(Lgrid);
        LL1.add(3);
        System.out.println(Lgrid2); // >>> [[1, 2, 3, 3], [4, 5, 6], [7, 8, 9]]  // impacted by LL1

        Lgrid.get(0).add(3);
        System.out.println(Lgrid2);
        // still changed, so it is shallow copy
    }
}