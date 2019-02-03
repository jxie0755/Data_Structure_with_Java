package W3C_basic;

// Learn abstract

abstract class C05_OOP_Abstract {
    String name;

    public C05_OOP_Abstract (String name) {
        this.name = name;
    }


    String show_name() {
        return this.name;
    }

    void print_name() {
        System.out.println(this.name);
    }

    // abstract方法
    public abstract int ABS_method(int i);

    public static void main(String[] args) {

        System.out.println("This is an abstract class");
        // C05_OOP_Abstract abs = new  C05_OOP_Abstract("abstract one");
        // System.out.println(abs.show_name());
        // abs.print_name();                     // abstract类无法实例化


        // 通过一个子类的实例就可以实现abstract类的方法和变量
        System.out.println("This is an abstract class's sub-class");
        Sub_Abstract A_sub = new Sub_Abstract("ABS");
        System.out.println(A_sub.show_name());   // >>> ABS
        A_sub.print_name();                      // >>> ABS

        System.out.println(A_sub.ABS_method(5));  // >>> 5  abstract method
    }
}


class Sub_Abstract extends C05_OOP_Abstract {

    public Sub_Abstract (String name) {
        super(name);
    }

    public int ABS_method (int i) {
        return i;
    }
}


/*
 * abstract类
     * 在面向对象的概念中，所有的对象都是通过类来描绘的，但是反过来，并不是所有的类都是用来描绘对象的，如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。
     * 抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。
     * 由于抽象类不能实例化对象，所以抽象类必须被继承，才能被使用。也是因为这个原因，通常在设计阶段决定要不要设计抽象类。
     * 父类包含了子类集合的常见的方法，但是由于父类本身是抽象的，所以不能使用这些方法。
     * 在Java中抽象类表示的是一种继承关系，一个类只能继承一个抽象类，而一个类却可以实现多个接口。
 * abstract 方法
    * 如果你想设计这样一个类，该类包含一个特别的成员方法，该方法的具体实现由它的子类确定，那么你可以在父类中声明该方法为抽象方法。
    * Abstract 关键字同样可以用来声明抽象方法，抽象方法只包含一个方法名，而没有方法体。
    * 抽象方法没有定义，方法名后面直接跟一个分号，而不是花括号。
 */