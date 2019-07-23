package Java_OOP;

public class C04c_Use_of_Super {
    /*
     * 学习Super的两种形式
     * super    - super指的是父类, 用super.方法, super.变量来找父类的方法和变量
     * super()  - super()是专门调用父类的constructor, 用于实现子类的constructor
     * super跳跃只能跳一级,无法访问父类的父类
     */
}


class C7 {
    String name;

    public C7(String name) {
        this.name = name;
        System.out.println("!! " + name + " !!");
    }

    void foo(String s) {
        System.out.println(s + " <<<your grandfather");
    }

}


class C8 extends C7 {
    Integer innt;

    public C8(String name) {
        super(name);
    }

    public C8(String name, int x) {
        super(name + " " + x);        // 即使重载也必须先使用super, 必须第一行
        this.name = name; // 然后再覆盖?
        this.innt = x;
    }

    void foo(String s) {
        super.foo(s + " <<<your father");  // super用于其他位置, 其实就是代表Parent
    }

    void bar() {
    }

}

class C9 extends C8 {

    public C9(String name) {
        super(name);
    }

    void foo(String s) {
        super.foo(s + " <<< yourself");
        // C8.foo(s + " <<< yourself")   意思就是这样,但是不能这么写
    }

    public static void main(String[] args) {

        C7 c77 = new C7("c777"); // >>>  !! c777 !!
        C8 c88 = new C8("c888"); // >>>  !! c888 !!
        C8 c888 = new C8("c8888", 10); // >>>  !! c8888 10 !!
        // System.out.println(c888.name); // >>>  c8888???>
        c77.foo("c77");   // >>>  c77 <<<your grandfather
        c88.foo("c88");   // >>>  c88 <<<your father <<<your grandfather
        C9 c99 = new C9("c999");
        c99.foo("c99"); // >>>  c99 <<< yourself our father <<<your grandfather  // 链式继承super方法
    }

}


// 额外例子展示super访问父类变量
class ParentClass {
    // x成员变量
    int x = 10;
}

class SubClass extends ParentClass {
    // 屏蔽父类x成员变量
    int x = 20;

    public void print() {
        // 访问子类对象x成员变量
        System.out.println("x = " + x);
        // 访问父类x成员变量
        System.out.println("super.x = " + super.x);
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

        System.out.println(two instanceof Two);  // >>> true
        System.out.println(two instanceof One);  // >>> true
        System.out.println(two instanceof Zero); // >>> true
    }
}
