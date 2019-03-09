package W3C_Java_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

    // ListIterator 类似iterator, 但是多一些特性
}

