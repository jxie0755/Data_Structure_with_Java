package W3C_Java_Advaned_OOP;

public class C02_Overide_Overload {
}


// 重写Override
class Animal_3 {
    public String name;
    public Animal_3(String name) {
        this.name = name;
    }

    public int move(int n) {
        System.out.println("动物可以移动" + n + "步");
        return n;
    }
}

class Dog_3 extends Animal_3 {

    // 不需要再声明String name的实例变量
    public Dog_3 (String name) {
        super(name);          // 使用super来继承父类方法
    }


    public int move(int n) {
        super.move(0);    // 同样使用Super来继承父类的方法
        System.out.println("狗可以跑和走" + n + "步");
        return n + super.move(10);  // 继续使用super
    }

}

class Cat_3 extends Animal_3 {

    public Cat_3 (String name) {
        super(name);
    }

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
        Animal_3 a = new Animal_3("Animal One"); // Animal 对象
        Dog_3 b = new Dog_3("Didi"); // Dog 对象


        Cat_3 c = new Cat_3("Garfield");
        Animal_3 c2 = new Cat_3("Tom");

        a.move(3);// 执行 Animal 类的方法
        // >>> 动物可以移动3步

        b.move(4);//执行 Dog 类的方法
        // >>>
        // 动物可以移动0步
        // 动物可以移动10步

        c.move(5);   // 直接继承Animal
        // >>> 动物可以移动5步
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