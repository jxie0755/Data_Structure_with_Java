package zlearnings;

public class Use_of_This {
    // 学习什么时候该用this
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
