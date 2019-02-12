package W3C_basic;

import java.io.UncheckedIOException;

public class C06_Exceptions {
}

/*
 * 异常发生的原因有很多，通常包含以下几大类:
     * 用户输入了非法数据。
     * 要打开的文件不存在。
     * 网络通信时连接中断，或者JVM内存溢出
 */


/*
 * 这些异常有的是因为用户错误引起，有的是程序错误引起的，还有其它一些是因为物理错误引起的
 * 要理解Java异常处理是如何工作的，你需要掌握以下三种类型的异常:
    * 检查性异常：最具代表的检查性异常是用户错误或问题引起的异常，这是程序员无法预见的。
        * 例如要打开一个不存在文件时，一个异常就发生了，这些异常在编译时不能被简单地忽略。
    * 运行时异常： 运行时异常是可能被程序员避免的异常。
        * 与检查性异常相反，运行时异常可以在编译时被忽略。
    * 错误： 错误不是异常，而是脱离程序员控制的问题。
        * 错误在代码中通常被忽略。例如，当栈溢出时，一个错误就发生了，它们在编译也检查不到的。
 */


// 异常类
/*
 * 异常类结构:
    * Throwable
        * Error
            * 无子类
        * Exception
            * IOException
            * RuntimeException

 * Error:
     * Java程序通常不捕获Errir。错误一般发生在严重故障时，它们在Java程序处理的范畴之外。
     * Error用来指示运行时环境发生的错误。
    * 例如，JVM内存溢出。一般地，程序不会从错误中恢复。
 */


// 捕获异常
class Exception_Test {
    public static void main(String[] args) {

        // 简单捕获
        try {
            int x = 1 / 0;
        } catch(Exception e1) {
            System.out.println("WTF?");
            System.out.println(e1);  // >>> java.lang.ArithmeticException: / by zero
        }

        // 多重捕获
        try {
            // 程序代码
        } catch (ArithmeticException e1) {
            // 程序代码
        } catch (UncheckedIOException e2) {
            // 程序代码
        } catch (ClassCastException e3) {
            // 程序代码
        }
    }
}

// throws/throw关键字
// 如果一个方法没有捕获一个检查性异常，那么该方法必须使用throws 关键字来声明。throws关键字放在方法签名的尾部

//这是自定义的异常类
class AuctionException extends Exception{
    public AuctionException(){}
    public AuctionException(String msg){super(msg);}
}

class Auction {
    private double iniPrice = 30.0;

    public void bid(String bidPrice) throws AuctionException{ // 可支持多个已异常,用括号间隔
        double d = 0.0;
        boolean err = false;

        // 方法内部进行了异常处理
        try{
            d = Double.parseDouble(bidPrice); // 转化string为double

        }catch (NumberFormatException e){
            err = true;
            throw new AuctionException("字符转化不成数字");

        } finally {  // finally必须被执行
            if (! err && iniPrice > d) {
                System.out.print("??????????? ");
                throw new AuctionException("出价还不够起价");
            }
        }
        iniPrice = d;  // 这个一定要放finally外面,因为finally就算遇到错误也会执行
    }


    public static void main(String args[]){
        Auction vase = new Auction();
        // main方法为调用者，必须使用try进行异常处理
        // vase.bid("123"); // 不然会出现unhandled exception

        try{
            vase.bid("abc");
        }catch (AuctionException ae){
            System.out.println(ae);
        }
        // >>> W3C_basic.AuctionException: 字符转化不成数字

        try{
            vase.bid("12");
        }catch (AuctionException ae){
            System.out.println(ae);
        }
        // >>> ??????????? W3C_basic.AuctionException: 出价还不够起价
    }
}



// 详细例子: 自定义的异常类