package zsnippets;

public class Return_Null {

    static Integer foo(Integer n) {
        if (n < 10) {
            return n;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

        Integer x = foo(20);
        System.out.println(x);  // 因为null 是可以强转为任何类类型的

        System.out.println((Double) null);
    }

}

