package java_reference;// 1.3.5

public class C04_Static_Methods {
    /*
     * Methods
     * static methods (also called class methods)
     * non-static method (or instance methods)
     */

    /** Return the square of x */
    static int square_1 (int x) {
        return x * x;
    }

    public static void main(String[] args) {
        System.out.println(square_1(5));
    }

}


/*

A static Tr N (T1 N1, T2 N2, ...) {
    B
}

T: type of returned value and parameters
N: Name
A: public, private, protected or simply missing (as the default)
B: Body of the method

use of javadoc \/** Return the square of x *\/

 */


/*
 * 在java中我们使用private、protected、public和default来控制类中属性和函数的访问：
               类内部    本包    子类    外部包
    public       √       √      √       √
    protected    √       √      √       ×
    default	     √       √      ×       ×
    private	     √       ×      ×       ×
 */
