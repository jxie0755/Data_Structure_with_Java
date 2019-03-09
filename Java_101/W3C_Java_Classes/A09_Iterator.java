package W3C_Java_Classes;

import java.util.*;

public class A09_Iterator {

    public static void main(String[] args) {

        // 构造方法
        List<Integer> IL1 = new ArrayList<>(Arrays.asList(1,2,1,3,1,4));
        Iterator<Integer> IL11 = IL1.iterator();  // 从一个ArrayList来构造

        // next
        System.out.println(IL11.next()); // >>> 1
        System.out.println(IL11.next()); // >>> 2
        System.out.println(IL11.next()); // >>> 1  直到结束

        // for loop
        System.out.println();
        for (Iterator<Integer> iter = IL11; iter.hasNext();) { // 注意这里还需要对Iterator定型
            // 更多的时候这里才使用 IL1.iterator();

            Integer intt = iter.next();
            System.out.println(intt);
        }
        // 迭代器用于while循环
        Iterator<Integer> IL12 = IL1.iterator();
        IL12.next(); // >>> 1
        IL12.next(); // >>> 2
        IL12.next(); // >>> 1

        System.out.println();
        while (IL12.hasNext()) {
            Integer intt = IL12.next();
            System.out.println(intt);
        }

        // forEachRemaining 能够将Iterator中迭代剩余的元素传递给一个函数
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        Iterator<String> it = list.iterator();
        it.next();  // "a"
        it.next();  // "b"  // 先消耗两个

        it.forEachRemaining(s -> System.out.println("WTF " + s + " "));
        // >>>
        // WTF c
        // WTF d
        // WTF e
    }
}


class List_Iterator {

    // An iterator for lists that allows the programmer to traverse the list in either direction,
    // modify the list during iteration, and obtain the iterator's current position in the list.

    // A ListIterator has no current element;
    // its cursor position always lies between the element that would be returned by a call to previous() and the element that would be returned by a call to next().

    // An iterator for a list of length n has n+1 possible cursor positions,
    // as illustrated by the carets (^) below:
    //                      Element(0)   Element(1)   Element(2)   ... Element(n-1)
    // cursor positions:  ^            ^            ^            ^                  ^


    // ListIterator 类似iterator, 但是多一些特性
    public static void main(String[] args) {

        // 构造很类似
        List<Integer> IL1 = new ArrayList<>(Arrays.asList(1,2,1,3,1,4));
        ListIterator<Integer> IL10 = IL1.listIterator();  // 从一个ArrayList来构造
        System.out.println(IL10.toString());  // java.util.ArrayList$ListItr@6e8dacdf 无法被print

        // add
        // 可以多次重复执行
        ListIterator<Integer> IL11 = IL1.listIterator();  // 从一个ArrayList来构造
        IL11.next(); // 1
        IL11.next(); // 2
        IL11.add(9); // 它们被依次添加到迭代器当前cursor位置之前
        IL11.add(8); // 它们被依次添加到迭代器当前cursor位置之前
        System.out.println(IL1); // >>> [1, 2, 9, 8, 1, 3, 1, 4]
        // 即使再生成一个迭代器, 也会重复在同一个list上操作
        ListIterator<Integer> IL12 = IL1.listIterator();  // 从一个ArrayList来构造
        IL12.add(5);
        System.out.println(IL1); // >>>  [5, 1, 2, 9, 8, 1, 3, 1, 4]

        // remove
        // 要执行remove，首先要找到所需移除的元素，怎样找？当然是通过next()跟previous()方法，
        // 所以remove必须要跟在next()或是previous()之后，而且只能执行一次
        // (一个元素当然只能删一次，删多个元素，需要再执行next()或previous())。
        List<Integer> IL2 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 1, 4));
        ListIterator<Integer> IL22 = IL2.listIterator();
        IL22.next(); // 1
        IL22.next(); // 2
        IL22.remove();
        System.out.println(IL2); // >>>  [1, 1, 3, 1, 4]  删了2


        // next and previous
        List<Integer> IL3 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 1, 4));
        ListIterator<Integer> IL33 = IL3.listIterator();
        System.out.println(IL33.next());
        System.out.println(IL33.next());
        System.out.println(IL33.next());
        System.out.println(IL33.previous());
        System.out.println(IL33.previous());
        System.out.println(IL33.next());
        System.out.println(IL33.next());
        System.out.println(IL33.next());
        // 也就是ListIterator 被call next和previous不会让元素消失

        // 	nextIndex() and previousIndex()
        List<Integer> IL4 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 1, 4));
        ListIterator<Integer> IL44 = IL4.listIterator();
        System.out.println(IL44.nextIndex()); // >>> 0
        System.out.println(IL44.nextIndex()); // >>> 0
        System.out.println(IL44.nextIndex()); // >>> 0
        // 不会移动cursor

        // set  Replaces the last element returned by next() or previous()
        IL44.next();  // 1
        IL44.next();  // 2
        IL44.next();  // 1
        IL44.set(5);
        System.out.println(IL4); // >>>  [1, 2, 5, 3, 1, 4]
    }
}

