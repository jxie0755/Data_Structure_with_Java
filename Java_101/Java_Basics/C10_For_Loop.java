package Java_Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class C10_For_Loop {

    /*
     * for loop defines start value, limit, and step
        * for loop      相当于 for i in range(0, len(array)):
        * for-each loop 相当于 for i in array:
        * for-each loop 也可以用于iterator

     * break work the same way as python
     */

    public static void main(String[] args) {

        System.out.print("for loop: ");
        for (int x = 0; x < 10; x = x + 1) {
            System.out.println(x); // >>> For loop: 0123456789
        }

        System.out.println();
        System.out.print("for loop break: ");
        for (int x = 0; x < 10; x = x + 1) {
            if (x == 5){
                break;
            } else {
                System.out.println(x); // >>> For loop: 01234 break 56789
            }
        }

        // 双参数 multiple parameters
        int x;
        int y;
        for (x = 0, y = 10; x < y; x++, y--) {
            System.out.printf("(x,y) = (%d, %d)", x, y);
            System.out.println();  // 打印一个换行符， 实现换行
            // >>>
            // (x,y) = (0, 10)
            // (x,y) = (1, 9)
            // (x,y) = (2, 8)
            // (x,y) = (3, 7)
            // (x,y) = (4, 6)
        }
    }
}

class C10b_For_each_Loop {

    public static void main(String[] args) {

        // 等同于python的for i in interable
        System.out.println("\n增强型for loop");
        // for-each(声明语句 : 表达式)
        String [] names = {"Denis", "Cindy", "Adrienne", "Simon"};
        for (String name: names) {     // name的类型必须和数组元素类型一致
            System.out.println(name);
        }

        // 再来一个例子
        // for-each loop in ArrayList
        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        for (Integer int_x: intList) {
            System.out.println(int_x);  // >>> 12345
        }


        // ArrayList的特殊forEach方法(根源来自interface Iterable)
        // 所以可以被用于所有Iterable的子interface的多态实例包括Collection, Set, List, ArrayList, HasSet等等
        // 本质上和 for-each(声明语句 : 表达式) 是一样的
        // 实际上完全可以不必使用, 用for-each更普遍
        ArrayList<Integer> IAL = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        IAL.forEach(i -> System.out.println(i));
        // >>>
        // 1
        // 2
        // 3
        // 4
        // 5

        IAL.forEach(i -> {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        });
        // >>>
        // 1
        // 3
        // 5

        List<String> SL = new ArrayList<>(Arrays.asList("A", "B", "C"));
        SL.forEach(i -> System.out.println(i));
        // >>>
        // A
        // B
        // C

        SL.forEach(System.out::println);  // 另一个种方式
        // >>>
        // A
        // B
        // C
    }
}


class C10c_For_loop_Iterator {

    public static void main(String[] args) {

        // For loop in Iterator
        // build a Tuple, then build an iterator in the for loop
        List<String> strTuple = List.of("A", "B", "C", "D", "E");
        for (Iterator<String> iter = strTuple.iterator(); iter.hasNext();) { // 注意这里还需要对Iterator定型
            String str_sample = iter.next();
            System.out.println(str_sample);  // >>> A B C D E
        }
    }
}
