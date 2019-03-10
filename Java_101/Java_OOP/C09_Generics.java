package Java_OOP;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class C09_Generics {
    // Java泛型
    // 使用泛型可以使错误在编译时被探测到，从而增加程序的健壮性


    /*
     * bug可分为两种
        * 编译时错误 - 编译时错误在编译时可以发现并排除
        * 运行时错误 - 而运行时错误具有很大的不确定性，在程序运行时才能发现，后果严重
     */


    /*
     * 命名规则
     * 类型参数的命名有一套默认规则，为了提高代码的维护性和可读性，强烈建议遵循这些规则。JDK中，随处可见这些命名规则的应用.
     * E - Element (通常代表集合类中的元素)
     * K - Key
     * V - Value
     * N - Number
     * T - Type
     * S,U,V etc. – 第二个，第三个，第四个类型参数……
     */

    // 同时声明多个变量类型
    // 泛型是JDK 5.0之后才引入的，为了兼容性，允许不指定泛型参数，但是如此一来，编译器就无法进行类型检查，在编程时，最好明确指定泛型参数

}


// 容器box
class Box {
    private Object object;
    // set()方法可以接受任何java对象作为参数

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }

    // 如果不用泛型, 对于generic_box如果要支持多个数据类型, 需要重载方法
    void write(Integer i, Integer[] ia){}
    void write(Double  d, Double[] da){}
    void write(Long l, Long[] la){}
}

class Box_Test {

    public static void main(String[] args) {
        Box box = new Box();
        box.set("abc");                   // 往box里装了一个String
        // Integer a = (Integer)box.get();   // 但是取出来的时候声明取的是Integer, 这里不会报错
                     // 注意这里也是用上了向下转型(但没用if所以不安全)
        // System.out.println(a);  // 从而就制造了一个bug, 因为box里装的不是Integer
    }
}

// 使用泛型来防止这种情况
class Generic_Box<T> {   // 当我们使用该类时会指定T的具体类型，该类型参数可以是类、接口、数组等，但是不能是基本类型
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }

    // 如果使用泛型来做write()就会简单
    <T> void write(T t, T[] ta){}

}

class Generic_Box_Test {

    public static void main(String[] args) {
        Generic_Box<String> g_box = new Generic_Box(); //指定了类型类型为Integer
        g_box.set("abc");
        // Integer a = (Integer)g_box.get();    // 这里直接就会报错,不会隐藏
        String x = g_box.get();    // 而取出时则不必再向下转型成String, 因为制造的时候已经声明了g_box只能装String
        System.out.println(x);  // >>> abc
    }
}



// 泛型的继承
interface Pair<K, V> {
    K getKey();
    V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}

class Pair_test {

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        Pair<String, String> p2 = new OrderedPair<String, String>("hello", "world");

        //也可以将new后面的类型参数省略，简写为：
        Pair<String,Integer> p3 = new OrderedPair<>("Even", 8);

        //也可以在尖括号内使用带有类型变量的类型变量，例如：
        OrderedPair<String, ArrayList<Integer>> p4 = new OrderedPair<>("primes", new ArrayList<>(123));
                                                                                            // |--- 同样可以省略
    }
}


// 同样，在方法中也可是使用泛型参数，并且该参数的使用范围仅限于方法体内
class Util {
    //该方法用于比较两个Pair对象是否相等。
    //泛型参数必须写在方法返回类型boolean之前
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}

class Util_Test {

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        Pair<Integer, String> p2 = new OrderedPair<>(2, "pear");
        Pair<String, String> p3 = new OrderedPair<>("2", "pear");

        // boolean same = Util.<Integer, String>compare(p1, p2);
        //实际上，编译器可以通过Pair当中的类型来推断compare需要使用的类型，所以可以简写为：
        boolean same_1_2 = Util.compare(p1, p2);
        System.out.println(same_1_2);  // >>> false

        // boolean same_2_3= Util. compare(p2, p3);  // 两个Pair泛型不同无法比较
        // System.out.println(same_2_3);  // >>> false
    }
}


// 有时候我们想让类型参数限定在某个范围之内，就需要用到extends关键字（extends后面可以跟一个接口)
// 这里的extends既可以表示继承了某个类，也可以表示实现了某个接口

class Generic_Box_Num<T extends Number> extends Generic_Box {  //类型参数限定为Number的子类

    public void print_class() { System.out.println(this.get().getClass().getName()); }

    public static void main(String[] args) {

        Generic_Box_Num<Integer> box1 = new Generic_Box_Num<Integer>();
        box1.set(123);
        box1.print_class();  // >>> java.lang.Integer

        Generic_Box_Num<Double> box2 = new Generic_Box_Num<Double>();
        box2.set(1.234);
        box2.print_class();  // >>> java.lang.Double

        // Generic_Box_Num<String> box3 = new Generic_Box_Num<String>(new String("abc"));
        //报错，因为String类型不是Number的子类
    }
}


// 泛型类的继承
class Generic_Box_Num_2<T extends Number> {  //类型参数限定为Number的子类
    private ArrayList<T> contents;

    Generic_Box_Num_2(){
        this.contents = new ArrayList<>();
    }

    void add(T t){
        this.contents.add(t);
    }

     void fill(T[] ta){
        for (T t: ta) {
            this.contents.add(t);
        }
    }

    void print_contents(){
        System.out.println(this.contents);
    }

    public static void main(String[] args) {

        Generic_Box_Num_2<Number> box1 = new Generic_Box_Num_2<>();
        Generic_Box_Num_2<Integer> box2 = new Generic_Box_Num_2<>();
        Generic_Box_Num_2<Double> box3 = new Generic_Box_Num_2<>();
        box1.add(123);
        box1.add(456.789);
        box1.print_contents();
        // >>> [123, 456.789]   这里box可以同时支持放入Integer和Double, 因为它们都是Number的子类\
        box1.fill(new Short[]{10,20,30});
        box1.print_contents();  // >>> [123, 456.789, 10, 20, 30]
    }
}


// 类型推断
// 例子
// https://stackoverflow.com/questions/54623214/java-generic-method-not-working-the-parameter-is-not-being-restricted#54623214
class Demo {

    // 静态方法pick()在三个地方使用了泛型，分别限定了两个输入参数的类型与返回类型
    // <T> in method, It defines that T is a generic type and not a defined type named T
    static <T> T pick(T a1, T a2) {
        return a2;
    }

    public static void main(String[] args) {
        //前文已经提到，上面的代码可以简写为：
        Integer ret = Demo.<Integer>pick(1, 2);


        // 那么问题来了，假如两个输入参数为不同的类型，应该返回什么类型呢？
        // 为什么这里, "d"和123被允许代入到pick呢?
        System.out.println(pick("d", 123)); // >>> 123
        // 因为Java会自动做类型推断,找出这两个参数的共有类型
        // 虽然String和Integer看似不相干, 但是总有一个root共有类型,也就是Object
        // The compiler will walk down the inheritance tree of  a1 and a2 to find a common ancestor
        // 所以在这里, <T>就成了Object

        // 延伸:
        Object picked = pick("d", 123); // 可行
        // Integer picked_2 = pick("d", 123); // 不可行, 虽然返回的是Integer,但是必须声明为"d"和123的共有类型

        // 第一个参数为String类型，第二个参数为ArrayList类型
        Serializable x = pick(new String("d"), new ArrayList<Number>());   // 如果不确定共有类型,可以查看Navigate - Type Hierarchy 或者Show Diagram

        // java编译器就会根据这两个参数类型来推断，尽量使返回类型为最明确的一种。
        // 本例中，String与ArrayList都实现了同样的接口——Serializable，当然，他们也是Object的子类，
        // Serializable类型显然比Object类型更加明确，因为它的范围更小更细分，所以最终的返回类型应该为Serializable
    }
}


// 通配符
class Generic_Box_Num_3 extends Generic_Box_Num_2 {

    // 虽然说G_Box_Num_2<T extends Number>可以支持制造Box实例能装Number的各种子类
    // 但是,有一种情况容易误操作, 就是G_Box_Num<Integer>和G_Box_Num<Double>并不是G_Box_Num<Number>的子类
    static void boxTest(Generic_Box_Num_2<Number> n) {
    }
    // 这里形参是Box<Number>, 所以实参必须也是Box<Number>或其子类

    // 上限通配符（upper bounded wildcard）
    static void boxTest_upper(Generic_Box_Num_2<? extends Number> n) {
    }  // 通配符解决问题
    // ? extends Number”就代表可以接受Number以及它的子类作为参数

    // 下限通配符（lower bounded wildcard）
    static void boxTest_lower(Generic_Box_Num_2<? super Integer> n) {
    }  // 通配符解决问题
    // “? super Integer”代表可以接受Integer以及它的父类作为参数 (Number, Object)

    // 无限定通配符（Unbounded Wildcards)
    static void boxTest_infinite(Generic_Box_Num_2<?> n) {
    }


    // 为何使用无限通配符
    public static void printList(List<Object> list) {  // 这要求List必须是Object类,不能是子类
        for (Object elem : list)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static void printList_fix(List<? extends Object> list) {  // 这允许List时任何Object的子类
        for (Object elem : list)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static void printList_inf(List<?> list) {  // 相当于上方,只是写起来简单
        for (Object elem : list)
            System.out.print(elem + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        // Test boxTest
        // boxTest(new Generic_Box_Num_2<Integer>());
        // boxTest(new Generic_Box_Num_2<Double>());

        /*
         * 以上皆出错, 除非 boxTest(new Generic_Box_Num_2<Number>());
         * 虽然Integer和Double都是Number的子类
         * 但是G_Box_Num_2<Integer>与G_Box_Num_2<Double>并不是G_Box_Num_2<Number>的子类，不存在继承关系
         * G_Box_Num_2<Integer>与G_Box_Num_2<Double>的共同父类是Object
         */
        // 那怎么办呢?? 使用通配符 (boxTest_upper and boxTest_lower)
        boxTest_upper(new Generic_Box_Num_2<Integer>());
        boxTest_upper(new Generic_Box_Num_2<Double>());

        boxTest_lower(new Generic_Box_Num_2<Integer>());
        boxTest_lower(new Generic_Box_Num_2<Number>());

        boxTest_infinite(new Generic_Box_Num_2<Integer>());
        boxTest_infinite(new Generic_Box_Num_2<Number>());

        // boxTest_infinite(new Generic_Box_Num_2<Object>());
        // boxTest_lower(new Generic_Box_Num_2<Object>());
        // Object不行因为这里G_Box_Num_2限定了最高只能到Number, 如果类限制是<T>就可以

        /*
         * 通常在两种情况下会使用无限定通配符:
         * 如果正在编写一个方法，可以使用Object类中提供的功能来实现
         * 代码实现的功能与类型参数无关，比如List.clear()与List.size()方法，还有经常使用的Class<?>方法，
         * 或者方法实现的功能与类型参数无关
         */

        List<Object> obj_lst = new ArrayList();
        obj_lst.add("A");
        obj_lst.add("B");
        obj_lst.add("C");

        obj_lst.add(1);
        obj_lst.add(2);
        obj_lst.add(3);
        Generic_Box_Num_3.printList(obj_lst);       // >>> A B C 1 2 3
        Generic_Box_Num_3.printList_inf(obj_lst);   // >>> A B C 1 2 3

        List<String> str_lst = new ArrayList();
        str_lst.add("A");
        str_lst.add("B");
        str_lst.add("C");
        // Generic_Box_Num_3.printList(str_lst);  实现不了
        Generic_Box_Num_3.printList_fix(str_lst); // >>> A B C
        Generic_Box_Num_3.printList_inf(str_lst); // >>> A B C

        // 这招也可以用来申明变量_
        List<? extends Integer> intList = new ArrayList<>();  // 缺省就是<?>不是<Object>
        List<? extends Number> numList = intList;  // 不会报错，
        // List<? extends Integer> 是 List<? extends Number>的子类
    }
}

// 编译器可以通过类型推断机制来决定通配符的类型，这种情况被称为通配符捕获 (类似类型推断)
// 大多时候我们不必担心通配符捕获，除非编译器报出了包含“capture of”的错误

class WildcardScenarios {

    // void foo_error(List<?> i) {
    //     i.set(0, i.get(0));  //会报编译错误, 编译器无法推断i.get(0)是什么类型, 虽然说不论是什么类型,取出来都能放回去
    // }

    // 该方法可以确保编译器通过通配符捕获来推断出参数类型
    void  foo_fix(List<?> i) {  // 不能前置<?>, 借用private方法来处理
        fooHelper(i);
    }

    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }
}

/*
 * 什么时候该使用上限通配符，什么时候该使用下限通配符，应该遵循一下几项指导规则。
 * 首先将变量分为in-变量与out-变量:
     * in-变量持有为当前代码服务的数据
     * out-变量持有其他地方需要使用的数据
        * 例如copy(src, dest)方法实现了从src源头将数据复制到dest目的地的功能，那么src就是in-变量，而dest就是out-变量
        * 当然，在一些情况下，一个变量可能既是in-变量也是out-变量
            * in-变量使用上限通配符
            * out-变量使用下限通配符
            * 当in-变量可以被Object类中的方法访问时，使用无限定通配符
            * 一个变量既是in-变量也是out-变量时，不使用通配符
        * 注意，上面的规则不适用于方法的返回类型
 */


// 类型擦除
/*
 * java编译器在处理泛型的时候，会做下面几件事：
     * （1）将没有限定的类型参数用Object替换，保证class文件中只含有正常的类、接口与方法；
     * （2）在必要的时候进行类型转换，保证类型安全；
     * （3）在泛型的继承上使用桥接方法（bridge methods）保持多态性。
 * 这类操作被称为类型擦除。
 */

class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
    // ...
}

// Node类中的T没有被extends或者super限定，会被编译器替换成Object. 实际变成:
class Node_compiler {

    private Object data;
    private Node next;

    public Node_compiler(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() { return data; }
    // ...
}

// 如果T加了限定，编译器会将它替换成合适的类型

class Node_generics<T extends Comparable<T>> {   //也就是去掉泛型,变成一个普通类

    private T data;
    private Node<T> next;

    public Node_generics(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
    // ...
}

// 改造成:

class Node_generics_compiler {

    private Comparable data;
    private Node next;

    public Node_generics_compiler(Comparable data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() { return data;}
    //...
}


// 类型擦除可能造成意外
class Node_suprise<T> {

    public T data;

    public Node_suprise(T data) { this.data = data; }

    public void setData(T data) {
       System.out.println("Node.setData");
        this.data = data;
    }
}

class MyNode extends Node_suprise<Integer> {

    public MyNode(Integer data) { super(data); }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}

class MyNode_Test {
    public static void main(String[] args) {
        MyNode mn = new MyNode(5);
        Node_suprise n = mn;
        n.setData("Hello");
        Integer x = mn.data;    // 抛出ClassCastException异常

        // MyNode mn = new MyNode(5);
        // Node_suprise n = (MyNode) mn;
        // n.setData("Hello");
        // Integer x = (String) mn.data;   // 抛出ClassCastException异常, 很正常因为类型不match

        /*
         * 我们来看看代码是怎么执行的:
         * （1）n.setData("Hello")调用的其实是MyNode类的setData(Object)方法（从Node类继承的）
         * （2）n引用的对象中的data字段被赋值一个String变量
         * （3）mn引用的相同对象中的data预期为Integer类型（mn为Node<Integer>类型）
         * （4）第四行代码试图将一个String赋值给Integer类型的变量，所以引发了ClassCastException异常
         * 当编译一个继承了带有参数化泛型的类或借口时，编译器会根据需要创建被称为bridge method的桥接方法，这是类型擦除中的一部分
         */
    }
}




// 最后: 注意事项


// 不能用基本类型实例化类型参数
// class Pair<K,V>
// Pair<int, char> p = new Pair<>(8, 'a'); // 编译错误
// Pair<Integer, Character> p = new Pair<>(8, 'a'); // 正确写法


// 不可实例化类型参数
// public static <E> void append(List<E> list) {
//     E elem = new E();  // 编译错误
//     list.add(elem);
// }
// 通过反射实例化带有类型参数的对象
// public static <E> void append(List<E> list, Class<E> cls) throws Exception{
//     E elem = cls.newInstance();   // 正确
//     list.add(elem);
// }
//
// List<String> ls = new ArrayList<>();
// append(ls,String.class);  //传入类型参数的Class对象


// 不能在静态字段上使用泛型
// public class MobileDevice <T> {
//     private static T os;  //假如我们定义了一个带泛型的静态字段
//
//     // ...
// }
//
// MobileDevice<Smartphone> phone = new MobileDevice<>();
// MobileDevice<Pager> pager = new MobileDevice<>();
// MobileDevice<TabletPC> pc = new MobileDevice<>();
// 因为静态变量是类变量，被所有实例共享，此时，静态变量os的真实类型是什么呢？显然不能同时是Smartphone、Pager、TabletPC


// 不能对带有参数化类型的类使用cast或instanceof方法
// public static <E> void rtti(List<E> list) {
//     if (list instanceof ArrayList<Integer>){  // 编译错误
//         // ...
//     }
// }
// 同样，不能将参数转换成一个带参数化类型的对象，除非它的参数化类型为无限定通配符（<?>）
// List<Integer> li = new ArrayList<>();
// List<Number>  ln = (List<Number>) li;  // 编译错误
// 当然，如果编译器知道参数化类型肯定有效，是允许这种转换的:
// List<String> l1 = ...;
// ArrayList<String> l2 = (ArrayList<String>)l1;  // 允许转变，类型参数没变化


// 不能创建带有参数化类型的数组
// List<Integer>[] arrayOfLists = new List<Integer>[2]; // 编译错误
// 下面通过两段代码来解释为什么不行。先来看一个正常的操作:
// Object [] strings = new String[2];
// string s[0] = "hi";   // 插入正常
// string s[1] = 100;    //报错，因为100不是String类型
// 同样的操作，如果使用的是泛型数组，就会出问题:
// Object[] stringLists = new List<String>[]; // 该句代码实际上会报错，但是我们先假定它可以执行
// string Lists[0] =new ArrayList<String>();   // 插入正常
// string Lists[1] =new ArrayList<Integer>();  // 该句代码应该报ArrayStoreException的异常，但是运行环境探测不到


// 不能创建、捕获泛型异常
// 泛型类不能直接或间接继承Throwable类
// class MathException<T> extends Exception { /* ... */ }    //编译错误
// class QueueFullException<T> extends Throwable { /* ... */} // 编译错误
// 方法不能捕获泛型异常:
// public static<T extends Exception, J> void execute(List<J> jobs) {
//     try {
//         for (J job : jobs)
//             // ...
//     } catch (T e) {   // 编译错误
//         // ...
//     }
// }
// 但是，我们可以在throw子句中使用类型参数:
// class Parser<T extends Exception> {
//     public void parse(File file) throws T{     // 正确
//         // ...
//     }
// }


// 不能重载经过类型擦除后形参转化为相同原始类型的方法
// List<String> l1 = new ArrayList<String>();
// List<Integer> l2 = new ArrayList<Integer>();
// System.out.println(l1.getClass()== l2.getClass());   // 竟然是true
// 因为一个泛型类的所有实例在运行时具有相同的运行时类(class)，而不管他们的实际类型参数
// 事实上，泛型之所以叫泛型，就是因为它对所有其可能的类型参数，有同样的行为；同样的类可以被当作许多不同的类型
// class Example {
//     public void print(Set<String> strSet){ }  //编译错误
//     public void print(Set<Integer> intSet) { }  //编译错误
// }
// 因为Set<String>与Set<Integer>本质上属于同一个运行时类，在经过类型擦出以后
// 上面的两个方法会共享一个方法签名，相当于一个方法，所以重载出错