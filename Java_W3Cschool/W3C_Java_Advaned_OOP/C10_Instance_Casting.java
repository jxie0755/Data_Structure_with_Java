package W3C_Java_Advaned_OOP;

public class C10_Instance_Casting {
}




// 由导出类转型成基类， 就是一个向上转型       如"Human a1=new Woman( );
// 父类转型成子类,     就是向下转型，        如“Human a1=new Woman( ); Woman b1=(Woman) a1;”。

class China {
	public void language(){System.out.println("Chinese speak Chinese");}
	public void flu(){System.out.println("yellow");}
}

class HongKong extends China {
	public void language(){System.out.println("people lived in HongKong speak Chinese");}
	public void flu(){System.out.println("yellow");}
	public void location(){System.out.println("South of China");}
}

class  test1 {

    public static void main(String[] args) {

        // 实践向上转型
		China a1 = new HongKong();
		a1.language();  // >>> people lived in HongKong speak Chinese
		//a1.location();   // 如果把注释掉的a1.location（）加上他会提示找不到loaction()，所以用不了子类新扩展的location（）方法

        // 那么你可能会有疑问，为什么不用HongKong al=new HongKong,直接调用location（）方法呢？这样做其实就丧失了面向对象继承多态性的灵活: 见下面例子Material and MyMenu的应用

        //实践向下转型

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

    // 不用casting
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
    }
}
