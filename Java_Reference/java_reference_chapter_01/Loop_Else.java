package java_reference_chapter_01;

public class Loop_Else {
    public static void main(String[] args) {
        System.out.println("for...else...");
        loop1: {   // label the loop
            for (int x=0; x <= 5; x = x+1) {
                System.out.println(x);
                if (x == 3) {
                    System.out.print("found ");
                    System.out.println(x);
                    break loop1;                // 注意这里break是break整个label而不是break for loop
                }
            }
            System.out.println("found no number");  // 所以这行就被忽略了, 因为整个label内的内容都被终止了
        }
        // >>>
        //0
        //1
        //2
        //3
        //found 3

        loop2: {
            for (int x=0; x <= 5; x = x+1) {
                System.out.println(x);
                if (x == 6) {
                    System.out.print("found ");
                    System.out.println(x);
                    break loop2;
                }
            }
            System.out.println("found no number");
        }
        // >>>
        //1
        //2
        //3
        //4
        //5
        //found no number

        System.out.println();
        System.out.println("while...else...");
        loop2: {   // label name can repeat
            int x = 0;
            while (x <= 5) {
                System.out.println(x);
                if (x == 3) {
                    System.out.print("found ");
                    System.out.println(x);
                    break loop2;
                }
                x = x + 1;
            }
            System.out.println("found no number");
        }
        // >>>
        //0
        //1
        //2
        //3
        //found 3

        label: {
            int x = 0;
            while (x <= 5) {
                System.out.println(x);
                if (x == 6) {
                    System.out.print("found ");
                    System.out.println(x);
                    break label;
                }
                x = x + 1;
            }
            System.out.println("found no number");
        }
        // >>>
        //1
        //2
        //3
        //4
        //5
        //found no number

        // 扩展: 一次break多个loop
        multiloop: {
            for (int x=0; x <= 5; x = x+1) {
                System.out.println(x);
                for (int y=10; y <= 15; y = y+1) {
                System.out.println(y);
                if (y == 13) {
                    break multiloop;
                }
                }
            }
        }
        // >>>
        //0
        //10
        //11
        //12
        //13   // 直接break了两重for loop, 跳出multiloop

        // 扩展: 不止是break loop,可以break任何代码块
        code_snippet :{
            int x = 0;
            if (x == 5) {
                System.out.println(x);
            } else if (x == 0) {
                System.out.println(x);
                System.out.println("ABC");
                break code_snippet;

            } else {
                System.out.print("already break");
            }
        }
    }
}


/*
 * Use label to achieve for...else and while...else
 * Use labeled break statement to terminate the outer loop.
 * Label system is designed to use break or continue in multi-loop scenarios
 * See more labeled loop in https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html
 * Also see more in Java 11 language specifcation Section 14.7
 */