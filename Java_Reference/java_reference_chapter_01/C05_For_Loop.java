package java_reference_chapter_01;

public class C05_For_Loop {
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
    }
}

/*
 * for loop defines start value, limit, and step
 * break work the same way as python
 */