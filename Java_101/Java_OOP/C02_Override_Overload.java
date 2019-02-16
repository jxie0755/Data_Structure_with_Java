package Java_OOP;

public class C02_Override_Overload {
}


// 重写Override, 就是子类改写父类的方法,让不同子类用同一个方法分别出不同结果.
class Animal_3 {
    public String name;
    public Animal_3(String name) {
        this.name = name;
    }

    public int move(int n) {
        return n;
    }
}

class Dog_3 extends Animal_3 {

    // 不需要再声明String name的实例变量,因为继承了
    public Dog_3 (String name) {
        super(name);          // 使用super来继承父类方法
    }


    public int move(int n) {
        System.out.println("狗可以两倍速移动");
        return super.move(2 * n);  // 继续使用super, 狗每次是普通动物两倍速
    }

}

class Cat_3 extends Animal_3 {

    public Cat_3 (String name) {
        super(name);
    }

    public void meow(int n) {
        System.out.println("Cat MEWO" + n + "times");
    }

}


class TestDog_3 {

    public static void main(String args[]) {

        Animal_3 a = new Animal_3("Animal One"); // Animal 对象
        Dog_3 b = new Dog_3("Didi"); // Dog 对象

        Cat_3 c = new Cat_3("Garfield");
        Animal_3 c2 = new Cat_3("Tom");

        System.out.println(a.move(3));// 执行 Animal 类的方法
        // >>> 3

         System.out.println(b.move(3));//执行 Dog 类的方法
        // >>>
        // 狗可以两倍速移动
        // 6

        System.out.println(c.move(3));   // 直接继承Animal
        // >>> 3
    }
}


/*
 * 重写是子类对父类的允许访问的方法的实现过程进行重新编写! 返回值和形参都不能改变。即外壳不变，核心重写! 重写的好处在于子类可以根据需要，定义特定于自己的行为!也就是说子类能够根据需要实现父类的方法。
    * 参数列表必须完全与被重写方法的相同；
    * 返回类型必须完全与被重写方法的返回类型相同；
    * 子类方法的访问权限必须大于或等于父类方法的访问权限。例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。
    * 父类的成员方法只能被它的子类重写。
    * 声明为final的方法不能被重写。
    * 声明为static的方法不能被重写，但是能够被再次声明。
    * 如果一个方法不能被继承，那么该方法不能被重写。
    * 子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为private和final的方法。
    * 子类和父类不在同一个包中，那么子类只能够重写父类的声明为public和protected的非final方法。
    * 重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法
    * 明的更广泛的强制性异常，反之则可以。
    * 构造方法不能被重写。
    * 如果不能继承一个方法，则不能重写这个方法。
 */


// Leanr Overload
// 重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型呢？可以相同也可以不同。
// 每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表
// 只能重载构造函数


class AA {

    // AA类中存在多个test方法, 它们可以并存
    int test() {
        System.out.println("test 1");
        return 1;
    }

    void test(int a) {
        System.out.println("test 2");
    }

    String test(int a, String s) {
        System.out.println(s);
        return "return test 3";
    }

    String test(String s, int a) {
        System.out.println(s);
        return "return test 4";
    }

    public static void main(String[] args) {

        AA a_overload = new AA();

        System.out.println(a_overload.test());
        // >>>
        // test 1
        // 1

        a_overload.test(1);
        // >>> test 2

        System.out.println(a_overload.test(3, "T3"));
        // >>>
        // T3
        // return test 3

        System.out.println(a_overload.test("T4", 4));
        // >>>
        // T4
        // return test 4

    }


}


/*
 * 重载规则
     * 被重载的方法必须改变参数列表 (哪怕只是改变顺序)
     * 被重载的方法可以改变返回类型
     * 被重载的方法可以改变访问修饰符
     * 被重载的方法可以声明新的或更广的检查异常
     * 方法能够在同一个类中或者在一个子类中被重载
 */