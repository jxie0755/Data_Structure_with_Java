package chapter_01;

public class C06_Loop_Else {
    public static void main(String[] args) {
        System.out.println("for...else...");
        label: {
            for (int x=0; x <= 5; x = x+1) {
                System.out.println(x);
                if (x == 3) {
                    System.out.print("found ");
                    System.out.println(x);
                    break label;
                }
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
            for (int x=0; x <= 5; x = x+1) {
                System.out.println(x);
                if (x == 6) {
                    System.out.print("found ");
                    System.out.println(x);
                    break label;
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
        label: {
            int x = 0;
            while (x <= 5) {
                System.out.println(x);
                if (x == 3) {
                    System.out.print("found ");
                    System.out.println(x);
                    break label;
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
    }
}


/*
 * Use label to achieve for...else and while...else
 * Need to learn why this label could work in java
 */