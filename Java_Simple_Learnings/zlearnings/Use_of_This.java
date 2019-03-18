package zlearnings;

public class Use_of_This {
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



class Father {

    // 当一个类有多个Constructor的时候, 重载Constructor可以用this来省略一些代码
    public Father(String a, String b) {
        System.out.println(a);
        System.out.println(b);
    }

    public Father(String a) {
        this(a, "Nothing");
    }

    public static void main(String[] args) {

        Father A = new Father("AAA", "BBB");
        // >>>
        // AAA
        // BBB

        Father C = new Father("CCC");
        // >>>
        // CCC
        // Nothing
    }
}
