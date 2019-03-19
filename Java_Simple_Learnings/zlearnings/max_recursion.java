package zlearnings;

public class max_recursion {

    static void maxRecursionDepth(int n) {
        System.out.println(n);
        maxRecursionDepth(n+1);
    }

    public static void main(String[] args) {
        maxRecursionDepth(1);
    }
}

