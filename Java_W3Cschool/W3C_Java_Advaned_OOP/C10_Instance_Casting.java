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
        System.out.println("向上转型第一种写法: ");
		China a1 = new HongKong();  //子类实例被包装成父类(向上)
    //   定义方法       实际变量

        a1.language();       // >>> people lived in HongKong speak Chinese

        //a1.location();   // 向上转型时，子类单独定义的方法会丢失
        ((HongKong) a1).location(); // 但是可以利用前置括号子类,再强行转回

        // 第二种写法
        System.out.println("向上转型第二种写法: ");
        China a1b = HongKong.class.cast(new HongKong());   // 这就谁让一个子类的实例 - 能被看成父类实例
        a1b.language();     // >>> people lived in HongKong speak Chinese

        System.out.println(a1.getClass().equals(a1b.getClass()));  // >>> true

        // 子类引用不能指向父类对象 Hongkong c = (Hongkong)new China()这样是不行的
        // 那么你可能会有疑问，为什么不用HongKong al=new HongKong,直接调用location（）方法呢？这样做其实就丧失了面向对象继承多态性的灵活: 见下面例子Material and MyMenu的应用



        // 实践向下转型
        System.out.println("向下转型第一种写法: ");
        // 用于父类调用子类方法或者父类给子类变量赋值，利于程序扩展。最多的应用是Java的泛型，但向下转型存在风险
        China a2 = new HongKong();  // 同样是向上转型
        if (a2 instanceof HongKong) {  // 用if来避免问题
            China b2 = (China) a2;  // 再造一个父类实例b2,它是a2的cast,而a2其实是子类实例, 所以这个父类实例b2能支持子类的方法!!!!!
            // 上面这三行操作是精髓
            System.out.println(b2.getClass());  // >>> Hongkong  // 父类变子类成功!!
            b2.language(); // >>> people lived in HongKong speak Chinese
            // 这样b2就用上了子类的方法
        }

        // 第二种写法
        System.out.println("向下转型第二种写法: ");
        China a2b2 = new HongKong();
        if (a2b2 instanceof HongKong) {  // 用if来避免问题
            China b22 = China.class.cast(a2b2);  // 这就不多余, 再造一个父类实例b22,它是a2b2的cast,所以能被特殊看成是一个子类实例, 所以这个父类实例b22能支持子类的方法!!!!!
            // 上面这三行操作是精髓
            System.out.println(b22.getClass());  // >>> Hongkong  // 父类变子类成功!!
            b22.language(); // >>> people lived in HongKong speak Chinese
            // 这样b2就用上了子类的方法
        }
	}
}

// 向上转型语法实战
// define: fun(SuperClass Instance_Var) { }

// use: Var.method() -- use SubClass method

// 向下转型语法:
// define: fun(SuperClass Instance_Var) { }                     // 和向上转型相同!

// use:    if (Var instanceof SubClass) {              // additional if condition to make ensure correct casting
//              SuperClass New_Var = (SuperClass) Instance_Var
//              New_Var.method()                       // 调用子类方法
//              New_Var.specialmethod()                // 调用子类独有的方法
//              Special Processing(New_Var)            // 调用其他方法,只对这个子类使用
//              }


// 其他语法:
// SuperClass instace_var_1 = SubClass.class.cast(new SubClass());   // 向上专型
// SuperClass instace_var_2 = SuperClass.class.cast(instace_var_1);  // 向下专型 (但是需要先使用向上专型)
// (SubClass) SuperClass_Instance_b; 向下转型使用: 强制父类实例b使用子类的特性, 注意容易出错





// 向上转型详细解释:
class Material {
    public void intro() { }
}

//盐类
class Salt extends Material {
    public void intro() { System.out.println("我是盐"); }
    public void health() { System.out.println("做菜少放盐!");}
}

//肉类
class Meat extends Material {
    public void intro() { System.out.println("我是肉"); }
    public void price() { System.out.println("我很贵!!");}
}

//蔬菜类
class Vegetable extends Material {
    public void intro() { System.out.println("我是蔬菜"); }
}


class MyMenu {

    // 实战:
    // 不用casting,为三个子类分别写方法, 相当于使用重载overload
    public static void add(Salt m) { m.intro(); m.health(); }
    public static void add(Meat m) { m.intro(); m.price(); }
    public static void add(Vegetable m) { m.intro(); }


    // 使用casting
    // 向上向下转型混合实战:
    public static void add_2(Material m) {  // 向上转型
        if (m instanceof Salt) {
            Salt m_2 = (Salt) m;     // 需要对Salt特殊health(), 所以向下转型, 使用if来安全执行
            m_2.intro();
            m_2.health();
        } else if (m instanceof  Meat) {
            Meat m_2 = (Meat) m;    // 需要对Meat特殊health(), 所以向下转型, 使用else if来安全执行
            m_2.intro();
            m_2.price();
        } else {
            m.intro();      // 不做特殊处理的话就是单纯向上转型即可
        }
    }

    public static void main(String[] args) {
        add(new Salt());
        add(new Meat());
        add(new Vegetable());

        // add_2因为casting可以同时套用到三个子类上,分别输出子类的方法, 这样节省了重复代码
        // 向上转型是统一的单个方法来执行子类中重写的不同方法, 避免重载的麻烦
        add_2(new Salt());
        // >>>
        // 我是盐
        // 做菜少放盐

        add_2(new Meat());
        // >>>
        // 我是肉
        // 我很贵!!

        add_2(new Vegetable());
        // >>>
        // 我是蔬菜
        // 如果我又有一种新菜加进来，我只需要实现它自己的类，让他继承Material就可以了，而不需要为它单独写一个add方法。是不是提高了扩展性?
    }
}


/*
 * 用法总结:
    * 向上转型和向下转型,原则上都是用父类作为一个方法的参数(向上转型),让它分别执行子类的方法
        * 向上转型的用处是, 执行各子类相同的方法时,避免重载导致代码重复
        * 向下转型的用处是, 能够使父类参数执行子类中独特的方法(附加处理)或者是父类没有的方法
    * 这么做的动机:
        * 方法中只需要用定义一个父类的实例参数,让他们能在方法中展现出子类的特性, 由于类型检查的特性, 这个父类实例需要被看成是子类实例才能去继承子类的方法
        * 有些子类中的方法是父类也有的, 虽然被重写, 这样直接对子类call这个方法时安全的(向上转型)
        * 有些子类的方法是父类没有的,或者需要对子类进行特别操作, 因此需要根据子类类型来分别对待,这时这个父类参数必须是安全的向下转型
    * 这些都是python作为动态语言不会出现的问题,因为python不检查参数类型,而java会检查,导致了参数不能多态
 */
