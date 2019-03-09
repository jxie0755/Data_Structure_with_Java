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
    int speed;
    int max_speed;

    public Vehicle(int year, String build, String model, int MaxSpeed) {
        this.year = year;
        this.build = build;
        this.model = model;
        this.speed = 0;
        this.max_speed = MaxSpeed;
    }

    void ignition() {
        System.out.println("This " + this.model + " is started");
        System.out.println("Speed is " + this.speed);
    }

    void setSpeed (int new_speed) {
        this.speed = new_speed;
    }

    int full_speed() {
        this.ignition();
        this.setSpeed(this.max_speed);
        System.out.println(this.model + "'s speed is now " + this.speed);
        return this.speed;
    }

}

class Speed{}

class SUV extends Vehicle{

    private Speed sp;

    public SUV (int year, String build, String model, int MaxSpeed){
        super(year, build, model, MaxSpeed);
    }


}


class Vehicle_Test {

    public static void main(String[] args) {
        Vehicle V1 = new Vehicle(2000, "Nissan", "Altima", 120);
        V1.full_speed();
        // >>>
        // This Altima is started
        // Speed is 0
        // Altima's speed is now 120

        SUV J1 = new SUV(2015, "Jeep", "Grand Cherokee", 180);
        J1.full_speed();
        // >>>
        // This Grand Cherokee is started
        // Speed is 0
        // Grand Cherokee's speed is now 180

    }

}

/*
 * Vehicle has speed. Van also has speed
 * 这样就不用将Speed类的全部代码粘贴到Van类中了
 * 并且Speed类也可以重复利用于多个应用程序
 */


