package Java_OOP;

class C07b_Casting_Inheritance {
    /*
     *  Java的继承与Python不同
     *  Python的实例只能来自它本身的类
     *  由于转型问题的存在, Java可以以子类实例创建父类实例, 这就导致了一个父类实例是否继承子类的属性和方法的问题
     * 属性
     * 子类和父类共有的属性 -- 父类实例使用父类的属性
     * 子类和父类不共有的属性 -- 父类实例不能使用, 除非通过转型
     * 方法
     * 子类和父类共有的方法 -- 父类实例使用子类的方法
     * 子类和父类不共有的方法 -- 父类实例不能使用, 除非通过转型
     */
}


// 以下是更清晰演示转型中的继承与多态:
class Father {
    int i;

    public Father() {
        this.i = 0;
    }

    public void foo(int n) {
        System.out.print("from Father2 foo");
        System.out.println(n);
    }
}

class Child1 extends Father {
    int i;
    int j = 99;

    public Child1() {
        this.i = 1;
    }

    public void foo(int n) {
        System.out.print("from Child foo 111 ");
        System.out.println(n + 1);
    }

    public void bar(int n) {
        System.out.print("from Child bar 11111111 ");
        System.out.println(n + 1);
    }
}

class Child2 extends Father {
    int i;

    public Child2() {
        this.i = 2;
    }

    public void foo(int n) {
        System.out.print("from Child foo 222 ");
        System.out.println(n + 2);
    }

    public void bar(int n) {
        System.out.print("from Child bar 22222222 ");
        System.out.println(n + 2);
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
        // System.out.println(F1.j);
        System.out.println(((Child1) F1).j); // >>>  99 (向下转型获得)


        C1.foo(5); // >>> from Child foo 111 6
        C1.bar(5); // >>> from Child bar 11111111 6

        C2.foo(5); // >>> from Child foo 222 7
        C2.bar(5); // >>> from Child bar 22222222 7

        F1.foo(5); // >>>  from Child foo 111 6 // 顺利的继承了Child1的方法
        // F1.bar(5); // F1没有bar, 因为Father 没有Bar(), 虽然new Child1()有
        // 通过向下转型来运行bar
        ((Child1) F1).bar(5);  // >>> from Child bar 11111111 6
        // ((Child1) F2).bar(5);  // 不行, 虽然有方法同名

        F2.foo(5); // >>>  from Child foo 222 7  // 顺利的继承了Child1的方法
        // F2.bar(5); // F2也没有bar, 因为Father 没有Bar(), 虽然new Child2()有
        // 通过向下转型来运行bar
        ((Child2) F2).bar(5);  // >>> from Child bar 22222222 7

        Father F1b = new Child1();
        System.out.println(F1b.i);  // >>> 0
        F1b.foo(8);              // >>> from Child 111 9

        // Father2 F1b = new Child2();   若原地改
        // System.out.println(F1b.i);    // >>> 0
        // F1b.foo(8);                   // >>> from Child 222 10  // 可以直接换Child2的方法
    }
}
