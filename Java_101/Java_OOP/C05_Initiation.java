package Java_OOP;

public class C05_Initiation {

    // 子类是否必须要重写父类的构造函数?
    // 若父类只有构造函数, 则子类必须重写
}

class Superman_1 {

    String name;
    int age;

    public Superman_1(String hero_name, int hero_age) {
        this.name = hero_name;
        this.age = hero_age;
    }
}


class Supermario_1 extends Superman_1 {
    public Supermario_1 (String mario_name, int mario_age) {
        super(mario_name, mario_age);  // 名字不一定要相同,数目要给够
        System.out.println(this.name + " is made!!");  // 可以额外再加
    }
}


// 若父类只有构造函数, 同时还重载了一个无参构造函数, 则子类不必重写
class Superman_2 {

    String name;
    int age;
    public Superman_2(String hero_name, int hero_age) {
        this.name = hero_name;
        this.age = hero_age;
    }
    public Superman_2 () { }
}

class Supermario_2 extends Superman_2 { }


// 如果父类构造函数不公开呢?
class Superman_3 {

    private String name;
    private Superman_3(String hero_name) {
        this.name = hero_name;
    }
    public Superman_3 () { }

}

class Supermario_3 extends Superman_3 {

    // 父类必须要提供一个重载的public的构造器才能被子类重写
    String name;
    public Supermario_3(String mario_name) {
        this.name = mario_name;
    }
}
