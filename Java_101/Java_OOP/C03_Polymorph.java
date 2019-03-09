package Java_OOP;

public class C03_Polymorph {
    /*
     * 因为Deer类具有多重继承，所以它具有多态性。以上实例解析如下:
         * 一个 Deer IS-A（是一个） Animal_4
         * 一个 Deer IS-A（是一个） Vegetarian_4
         * 一个 Deer IS-A（是一个） Deer_4
         * 一个 Deer IS-A（是一个） Object
     */
}


// 多态是同一个行为具有多个不同表现形式或形态的能力。

interface Vegetarian_4{}
class Animal_4{}
class Deer_4 extends Animal_4 implements Vegetarian_4{}

class test {
    public static void main(String[] args) {
        Deer_4 DD4 = new Deer_4();
        System.out.println(DD4 instanceof Deer_4);         // >>> true
        System.out.println(DD4 instanceof Vegetarian_4);   // >>> true
        System.out.println(DD4 instanceof Animal_4);       // >>> true
        System.out.println(DD4 instanceof Object);         // >>> true


        // 当我们将引用型变量应用于Deer对象的引用时，下面的声明是合法的
        Deer_4 d = new Deer_4();
        Animal_4 a = d;
        Vegetarian_4 v = d;
        Object o = d;
        // 因为Deer_4被三类所包容

        // 但是如果这样
        Animal_4 A4 = new Animal_4();
        // Deer_4 D4 = A4;  // 就不行, 必须是父类引用子类的对象

    }
}


