package zlearnings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This is to learn the difference of the generic type claim

class Car {
    void foo() {
        System.out.println("!!!!!!!!!");
    }
}

public class Generics_Statement {

    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();

        List<Car> carList = List.of(c1,c2,c3);
        System.out.println(carList.get(0).getClass());      // >>> class zlearnings.Car
        System.out.println(carList.get(0) instanceof Car);  // >>> true

        carList.get(0).foo();

        List<Object> objList = List.of(c1,c2,c3);
        System.out.println(objList.get(0).getClass());      // >>> class zlearnings.Car
        System.out.println(objList.get(0) instanceof Car);  // >>> true
        // objList.get(0).foo();


        List rawList = List.of(c1,c2,c3);
        System.out.println(rawList.get(0).getClass());      // >>> class zlearnings.Car
        System.out.println(rawList.get(0) instanceof Car);  // >>> true
        // rawList.get(0).foo();

        List<?> wtfList = List.of(c1,c2,c3);
        System.out.println(wtfList.get(0).getClass());      // >>> class zlearnings.Car
        System.out.println(wtfList.get(0) instanceof Car);  // >>> true
        // rawList.get(0).foo();
    }
}


// 参见STOF: https://stackoverflow.com/a/2770692/8435726
/*
 * quick summary
    * 避免使用raw type,声明尽量准确
    * raw type被允许是因为兼容老代码, 彼时java还不支持泛型
    * List和List<?>和List<Object>都是不同的
 */



class MyType<E> {

    class Inner { }
    static class Nested { }

    public static void main(String[] args) {
        MyType mt;          // warning: MyType is a raw type
        MyType.Inner inn;   // warning: MyType.Inner is a raw type
        MyType.Nested nest; // no warning: not parameterized type
        MyType<Object> mt1; // no warning: type parameter given
        MyType<?> mt2;      // no warning: type parameter given (wildcard OK!)



        List names = new ArrayList(); // warning: raw type!
        names.add("John");
        names.add("Mary");
        names.add(Boolean.FALSE); // not a compilation error!
                 // 不报错,但是下面运行时可能出问题

        for (Object o : names) {
            String name = (String) o;
            System.out.println(name);
        } // throws ClassCastException! // 显然Boolean不是String
        //    java.lang.Boolean cannot be cast to java.lang.String

        // 正确使用泛型可以预防这种错误, 在编译前就被发现
        List<String> names2 = new ArrayList<String>();
        names2.add("John");
        names2.add("Mary");
        names2.add(Boolean.FALSE); // compilation error!
                  // 直接就报错
    }
}


class rawTypeTest {

    // 先造一个方法
    void appendNewObject(List<Object> list) {
        list.add(new Object());
    }

    // 如果用wildcard
    static void appendNewObject2(List<?> list) {
        list.add(new Object()); // compilation error!
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        appendNewObject(names); // compilation error!
        // 原因也在之前泛型总结里讨论过, String是Object的子类, 但是List<String>不是List<Object>的子类

        // 但是这个在Raw Type反而可行
        List names2 = new ArrayList<String>();
        appendNewObject(names2);
        // If you had declared appendNewObject to take a raw type List as parameter, then this would compile,
        // and you'd therefore lose the type safety that you get from generics.
        // 可能java版本更新了,现在也不能通过编译了


        //wildcard
        List<String> names3 = new ArrayList<String>();
        appendNewObject2(names3); // this part is fine!
        // 但是在方法声明时就会报错

    }
}



class MyType2<E> {

    List<String> getNames() {
        return Arrays.asList("John", "Mary");
    }


    public static void main(String[] args) {
        MyType rawType = new MyType();
        // unchecked warning!
        // required: List<String> found: List

        // 类型擦除导致即使方法声明了返回List<String>, 也被擦除成为List
        List<String> names = rawType.getNames();
        // compilation error!
        // incompatible types: Object cannot be converted to String
    }
}

