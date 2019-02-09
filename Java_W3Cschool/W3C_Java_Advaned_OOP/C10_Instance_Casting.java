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
		China a1 = new HongKong();
		a1.language();  // >>> people lived in HongKong speak Chinese
		//a1.location();   // 向上转型时，子类单独定义的方法会丢失
        // 子类引用不能指向父类对象 Hongkong c = (Hongkong)new China()这样是不行的
        // 那么你可能会有疑问，为什么不用HongKong al=new HongKong,直接调用location（）方法呢？这样做其实就丧失了面向对象继承多态性的灵活: 见下面例子Material and MyMenu的应用


        // 实践向下转型
        // 用于父类调用子类方法或者父类给子类变量赋值，利于程序扩展。最多的应用是Java的泛型，但向下转型存在风险
        China a2 = new HongKong();
        if (a2 instanceof HongKong) {  // 用if来避免问题
            China b2 = (China) a2;
            System.out.println(b2.getClass());  // >>> Hongkong  // 父类变子类成功!!
            b2.language(); // >>> people lived in HongKong speak Chinese
            // 这样b2就用上了子类的方法
        }
	}
}


// 向上转型实用性解释:
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

    // 不用casting,为三个子类分别写方法
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
        add_2(new Salt());
        add_2(new Meat());
        add_2(new Vegetable());
        // 如果我又有一种新菜加进来，我只需要实现它自己的类，让他继承Material就可以了，而不需要为它单独写一个add方法。是不是提高了扩展性?
    }
}
