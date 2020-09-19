package Java_Classes;

class A02_Math {

    /*
     * Module java.base
     * Package java.lang
     * Class Math
     */
}

class Math_zMethods {
    public static void main(String[] args) {
        // ceil, floor, and rint
        // 返回doubnle值
        Double d1 = 1.499999;
        Double d2 = Math.ceil(d1);   // 2.0
        Double d3 = Math.floor(d1);  // 1.0
        Double d4 = Math.rint(d1);   // 分界于0.499和0.500
        System.out.println(d2 + " " + d3 + " " + d4);


        // round
        // 返回int, long值
        int i1 = Math.round(1.9f);   // 2  // float参数返回int或long
        long l1 = Math.round(1.9d);  // 2  // double参数返回long
        System.out.println(i1 + " " + l1);

        // abs
        // 取绝对值(double, float, int, long)
        Integer i2 = -128;
        Integer i2abs = Math.abs(i2);  // 128

        // exp
        double e = Math.E;  // 2.718281828459045
        Integer i3 = 3;
        Double i3exp = Math.exp(i3);  // e^3

        // log, log10
        double d5 = Math.log(Math.exp(i3));  // 3.0
        double d6 = Math.log10(100);         // 2.0

        // pow
        double d7 = Math.pow(2, 3);  // 8.0

        // sqrt and cbrt
        double d8 = Math.sqrt(16);  // 4.0
        double d9 = Math.cbrt(27);  // 3.0

        // 三角函数
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI / 2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI / 3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI / 2));
        System.out.println(Math.PI);


        // Max and Min
        // int long double float
        double d10 = Math.max(10, 9);  // 10.0
        double d11 = Math.min(10, 9);  // 9.0
        // check Code snippet for max and min in an iterable (Array or ArrayList)

        // random
        // Returns a double value with a positive sign,
        // greater than or equal to 0.0 and less than 1.0
        double x = Math.random();
        System.out.println(x);
        // As the largest double value less than 1.0 is Math.nextDown(1.0),
        // a value x in the closed range [x1,x2] where x1<=x2
        // may be defined by the statements
        double f = Math.random() / Math.nextDown(1.0);
        double x_range = 3 * (1.0 - f) + 5 * f;  // range(3, 5)

        // 获取随机整数? 比如[0, 100)
        int random_int = (int) (Math.random() * 100);


        // nextUp and nextDown
        // float and double
        // nextUp: Returns the floating-point value adjacent to d in the direction of positive infinity
        double dd = 0.0; // remember double type
        double d_up = Math.nextUp(dd);
        System.out.println(d_up + ">>>>>>>>");  // 4.9E-324
        System.out.println((d_up - dd) == Double.MIN_VALUE);
        System.out.println(Double.MIN_VALUE); // but only worked for 0.0

        // nextDown: Returns the floating-point value adjacent to d in the direction of negative infinity.
        double d_down = Math.nextDown(dd);
        System.out.println(d_down + ">>>>>>>>");  // 4.9E-324
        System.out.println((dd - d_down) == Double.MIN_VALUE);
        System.out.println(Double.MIN_VALUE); // but only worked for 0.0
        // STOF: https://stackoverflow.com/questions/54699305/java-nextup-is-not-adding-float-min-value?noredirect=1#comment96185999_54699305
        // Your assumption would only be correct if all doubles were evenly spaced, but of course they are not.

        // nextAfter
        // double, float
        // same thing but add a second parameter to go with the direction
        double ddd = 1.5;
        double d_after1 = Math.nextAfter(ddd, 2.0);  // 1.5000000000000002
        double d_after2 = Math.nextAfter(ddd, 1.0);  // 1.4999999999999998
        double d_after3 = Math.nextAfter(ddd, 1.5);  // 1.5
        // 简单的说就是
        // if second para > dd, return Math.nextUp()
        // if second para < dd, return Math.nextDown()
        // if second para == dd, reurn dd
    }
}
