package zsnippets;

import java.util.ArrayList;
import java.util.List;

public class List_and_ArrayList {

    public static void main(String[] args) {
        /*
         * List是一个接口，而ListArray是一个类。
            * ListArray继承并实现了List。 \
            * 所以List不能被构造，但可以向上面那样为List创建一个引用，而ListArray就可以被构造。
         */

        // List<Object> list;     //正确   list=null;
        // List<Object> list2=new List();    //   是错误的用法



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

        /*
         * 如果 List a=new ArrayList();
            * 则a拥有List与ArrayList的所有属性和方法，不会减少
            * 如果List与ArrayList中有相同的属性（如int i),    则a.i是调用了   !!!!!父类!!!!! List中的i
            * 如果List与ArrayList中有相同的方法（如void f()), 则a.f()是调用了 !!!!!子类!!!!! ArrayList中的f()
                * 注意这个python的OOP思想不同!!!
                * 这是因为python没有泛型, 没有办法规定一个实例是父类, 但是通过子类来实例来实现
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
    }
}

// 以下是更清晰的继承与多态的方法和属性演示:
class Father {
    int i;
    public Father (){
        this.i = 0;
    }

    public void foo(int n) {
        System.out.print("from Father foo" );
        System.out.println(n);
    }
}

class Child1 extends Father {
    int i;
    public Child1 (){
        this.i = 1;
    }

    public void foo(int n) {
        System.out.print("from Child foo 111 ");
        System.out.println(n+1);
    }

    public void bar(int n) {
        System.out.print("from Child bar 11111111 ");
        System.out.println(n+1);
    }
}

class Child2 extends Father {
    int i;
    public Child2 (){
        this.i = 2;
    }

    public void foo(int n) {
        System.out.print("from Child foo 222 ");
        System.out.println(n+2);
    }

    public void bar(int n) {
        System.out.print("from Child bar 22222222 ");
        System.out.println(n+2);
    }
}

class Testttt {

    public static void main(String[] args) {
        Child1 C1 = new Child1();
        Child2 C2 = new Child2();

        Father F1 = new Child1();
        Father F2 = new Child2();

        // 各自继承自己的属性, 没有问题
        System.out.println(C1.i); // >>> 1
        System.out.println(C2.i); // >>> 2
        System.out.println(F1.i); // >>> 0     // 注意这里属性跟随的居然是父类的属性
        System.out.println(F2.i); // >>> 0     // 注意这里属性跟随的居然是父类的属性

        C1.foo(5); // >>> from Child foo 111 6
        C1.bar(5); // >>> from Child bar 11111111 6

        C2.foo(5); // >>> from Child foo 222 7
        C2.bar(5); // >>> from Child bar 22222222 7

        F1.foo(5); // >>>  from Child foo 111 6 // 顺利的继承了Child1的方法
        // F1.bar(5); // F1没有bar, 因为Father 没有Bar(), 虽然new Child1()有
        // 通过转型来运行bar
        ((Child1) F1).bar(5);  // >>> from Child bar 11111111 6
        // ((Child1) F2).bar(5);  // 不行, 虽然有方法同名

        F2.foo(5); // >>>  from Child foo 222 7  // 顺利的继承了Child1的方法
        // F2.bar(5); // F2也没有bar, 因为Father 没有Bar(), 虽然new Child2()有
        // 通过转型来运行bar
        ((Child2) F2).bar(5);  // >>> from Child bar 22222222 7

        Father F1b = new Child1();
        System.out.println(F1b.i);  // >>> 0
        F1b.foo(8);              // >>> from Child 111 9

        // Father F1b = new Child2();   若原地改
        // System.out.println(F1b.i);    // >>> 0
        // F1b.foo(8);                   // >>> from Child 222 10  // 可以直接换Child2的方法
    }
}