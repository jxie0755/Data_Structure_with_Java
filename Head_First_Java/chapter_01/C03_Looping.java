package chapter_01;

public class C03_Looping {
    public static void main(String[] args) {
        System.out.print("for loop 1: ");
        for (int x = 0; x < 10; x = x + 1) {
            System.out.print(x);
            // >>> For loop:0123456789
        }

        System.out.println("");
        System.out.print("for loop 2: ");
        for (int x = 0; x < 10; x = x + 1) {
            System.out.print(x); // >>> For loop:0123456789
        // System.out.println("?");  // indentation doesnot impact, because loop defined in {}
            System.out.println("?"); // but to look nice, we use indentation
            // >>>
            //for loop 2: 0?
            //1?
            //2?
            //3?
            //4?
            //5?
            //6?
            //7?
            //8?
            //9?
        }

        System.out.println("");
        System.out.println("while loop");

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
    }
}

/*
 * print command (keep next print/println command at the same as this line)
 * println command (keep next print/println command at a new line)
 * from now on, just use println
 * for loop defines start value, limit, and step
 * while loop is more like python, define indicator outside
 * java中,int和boolean不同, 所以不能while(0)或者while(1)
 */
