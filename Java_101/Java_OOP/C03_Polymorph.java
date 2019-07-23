package Java_OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

interface Vegetarian_4 {
}

class Animal_4 {
    void animal() {
        System.out.println("I am ANIMAL");
    }
}

class Deer_4 extends Animal_4 implements Vegetarian_4 {
    void deer() {
        System.out.println("I am DEER");
    }
}

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


        // 注意还有这种普遍操作, 利用多态性质通过子类创建父类实例
        Animal_4 AX = new Deer_4();
        // 前例当中d是Deer类实例
        d.deer();   // >>>  I am DEER
        d.animal(); // >>>  I am ANIMAL
        // 此例 AX虽然是new Deer()但是属于Animal的实例
        // AX.deer(); // 则不能运行!! 除非通过转型
        ((Deer_4) AX).deer();  // >>>  I am DEER
        AX.animal();           // >>>  I am ANIMAL
        // 这有什么用?  实际上这种做法很常用, 为了使得代码能够更加灵活, 忽略底层类的
        // 特别是用于interface, 因为interface不能创造实例! 比如:
        List<Object> objList = new ArrayList<>(Arrays.asList(1, 2, 3));
        // 参见C07_Interface
    }
}
