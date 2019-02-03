package W3C_basic;

import java_reference_chapter_01.C07_Primes;

public class C04_OOP_Dog {

    // 类变量其实也是init的一部分
    String name;
    String breed;
    String color = "White";  // 初始化的时候直接用这里的值作为默认
    int age;  // 若不说默认则为0

    // Initialization  等同于python __init__, 但是如果创立时不需要特别指定参数,可以不写
    public C04_OOP_Dog(String name){
        this.name = name;
        System.out.println("Dog " + name + " is created");
    }

    // 三个方法
    void barking(){
        System.out.println(this.name + ": Woo Woo!");
    }

    void hungry(){
        this.barking();  // 用this来指该实例
        System.out.println("I am hungry!");
    }

    public void printinfo(){
       System.out.println("Name: " + this.name);
       System.out.println("Age: " + this.age);
       System.out.println("Breed: " + this.breed);
       System.out.println("Color: " + this.color);
   }

    // set and get
    public void setAge (int new_age) {
        age = new_age;
    }

    public int getAge(){
        return age;
    }


    public static void main(String[] args) {
        C04_OOP_Dog d1 = new C04_OOP_Dog("Jackie");  // >>> Dog Jackie is created
        // C04_OOP_Dog.barking();  // >>>  Woo Woo!   // 只有static才能被类直接call

        d1.barking();
        // >>> Woo Woo!

        d1.hungry();
        // >>>
        // Woo Woo!
        // I am hungry!

        System.out.println(d1.breed);  // >>> null     String缺省为null
        System.out.println(d1.color);  // >>> white
        System.out.println(d1.age);    // >>> 0          int 缺省为0
        d1.setAge(5);
        System.out.println(d1.age);  // >>> 5

        d1.printinfo();
        // >>>
        // Name: Jackie
        // Age: 5
        // Breed: null
        // Color: white


        // 引用另一个包里的类才需要import
        C03_Variable_Types_Employee new_worker = new C03_Variable_Types_Employee ("Denis");
        C07_Primes new_primes = new C07_Primes();

        Cat cat_1 = new Cat("Garfield");
        cat_1.sound();
    }
}

/*
 * 一个类可以包含以下类型变量:
     * 局部变量：在方法、构造方法或者语句块中定义的变量被称为局部变量。变量声明和初始化都是在方法中，方法结束后，变量就会自动销毁。
     * 成员变量：成员变量是定义在类中，方法体之外的变量。这种变量在创建对象的时候实例化。成员变量可以被类中方法、构造方法和特定类的语句块访问。
     * 类变量：类变量也声明在类中，方法体之外，但必须声明为static类型。
 */

/*
 * 源文件声明规则
     * 在本节的最后部分，我们将学习源文件的声明规则。当在一个源文件中定义多个类，并且还有import语句和package语句时，要特别注意这些规则。
     * 一个源文件中只能有一个public类
     * 一个源文件可以有多个非public类
     * 源文件的名称应该和public类的类名保持一致。例如：源文件中public类的类名是Employee，那么源文件应该命名为Employee.java。
     * 如果一个类定义在某个包中，那么package语句应该在源文件的首行。
     * 如果源文件包含import语句，那么应该放在package语句和类定义之间。如果没有package语句，那么import语句应该在源文件中最前面。
     * import语句和package语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。
 * 类有若干种访问级别，并且类也分不同的类型：抽象类和final类等。这些将在访问控制章节介绍。
 * 除了上面提到的几种类型，Java还有一些特殊的类，如：内部类、匿名类。
 */



class Cat {
    String name;

    public Cat(String name){
        this.name = name;
    }

    void sound(){
        System.out.println(this.name + ": Meow Meow!");
    }

    public static void main(String[] args) {

    }
    }
