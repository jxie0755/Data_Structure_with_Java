package Java_OOP;

public class C02_Override_Overload {
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

    /*
     * 重载规则
         * 被重载的方法必须改变参数列表 (哪怕只是改变顺序)
         * 被重载的方法可以改变返回类型
         * 被重载的方法可以改变访问修饰符
         * 被重载的方法可以声明新的或更广的检查异常
         * 方法能够在同一个类中或者在一个子类中被重载
     */

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

    @Override
    public int move(int n) {
        System.out.println("狗可以两倍速移动");
        int dog_speed = super.move(n) * 2;
        return dog_speed;  // 继续使用super, 狗每次是普通动物两倍速
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


class AA {

    // AA类中存在多个test方法, 它们可以并存
    int test() {
        System.out.println("test 1");
        return 1;
    }

    // Overload
    void test(int a) {
        System.out.println("test 2");
    }

    // Overload
    String test(int a, String s) {
        System.out.println(s);
        return "return test 3";
    }

    // Overload
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




// 另一个例子
class Grand {
    int x = 99999;
}


class ParentClass2 extends Grand {
    // x成员变量
    int x = 0;

    protected void setValue(int n) {
        x = n;
    }
}

class SubClass2 extends ParentClass2 {
    // 屏蔽父类x成员变量
    int x = 1;

    @Override
    public void setValue(int n) { // 覆盖父类方法 ②
        // 访问子类对象x成员变量
        x = n;
        // 调用父类setValue()方法
        super.setValue(n+1);
    }

    public void print() {
        // 访问子类对象x成员
        System.out.println("x = " + x);
        // 访问父类x成员变量
        System.out.println("super.x = " + super.x);
        // System.out.println("super.super.x = " + Grand.x);
    }

    public static void main(String[] args) {
        SubClass2 sub2 = new SubClass2();
        sub2.print();
        // >>>
        // x = 1
        // super.x = 0 存在区别   // 子类虽然含有同名变量,但不代表父类的那个变量就消失了

        sub2.setValue(5);
        sub2.print();
        // >>>
        // x = 5
        // super.x = 6    // 通过父类方法修改的是父类的那个同名变量!!
    }

}


/*
 * 研究继承属性和方法的不同
 * 如果List与ArrayList中有相同的属性（如int i),    则a.i是调用了   !!!!!父类!!!!! List中的i
    * 如果List与ArrayList中有相同的方法（如void f()), 则a.f()是调用了 !!!!!子类!!!!! ArrayList中的f()  (参见下面FatherX和SonX)
        * 注意这个python的OOP思想不同!!!
        * 这是因为python没有泛型, 没有办法规定一个实例是父类, 但是通过子类来实例来实现
 */
class FatherX {
    String x = "Father";

    void foo() {
        System.out.println("from father");
    }

}

class SonX extends FatherX{
    String x = "Son";

    void foo() {
        System.out.println("from son");
    }
}

class TT {
    public static void main(String[] args) {

        // 两种实例
        FatherX real_father = new FatherX();
        FatherX father_son = new SonX();
        SonX real_son = new SonX();
        // 两个个fake指引
        // SonX fake_son = (SonX) real_father;  // 不行
        FatherX son_father = (FatherX) real_son;
        FatherX son_father2 = (FatherX) father_son;

        //泛型导致两者不同!
        System.out.println(real_father.x);  // >>> Father  // of course
        System.out.println(father_son.x);   // >>> Father    // 不继承SonX的变量,而是FatherX的边浪
        System.out.println(real_son.x);     // >>>  Son
        // System.out.println(fake_son.x);     // error
        System.out.println(son_father.x); // >>> Father
        System.out.println(son_father2.x); // >>> Father

        System.out.println();
        real_father.foo(); // >>> from father  // of course
        father_son.foo();  // >>> from son     // 仍然继承SonX的方法
        real_son.foo();    // >>> from son
        // fake_son.foo();                    // error
        son_father.foo();  // >>> from son   // 转型的Father仍然执行子类的方法, 这也是转型的目的
        son_father2.foo(); // >>> from son
    }
}



// 研究super的跳跃层数
// STOF: https://stackoverflow.com/q/55249557/8435726
class Zero {
    int n = 0;

    void setN(int x) {
        n += x;
    }

    void showZeroN() {
        System.out.println(n);
    }
}

class One extends Zero {
    int n = 1;

    void setN(int x) {
        n += x;
        super.setN(x);
    }

}

class Two extends One {
    int n = 2;

    void setN(int x) {
        n += x;
        super.setN(x);
    }

    void show() {
        System.out.println(n);
        System.out.println(super.n);
        // System.out.println(super.super.n);   error

    }

    public static void main(String[] args) {
        Two two = new Two();
        two.show();
        // >>>
        // 2
        // 1

        two.setN(1);
        // 通过链式super直接改了Zero,One和Two的n属性,但是无法在Two直接看到两层后的Zero!
        two.show();
        // >>>
        // 3
        // 2

        two.showZeroN(); // >>> 1  // 通过Zero中的showZeroN可以确定这个事实
    }
}

