package W3C_Java_Advaned_OOP;

public class C10_Instance_Casting {
}




// 由导出类转型成基类， 就是一个向上转型       如"Human a1=new Woman( );                            通俗地说就是是将子类对象转为父类对象
// 父类转型成子类,     就是向下转型，        如“Human a1=new Woman( ); Woman b1=(Woman) a1;”。     向下转型是把父类对象转为子类对象


class China {
	public void language(){System.out.println("Chinese people speak Chinese");}
}

class HongKong extends China {
	public void language(){System.out.println("people lived in HongKong speak Cantonese");}
	public void location(){System.out.println("South of China");}
}

class Geography_Test {

    public static void main(String[] args) {

        // 实践向上转型
        System.out.println("\n向上转型第一种写法: ");
		China a1 = new HongKong();  //子类实例被包装成父类(向上)
    //   定义变量       实际实例       理解: a1真是身份HongKong实例,但是被包装成父类实例
        System.out.println(a1.getClass()); // >>> HongKong  (暴露出真实身份)
        a1.language();       // >>> people lived in HongKong speak Cantonese  (这里可行是因为language()在父类和子类中都存在,所以真实身份(HongKong)的方法被执行)

        //a1.location();   // 然而由于a1被包装成了父类, 向上转型时，子类单独定义的方法会丢失
        ((HongKong) a1).location(); // 但是可以利用前置括号子类,再强行转回真实身份 (这其实就是向下转型了)

        // 第二种写法
        System.out.println("\n向上转型第二种写法: ");
        China a1b = HongKong.class.cast(new HongKong());  // 同理, 只是写成cast方法来, 同样是把a1b的HongKong真实身份用China包装

        System.out.println(a1.getClass()); // >>> HongKong  (暴露出真实身份)
        a1b.language();     // >>> people lived in HongKong speak Cantonese

        // 子类引用不能指向父类对象 Hongkong c = (Hongkong)new China()这样是不行的
        // 那么你可能会有疑问，为什么不用HongKong a_X =new HongKong,直接调用location（）方法呢？这样做其实就丧失了面向对象继承多态性的灵活: 见下面例子Material and MyMenu的应用



        // 实践向下转型
        System.out.println("\n向下转型第一种写法: ");
        // 用于父类调用子类方法或者父类给子类变量赋值，利于程序扩展。最多的应用是Java的泛型，但向下转型存在风险
        China a2 = new HongKong();  // 同样是向上转型, 这是必须的前提操作

        if (a2 instanceof HongKong) {  // 用if来避免问题(因为一个父类可能有多个子类,我们必须确定子类身份)

            HongKong b2 = (HongKong) a2;  // 再造一个子类变量b2,它指向的是被转回成HongKong类的a2,所以这个变量b2能支持子类的方法(尤其是指定了特定子类的HongKong的方法)!!!!!
            // 上面这三行操作是精髓

            // 这样b2就能以HongKong的身份执行HongKong的所有方法了
            b2.language(); // >>> people lived in HongKong speak Cantonese
            b2.location(); // >>> South of China
        }

        // 第二种写法
        System.out.println("\n向下转型第二种写法: ");
        China a2b2 = new HongKong();   // 同样的向上转型,包装a2b2为China身份

        if (a2b2 instanceof HongKong) {  // 用if来避免问题
            HongKong b22 = HongKong.class.cast(a2b2);  // 这就不多余, 再造一个子类变量b22,它是a2b2变回回HongKong的cast,所以能被特殊看成是一个HongKong实例
            // 上面这三行操作是精髓

            // 这样b2就用上了子类的方法
            b22.language(); // >>> people lived in HongKong speak Cantonese
            b22.location(); // >>> South of China
        }
	}
}


// 向上转型语法
// define: fun(SuperClass ins_Var) { }
// use:    ins_Var.method() -- use SubClass method

// 向下转型语法:
// define: fun(SuperClass ins_Var) { }                     // 和向上转型相同!

// use:    if (ins_Var instanceof SubClass) {              // additional if condition to make ensure correct casting
//              SubClass new_Var = (SubClass) ins_Var
//              new_Var.method()                       // 调用子类方法
//              new_Var.specialmethod()                // 调用子类独有的方法
//              special_processing(new_Var)            // 调用其他方法,只对这个子类使用
//              }


// 其他语法:
// SuperClass ins_Var_1 = SubClass.class.cast(new SubClass());   // 向上专型
// SubClass ins_Var_2 = SubClass.class.cast(ins_Var_1);  // 向下专型 (但是需要先使用向上专型)
// ((SubClass) ins_Var_1).SubClass_method();   // 另类写法, 直接引用SubClass


// 实战: 利用Casting来简化代码,避免重载, 而且方便未来扩展代码
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

    // 不用casting,为三个子类分别写方法, 相当于使用重载overload
    public static void add(Salt m) { m.intro(); m.health(); }
    public static void add(Meat m) { m.intro(); m.price(); }
    public static void add(Vegetable m) { m.intro(); }
    // 如果因为开发需要,必须增加一个新的Material子类Sugar怎么办?
    // public static void add(Sugar m) { m.intro(); }  // 只能手动添加一个新的重载方法


    // 使用casting
    public static void add_2(Material m) {  // 向上转型, 形参使用父类声明,一个方法可以通用所有子类的实参
        if (m instanceof Salt) {
            Salt m_2 = (Salt) m;     // 需要对Salt特殊health(), 所以向下转型为m_2, 使用if来安全执行
            // 这里m_2其实就是((Salt) m), m_2前面的Salt只不过是声明变量前必须给出类型
            m_2.intro();
            m_2.health();
        } else if (m instanceof  Meat) {
            ((Meat) m).intro();     // 比Salt更直接的向下转型的写法(其实是一个意思)
            ((Meat) m).price();
            System.out.println("肉类含有丰富动物蛋白质");
        } else {
            m.intro();      // 如果只是运行父类和子类共有的方法, 就是单纯向上转型即可
        }
    }

    public static void main(String[] args) {
        add(new Salt());
        add(new Meat());
        add(new Vegetable());

        // add_2因为casting可以同时套用到三个子类上,分别输出子类的方法, 这样节省了重复代码
        add_2(new Salt());
        // >>>
        // 我是盐
        // 做菜少放盐  // Salt的特殊方法

        add_2(new Meat());
        // >>>
        // 我是肉
        // 我很贵!!               // Meat的特殊方法
        // 肉类含有丰富动物蛋白质    // 针对Meat的特殊处理

        add_2(new Vegetable());
        // >>>
        // 我是蔬菜

        // 如果我又有一种新菜加进来，我只需要实现它自己的类，让他继承Material就可以了，而不需要为它单独写一个add_2方法。是不是提高了扩展性?
        // add_2(new Sugar());
    }
}


/*
 * 用法总结:
    * 向上转型和向下转型,原则上都是用父类作为一个方法的形参(向上转型),给它带入子类的形参, 让它可以分别执行子类的方法
        * 向上转型的用处是, 执行各子类相同的方法时,避免重载导致代码重复
        * 向下转型的用处是, 能够使父类形参执行子类实参的独特方法或是附加处理
    * 这么做的动机:
        * 为了规避类型检查的特性,只需要用定义一个父类的形参,让他们能在方法中展现出子类实参的特性,
        * 有些子类中的方法是父类也有的, 虽然被重写, 这样直接对子类call这个方法时安全的(向上转型)
        * 有些子类中的方法是父类没有的,或者需要对子类进行特别操作, 因此需要根据子类类型来分别对待,这时这个父类形参必须是安全的向下转型回子类实参
    * 这些都是python作为动态语言不会出现的问题,因为python不检查参数类型,而java会检查,导致了参数不能多态
 */
