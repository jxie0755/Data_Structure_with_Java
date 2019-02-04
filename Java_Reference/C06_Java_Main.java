// 1.5

public class C06_Java_Main {

    // Explanation of main
    // This notation means that the formal parameter, args, is an array of strings
    public static void main(String[] args) {
                            // this means that it references a sequence of string values called
                            // args[0], args[1], args[2], etc....up to args[args.length - 1]
                            // args.length is the number of strings in args

        // Create a function in main:
        System.out.println (Integer.parseInt (args[0]) % Integer.parseInt (args[1]));
    }
}


/*
 * Then run this file in Terminal
 * First: javac C06_Java_Main.java to generate Class file
 * Then:  java C06_Java_Main 10 7    // 10 and 7 will be the two parameter for main function
 * >>> 3  get the remainder of 10 / 7
 */