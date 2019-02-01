import java.util.ArrayList;
import java.util.List;   // ArrayList 属于List Class旗下的subclass


public class List_and_Array {
    public static void main(String[] args) {


        // This is to understand the difference between ArrayList and Array
        List<Integer> l1 = new ArrayList(3);   // Initial capacity 只是内存占用,并不影响实际长度
                                                          // 如果没有initialCapacity参数则默认为10
                                                          // tips: 在新建一个ArrayList时可以预估需要的大小,可以避免在使用ArrayList时多次扩容。

        l1.add(5);
        l1.add(6);
        System.out.println(l1);  // >>> [5, 6]
        System.out.println(l1.size());  // >>> 2    not full length

        l1.add(7);
        l1.add(8);    // 虽然起始长度是3, 但是可以随时添加
        l1.add(9);

        System.out.println(l1);  // >>> [5, 6, 7, 8, 9]
        System.out.println(l1.size());  // >>> 5    not full length

        List<String> l2 = new ArrayList(3);   // String list原理完全相同
        System.out.println(l2.ca);

    }
}

/*
 * Array(数组)和List(列表)都属于顺序表。
 * Array是一段连续的存储结构 (类似链表)
    * int[] i=new int[3]
    * i其实记录的是数组的首地址，而i[1]其实相当于在i的地址的基础上加上1个整数的地址偏移，然后再取这块地址中的值。
 * List则是不连续的存储结构,List的每个节点都有着一个Next属性，这个属性则记录着他的下一个节点的地址。
      * 也就是说当我们想找第100个节点的时候，他还是需要从第一个节点，然后做99次Next操作，才能找到list[99]节点。

 * Array必须要在初始化时分配固定的大小
    * 比如说int[] a = new int[3]; 或者 int[] a = new int[]{1,2,3};
    * 如果我们仅仅写int[] a=new int[]; 编译器就会无情地给我们报错。

 * ArryList由于空间不必连续，所以无须指定初始大小,但是它有个initial capacity的概念
    * Java ArrayList do not provide a way to access its current capacity.
    * You can only construct an ArrayList specifying an initial capacity or increase the capacity by calling ensureCapacity().
    * Expanding the capacity of an ArrayList is slow.
        * To avoid this, estimate how many elements are needed and construct an ArrayList of that many plus some extra

    * 总结1： 当不确定大小时，最好使用List代替Array。
    * 总结2： 当需要大量的查找操作时，最好使用Array。
 */
