// 1.1

public class C02_Print {
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
    }
}

/*
 * print command (keep next print/println command at the same as this line)
 * println command (keep next print/println command at a new line)
 * From now on it is suggested to only use println unless necessary
 * println()相当于python的'\n'
 * use print to break the printing of a complex line of output into pieces.
 */