package W3C_Java_Classes;

public class C02_Math {
}

class Math_Method_Test {
    public static void main(String[] args) {
        // abs
        // 取绝对值(double, float, int, long)
        Integer x1 = -128;
        Integer x1abs = Math.abs(x1);  // 128

        // exp
        double e = Math.E;  // 2.718281828459045
        Integer x2 = 3;
        Double x2exp = Math.exp(x2);  // e^3


        // 三角函数
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI/3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));
        System.out.println(Math.PI);
    }
}

