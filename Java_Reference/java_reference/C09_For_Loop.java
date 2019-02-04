package java_reference;

public class C09_For_Loop {
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
        // for(声明语句 : 表达式)
        String [] names = {"Denis", "Cindy", "Adrienne", "Simon"};
        for (String name: names) {     // name的类型必须和数组元素类型一致
            System.out.println(name);
        }
        // >>>
        // Denis
        // Cindy
        // Adrienne
        // Simon

        // 等同于python的for i in interable
    }
}

/*
 * for loop defines start value, limit, and step
 * break work the same way as python
 */