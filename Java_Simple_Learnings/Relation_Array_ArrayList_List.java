import java.util.ArrayList;
import java.util.List;


public class Relation_Array_ArrayList_List {

}

class Array_and_ArrayList {

    public static void main(String[] args) {

        // Array and ArrayList
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

 * Addtional: 在JKD1.6中实现是，如果通过无参构造的话，初始数组容量为10，每次通过copeOf的方式扩容后容量为原来的1.5倍
 */


class List_and_ArrayList {

    /*
     * 如果 List a=new ArrayList();
     * 则a拥有List与ArrayList的所有属性和方法，不会减少
     * 但是a没有ArrayList独有的,而List没有的方法
     */

    /*
     * 为什么要用 List list = new ArrayList() ,而不用 ArrayList alist = new ArrayList()呢？
     * 问题就在于List有多个实现类，现在你用的是ArrayList，也许哪一天你需要换成其它的实现类，
     * 如 LinkedList或者Vector等等，这时你只要改变这一行就行了:
     * List list = new LinkedList(); 其它使用了list地方的代码根本不需要改动
     * 理解: List作为父类, 它可以接受各种其他子类和它共有的方法, 这个优势如果建立ArrayList就没有.
     * 假设你开始用 ArrayList alist = new ArrayList(), 这下你有的改了，特别是如果你使用了 ArrayList特有的方法和属性

     * 所以这个事是各有利弊:
     * 用List = 就更通用,但是不能使用子类的独特特性, (但是可以通过转型来弥补这一缺陷!, 所以这样写更优!)
     * 用ArrayList = 就专注于ArrayList的独特特性, 但是不好换型 (而且无法转型)
     */

    public static void main(String[] args) {
        /*
         * List是一个接口，而ListArray是一个类。
         * ListArray继承并实现了List。
         * 所以List不能被构造，但可以向上面那样为List创建一个引用，而ListArray就可以被构造。
         */

        // List<Object> list;     //正确   list=null;
        // List<Object> list2= new List();    //   是错误的用法 List是接口无法被实例化


        /*
         * 创建List还是ArrayList?

         * List list<Object> = new ArrayList();
         * 这句创建了一个ArrayList的对象后把上溯到了List
         * 此时它是一个List对象了
         * 它只支持List的方法, (但是有些List的方法ArrayList也有,这部分它是支持的, (多态))
         * 但是也有一部分ArrayList独有的方法, 它就不会支持了

         * ArrayList<Object> list=new ArrayList();
         * 创建一对象则保留了ArrayList的所有属性
         */
        List list = new ArrayList();
        ArrayList arrayList = new ArrayList();
        // list.trimToSize(); //错误，没有该方法。
        arrayList.trimToSize();   //ArrayList里有该方法。
    }
}
