package Java_OOP;

public class C09_Interface_3 {
}

// Aditional 致命方块, 多重继承接口时出现同名方法(彻底重名,无法重载)
// 如果类型实现两个接口，并且每个接口定义具有相同签名的方法，则实际上只有一个方法，并且它们是不可区分的
interface Friend_X {
    public void play() ;
    public void beFriendly();
}

interface Pet_X {
    public void play() ;
    public void beFriendly();
}

// 这样建立一个狗类,既是朋友,也是宠物,不得行!
class Dog_X implements Friend_X, Pet_X {
    @Override
    public void play() {
        System.out.println();
    }
    @Override
    public void beFriendly(){}
}

// 还有一种方法就是使用内部类
class Dog_Y implements Friend_X {

    public void play() {
        System.out.println("Play as Friend");
    }

    public void beFriendly() {
        System.out.println("Friendly Friend");
    }

    public static class Dog_Y2 implements Pet_X { // 注意内部类要static

        public void play() {
        System.out.println("Play as Pet");
        }

        public void beFriendly() {
            System.out.println("Friendly Pet");
        }
    }
}

class Test {
    public static void main(String[] args) {

        Dog_Y DX = new Dog_Y();
        DX.beFriendly();  // >>> Friendly Friend
        DX.play();        // >>> Play as Friend

        Dog_Y.Dog_Y2 DX2 = new Dog_Y.Dog_Y2();
        DX2.beFriendly();  // >>> Friendly Pet
        DX2.play();        // >>> Play as Pet
    }
}
