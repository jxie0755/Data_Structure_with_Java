package W3C_Java_Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;  // Array并不是列表
import java.util.List;


public class A07_Arrays {

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
        int[] A;
        // System.out.println(A);  Not initialized, only created a null point (linked list)
        A = new int[]{1, 2, 3};   // 必须填充一些内容或者给出长度
        System.out.println(A);  // >>> [I@1e643faf   // Does not print_class out A
        System.out.println(A.length);  // >>> 3

        System.out.println(A[0]);            // >>> 1
        System.out.println(A[1]);            // >>> 1
        System.out.println(A[A.length-1]);   // >>> 1
        // System.out.println(A[-1]);            // negative index is not allowed in java as in python


        A = new int[100];  // this create a new int list of length at 100
        System.out.println(A.length);  // >>> 100

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

        // int T[] = new int[3]{1,2,3};
        // Error:(57, 29) java: array creation with both dimension expression and initialization is illegal

        int T[] = new int[]{1,2,3};  // This expression will also work
        System.out.println(T[1]);  // >>> 2


        /*
         * 在计算机语言中数组是非常重要的集合类型， 大部分计算机语言中数组具有如下三个基本特性：
             * 01. 一致性： 数组只能保存相同数据类型元素， 元素的数据类型可以是任何相同的数据类型。
             * 02. 有序性： 数组中的元素是有序的， 通过下标访问。
             * 03. 不可变性： 数组一旦初始化， 则长度（数组中元素的个数） 不可变

         * Java中数组的下标是从零开始
         * Java中的数组本身是引用数据类型， 它的长度属性是length
         * 数组可以分为： 一维数组和多维数组
         * 数组声明完成后， 数组的长度还不能确定， JVM（Java虚拟机） 还没有给元素分配内存空间
         */

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
            System.out.println(i);
        }
        // >>>
        // false
        // false
        // false

        boolean[] b2 = new boolean[3];
        Arrays.fill(b2, true);
        for (boolean k: b2) {
            System.out.println(i);
        }
        // >>>
        // true
        // true
        // true
    }
}

// Print Array?
class Arrays_toString {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4};
        System.out.println(intArray);  // >>> [I@1e643faf   // don't use this
        for (int i = 0; i <= 5; i += 1) {
            intArray[1] = i * 7;
        }
        // Use toString method to print
        System.out.println(java.util.Arrays.toString(intArray)); // >>> [1, 35, 3, 4]
        System.out.println(Arrays.toString(intArray));           // >>> [1, 35, 3, 4]

    }
}

// Arrays方法
// 筛选一些重要的方法来学

class Arrays_asList {

    public static void main(String[] args) {
        // 学习怎么使用Arrays.asList
        // https://www.jianshu.com/p/2b113f487e5e

        // List 是一种很有用的数据结构，如果需要将一个数组转换为 List 以便进行更丰富的操作的话
        String strArray1[] = {"A", "B", "C"};
        List<String> strList2 = Arrays.asList(strArray1);  // >>> [A, B, C]

        // 但是如果类型是基本类型(int, char, etc...)
        int intArray1[] = {21,32,43,45};
        // List<Integer> intList2 = Arrays.asList(intArray1);  // 就不行!!
        // 这个错误产生的原因可解释为：asList 方法的参数必须是对象或者对象数组，而原生数据类型不是对象
        // 如果需要将一个整型数组转换为 List，那么就将数组的类型声明为 Integer 而不是 int
        Integer intArray2[] = {21,32,43,45};
        List<Integer> intList2 = Arrays.asList(intArray2);  // >>>  [21, 32, 43, 45]

        // 此List不可更改长度, 文档说说明了:
        // Returns a fixed-size list backed by the specified array
        // intList2.add(99);  // 而且只有在编译时报错, IDE不能提前发现!
        // asList 方法返回的确实是一个 ArrayList ,但这个 ArrayList 并不是 java.util.ArrayList ，
        // 而是 java.util.Arrays 的一个内部类
        // 解决方案, 使用真正的ListArray
        List<Integer> intList2b = new ArrayList<Integer>(Arrays.asList(intArray2));
        // 这里相当于二次转换, 先转换成一个假的ArrayList,然后再造一个真的Arraylist把假的arraylist代入进去
        // 可能还不如手动写一个直接转换的来的方便
        intList2b.add(99);
        System.out.println(intList2b); // >>> [21, 32, 43, 45, 99]
    }
}

class Arrays_deepMethods {

    public static void main(String[] args) {
        // 用于多维数组

        // deepEquals​(Object[] a1, Object[] a2)
        // Returns true if the two specified arrays are deeply equal to one another.
        int[][] A = {
                {1, 3, 5, 7},    // 0
                {2, 5, 8, 11},   // 1
                {3, 7, 11, 15},  // 2
                //0  1  2   3
        };

        int[][] B = {
                {1, 3, 5, 7},    // 0
                {2, 5, 8, 11},   // 1
                {3, 7, 11, 16},  // 2
                //0  1  2   3
        };
        System.out.println(Arrays.deepEquals(A, B)); // >>>  false

        // 	deepToString​(Object[] a)
        System.out.println(Arrays.deepToString(B));
        // >>>  [[1, 3, 5, 7], [2, 5, 8, 11], [3, 7, 11, 16]]
    }
}


class Arrays_equals {

    public static void main(String[] args) {

        // Equality

        // 	equals​(int[] a, int[] a2)
        // 	equals​(int[] a, int aFromIndex, int aToIndex, int[] b, int bFromIndex, int bToIndex)

        int[] intArray1 = {1, 2,3,4, 5,6};
        //                 0  1 2 3  4 5
        int[] intArray2 = {0,0, 2,3,4, 7};
        //                 0 1  2 3 4  5

        System.out.println(Arrays.equals(intArray1, intArray2)); // >>>  false
        System.out.println(Arrays.equals(intArray1, 1, 4,
                                         intArray2, 2, 5)); // >>>  true
    }
}


class Arrays_fill {

    public static void main(String[] args) {

        // fill values in Arrays

        // 	fill​(int[] a, int val)
        // 	fill​(int[] a, int fromIndex, int toIndex, int val)   // 局部填充

        int[] intArray1 = new int[5];
        Arrays.fill(intArray1, 9);
        System.out.println(Arrays.toString(intArray1)); // >>>  [9, 9, 9, 9, 9]
        // 可以重复fill, 反正就是全改
        Arrays.fill(intArray1, 8);
        System.out.println(Arrays.toString(intArray1)); // >>>  [8, 8, 8, 8, 8]

        int[] intArray2 = new int[5];
        Arrays.fill(intArray2, 0, 2, 3);
        System.out.println(Arrays.toString(intArray2));  // >>>  [3, 3, 0, 0, 0]
        Arrays.fill(intArray2, 1, 4, 9);
        System.out.println(Arrays.toString(intArray2));  // >>>  [3, 9, 9, 9, 0]
    }
}


class Arrays_copyOf {

    public static void main(String[] args) {

        // 相当于切片slice了, 但是换了一种形式
        // copyOf​(int[] original, int newLength)
        int[] intArray4 = {1,2,3,4,5,6};
        int[] intArray5 = Arrays.copyOf(intArray4,3); // 小于原长度
        System.out.println(Arrays.toString(intArray5)); // >>>  [1, 2, 3]
        int[] intArray6 = Arrays.copyOf(intArray4,10); // 大于原长度, 填充默认值
        System.out.println(Arrays.toString(intArray6)); // >>>  [1, 2, 3, 4, 5, 6, 0, 0, 0, 0]

        int[] intArray_copy = Arrays.copyOf(intArray4, intArray4.length);
        System.out.println("Copy: " + Arrays.toString(intArray_copy));
        intArray_copy[3] = 99;
        System.out.println("Copy: " + Arrays.toString(intArray_copy));  // Copy: [1, 2, 3, 99, 5, 6]
        System.out.println("Original: " + Arrays.toString(intArray4));  // Original: [1, 2, 3, 4, 5, 6]


        // copyOfRange​(int[] original, int from, int to)
        int[] intArray7 = Arrays.copyOfRange(intArray4,1, 5); // 从index1开始,长度为4
        System.out.println(Arrays.toString(intArray7)); // >>>  [2, 3, 4, 5]
    }
}


class Arrays_sort {

    public static void main(String[] args) {

        // 并行排序算法
        // parallelSort​(int[] a)
        // parallelSort​(int[] a, int fromIndex, int toIndex)
        // Sorts the specified range of the array into ascending numerical order.
        int[] iA6 = {2,3,1,5,4,0};
        Arrays.parallelSort(iA6);
        System.out.println(Arrays.toString(iA6)); // >>> [0, 1, 2, 3, 4, 5]
        char[] cA6 = {'z','n','l','m','6','a'};
        Arrays.parallelSort(cA6, 1, 5);
        System.out.println(Arrays.toString(cA6)); // >>> [z, 6, l, m, n, a]

        // 为串行排序
        // sort​(int[] a)
        // sort​(int[] a, int fromIndex, int toIndex)
        int[] iA7 = {2,3,1,5,4,0};
        Arrays.sort(iA7);
        System.out.println(Arrays.toString(iA7)); // >>> [0, 1, 2, 3, 4, 5]
        char[] cA7 = {'z','n','l','m','6','a'};
        Arrays.sort(cA7, 1, 5);
        System.out.println(Arrays.toString(cA7)); // >>> [z, 6, l, m, n, a]

        // 以上两者用法完全相同,结果也完全相同
        // 当数据规模达到很大时，并行排序的性能要超过串行排序

    }
}

class Arrays_zMethods {

    public static void main(String[] args) {

        // 大多数方法都被重载给了所有基本类型, 这里只用int[]举例

        // binarySearch
        // The array must be sorted (as by the sort(int[]) method) prior to making this call.
        // If it is not sorted, the results are undefined.

        int[] intArray1 = {1,2,3,4,5,6};
        // return index of the search key, if it is contained in the array;
        System.out.println(Arrays.binarySearch(intArray1, 4));  // >>>  3  // index 3
        // return:  otherwise, (-(insertion point) - 1)
        int[] intArray2 = {1,3,5,6};
        System.out.println(Arrays.binarySearch(intArray2, 4));
        // >>>  4应该在 index 2, 所以返回 -2-1 = -3

        // If the array contains multiple elements with the specified value,
        // there is no guarantee which one will be found
        int[] intArray3 = {1,3,3,3,3,3,3,4,5,6};
        System.out.println(Arrays.binarySearch(intArray3, 3)); // >>> 4,  肯定是对的,但是没法判断它会给哪个index


        // hashCode​(int[] a)
        int hc = Arrays.hashCode(intArray1);
        System.out.println(hc); // >>>  918073252


        // mismatch​(int[] a, int[] b)
        // mismatch​(int[] a, int aFromIndex, int aToIndex, int[] b, int bFromIndex, int bToIndex)
        // Finds and returns the relative index of the first mismatch
        // between two int arrays over the specified ranges,
        // otherwise return -1 if no mismatch is found.
        int[] iA1 = {1,2,3,4,5,6};
        //           0 1 2 3 4 5
        int[] iA2 = {1,2,3,5,6,7};
        //           0 1 2 3 4 5
        int[] iA3 = {1,2,3,5,6,7};
        //           0 1 2 3 4 5
        int[] iA4 = {2,3,5,6,7,8};
        //           0 1 2 3 4 5
        int[] iA5 = {1,2,3,5,6,7,8};
        //           0 1 2 3 4 5,6

        System.out.println(Arrays.mismatch(iA1, iA2)); // >>> 3 (index 3的时候出现不同)
        System.out.println(Arrays.mismatch(iA2, iA3)); // >>> -1 (完全相同)

        System.out.println(Arrays.mismatch(iA3, 1, iA3.length, iA4, 0, iA4.length));
        // >>> 5  (iA4 在index5还有数8, iA3从1开始,所以已经完结)

        System.out.println(Arrays.mismatch(iA5, 1, iA5.length, iA4, 0, iA4.length));
        // >>> -1  (iA5 从index1开始的话,和iA4一模一样)

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


class Arrays_Grid {
    public static void main(String[] args) {

        // 声明形式:
        int[][] arrayX;
        int arrayY[];
        int[] arrayZ[];

        // two dimentional grid
        int[][] A = {
                {1, 3, 5, 7},    // 0
                {2, 5, 8, 11},   // 1
                {3, 7, 11, 15},  // 2
                //0  1  2   3
        };

        System.out.println(A[1][2]);  // >>> 8  第1行第2个
    }

    // Build a Pascal Triangle
    // https://stackoverflow.com/questions/54482724/java-pascal-triangle-initialization-question
    public static int[][] Pascal(int N) {

        // 动态初始化不规则数组比较麻烦， 不能使用new int[X][Y]语句， 而是先初始化高维数组， 然后再分别逐个初始化低维数组
        int[][] result = new int[N][];  // Create array of N initially null rows.
                                        // Does not need length for sub arrays
        // Because result is an [] of int[], so we only statement one length of the big array

        for (int i = 0; i < N; i += 1) {

            result[i] = new int[i + 1];       // Build an empty row with length
            result[i][0] = result[i][i] = 1;  // The ends of the row are 1.

            for (int j = 1; j < i; j += 1)
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];  // 上一行相邻两数相加
        }
        return result;
    }
}

