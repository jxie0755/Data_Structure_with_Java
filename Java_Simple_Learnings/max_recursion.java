public class max_recursion {

    static void maxRecursionDepth(int n) {
        System.out.println(n);
        maxRecursionDepth(n+1);
    }

    static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        // maxRecursionDepth(1);

        double startTime  =System.currentTimeMillis();   //获取开始时间

        System.out.println(max_recursion.fib(45));

        double endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("--- "+ (endTime-startTime)/1000  + "s seconds ---");

    }
}
