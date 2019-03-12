package W3C_Java_Classes;


import java.lang.reflect.Array;
import java.util.Arrays;

// Array的构造方法, 是在java.lang.reflect.Array
public class A07_Array {

    /*
     * Module java.base
     * Package java.lang.reflect
     * Class Array

     * 在计算机语言中数组是非常重要的集合类型， 大部分计算机语言中数组具有如下三个基本特性：
         * 01. 一致性： 数组只能保存相同数据类型元素， 元素的数据类型可以是任何相同的数据类型。
         * 02. 有序性： 数组中的元素是有序的， 通过下标访问。
         * 03. 不可变性： 数组一旦初始化， 则长度（数组中元素的个数） 不可变

     * Java中数组的下标是从零开始
     * Java中的数组本身是引用数据类型， 它的长度属性是length
     * 数组可以分为： 一维数组和多维数组
     * 数组声明完成后， 数组的长度还不能确定， JVM（Java虚拟机） 还没有给元素分配内存空间
     */

    public static void main(String[] args) {

        // 构造方法
        int[] A;
        // System.out.println(A);  Not initialized, only created a null point (linked list)
        A = new int[]{1, 2, 3};   // 必须填充一些内容或者给出长度
        A = new int[100];  // this create a new int list of length at 100
        int Tarray[] = new int[]{1,2,3};  // This expression will also work
        System.out.println(Tarray[1]);  // >>> 2
        // int T[] = new int[3]{1,2,3};
        // Error:(57, 29) java: array creation with both dimension expression and initialization is illegal

        // direct call elements
        System.out.println(A[0]);            // >>> 1
        System.out.println(A[1]);            // >>> 1
        System.out.println(A[A.length-1]);   // >>> 1
        // System.out.println(A[-1]);            // negative index is not allowed in java as in python

        // length
        System.out.println(A.length);  // >>> 100

        // Print Array?
        System.out.println(A);  // >>> [I@1e643faf   // Does not print_class out A
        // 参见A07b Arrays_toString

        // 一维数组
        //静态初始化int数组,声明同时初始化数组
        int intArray1[] = {21,32,43,45};
        String strArray1[] = {"A", "B", "C"};
        char[] chaArray = new char[5];
        char cc1 = chaArray[0];
        char cc2 = '\u0000';
        System.out.println(cc1 == cc2); // >>> true   // '\u0000' 是 null字符,长度为1, 不是空格, 也不是''空字符

        // 动态初始化int数组
        int intArray2[];
        intArray2 = new int[4];  // 此时已经预填充了默认数值,int[]填充的是0, 参见java数组默认值table
        // 随后再改动
        intArray2[0] = 21;
        intArray2[1] = 32;
        intArray2[2] = 43;
        intArray2[3] = 45;

        // boolean Arrays
        boolean[] b1 = new boolean[3];  // Initiation is always filled wilth false
        for (boolean j: b1) {
            System.out.println(j);
        }
        // >>>
        // false
        // false
        // false


        // get方法
        // getLength
        int intArray3[] = {21,32,43,45};
        System.out.println(Array.getLength(intArray3));     // >>> 4
        // get
        System.out.println(Array.get(intArray3, 2));  // >>>  43
        // getBoolean和get基本类型
        // System.out.println(Array.getBoolean(intArray3, 2)); 必须作用于Boolean数组或者boolean数组
        System.out.println(Array.getBoolean(b1, 1)); // >>> false

        // set方法
        Array.set(intArray3,0, 99);
        System.out.println(Arrays.toString(intArray3));  // >>> [99, 32, 43, 45]
        // set也有专门针对各种其他基本类型的方法比如setBoolean等等
    }
}


// 引用数据
// 这里需要注意的是引用类型数组， 每一个元素保存都是指向实际对象的内存地址
class BoxedArrays {

    public static void main(String[] args) {
        String a = "ABC";
        String b = "DEF";
        String c = "GHI";

        String[] strArray = new String[]{a, b, c};
        System.out.println(Arrays.toString(strArray));  // >>>  [ABC, DEF, GHI]

        // 若此时改变a
        a = "XXX";
        System.out.println(Arrays.toString(strArray));  // >>> [ABC, DEF, GHI]
        // 这里a虽然变了,但是由于String是不可变类型,所以a指向了另一个内存地址中的"XXX",并没有改变strArray通过一开始a指向的那个String.
        // 所以a变了不会导致strArray变了

        // 若是可变类型的数组 (二维数组), 就会出现数组元素变化导致数组变化
        int[] aa = new int[]{1,3,5,7};
        int[] bb = new int[]{2,5,8,11};
        int[] cc = new int[]{3,7,11,15};

        int[][] A = {aa,bb, cc};

        // 打印grid
        for (int i=0; i<3; i+=1) {
            System.out.println(Arrays.toString(A[i]));
            // >>>
            // [1, 3, 5, 7]
            // [2, 5, 8, 11]
            // [3, 7, 11, 15]
        }

        // 此时A中的aa不是全新的数组而是aa本身指向的那个数组
        aa[0] = 123;
        bb[1] = 99;
        // 若是改变aa,则同样会改变A中的aa

        for (int i=0; i<3; i+=1) {
            System.out.println(Arrays.toString(A[i]));
            // >>>
            // [123, 3, 5, 7]
            // [2, 99, 8, 11]
            // [3, 7, 11, 15]
        }
    }
}



class Array_Application {
    // Practice of finding primes with The Sieve of Eratosthenes
    /** Returns an array, p, of size N+1 such that p[k] is true iff
      * k is a prime. */
    public static boolean[] primes (int n) {
        boolean[] prime_sieve = new boolean[n + 1];  // a list of boolean length at n+1, initialized list will be all false!
        // All entries are initially true.
        Arrays.fill(prime_sieve, true);
        prime_sieve[0] = prime_sieve[1] = false;
        for (int k = 2; k * k <= n; k += 1) {
            for (int j = k * k; j <= n; j += k) {
                prime_sieve[j] = false;
            }
        }
        return prime_sieve;
    }

    public static void main(String[] args) {
        boolean[] S = primes(20);
        int i = 0;
        while (i != S.length) {
            if (S[i]) {
                System.out.println(i);
            }
            i += 1;
        }
        // >>>
        // 2
        // 3
        // 5
        // 7
        // 11
        // 13
        // 17
        // 19
    }
}