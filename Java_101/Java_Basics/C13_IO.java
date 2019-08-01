package Java_Basics;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class C13_IO {
    /*
     * 程序经常需要访问文件和目录, 读取文件信息或写入信息到文件, 在Java语言中对文件的读写是通过I/O流技术实现的
     * Java语言使用File类对文件和目录进行操作, 查找文件时需要实现FilenameFilter或FileFilter接口。
     * 另外， 读写文件内容可以通过FileInputStream, FileOutputStream, FileReader和FileWriter类实现, 它们属于I/O流

     * 在编程时尽量使用相对路径， 尽量不要使用绝对路径
     * 在目录中一个点“.”表示当前目录， 两个点表示“..”表示父目录
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
     * boolean isDirectory( )      测试当前文件是否是目录
     * 文件操作
     * long lastModified( )         获得文件最近一次修改的时间。
     * long length( )               获得文件的长度， 以字节为单位。
     * boolean delete( )            删除当前文件。 成功返回 true， 否则返回false。
     * boolean renameTo(File dest)  将重新命名当前File对象所表示的文件。 成功返回 true， 否则返回false。
     * 目录操作
     * boolean mkdir( )                         创建当前File对象指定的目录。
     * String[] list()                          返回当前目录下的文件和目录， 返回值是字符串数组。
     * File[] listFiles()                       返回当前目录下的文件和目录， 返回值是File数组。
     * String[] list(FilenameFilter filter)     (重载)返回当前目录下满足指定过滤器的文件和目录， 参数是实现FilenameFilter接口对象， 返回值是字符串数组。
     * File[] listFiles(FilenameFilter filter)  (重载)返回当前目录下满足指定过滤器的文件和目录， 参数是实现FilenameFilter接口对象， 返回值是File数组。
     * File[] listFiles(FileFilter filter)      (重载)返回当前目录下满足指定过滤器的文件和目录， 参数是实现FileFilter接口对象， 返回值是File数组。
     */


    /*
     * 对目录操作有两个过滤器接口
     * FilenameFilter
     * FileFilter
     * 它们都只有一个抽象方法accept，
     * accept方法如下
     * boolean accept(File dir, String name)      测试指定dir目录中是否包含文件名为name的文件。
     * boolean accept(File pathname)              测试指定路径名是否应该包含在某个路径名列表中。
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

        File dir2 = new File("./TestDir/New Folder");   // 可以识别带空格的路径
        System.out.println(dir2.exists()); // >>>  true

        // 文件
        File IOfile = new File("./TestDir/File_readIO.txt");
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

        // 文件操作
        System.out.println(IOfile.lastModified());        // >>> 1553540161979  // 毫秒
        Date filetime = new Date(IOfile.lastModified());
        System.out.println(filetime.toString());          // >>> "Mon Mar 25 14:56:01 EDT 2019"

        System.out.println(IOfile.length());
        System.out.println(IOfile.renameTo(new File("./TestDir/File_readIO_renamed.txt")));
        System.out.println(IOfile.delete());  // false 因为文件被改名了


        // 目录操作
        System.out.println(dir2.mkdir());
        // 也就是创建一个空路径File, 然后真的在电脑中造出这个路径, 如果路径存在就不造了,并返回false

        System.out.println(new ArrayList<String>(Arrays.asList(dir2.list())));
        // >>>  [file1 - Copy (2).txt, file1 - Copy.txt, file1.txt, TD1, TD1 - Copy, TD1 - Copy (2)]
        System.out.println(new ArrayList<File>(Arrays.asList(dir2.listFiles())));  // 返回File实例列表

        // Filter操作 (新建一个Filter类, 过滤文件类型)
        Filter filter = new Filter("txt");
        String[] files = dir2.list(filter); //dir.list();
        for (String fname : files) {
            System.out.println(fname);
        }
        // >>>
        // file1.txt
        // file4.txt
        // file5.txt


        // 使用内部类在创建和改写FileFilter
        // 只编辑非只读文件
        File[] files2 = dir2.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".txt")) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        for (File f : files2) {
            System.out.println(f.getName());
        }
        // >>>
        // file1.txt
        // file4.txt
        // file5.txt
    }
}


// 自定义基于文件扩展名的文件过滤器
class Filter implements FilenameFilter {
    // 文件扩展名
    String extent;

    // 构造方法
    Filter(String extent) {
        this.extent = extent;
    }

    @Override
    public boolean accept(File dir, String name) {
        // 测试文件扩展名是否为extent所指定的
        return name.endsWith("." + extent);
    }
}
