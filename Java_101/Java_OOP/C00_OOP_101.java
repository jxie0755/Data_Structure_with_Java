package Java_OOP;

import Java_Basics.C01b_Primes;
import Java_Basics.C04b_Variable_Types_Employee;

import java.util.List;


public class C00_OOP_101 {
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

    /*
     * 构造方法
     * 构造器可以有任何访问的修饰符，public、private、protected或者没有修饰符,都可以对构造方法进行修饰。
     * 不同于实例方法的是构造方法不能有任何非访问性质的修饰符修饰，例如static、final、synchronized、abstract等
        * 如果是private的话就是单例
        * 如果是protected就是只能被子例中使用
    * 当用户没有给java类定义明确的构造方法的时候,java为我们提供了一个默认的构造方法,这个构造方法没有参数,修饰符是public并且方法体为空。
    * 如果用户有定义构造方法，就不会有默认构造方法！！！
     */
}

class C00_OOP_Dog {

    // 类变量其实也是init的一部分
    String name;
    String breed;
    String color = "White";  // 初始化的时候直接用这里的值作为默认
    int age;  // 若不说默认则为0

    // Initialization  等同于python __init__, 但是如果创立时不需要特别指定参数,可以不写
    public C00_OOP_Dog(String name) {
        this.name = name;
        System.out.println("Dog " + name + " is created");
    }


    // 三个方法
    void barking() {
        System.out.println(this.name + ": Woo Woo!");
    }

    void hungry() {
        this.barking();  // 用this来指该实例 (相当于python的self)
        System.out.println("I am hungry!");
    }

    public void printinfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Breed: " + this.breed);
        System.out.println("Color: " + this.color);
    }

    // set and get
    public void setAge(int new_age) {
        age = new_age;
    }

    public int getAge() {
        return age;
    }


    public static void main(String[] args) {
        C00_OOP_Dog d1 = new C00_OOP_Dog("Jackie");  // >>> Dog Jackie is created
        // C00_OOP_Dog.barking();  // >>>  Woo Woo!   // 只有static才能被类直接call

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
        C04b_Variable_Types_Employee new_worker = new C04b_Variable_Types_Employee("Denis");
        C01b_Primes primes_example = new C01b_Primes();


        // 空对象
        String sss = null;
        Integer iii = null;
        List<Object> lll = null;

        // 销毁实例


    }
}

// 一个例子来展示Employee和EmployeeTest两个类的联用
class C00_OOP_DogTest {
    public static void main(String[] args) {
        C00_OOP_Dog dog_01 = new C00_OOP_Dog("Jackie");
        C00_OOP_Dog dog_02 = new C00_OOP_Dog("DiDi");
        System.out.println();

        dog_01.setAge(2);
        dog_01.age = 4;  // 仍然可以跳过set方法强制设定
        dog_01.breed = "Peking Dog";
        dog_02.setAge(3);
        dog_02.breed = "Poodle";
        dog_02.color = "Brown";

        dog_01.printinfo();
        System.out.println();
        dog_02.printinfo();

        // >>>
        // Dog Jackie is created
        // Dog DiDi is created
        //
        // Name: Jackie
        // Age: 2
        // Breed: Peking Dog
        // Color: white
        //
        // Name: DiDi
        // Age: 3
        // Breed: Poodle
        // Color: white
    }
}

