package Java_Basics;

import java.io.*;

public class C14_IO_stream {

    /*
     * Java将数据的输入输出（I/O） 操作当作“流”来处理
     * “流”是一组有序的数据序列
     * “流”分为两种形式:
        * 输入流 - 从数据源中读取数据是输入流
            * 输入形式如文件, 网络和键盘等, 键盘是默认的标准输入设备。
        * 输出流 - 将数据写入到目的地是输出流
            * 数据输出的目的地也有多种形式, 如文件, 网络和控制台, 控制台(console)是默认的标准输出设备
     * 所有的输入形式都抽象为输入流， 所有的输出形式都抽象为输出流， 它们与设备无关

     * 字节流处理所有二进制文件(所有电脑文件), 字符流只处理文本文件.
         * 以字节为单位的流称为字节流
            * Java中的字节流处理的最基本单位为单个字节，它通常用来处理二进制数据 (也就是处理所有文件)
         * 以字符为单位的流称为字符流
            * 通常用来处理文本数据。所谓Unicode码元，也就是一个Unicode代码单元，范围是0x0000~0xFFFF
            * 在以上范围内的每个数字都与一个字符相对应，Java中的String类型默认就把字符以Unicode规则编码而后存储在内存中

     * Java SE提供4个顶级抽象类:
        * 两个字节流抽象类:
            * InputStream
                * 实体子类 FileInputStream
                * 实体子类 FilterInputStream
                    * 实体子类 BufferedInputStream
            * OutputStream
                * 实体子类 FileOutputStream
                * 实体子类 FilterOutputStream
                    * 实体子类 BufferedOutputStream

        * 两个字符流抽象类 (基本对应字节流的架构)
            * Reader
                * 实体子类 FileReader
                * 实体子类 BufferedReader
            * Writer
                * 实体子类 FileWriter
                * 实体子类 BufferedWriter
     */


    /*
     * FilterInputStream和FilterOutputStream称为过滤流
     * 过滤流实现了装饰器（Decorator） 设计模式， 这种设计模式能够在运行时扩充一个类的功能。 而继承在编译时扩充一个类的功能
     * 过滤流的作用是扩展成其他流， 增强功能。

         * 那么BufferedInputStream和BufferedOutputStream增强了缓冲能力
         * BufferedInputStream和BufferedOutputStream称为字节缓冲流
             * 使用字节缓冲流内置了一个缓冲区， 第一次调用read方法时尽可能多地从数据源读取数据到缓冲区
             * 后续再到用read方法时先看看缓冲区中是否有数据
                 * 如果有则读缓冲区中的数据
                 * 如果没有再将数据源中的数据读入到缓冲区
             * 这样可以减少直接读数据源的次数。
             * 通过输出流调用write方法写入数据时， 也先将数据写入到缓冲区， 缓冲区满了之后再写入数据目的地，
             * 这样可以减少直接对数据目的地写入次数。 使用了缓冲字节流可以减少I/O操作次数， 提高效率
     */

}


class Java_Byte_Stream {

    /*
     * Module java.base
     * Package java.io
     * Class InputStream (Abstract)
     */


    /*
     * InputStream 常用方法
         * int read()
            * 读取一个字节， 返回0到255范围内的int字节值
            * 如果已经到达流末尾， 而且没有可用的字节， 则返回值-1。

         * int read(byte b[] )
            * 读取多个字节， 数据放到字节数组b中
            * 返回值为实际读取的字节的数量
            * 如果已经到达流末尾， 而且没有可用的字节， 则返回值-1。

         * int read(byte b[ ], int off, int len)
            * 最多读取len个字节， 数据放到以下标off开始字节数组b中
            * 将读取的第一个字节存储在元素b[off]中， 下一个存储在b[off+1]中依次类推。
            * 返回值为实际读取的字节的数量
            * 如果已经到达流末尾， 而且没有可用的字节， 则返回值-1。

         * void close()
            * 流操作完毕后必须关闭

         * 上述所有方法都可能会抛出IOException， 因此使用时要注意处理异常


     * FileInputStream 构造方法
        * FileInputStream(String name)
            * 构造方法, 创建FileInputStream对象， name是文件名
            * 如果文件不存在则抛出FileNotFoundException异常

        * FileInputStream(File file)
            * 构造方法(重载) 通过File对象创建FileInputStream对象
            * 如果文件不存在则抛出FileNotFoundException异常。

     * BufferedInputStream 构造方法
        * BufferedInputStream(InputStreamin)
            * 通过一个底层输入流in对象创建缓冲流对象
            * 缓冲区大小是默认的， 默认值8192。

        * BufferedInputStream(InputStreamin, int size)
            * 通过一个底层输入流in对象创建缓冲流对象， size指定的缓冲区大小
            * 缓冲区大小应该是2的n次幂， 这样可提供缓冲区的利用率
     */

    // =====================================================================================================//

    /*
     * Module java.base
     * Package java.io
     * Class OutputStream (Abstract)
     */

    /*
     * OutputSteam 常用方法
        * void write(int b)
            * 将b写入到输出流， b是int类型占有32位
            * 写入过程是写入b 的8个低位， b的24个高位将被忽略

        * void write(byte b[ ])
            * 将b.length个字节从指定字节数组b写入到输出流

        * void write(byte b[ ], int off, int len)
            * 把字节数组b中从下标off开始， 长度为len的字节写入到输出流

        * void flush()
            * 刷空输出流， 并输出所有被缓存的字节。 由于某些流支持缓存功能
            * 该方法将把缓存中所有内容强制输出到流中

        * void close( )
            * 流操作完毕后必须关闭

        *  上述所有方法都声明抛出IOException， 因此使用时要注意处理异常


     * FileOutputStream 构造方法
        * FileOutputStream(String name)：
            * 通过指定name文件名创建FileOutputStream对象
            * 如果name文件存在， 但如果是一个目录或文件无法打开则抛出FileNotFoundException异常

        * FileOutputStream(String name, boolean append)
            * 通过指定name文件名创建FileOutputStream对象
            * append参数如果为 true， 则将字节写入文件末尾处， 而不是写入文件开始处
            * 如果name文件存在， 但如果是一个目录或文件无法打开则抛出FileNotFoundException异常

        * FileOutputStream(File file)
            * 通过File对象创建FileOutputStream对象。
            * 如果file文件存在,但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。

        * FileOutputStream(File file, boolean append)
            * 通过File对象创建FileOutputStream对象
            * append参数如果为 true， 则将字节写入文件末尾处，而不是写入文件开始处。
            * 如果file文件存在, 但如果是一个目录或文件无法打开则抛出FileNotFoundException异常

     * BufferedOutputStream 构造方法
        * BufferedOutputStream(OutputStreamout)
            * 通过一个底层输出流out 对象创建缓冲流对象
            * 缓冲区大小是默认的， 默认值8192。
        * BufferedOutputStream(OutputStreamout, int size)
            * 通过一个底层输出流out对象创建缓冲流对象， size指定的缓冲区大小，
            * 缓冲区大小应该是2的n次幂， 这样可提高缓冲区的利用率。
     */




    public static void main(String[] args) {

        // 案例1: 复制文件
        // 实现文件复制， 数据源是文件， 所以会用到文件输入流FileInputStream，
        // 数据目的地也是文件， 所以会用到文件输出流FileOutputStream
        // 这两个类也基本使用父类的方法
        // 首先读取文件
        try (FileInputStream in = new FileInputStream("./TestDir/IOfile.txt");
             FileOutputStream out = new FileOutputStream("./TestDir/IOfile_out.txt")) {
            // 这是自动资源管理的写法， 不需要自己关闭流

            // 准备一个缓冲区
            byte[] buffer = new byte[8];
            // 缓冲区大小（字节数组长度） 多少合适？
            // 缓冲区大小决定了一次读写操作的最多字节数， 缓冲区设置的很小， 会进行多次读写操作才能完成。
            // 所以如果当前计算机内存足够大， 而不影响其它应用运行情况下， 当然缓冲区是越大越好。

            // 首先读取一次
            int len = in.read(buffer);

            while (len != -1) {
                System.out.println("len: " + len);
                // 注意这个len才是真正表示读了几个in, 如果设定缓冲区为10
                // 那么每次如果可以全部读取新鲜数据就会返回
                // 如果剩下不到10个新鲜数据, 比如只有2个,就会返回2
                // 如果再往下, 没有任何新鲜数据, 才返回-1

                // 这个String会把整个buffer读出来, 问题是,buffer可能不全是新鲜数据
                System.out.println(new String(buffer));

                // 这样写就可以保证只把新鲜数据写到新文件, 而不是整个String
                out.write(buffer, 0, len);  // 开始写入
                len = in.read(buffer);         // 刷新len
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // 当使用try-with-resource时, 会有一个隐藏的close(), 这个方法会抛出IOExceptin,所以要处理
            // STOF: https://stackoverflow.com/q/55381324/8435726
            e.printStackTrace();
        }

        // 案例2: 高效复制文件 (大小为2.2G视频)
        // 为省空间这里视频文件已经不在, 直接comment whole block
        // 这里利用BufferedInputStream和BufferedOutputStream
        // try (FileInputStream in2 = new FileInputStream("./TestDir/testV.mp4");
        //      FileOutputStream out2 = new FileOutputStream("./TestDir/testV_buffered_out.mp4");
        //      // 使用缓冲字节流
        //      BufferedInputStream bis = new BufferedInputStream(in2);
        //      BufferedOutputStream bos = new BufferedOutputStream(out2)) {
        //
        //     long startTime = System.nanoTime();  //开始时间
        //     byte[] buffer = new byte[1024];      // 准备一个缓冲区
        //     int len = bis.read(buffer);          // 首先读取一次
        //
        //     while (len != -1) {
        //         bos.write(buffer, 0, len);   // 开始写入数据
        //         len = bis.read(buffer);          // 再读取一次
        //     }
        //     long elapsedTime = System.nanoTime() - startTime; //结束时间
        //     System.out.println("buffered 耗时： " + (elapsedTime / 1000000.0) + " 毫秒");
        //
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // // 对比不用缓冲字节流的方法1
        // try (FileInputStream in3 = new FileInputStream("./TestDir/testV.mp4");
        //      FileOutputStream out3 = new FileOutputStream("./TestDir/testV_out.mp4");){
        //
        //     long startTime = System.nanoTime(); //开始时间
        //     byte[] buffer = new byte[1024];     // 准备一个缓冲区
        //     int len = in3.read(buffer);        // 首先读取一次
        //
        //     while (len != -1) {
        //         out3.write(buffer, 0, len);   // 开始写入数据
        //         len = in3.read(buffer);           // 再读取一次
        //     }
        //     //结束时间
        //     long elapsedTime = System.nanoTime() - startTime;
        //     System.out.println("not buffered 耗时： " + (elapsedTime / 1000000.0) + " 毫秒");
        //
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // >>>
        // buffered 耗时： 2644.297795 毫秒        (快很多)
        // not buffered 耗时： 11545.606955 毫秒

        // 如果缓冲区设为4096:
        // 则buffer开始变慢, non-buffer变快, 也就是说如果缓冲区可以足够大, 则不需要用缓冲字节流
        // buffered 耗时： 3137.131243 毫秒
        // not buffered 耗时： 4267.921515 毫秒
    }
}

class Java_Character_Stream {

    /*
     * Module java.base
     * Package java.io
     * Class Reader    (Abstract)
     */

    /*
     * Reader主要方法
        * int read()
            * 读取一个字符， 返回值范围在0~65535(0x00~0xffff)之间。
            * 如果因为已经到达流末尾， 则返回值-1。

        * int read(char[] cbuf)
            * 将字符读入到数组cbuf中， 返回值为实际读取的字符的数量
            * 如果因为已经到达流末尾， 则返回值-1。

        * int read(char[] cbuf, int off, int len)
            * 最多读取len个字符， 数据放到以下标off开始字符数组cbuf中， 将读取的第一个字符存储在元素cbuf[off]中，
            * 下一个存储在cbuf[off+1]中， 依次类推。 返回值为实际读取的字符的数量，
            * 如果因为已经到达流末尾， 则返回值-1。

        * void close()
            * 流操作完毕后必须关闭。

        * 上述所有方法都声明了抛出IOException， 因此使用时要注意处理异常

     * FileReader 构造方法
        * FileReader(String fileName)
            * 创建FileReader对象， fileName是文件名。
            * 如果文件不存在则抛出FileNotFoundException异常。

        * FileReader(File file)
            * 通过File对象创建FileReader对象。
            * 如果文件不存在则抛出FileNotFoundException异常

     * BufferedReader
        * 构造方法
            * BufferedReader(Reader in)
                * 通过一个底层输入流in对象创建缓冲流对象， 缓冲区大小是默认的， 默认值8192。

            * BufferedReader(Reader in, int size)
                * 通过一个底层输入流in对象创建缓冲流对象
                * size指定的缓冲区大小， 缓冲区大小应该是2的n次幂， 这样可提高缓冲区的利用率。
        * 特殊方法
            * String readLine()
                * 读取一个文本行， 如果因为已经到达流末尾， 则返回值null
     */



    /*
     * Module java.base
     * Package java.io
     * Class Writer    (Abstract)
     */

    /*
     * Writer主要方法
        * void write(int c)
            * 将整数值为c的字符写入到输出流， c是int类型占有32位
            * 写入过程是写入c的16个低位， c的16个高位将被忽略。

        * void write(char[] cbuf)
            * 将字符数组cbuf写入到输出流。

        * void write(char[] cbuf, int off, int len)
            * 把字符数组cbuf中从下标off开始， 长度为len的字符写入到输出流。

        * void write(String str)
            * 将字符串str中的字符写入输出流。

        * void write(String str,int off,int len)
            * 将字符串str 中从索引off开始处的len个字符写入输出流。

        * void flush()
            * 刷空输出流， 并输出所有被缓存的字符。
            * 由于某些流支持缓存功能， 该方法将把缓存中所有内容强制输出到流中。

        * void close( )
            * 流操作完毕后必须关闭。

        * 上述所有方法都可以会抛出IOException， 因此使用时要注意处理异常。

     * FileWriter 构造方法
        * FileWriter(String fileName)
            * 通过指定fileName文件名创建FileWriter对象。 如果fileName文件存在，
            * 但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。

        * FileWriter(String fileName, boolean append)
            * 通过指定fileName文件名创建FileWriter对象
            * append参数如果为 true， 则将字符写入文件末尾处， 而不是写入文件开始处。
            * 如果fileName文件存在， 但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。

        * FileWriter(File file)
            * 通过File对象创建FileWriter对象。
            * 如果file文件存在， 但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。

        * FileWriter(File file, boolean append)
            * 通过File对象创建FileWriter对象
            * append参数如果为 true， 则将字符写入文件末尾处， 而不是写入文件开始处。
            * 如果file文件存在， 但如果是一个目录或文件无法打开则抛出FileNotFoundException异常。

     * BufferedWriter
        * 构造方法
            * BufferedWriter(Writerout)
                * 通过一个底层输出流out 对象创建缓冲流对象
                * 缓冲区大小是默认的， 默认值8192。
            * BufferedWriter(Writerout, int size)
                * 通过一个底层输出流out对象创建缓冲流对象
                * size指定的缓冲区大小， 缓冲区大小应该是2的n次幂， 这样可提高缓冲区的利用率。
        * 特殊方法
            * void newLine()
                * 写入一个换行符
     */

    public static void main(String[] args) {

        // 同样的方法复制py文档
        try (FileReader in = new FileReader("./TestDir/hello.py");
             FileWriter out = new FileWriter("./TestDir/hello_out.py")) {

            // 准备一个缓冲区
            char[] buffer = new char[4];
            // 首先读取一次
            int len = in.read(buffer);
            while (len != -1) {
                 System.out.println("len: " + len);
                // 注意这个len才是真正表示读了几个in, 如果设定缓冲区为10
                // 那么每次如果可以全部读取新鲜数据就会返回
                // 如果剩下不到10个新鲜数据, 比如只有2个,就会返回2
                // 如果再往下, 没有任何新鲜数据, 才返回-1

                // 这个String会把整个buffer读出来, 问题是,buffer可能不全是新鲜数据
                System.out.println(new String(buffer));

                // 这样写就可以保证只把新鲜数据写到新文件, 而不是整个String
                out.write(buffer, 0, len);  // 开始写入
                len = in.read(buffer);          // 刷新len
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 使用缓冲字符流复制文本文件也是基本一样的操作
        try (FileReader in2 = new FileReader("./TestDir/hello.py");
             FileWriter out2 = new FileWriter("./TestDir/hello_buffered_out.py");
             BufferedReader bis = new BufferedReader(in2);
             BufferedWriter bos = new BufferedWriter(out2)) {

            // 首先读取一行文本
            String line = bis.readLine();

            while (line != null) {
                bos.write(line);       // 开始写入数据
                bos.newLine();         // 写一个换行符
                line = bis.readLine(); // 再读取一行文本
            }
            System.out.println("复制完成");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
