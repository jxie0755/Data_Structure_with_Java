package Java_OOP;

public class C07_Interface {

    /*
     * 接口Interface 在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明
        * 一个类通过继承接口的方式，从而来继承接口的抽象方法
     * 接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念
        * 类描述对象的属性和方法。接口则包含类要实现的方法
     * 除非实现接口的类是抽象类，否则该类要定义接口中的所有方法
        * 接口无法被实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类
        * 另外，在Java中，接口类型可用来声明一个变量，他们可以成为一个空指针，或是被绑定在一个以此接口实现的对象
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

    public void eat();

    public void travel();
}

// 接口的实现
// 当类实现接口的时候，类要实现接口中所有的方法。否则，类必须声明为抽象的类!!

class Mammal_5 implements Animal_5 {

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
        Mammal_5 m = new Mammal_5();
        m.eat();      // >>> Mammal eats
        m.travel();   // >>> Mammal travels
    }
}



// interface的继承, 和多重实现
interface Sports
{
   public void setHomeTeam();
   public void setVisitingTeam();
}


interface Football extends Sports
{
   public void homeTeamScored(int points);
   public void visitingTeamScored(int points);

}

interface Events {
    public int starting_time(int time);

    // 接口中方法若重复怎么办?
    public String setHomeTeam(String name);
    public String setVisitingTeam(String name);

}

interface EPL extends Football, Events {

}


// 这里演示一个类继承多个接口
class PremierLeauge_Game_1 implements Football, Events {

    // 由于Football继承了Sports的两个方法, 所以在实现类中必须定义全部四个方法
    public void setHomeTeam() {
    }

    public void setVisitingTeam() {
    }

    public void homeTeamScored(int points) {
    }

    public void visitingTeamScored(int points) {
    }

    // 另外还要实现多重继承的另一个类的方法
    public int starting_time(int time) {
        return time;
    }

    // 在这里同样必须要把Events中相同的方法实现一次, 但是可以利用重载
    public String setHomeTeam(String name){
        return name;
    }
    public String setVisitingTeam(String name){
        return name;
    }

}


// 这里演示一个类继承一个多重继承的接口, 其实是一样的, 总之要把所有接口中的方法都给实现了
class PremierLeauge_Game_2 implements EPL {

    // 由于Football继承了Sports的两个方法, 所以在实现类中必须定义全部四个方法
    public void setHomeTeam() {
    }

    public void setVisitingTeam() {
    }

    public void homeTeamScored(int points) {
    }

    public void visitingTeamScored(int points) {
    }

    // 另外还要实现多重继承的另一个类的方法
    public int starting_time(int time) {
        return time;
    }

    // 在这里同样必须要把Events中相同的方法实现一次, 但是可以利用重载
    public String setHomeTeam(String name){
        return name;
    }
    public String setVisitingTeam(String name){
        return name;
    }
}

// 空接口 (标记接口)
interface EventListener_X {}

