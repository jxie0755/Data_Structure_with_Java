package chapter_01;

public class HeadFirstJava {

    public static void main(String[] args) {
        int x = 5;
        int y = x +3;  // must also claim y's type
        System.out.println(y);
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
