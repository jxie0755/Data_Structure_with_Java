package W3C_Java_Advaned_OOP;

public class C10_Instance_Casting {
}




// 由导出类转型成基类， 就是一个向上转型       如"Human a1=new Woman( );                            通俗地说就是是将子类对象转为父类对象
// 父类转型成子类,     就是向下转型，        如“Human a1=new Woman( ); Woman b1=(Woman) a1;”。     向下转型是把父类对象转为子类对象


class China {
	public void language(){System.out.println("Chinese speak Chinese");}
}

class HongKong extends China {
	public void language(){System.out.println("people lived in HongKong speak Chinese");}
	public void location(){System.out.println("South of China");}
}

class  test1 {

    public static void main(String[] args) {

        // 实践向上转型
		China a1 = new HongKong();  //子类实例被包装成父类(向上)
		a1.language();  // >>> people lived in HongKong speak Chinese
		//a1.location();   // 向上转型时，子类单独定义的方法会丢失
        // 子类引用不能指向父类对象 Hongkong c = (Hongkong)new China()这样是不行的
        // 那么你可能会有疑问，为什么不用HongKong al=new HongKong,直接调用location（）方法呢？这样做其实就丧失了面向对象继承多态性的灵活: 见下面例子Material and MyMenu的应用


        // 实践向下转型
        // 用于父类调用子类方法或者父类给子类变量赋值，利于程序扩展。最多的应用是Java的泛型，但向下转型存在风险
        China a2 = new HongKong();  // 同样是向上转型
        if (a2 instanceof HongKong) {  // 用if来避免问题
            China b2 = (China) a2;  // 再造一个父类实例b2,它是a2的cast,而a2其实是子类实例, 所以这个父类实例b2能支持子类的方法!!!!!
            // 上面这三行操作是精髓
            System.out.println(b2.getClass());  // >>> Hongkong  // 父类变子类成功!!
            b2.language(); // >>> people lived in HongKong speak Chinese
            // 这样b2就用上了子类的方法
        }
	}
}


// 向上转型详细解释:
class Material {
    public void intro() { }
}

//盐类
class Salt extends Material {
    public void intro() { System.out.println("我是盐"); }
}

//肉类
class Meat extends Material {
    public void intro() { System.out.println("我是肉"); }
}

//蔬菜类
class Vegetable extends Material {
    public void intro() { System.out.println("我是蔬菜"); }
}


class MyMenu {

    // 不用casting,为三个子类分别写方法, 相当于使用重载overload
    public static void add(Salt m) { m.intro(); }
    public static void add(Meat m) { m.intro(); }
    public static void add(Vegetable m) { m.intro(); }

    // 使用casting
    public static void add_2(Material m) { m.intro(); }

    public static void main(String[] args) {
        add(new Salt());
        add(new Meat());
        add(new Vegetable());

        // add_2因为casting可以同时套用到三个子类上,分别输出子类的方法, 这样节省了重复代码
        // 向上转型是统一的单个方法来执行子类中重写的不同方法, 避免重载的麻烦
        add_2(new Salt());
        add_2(new Meat());
        add_2(new Vegetable());
        // 如果我又有一种新菜加进来，我只需要实现它自己的类，让他继承Material就可以了，而不需要为它单独写一个add方法。是不是提高了扩展性?
    }
}




// 向下转型详细解释:
class Animal_7 {
    public void eat(){ System.out.println("animal eatting..."); }
}

class Cat_7 extends Animal_7{
    public void eat(){ System.out.println("我吃鱼"); }
}

class Dog_7 extends Animal_7{
    public void eat(){ System.out.println("我吃骨头"); }
    public void run(){ System.out.println("我会跑"); }
}

class Animal_7_Test {

    public static void main(String[] args) {
        Animal_7 a = new Cat_7();
        Cat_7 c = (Cat_7) a;  // c也就是a转成Cat的cast
        System.out.println(a instanceof Cat_7); // >>> true
        c.eat();  // >>> 我吃鱼
        // 为什么第一段代码不报错呢？因为a本身就是Cat对象，所以它理所当然的可以向下转型为Cat，但是这是无效操作

        // Dog_7 d = (Dog_7) a;  // 尝试吧a转型成Dog, 不能成功
        // System.out.println(d instanceof  Dog_7);
        // d.eat();  报错

        Animal_7 a1 = new Animal_7();
        System.out.println(a1 instanceof Cat_7); // >>> false
        // Cat_7 c1 = (Cat_7) a1;  // 尝试吧a1转型成Cat类,a1本身是动物类
        // c1.eat(); 报错

        // 正确操作
        Animal_7 a_x = new Cat_7();  // Cat_7新造的实例被cast成Animal类, 所以是先向上转型
        System.out.println(a_x.getClass()); // >>> Cat_7
        Animal_7 a_x_cast = (Animal_7) a_x;  // 向下转型
        System.out.println(a_x_cast.getClass()); // >>> Cat_7
        a_x_cast.eat(); // >>> 我吃鱼
        // 向下转型的前提是父类对象指向的是子类对象（也就是说，在向下转型之前，它得先向上转型）
        // 向下转型只能转型为子类对象（猫是不能变成狗的,因为他们是平行关系）


        // 这样就用一个eat来执行Dog和Cat各自独特的方法
        eat(new Dog_7());
        // >>>
        // 我吃骨头
        // 我会跑

        eat(new Cat_7());
        // >>>
        // 我吃鱼
        // 我也想跑，但是不会

    }

    // 用法:  向下转型就是根据子类的不同,执行子类独有的,父类没有的方法
    public static void eat (Animal_7 a){
            if (a instanceof Dog_7) {
                Dog_7 d = (Dog_7) a;
                d.eat();
                d.run(); // 狗有一个跑的方法 (这里如果单用向上转型,则不行,因为不是每个Animal都有run这个方法,必须是向下转型,使得父类能够在if成立时调用子类方法
            } else if (a instanceof Cat_7) {
                Cat_7 c = (Cat_7) a;
                c.eat();
                System.out.println("我也想跑，但是不会"); // 猫会抱怨, 也算是一个附加处理,比其他类只执行eat()不同
            } else { a.eat();//其他动物只会吃
            }
    }

}

/*
 * 用法总结:
    * 向上转型和向下转型,原则上都是用父类作为一个方法的参数(向上转型),让它分别执行子类的方法
        * 向上转型的用处是, 执行各子类相同的方法时,避免重载导致代码重复
        * 向下转型的用处是, 能够使父类参数执行子类中独特的方法(附加处理)或者是父类没有的方法
    * 这些都是python作为动态语言不会出现的问题,因为python不检查参数类型,而java会检查,导致了参数不能多态
 */
