package java_reference_chapter_01;

public class C03_Value_Expression {
    public static void main(String[] args) {

        /* Writing Numbers
         * Ordinary integers in Java, for example, are all in the range −2^31 to 2^31−1, or about ±2 billion
         * To get somewhat larger integers, you must use a distinct type of value, known as a long, whose literals have a trailing ‘L’ on them. These give you a range of −2^63 to 2^63−1.
         * To go even further requires one of the built-in library classes (appropriately called java.math.BigInteger), for which there aren’t any built-in literals.
         */

        System.out.println(42); // Base 10
        System.out.println(052); // Base 8 (starts with 0)
        System.out.println(0x2a); // Base 16 (a=10, b=11, ..., f=15)
        // A. All print 42

        System.out.println(31.45);
        System.out.println(3.145e1); // en or En means ×10n
        System.out.println(3145e-2);
        // B. All print 31.45

        System.out.println(12345678901L);  // C. Prints 12345678901


        /* Arithmetic
         * When the two types are mixed, Java first converts the integer quantities to floating point.
         * Float division on zero is Infinity, not Error! Only trigger Error when in integers
         */
        System.out.println ((3 + 7 + 10) * (1000 - 8) / 992 - 17);  // A Prints 3
        System.out.println (2.0 + 1.0/2 + 1.0/6 + 1.0/24 + 1.0/120);  // B Prints 2.7166666666666663
        System.out.println (2 + 1/2 + 1/6 + 1/24 + 1/120);   // C Prints 2
        System.out.println (1 - 2 - 2);        // D Prints -3
        System.out.println (117 % 20);         // E Prints 17
        System.out.println (1.0 / 0.0);        // F Prints Infinity
        System.out.println (2147483647 + 1);   // G Prints -2147483648
        System.out.println (0.0 / 0.0);        // H Prints NaN  (Not a Number)
        //System.out.println (1/0);            // I Halts the program with an exception

        System.out.println(1 / 2.0);  // >>> 0.5 if float is involved output complete float calculation
        System.out.println(1 / 2);    // >>> 0, as 1 // 2 in python

        System.out.println(Float.POSITIVE_INFINITY);  // >>>   Infinity
        System.out.println(Float.NEGATIVE_INFINITY);  // >>>  -Infinity



    }
}





