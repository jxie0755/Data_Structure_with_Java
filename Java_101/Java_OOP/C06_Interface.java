package Java_OOP;

public class C06_Interface {

    /*
     * 接口Interface 在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明
        * 一个类通过继承接口的方式，从而来继承接口的抽象方法
     * 接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念
        * 类描述对象的属性和方法。接口则包含类要实现的方法
     * 除非实现接口的类是抽象类，否则该类要定义接口中的所有方法
        * 接口无法 直接 实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类
        * 另外，在Java中，接口类型可用来声明一个变量，他们可以成为一个空指针，或是被绑定在一个以此接口实现的对象
     */

    /*
     * 接口和抽象类的设计目的就是不一样的。接口是对动作的抽象，而抽象类是对根源的抽象
        * 对于抽象类，比如男人，女人这两个类，那我们可以为这两个类设计一个更高级别的抽象类--人。
        * 对于接口，我们可以坐着吃饭，可以站着吃饭，可以用筷子吃饭，可以用叉子吃饭，甚至可以学三哥一样用手抓着吃饭，那么可以把这些吃饭的动作抽象成一个接口--吃饭

     * 面向接口编程，你关心的是这些对象的行为特性，而不是具体实现。
     * 比如Map只关心可以根据名字获取值，而不关心是用链表实现的，是用数组实现的，使用哈希表实现的，还是用二叉树实现的。
     */


    /*
     * 接口与类相似点:
        * 一个接口可以有多个方法
        * 接口文件保存在.java结尾的文件中，文件名使用接口名
        * 接口的字节码文件保存在.class结尾的文件中
        * 接口相应的字节码文件必须在与包名称相匹配的目录结构中
     * 接口与类的区别：
        * 接口不能用于实例化对象
        * 接口没有构造方法
        * 接口中所有的方法必须是抽象方法
        * 接口不能包含成员变量，除了static和final变量
        * 接口不是被类继承了，而是要被类实现
        * 接口支持多重继承
     * 接口特性
        * 接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字。
        * 接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键子。
        * 接口中的方法都是公有的。
     */

    /*
     * 在实现接口的时候，也要注意一些规则：
        * 在Java中，类的多重继承是不合法，但接口允许多重继承
        * 一个类可以同时实现多个接口
        * 一个类只能继承一个类，但是能实现多个接口
        * 一个接口能继承另一个接口，这和类之间的继承比较相似
     */

    /*
     * 建立一个公共的父接口:
        * 正如EventListener接口，这是由几十个其他接口扩展的Java API，你可以使用一个标记接口来建立一组接口的父接口。
        * 例如：当一个接口继承了EventListener接口，Java虚拟机(JVM)就知道该接口将要被用于一个事件的代理方案。
     * 向一个类添加数据类型:
        * 这种情况是标记接口最初的目的，实现标记接口的类不需要定义任何接口方法(因为标记接口根本就没有方法)，
        * 但是该类通过多态性变成一个接口类型。
     */

    /*
     * 空接口 (标记接口)
     * 最常用的继承接口是没有包含任何方法的接口。
     * 标识接口是没有任何方法和属性的接口.它仅仅表明它的类属于一个特定的类型,供其他代码来测试允许做一些事情。
     * 标识接口作用：简单形象的说就是给某个对象打个标（盖个戳），使对象拥有某个或某些特权。
     */

}



interface Animal_5 {
    // public static String T;  只能声明方法,不能声明变量

    // 接口是管理动作的, 不需要初始化实例, 如果需要就不应该做成interface而是做成抽象类或者别的
    public void eat();
    void travel();
    // interface 不需要public方法修饰符, 因为方法必须被子类实现


    // 注意: 静态方法还是需要声明完整, 而且子类不必继承!!
    static void wtf() {
        System.out.println("WFT!");
    }
}

// 接口的实现
// 当类实现接口的时候，类要实现接口中所有的方法。否则，类必须声明为抽象的类!!

class Mammal_5 implements Animal_5 {

    String name;

    public Mammal_5 (String m_name){
        this.name = m_name;
    }

    // eat和travel必须全部实现
    public void eat() {
        System.out.println("Mammal eats");
    }
    public void travel() {
        System.out.println("Mammal travels");
    }

    // 当然也可以额外添加方法
    public int noOfLegs() {
        return 4;
    }

    public static void main(String args[]) {
        Mammal_5 m = new Mammal_5("Jackie");
        m.eat();      // >>> Mammal eats
        m.travel();   // >>> Mammal travels
        System.out.println(m.noOfLegs()); // >>>  4

        Animal_5 a = new Mammal_5("Didi");
        a.eat();      // >>> Mammal eats
        a.travel();   // >>> Mammal travels   // 相同
        // System.out.println(a.noOfLegs()); // 父类通过多态实现的实例不能有子类独有的方法
    }
}



// interface的继承, 和多重实现
interface Sports {
   void sports1();
   void sports2();
}

interface Football extends Sports {
   void football1(int points);
   void football2(int points);
}

interface Events {
   int event1(int time);

    // 接口中方法若重复怎么办?
    String football1(String name);
    String football2(String name);
}

interface EPL extends Football, Events { }


// 这里演示一个类继承多个接口
class PremierLeauge_Game_1 implements Football, Events {

    // 由于Football继承了Sports的两个方法, 所以在实现类中必须定义全部Football和Sports四个方法
    public void sports1() { }
    public void sports2() { }
    public void football1(int points) { }
    public void football2(int points) { }

    // 另外还要实现多重继承的Events类的方法
    public int event1(int time) {
        return time;
    }
    // 虽然football1和football2的方法有了,但是可以重载来实现Events里的方法
    public String football1(String name){
        return name;
    }
    public String football2(String name){
        return name;
    }

}


// 这里演示一个类继承一个多重继承的接口, 其实和上面是一模一样的, 总之要把所有接口中的方法都给实现了
// class PremierLeauge_Game_2 implements EPL { }


// 空接口 (标记接口)
interface EventListener_X {}




/*
 * Aditional
 * 多重继承接口时出现同名方法(彻底重名,无法重载)
 * 如果类型实现两个接口，并且每个接口定义具有相同签名的方法，则实际上只有一个方法，并且它们是不可区分的
 */

interface Friend_X {
    void play() ;
    void beFriendly();
}

interface Pet_X {
    void play() ;
    void beFriendly();
}

// 这样建立一个狗类,既是朋友,也是宠物!
class Dog_X implements Friend_X, Pet_X {
    @Override
    public void play() {
        System.out.println();
    }
    @Override
    public void beFriendly(){}
}

// 还有一种方法就是使用内部类
class Dog_Y implements Friend_X {

    public void play() {
        System.out.println("Play as Friend");
    }
    public void beFriendly() {
        System.out.println("Friendly Friend");
    }
    public static class Dog_Y2 implements Pet_X { // 注意内部类要static
        public void play() {
        System.out.println("Play as Pet");
        }
        public void beFriendly() {
            System.out.println("Friendly Pet");
        }
    }
}

class Test {
    public static void main(String[] args) {

        Dog_Y DX = new Dog_Y();
        DX.beFriendly();  // >>> Friendly Friend
        DX.play();        // >>> Play as Friend

        Dog_Y.Dog_Y2 DX2 = new Dog_Y.Dog_Y2();
        DX2.beFriendly();  // >>> Friendly Pet
        DX2.play();        // >>> Play as Pet
    }
}


// 如果接口要实例化，就涉及到多态
interface Intf {
    void fook();
    void bark();
}

class CCC implements Intf {
    String name;
    CCC (String name) {
        this.name = name;
    }

    public void fook(){
        System.out.println("foo");
    }

    public void bark() {
        System.out.println("bar");
    }

    public  void foobar() {
        System.out.println("foobar");
    }
}

class CCC_test {
    public static void main(String[] args) {
        Intf IT = new CCC("jack");
        IT.fook();
        IT.bark();
        // IT.foobar(); // 除非通过转型
    }
}