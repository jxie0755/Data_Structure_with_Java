package W3C_Java_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 这里是对Arrays操作的static方法,不是这个类的定义
public class A07b_java_util_Arrays {

    public static void main(String[] args) {

        // 大多数方法都被重载给了所有基本类型, 这里只用int[]举例
        // 重要的方法在后面独立出来总结

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



// 重要的的Arrays static方法
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



// java.util.Arrays方法, 不是Array
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


        // 那么copyOf到底是浅copy还是深copy呢? 是浅Copy
        // java没有自带的deepcopy,只能自己写,用for loop就可以了 (省略)
        System.out.println("\nCopy test, grid: ");
        int[] iA1 = {1,3,5,7,9};
        int[] iA2 = {0,2,4,6,8};
        int[] iA3 = {9,9,9,9,9};

        int[][] grid = {iA1,iA2,iA3};
        for (int[] i: grid) {
            System.out.println(Arrays.toString(i));
        }
        // >>>
        // [1, 3, 5, 7, 9]
        // [0, 2, 4, 6, 8]
        // [9, 9, 9, 9, 9]

        System.out.println("Copy of grid");
        int[][] grid_copy = Arrays.copyOf(grid, 3);
        for (int[] i: grid_copy) {
            System.out.println(Arrays.toString(i));
        }
        // >>>
        // [1, 3, 5, 7, 9]
        // [0, 2, 4, 6, 8]
        // [9, 9, 9, 9, 9]

        System.out.println("revise iArray, now grid is: ");

        iA1[0] = 999;
        iA2[1] = 999;
        iA3[4] = 0;
        for (int[] i: grid) {
            System.out.println(Arrays.toString(i));
        }
        // >>>
        // [999, 3, 5, 7, 9]
        // [0, 999, 4, 6, 8]
        // [9, 9, 9, 9, 0]

        System.out.println("Copy of grid: ");
        for (int[] i: grid_copy) {
            System.out.println(Arrays.toString(i));
        }
        // >>>
        // [999, 3, 5, 7, 9]
        // [0, 999, 4, 6, 8]
        // [9, 9, 9, 9, 0]
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