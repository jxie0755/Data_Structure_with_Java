package chapter_01;

public class HeadFirstJava {

    public static void main_head(String[] args) {   // this will not be executed
        System.out.println("From main 2");
    }

    public static int larger(int x, int y) {
		if (x > y) {
			return x;
		}
		return y;
	}

    public static void main(String[] args) {
        int x = 5;
        int y = x +3;  // must also claim y's type
        System.out.println("From main():");
        System.out.println(y);
        System.out.println(larger(99, 101));
        System.out.println(larger_tail(99, 101));  // Actually the method (larger_tail) can be behind main()

    }

    public static void main_tail(String[] args) {   // this will not be executed
        System.out.println("From main 2");
    }

    public static int larger_tail(int x, int y) {
		if (x > y) {
		    return x;
		}
		return y;
	}
}

/**
 * Javac会执行main方法在{}内的所有指令
 * 每个Java程序最少都会有一个类以及一个main()
 * 每个应用程序只有一个main()函数
 */


/**
 * 在java中所有的东西都会属于某个类.
 * 源文件(*.java)会被编译成类文件(*.class)
 * 真正被执行的是类
 * 要执行某个程序就代表要命令java虚拟机(JVM)去加载这个类,开始执行它的main(),直到main()被执行完成
*/
