package W3C_Java_Advaned_OOP;

import java.util.ArrayList;

public class C11_Generics {
}

// Java泛型
// 使用泛型可以使错误在编译时被探测到，从而增加程序的健壮性

/*
 * bug可分为两种
    * 编译时错误 - 编译时错误在编译时可以发现并排除
    * 运行时错误 - 而运行时错误具有很大的不确定性，在程序运行时才能发现，后果严重
 */


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

interface Pair<K, V> {
    public K getKey();
    public V getValue();
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
        boolean same_1_2= Util. compare(p1, p2);
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

    // 但是,有一种情况容易误操作
    void boxTest(Generic_Box_Num_2<Number> n) { }
    // 这里形参是Box<Number>, 所以实参必须也是Box<Number>或其子类

    public static void main(String[] args) {

        Generic_Box_Num_2<Number> box1 = new Generic_Box_Num_2<>();
        box1.add(123);
        box1.add(456.789);
        box1.print_contents();
        // >>> [123, 456.789]   这里box可以同时支持放入Integer和Double, 因为它们都是Number的子类\

        // Test boxTest
        // boxTest(Box<Integer>);
        // boxTest(Box<Double>);
        /*
         * 以上皆出错, 因为:
             * 虽然Integer和Double都是Number的子类
             * 但是Box<Integer>与Box<Double>并不是Box<Number>的子类，不存在继承关系
             * Box<Integer>与Box<Double>的共同父类是Object
         */

        box1.fill(new Short[]{10,20,30});
        box1.print_contents();  // >>> [123, 456.789, 10, 20, 30]
    }
}


// 类型推断