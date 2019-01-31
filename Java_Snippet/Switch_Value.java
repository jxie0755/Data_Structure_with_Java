public class Switch_Value {
    public static void main(String[] args) {
        int x, y, temp;

        // 常用temp
        x = 10;
        y = 20;
        temp = x;
        x = y;
        y = temp;
        System.out.println("x " + x);
        System.out.println("y " + y);

        // 不借助 temp
        x = 10;
        y = 20;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("x " + x);
        System.out.println("y " + y);

        //利用位运算
        x = 10;
        y = 20;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x " + x);
        System.out.println("y " + y);
    }
}

/*
 * Java does not allow a, b = b, a
 */