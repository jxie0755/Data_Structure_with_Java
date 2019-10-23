package Java_Classes;

import java.util.*;

class A11_Comparator {

    /*
     * Module java.base
     * Package java.util
     * Interface Comparator<T>
     */

    /*
     * Comparator是在集合外部实现的排序, 或者寻找最大值最小值等等，位于java.util下。
     * Comparator接口包含了两个函数
     * int compare(T o1, T o2);
     * boolean equals(Object obj);
     * 我们若需要控制某个类的次序,而该类本身不支持排序(即没有实现Comparable接口);
     * 那么，我们可以新建一个该类的比较器来进行排序。这个比较器只需要实现comparator即可。
     */

}

// 构造方法, 是通过造一个新的外部Comparator子类, 来重载其中的方法
class MyComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a * a - b * b;
    }
}


class Comparator_test {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(Arrays.asList(-3, -2, -1, 0, 1, 2));

        System.out.println(Collections.max(lst));
        // >>>  正常是2

        // 第一种用法. 根据自定义Comparator类
        System.out.println(Collections.max(lst, new MyComparator()));
        // >>> -3

        // 第二种用法: 根据内部类
        // 如果根据自定义comparator,应该是绝对值最大的数最大
        System.out.println(Collections.max(lst, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a * a - b * b;
            }
        }));

        // 第三种: 利用Lambda函数 java7以后才能该用
        System.out.println(Collections.max(lst, (a, b) -> a * a - b * b));
        // 参见 Java101/Java_Basics/C12_Lambda


        // 第二个例子, 根据一个字典中值的长度来找key (使用内部类)
        Map<String, List<Integer>> Mapp = new HashMap<>(Map.ofEntries(
                Map.entry("A", List.of(9, 9)),
                Map.entry("B", List.of(2, 2, 3)),
                Map.entry("C", List.of(1, 2, 0, 0)),
                Map.entry("D", List.of(1))
        ));

        System.out.println(Collections.min(Mapp.keySet(), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Mapp.get(o1).size() - Mapp.get(o2).size();
            }
        })); // >>> D

        // 另一种写法, 使用Lambda函数简化
        System.out.println(Collections.min(Mapp.keySet(),
                (o1, o2) -> Mapp.get(o1).size() - Mapp.get(o2).size()));
        // >>> D


        // reversed
        List<Integer> lst2 = new ArrayList<>(Arrays.asList(2, 3, 1, 4, 5));
        Comparator<Integer> C = Comparator.comparingInt(x -> x);
        Collections.sort(lst2, C.reversed());
        System.out.println(lst2); // >>>  [5, 4, 3, 2, 1]
    }
}
