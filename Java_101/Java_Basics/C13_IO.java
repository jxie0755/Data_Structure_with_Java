package Java_Basics;

import java.io.File;

public class C13_IO {
    /*
     * 程序经常需要访问文件和目录, 读取文件信息或写入信息到文件, 在Java语言中对文件的读写是通过I/O流技术实现的
     * Java语言使用File类对文件和目录进行操作, 查找文件时需要实现FilenameFilter或FileFilter接口。
     * 另外， 读写文件内容可以通过FileInputStream, FileOutputStream, FileReader和FileWriter类实现, 它们属于I/O流
     */
}


class Java_File {

    /*
     * Module java.base
     * Package java.io
     * Class File
     */

    /*
     * File类
     * File类表示一个与平台无关的文件或目录。
     * File类名很有欺骗性， 初学者会误认为是File对象只是一个文件， 但它也可能是一个目录
     */

    /*
     * 常用方法
        * 获得文件名
            * String getName( )           获得文件的名称， 不包括路径。
            * String getPath( )           获得文件的路径。
            * String getAbsolutePath( )   获得文件的绝对路径。
            * String getParent( )         获得文件的上一级目录名。
        * 文件属性测试
            * boolean exists( )           测试当前File对象所表示的文件是否存在。
            * boolean canWrite( )         测试当前文件是否可写。
            * boolean canRead( )          测试当前文件是否可读。
            * boolean isFile( )           测试当前文件是否是文件。
            * boolean isDirectory( )       测试当前文件是否是目录
     */


    public static void main(String[] args) {

        // 构造方法
        // File(String path)
        // 如果path是实际存在的路径. 则该File对象表示的是目录. 如果path是文件名, 则该File对象表示的是文件

        // File(String path, String name)
        // path是路径名, name是文件名。

        // File(File dir, String name)
        // dir是路径对象, name是文件名。


        // 路径
        File dir = new File("./TestDir");
        System.out.println(dir.getPath()); // >>> ".\TestDir"
        System.out.println(dir.getAbsolutePath());
        // >>> "D:\Documents\GitHub\Data_Structure_with_Java\.\TestDir"

        // 文件
        File IOfile =  new File("./TestDir/File_readIO.txt");
        // 这里"."指的是项目的根目录,也就是Data_structure_with_Java下

        System.out.println(IOfile.getName()); // >>> "File_readIO.txt"
        System.out.println(IOfile.getPath()); // >>> ".\TestDir\File_readIO.txt"
        System.out.println(IOfile.getParent()); // >>> ".\TestDir"
        System.out.println(IOfile.getAbsolutePath());
        // >>>  D:\Documents\GitHub\Data_Structure_with_Java\.\TestDir\File_readIO.txt

        // 文件属性
        System.out.println(IOfile.exists());        // true
        System.out.println(IOfile.canRead());       // true
        System.out.println(IOfile.canWrite());      // true
        System.out.println(IOfile.isFile());        // true
        System.out.println(IOfile.isDirectory());   // false


    }

}

