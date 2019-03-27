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
     * 以字节为单位的流称为字节流， 以字符为单位的流称为字符流。

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
        * 两个字符流抽象类
            * Reader
            * Writer
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


                String copyStr = new String(buffer);
                // 这个String会把整个buffer读出来, 问题是,buffer可能不全是新鲜数据

                System.out.println(copyStr);
                // 开始写入
                out.write(buffer, 0, len);
                // 这样写就可以保证只把新鲜数据写到新文件, 而不是整个String

                len = in.read(buffer);  // 刷新len
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // 当使用try-with-resource时, 会有一个隐藏的close(), 这个方法会抛出IOExceptin,所以要处理
            // STOF: https://stackoverflow.com/q/55381324/8435726
            e.printStackTrace();
        }

        // 案例2: 高效复制文件 (大小为2.2G视频)
        // 这里利用BufferedInputStream和BufferedOutputStream
        try (FileInputStream in2 = new FileInputStream("./TestDir/testV.mp4");
             FileOutputStream out2 = new FileOutputStream("./TestDir/testV_buffered_out.mp4");
             // 使用缓冲字节流
             BufferedInputStream bis = new BufferedInputStream(in2);
             BufferedOutputStream bos = new BufferedOutputStream(out2)) {

            //开始时间
            long startTime = System.nanoTime();

            // 准备一个缓冲区
            byte[] buffer = new byte[1024];
            // 首先读取一次
            int len = bis.read(buffer);

            while (len != -1) {
                // 开始写入数据
                bos.write(buffer, 0, len);
                // 再读取一次
                len = bis.read(buffer);
            }
            //结束时间
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("buffered 耗时： " + (elapsedTime / 1000000.0) + " 毫秒");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对比不用缓冲字节流的方法1
        try (FileInputStream in3 = new FileInputStream("./TestDir/testV.mp4");
             FileOutputStream out3 = new FileOutputStream("./TestDir/testV_out.mp4");){

            //开始时间
            long startTime = System.nanoTime();

            // 准备一个缓冲区
            byte[] buffer = new byte[1024];
            // 首先读取一次
            int len = in3.read(buffer);

            while (len != -1) {
                // 开始写入数据
                out3.write(buffer, 0, len);
                // 再读取一次
                len = in3.read(buffer);
            }
            //结束时间
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("not buffered 耗时： " + (elapsedTime / 1000000.0) + " 毫秒");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // >>>
        // buffered 耗时： 2644.297795 毫秒        (快很多)
        // not buffered 耗时： 11545.606955 毫秒

        // 如果缓冲区设为32768:  // 则都更快,甚至差距很小
        // buffered 耗时： 1383.841018 毫秒
        // not buffered 耗时： 1347.625697 毫秒
    }
}



