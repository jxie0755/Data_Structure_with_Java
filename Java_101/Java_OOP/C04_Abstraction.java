package Java_OOP;

// Learn abstract

abstract class C04_Abstraction {
    String name;

    public C04_Abstraction(String name) {
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
        // C04_Abstraction abs = new  C04_Abstraction("abstract one");
        // System.out.println(abs.show_name());
        // abs.print_name();                     // abstract类无法实例化


        // 通过一个子类的实例就可以实现abstract类的方法和变量
        System.out.println("This is an abstract class's sub-class");
        Sub_Abstraction A_sub = new Sub_Abstraction("ABS");
        System.out.println(A_sub.show_name());   // >>> ABS
        A_sub.print_name();                      // >>> ABS

        System.out.println(A_sub.ABS_method(5));  // >>> 5  abstract method
    }
}


class Sub_Abstraction extends C04_Abstraction {

    // 子类必须也有制造方法
    public Sub_Abstraction(String name) {
        super(name);
    }

    // 子类必须重写全部抽象方法
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
    * 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
    * 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。抽象方法没有定义，方法名后面直接跟一个分号，而不是花括号。
    * 抽象类的子类 !必须! 给出抽象类中的初始化方法和抽象方法的具体实现，除非该子类也是抽象类。
    * 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
 */