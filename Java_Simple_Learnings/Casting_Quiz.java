class Casting_Quiz {
    // TODO: https://www.yinwang.org/blog-cn/2020/02/13/java-type-system
    // http://www2.zhihu.com/question/371957442
    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }

    public static void main(String[] args) {
        f();
    }
}

