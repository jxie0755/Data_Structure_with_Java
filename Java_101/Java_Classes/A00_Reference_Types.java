package Java_Classes;

public class A00_Reference_Types {

    // 除8项基本类型外其他全是reference types (引用类型)
    /*
     * 类    Class
     * 接口  Interface
     * 数组  Array
     */

    // Java中的引用数据类型， 相当于C等语言中指针（pointer） 类型， 引用事实上就是指针， 是指向一个对象的内存地址

    public static void main(String[] args) {
        int x = 7;
        int y = x;
        // x值为7， x赋值给y， 这时y的值也是7，x和y两个变量值都是7
        // 但是它们之间是独立的， 任何一个变化都不会影响另一个, 内存有种两个7

        String str1 = "Hello";  // 如果改变"Hello"则str1和str2都会改变,但是String是不可变变量所以这里实现不了
        String str2 = str1;
        // str1和str2本质上是引用一个对象，通过任何一个引用都可以修改对象本身
        // 这里相当于内存中只存在一个"Hello"
    }
}
