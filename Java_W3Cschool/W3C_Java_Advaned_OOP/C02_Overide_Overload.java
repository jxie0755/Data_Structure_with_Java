package W3C_Java_Advaned_OOP;

public class C02_Overide_Overload {
}


// 重写Override
class Animal_3 {
    public int move(int n) {
        System.out.println("动物可以移动" + n + "步");
        return n;
    }
}

class Dog_3 extends Animal_3 {

    public int move(int n) {
        System.out.println("狗可以跑和走" + n + "步");
        return n;
    }

}

class Cat_3 extends Animal_3 {

    // public int move(int n) {
    //     System.out.println("Cat move " + n + "Steps!");
    //     return n;
    // }

    public void meow(int n) {
    System.out.println("Cat MEWO" + n + "times");

    }

}


class TestDog_3 {

    public static void main(String args[]) {
        Animal_3 a = new Animal_3(); // Animal 对象
        Dog_3 b = new Dog_3(); // Dog 对象


        Cat_3 c = new Cat_3();
        Animal_3 c2 = new Cat_3();

        a.move(3);// 执行 Animal 类的方法
        // >>> 动物可以移动3步

        b.move(4);//执行 Dog 类的方法
        // >>> 狗可以跑和走4步

        c.move(5);   // 直接继承Animal
        // >>> 动物可以移动5步
    }
}


/*
 * 重写是子类对父类的允许访问的方法的实现过程进行重新编写!
 * 返回值和形参都不能改变。即外壳不变，核心重写!
 * 重写的好处在于子类可以根据需要，定义特定于自己的行为!
 * 也就是说子类能够根据需要实现父类的方法。
 */