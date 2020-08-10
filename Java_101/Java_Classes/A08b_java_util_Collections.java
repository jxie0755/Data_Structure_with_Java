package Java_Classes;


// 还有一个Module java.base / Package java.util / Class Collections
// 属于工具方法


import java.util.*;

class A08b_java_util_Collections {

    /*
     * Module java.base
     * Package java.util
     * Class Collections

     * 最常用方法
     * addAll      批量add很多个element (到末尾)
     * copy        更像是copy and paste
     * min 和 max   容易理解,     可以自定义规则 (key=)
     * nCopies      一次生成n个相同的值
     * reverse     反序
     * sort        按从小到大顺序, 或者自定义规则 (key=)
     * swap        交换两个值的位置, 很方便
     * rotate      轮转, 方便
     * replaceAll  批量替换元素
     * shuffle     随机排列

     * unmodifiableCollection    返回一个inmutable copy? (把list转成tuple)
     * singletonCollection       单点, 意义不大
     * synchronizedCollection    返回一个多线程copy
     */

}


class Collections_for_General {

    // 和java.util.Arrays与Array类的关系一样, 提供static方法给Collection的子类使用
    // 重要的方法会独立出来总结
    public static void main(String[] args) {

        // addAll, 与Collection中addAll相重复
        // return true if modification is done
        // 与本类方法不同, 这个是可以添加任意数目的单独元素, 而不是在某个index直接插入另一个List的全部内容
        List<Integer> IL1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(Collections.addAll(IL1, 6, 7, 8, 9));  // >>>  true
        System.out.println(IL1);  // >>> [1, 2, 3, 4, 5, 6, 7, 8, 9]


        // binarySearch(List<? extends Comparable<? super T>> list, T key)
        // 类似Arrays.binarySearch
        // The list must be sorted into ascending order
        // Return  the index of the search key, if it is contained in the list;
        // otherwise, (-(insertion point) - 1)
        System.out.println(Collections.binarySearch(IL1, 6)); // >>>  5 (return index)


        // checkedCollection(Collection<E> c, Class<E> type)
        // Returns a dynamically typesafe view of the specified collection.
        // checkedList(List<E> list, Class<E> type)
        // 此逻辑还可以return很多其他Type
        // STOF: https://stackoverflow.com/questions/1161176/what-is-the-collections-checkedlist-call-for-in-java


        // copy(List<? super T> dest, List<? extends T> src)
        // 这个也在Collection本类中有类似的方法
        // len(dest) must >= len(src) !!
        List<Integer> IL2 = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110));
        Collections.copy(IL2, IL1);
        System.out.println(IL2);  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 100, 110]
        // 这个方法相当于,复制一个长度为n的List,并粘贴覆盖到另一个list的前n位.


        // min and max
        // 同时支持自定义compare规则, 类似python的__lt__, __eq__, __get__等等
        // 用法参见A11_Comparator
        System.out.println(Collections.min(IL2));  // >>>  1
        List<String> SL1 = new ArrayList<>(Arrays.asList("a", "A", "b", "c", "D", "d"));
        System.out.println(Collections.max(SL1)); // >>> d  (d > D) (比较ascii码)


        // 	nCopies(int n, T o)  (Inmutale List)
        List<String> SL2 = Collections.nCopies(4, "A");                   // [A, A, A, A]
        List<String> SL3 = new ArrayList<>(Collections.nCopies(3, "B"));  // [B, B, B]  // 如何Mutable?


        // reverse(List<?> list)
        // public static <T> Comparator<T> reverseOrder()
        // public static <T> Comparator<T> reverseOrder(Comparator<T> cmp)
        List<Integer> IL3 = new ArrayList<>(Arrays.asList(2, 3, 1, 4, 6, 4, 5));
        Collections.reverse(IL3);
        System.out.println(IL3);  // [5, 4, 6, 4, 1, 3, 2]  // 单纯反序


        // replaceAll(List<T> list, T oldVal, T newVal)
        // return true if modification is done
        List<String> SL4 = new ArrayList<>(Arrays.asList("A", "B", "C", "B", "D"));
        System.out.println(Collections.replaceAll(SL4, "B", "C")); // >>> true
        System.out.println(SL4);  // [A, C, C, C, D]


        // 	rotate(List<?> list, int distance) 把元素从最后一位扔回第一位
        List<String> SL5 = new ArrayList<>(Arrays.asList("A", "B", "C", "X", "Y"));
        Collections.rotate(SL5, 3);
        System.out.println(SL5); // >>> [C, X, Y, A, B]  注意不是依次rotate,而是整体一次过去


        // shuffle(List<?> list)
        // shuffle(List<?> list, Random rnd)  // TODO learn Random
        // Randomly permutes the specified list using a default source of randomness.
        List<String> SL6 = new ArrayList<>(Arrays.asList("A", "B", "C", "X", "Y"));
        Collections.shuffle(SL6);
        System.out.println(SL6); // >>>  [X, B, C, Y, A]  // 每次运行都不同


        // singletonList(T o)
        // Returns an immutable list containing only the specified object.
        List<String> SL7single = Collections.singletonList("X");
        System.out.println(SL7single); // >>> [X]
        // 还不如创建一个单元素Tuple
        List<String> TL7single = List.of("X");
        System.out.println(SL7single.equals(TL7single)); // >>> true


        // sort(List<T> list)
        // sort(List<T> list, Comparator<? super T> c)
        // 用法参见A11_Comparator
        List<String> SL8 = new ArrayList<>(Arrays.asList("BC", "B", "X", "Y", "A"));
        Collections.sort(SL8);   // >>> [A, B, BC, X, Y]


        // swap(List<?> list, int i, int j)  // 交换两个index的值
        Collections.swap(SL8, 0, 2);
        System.out.println(SL8); // >>> [BC, B, A, X, Y]


        // synchronizedCollection  (extends to subclasses)
        // Returns a synchronized (thread-safe) ABC backed by the specific ABC
        // 以List为例, 输出看起来还是同一个List:
        List<String> SL9 = Collections.synchronizedList(SL8);  // [BC, B, A, X, Y]


        // unmodifiableCollection  (extends to subclasses)
        // Returns an unmodifiable view of the specified ABC.
        // 以List为例, 输出看起来还是同一个List:
        List<String> SL10 = Collections.unmodifiableList(SL8); // [BC, B, A, X, Y]
        // 还是相当于Tuple
    }
}


class Collections_for_Set {

    public static void main(String[] args) {

        // singleton(T o)
    }

}

class Collections_for_Map {

    public static void main(String[] args) {

        // newSetFromMap(Map<E,Boolean> map)
        // K的数据类型必须与你想要创建的Set中元素的数据类型一致；而V必须是Boolean类型的，这是因为value字段用于标记该元素是否存在
        // 从一个空Map创造一个Set, 然后为Set添加元素,此时Map为元素生成key,赋值为true;
        Map<String, Boolean> Map1 = new HashMap<>();
        Set<String> S1 = Collections.newSetFromMap(Map1);
        S1.add("A");
        S1.add("B");
        S1.add("C");
        System.out.println(S1);   // >>>  [A, B, C]
        System.out.println(Map1); // >>>  {A=true, B=true, C=true}
        // 此工厂方法提供了一个对应于任何 map 实现的 set 实现。不必在已经有一个对应 set 实现（比如 hashmap 或 treemap）的 map 实现上使用此方法

        // singletonMap(K key, V value)
    }
}
