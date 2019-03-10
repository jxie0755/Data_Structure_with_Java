package Java_OOP;

public class C01_Inheritance_Extends {

    /*
     * 通过使用关键字extends，子类可以继承父类的除private属性外所有的属性
         * Animal类是Mammal类的父类。
         * Animal类是Reptile类的父类。
         * Mammal类和Reptile类是Animal类的子类。
         * Dog类既是Mammal类的子类又是Animal类的子类。
     */

}

// Inheritance

// Use of extends (Is-A关系)
class Animal{
}


class Mammal extends Animal{
}

class Reptile extends Animal{
}

class Dog extends Mammal{

    public static void main(String[] args) {
        Animal a = new Animal();
        Mammal m = new Mammal();
        Dog d = new Dog();

        // use instanceof 来判定类的从属关系
        System.out.println(m instanceof Animal);  // >>> true
        System.out.println(d instanceof Mammal);  // >>> true
        System.out.println(d instanceof Animal);  // >>> true
    }

// Java只支持单继承，也就是说，一个类不能继承多个类。
// public class Dog extends Animal, Mammal{}    是不合法的

// Java只支持单继承（继承基本类和抽象类），但是我们可以用接口来实现（多继承接口来实现）,脚本结构如
// public class Apple extends Fruit implements Fruit1, Fruit2{}

}

// Use of extends 2 (Has-A 关系)

class Vehicle {
    int year;
    String build;
    String model;
    int maxspd;
    public Speed speed;  // has-a 继承关系

    public Vehicle(int year, String build, String model, int MaxSpeed) {
        this.year = year;
        this.build = build;
        this.model = model;
        this.maxspd = MaxSpeed;
        this.speed = new Speed();
        System.out.println(this.model + " starting speed: " + this.speed.spd);
    }

    void add_speed(int n) {
        this.speed.set_speed(n);
        System.out.println(this.model + " speed: " + this.speed.spd);
    }

    void full_speed() {
        this.speed.set_speed(this.maxspd);
        System.out.println(this.model + " speed: " + this.speed.spd);
    }

}

class SUV extends Vehicle{

    public SUV (int year, String build, String model, int MaxSpeed){
        super(year, build, model, MaxSpeed);
    }

}

class Speed{
    /*
     * Vehicle has speed. Van also has speed
     * 这样就不用将Speed类的全部代码粘贴到Van类中了
     * 并且Speed类也可以重复利用于多个类
     */

    int spd = 0;

    public void set_speed(int new_speed) {
        this.spd = new_speed;

    }

}


class Vehicle_Test {

    public static void main(String[] args) {
        Vehicle V1 = new Vehicle(2000, "Nissan", "Altima", 120);
        V1.add_speed(55);
        V1.full_speed();
        // >>>
        // Altima starting speed: 0
        // Altima speed: 55
        // Altima speed: 120

        System.out.println();
        SUV J1 = new SUV(2015, "Jeep", "Grand Cherokee", 180);
        J1.add_speed(80);
        J1.full_speed();
        // >>>
        // Grand Cherokee starting speed: 0
        // Grand Cherokee speed: 80
        // Grand Cherokee speed: 180
    }
}




