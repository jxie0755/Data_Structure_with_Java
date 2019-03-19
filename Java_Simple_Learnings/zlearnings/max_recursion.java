package zlearnings;

public class max_recursion {

    void maxRecursionDepth(int n) {
        System.out.println(n);
        this.maxRecursionDepth(n+1);
    }

    public static void main(String[] args) {
        max_recursion A = new max_recursion();
        A.maxRecursionDepth(1);
    }
}

