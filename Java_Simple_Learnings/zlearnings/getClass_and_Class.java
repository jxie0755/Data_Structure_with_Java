package zlearnings;

public class getClass_and_Class {

    /*
     * 学习getClass和instance.class有什么区别
     *  看起来一样?
        *  但是getClass()是给实例用的
        *  class是给类用的
     */

}


class GetClassExample {
    public void func(){

    }
}

class GetClassTest {

    public static void main(String[] args) {
        GetClassExample a = new GetClassExample();
        System.out.println(a.getClass());            // >>>  class ..GetClassExample
        System.out.println(GetClassExample.class);   // >>>  class ..GetClassExample
    }
}


//出现继承时?
class GetA {
    public class GetC extends GetA {

    }
}

class GetB extends GetA {

}

class GetABTest {

    public static void main(String[] args) {
        GetA a = new GetA();
        GetB b = new GetB();
        GetA ab = new GetB();

        System.out.println(a.getClass()+" "+ GetA.class); // >>>  class ..GetA class ..GetA
        System.out.println(b.getClass()+" "+ GetB.class); // >>>  class ..GetB class ..GetB
        System.out.println(ab.getClass()); // >>> class ..GetB
        ab = a;
        System.out.println(ab.getClass()); // >>> class ..GetA // 是ab在运行到这一时刻是所属的类型

        // 还有一个getSuperclass (对于class用而不是instance)
        // 对于内部类也有用,参见C09_Inner_Class
        System.out.println(b.getClass().getSuperclass()); // >>> class ..GetA

    }

}
