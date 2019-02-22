package Java_Basics;

public class C09_While_Loop {
    public static void main(String[] args) {

        System.out.println("while loop 1: ");

        int x = 0;
        while (x <= 10) {
            System.out.println(x);
            x = x + 1;
            // >>>
            // while loop
            //0
            //1
            //2
            //3
            //4
            //5
            //6
            //7
            //8
            //9
            //10
        }

        System.out.println();
        System.out.println("while loop break: ");
        x = 0;
        while (x <= 10) {
            if (x == 5) {
                break;
            } else {
                System.out.println(x);
                x = x + 1;
            }
            // >>>
            // while loop
            //0
            //1
            //2
            //3
            //4
        }


        // do-while loop
        // 对于 while 语句而言，如果不满足条件，则不能进入循环
        // 但有时候我们需要即使不满足条件，也至少执行一次
        int response = 0;
        do {
            System.out.println ("reponse is now: " + response);
            response += 1;
        } while (response != 5);
        // >>>
        // reponse is now: 0
        // reponse is now: 1
        // reponse is now: 2
        // reponse is now: 3
        // reponse is now: 4


        // This won't work
        // while (false) {
        //     System.out.println ("Hello!");
        // }

        // This prints at lease once Hello
        do {
            System.out.println ("Hello!");
        } while (false);

        // 其实相当于while True, 执行一段代码, 然后if条件不符合,就break

    }
}

/*
 * while loop is more like python, define indicator outside
 * java中,int和boolean不同, 所以不能while(0)或者while(1)
 * Use break the same way
 * 只有do-while loop, 没有do-for loop
 */