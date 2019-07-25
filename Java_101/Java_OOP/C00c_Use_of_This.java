package Java_OOP;

public class C00c_Use_of_This {
    // 学习什么时候该用this
}


// 不像python强制使用self, java可以选择性不使用this
class Point1 {
    public int x = 0;
    public int y = 0;

    //constructor
    public Point1(int a, int b) {
        x = a;
        y = b;
    }
}

// but it could have been written like this:
class Point2 {
    public int x = 0;
    public int y = 0;

    //constructor
    public Point2(int x, int y) {
        this.x = x;   // 区分开内部参数和外部参数
        this.y = y;
    }
}


class Father2 {

    // 当一个类有多个Constructor的时候, 重载Constructor可以用this来省略一些代码
    public Father2(String a, String b) {
        System.out.println(a);
        System.out.println(b);
    }

    public Father2(String a) {
        this(a, "Nothing");  // 必须第一行
    }

    public static void main(String[] args) {

        Father2 A = new Father2("AAA", "BBB");
        // >>>
        // AAA
        // BBB

        Father2 C = new Father2("CCC");
        // >>>
        // CCC
        // Nothing
    }
}
