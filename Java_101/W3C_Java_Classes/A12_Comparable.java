package W3C_Java_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A12_Comparable {

    /*
     * Module java.base
     * Package java.lang
     * Interface Comparable<T>
     */

    /*
     * 用于类内部定义比较各instance之间的大小
     * 类似python的__lt__, __le__之类
     */

    /*
     * x.compareTo(y) 来“比较x和y的大小”
         * 若返回“负数”，意味着“x比y小”
         * 返回“零”，意味着“x等于y”
         * 返回“正数”，意味着“x大于y”
     */

}

// 一个例子来解释怎么用

class Animal {
    void foo() {
        System.out.println("!!!!!!!!!!!");
    }
}


class Dog extends Animal implements Comparable<Dog> {
                         // 记住不要忘了继承Comparable接口

    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog " + this.name;
    }

    @Override
    public int compareTo(Dog a) { // 只要一个参数
        return this.age - a.age;
    }

    public static void main(String[] args) {

        // 给狗排序, 根据什么呢? 根据狗的年龄
        Dog d1 = new Dog("AA", 5);
        Dog d2 = new Dog("BB", 1);
        Dog d3 = new Dog("CC", 2);

        d1.foo();

        List<Dog> doglist = new ArrayList<>(Arrays.asList(d1, d2, d3));
        System.out.println(doglist);
        // >>> [Dog AA, Dog BB, Dog CC]

        Collections.sort(doglist);

        System.out.println(doglist);
        // >>> [Dog AA, Dog BB, Dog CC]
    }
}

