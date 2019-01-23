package chapter_01;

public class C05_For_Loop {
    public static void main(String[] args) {

        System.out.print("for loop: ");
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
    }
}

/*
 * for loop defines start value, limit, and step
 */