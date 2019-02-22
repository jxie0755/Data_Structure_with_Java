package Java_Basics;

import java.util.ArrayList;
import java.util.List;

public class C10_For_Loop {
    public static void main(String[] args) {

        System.out.print("for loop: ");
        for (int x = 0; x < 10; x = x + 1) {
            System.out.println(x); // >>> For loop:0123456789
        // System.out.println(x);  // indentation does not impact, because loop defined in {}
            // >>>
            //for loop 1: 0
            //1
            //2
            //3
            //4
            //5
            //6
            //7
            //8
            //9
        }

        System.out.println();
        System.out.print("for loop break: ");
        for (int x = 0; x < 10; x = x + 1) {
            if (x == 5){
                break;
            } else {
                System.out.println(x); // >>> For loop:0123456789
            }

            // >>>
            //for loop 2: 0?
            //1
            //2
            //3
            //4
        }

        System.out.println("\n增强型for loop");
        // for-each(声明语句 : 表达式)
        String [] names = {"Denis", "Cindy", "Adrienne", "Simon"};
        for (String name: names) {     // name的类型必须和数组元素类型一致
            System.out.println(name);
        }
        // >>>
        // Denis
        // Cindy
        // Adrienne
        // Simon

        // 再来一个例子
        // for-each loop
        // 先构建一个int Array
        int[] int_list = new int[]{1,2,3,4,5};
        for (Integer int_x: int_list) {
            System.out.print(int_x);  // >>> 12345
        }
        System.out.println();
        // 等同于python的for i in interable

        // 双参数
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

/*
 * for loop defines start value, limit, and step
 * break work the same way as python
 */