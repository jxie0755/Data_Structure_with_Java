package Java_Basics;// 1.1

public class C02_Print {

    /*
     * print_class command (keep next print_class/println command at the same as this line)
     * println command (keep next print_class/println command at a new line)
     * From now on it is suggested to only use println unless necessary
     * println()相当于python的'\n'
     * use print_class to break the printing of a complex line of output into pieces.
     */

    public static void main(String[] args) {
        System.out.print("1");
        System.out.print("2");
        System.out.print("3");
        System.out.println("4");  // println suggest next line will be new line, not this one
        System.out.print("new line");
        System.out.print("5");
        System.out.print("6");
        System.out.print("7");
        // >>>
        //1234
        //new line567
        System.out.println();

        // Learn printf
        System.out.printf("%5.2f", 3.444789);   // "  3.46"
        // 格式化浮点模式,总长度5位,小数点后两位, 注意如果不够5位会用空字符弥补, 会自动四舍五入
        System.out.printf("\n%d%n", 3123);   // "  3.46"   // "\n"和"%n"都是换行
    }
}

