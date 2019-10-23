package Java_Classes;

class A05_Mutable_String {

    /*
     * String 字符串常量
     * StringBuilder 字符串变量（非线程安全）
     * StringBuffer 字符串变量（线程安全）
     * StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象
     * 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
     * 然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类
     */
}

class A05b_StringBuilder {

    /*
     * Module java.base
     * Package java.lang
     * Class StringBuilder
     */


    /*
     * 常用方法
     * 来自自身
     * 可以直接打印
     * append                         添加 (支持添加String和Char两个类型)
     * reverse                        自身反转
     * delete(idxA, idxB)             删掉一段
     * insert(idx, Obj)               在一个index插入任何Obj的__str__
     * replace(idxA, idxB, Str)       用一个String替换一个子段落 (不一定要等长)
     * setCharAt(idx, char)           替换单个char
     * setLength(int)                 从头保留长度内的字符串,多余的删去

     * * 其他和String类似的方法
     * char charAt(int index)
     * getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
     * int indexOf(String str)
     * int indexOf(String str, int fromIndex)
     * int lastIndexOf(String str)
     * int lastIndexOf(String str, int fromIndex)
     * int length()
     * CharSequence subSequence(int start, int end)
     * String substring(int start)
     * String substring(int start, int end)  // 相当于slice切片
     * String toString()
     */

    public static void main(String[] args) {

        // 可以说StringBuilder和StringBuffer使用上是一模一样,所有这些方法都能通用

        // 构造方法非常类似String
        StringBuilder sBuilder = new StringBuilder("Cindy: ");
        // StringBuffer sB2 = "JoJoJo";  这是不允许的, Str和SB二者不是继承关系


        // 可变类型 (append方法)
        sBuilder.append("first");
        sBuilder.append("second");
        sBuilder.append("last");


        // 可以直接打印
        System.out.println(sBuilder);  // >>> Cindy: firstsecondlast

        // reverse 反转
        sBuilder.reverse();
        System.out.println(sBuilder);  // >>> tsaldnocestsrif :ydniC
        sBuilder.reverse();


        // delete(int start, int end)
        sBuilder.delete(1, 5);
        System.out.println(sBuilder);  // >>>  C indy : firstsecondlast
        //     0 1234 5

        // insert(int offset, String i)  支持插入各种obj, 这里以String为例
        sBuilder.insert(1, "9");
        System.out.println(sBuilder);  // >>>  C9: firstsecondlast


        // replace(int start, int end, String str) 使用给定 String 中的字符替换此序列的子字符串中的字符
        // 不一定要等长, 就是纯替换
        // C9: firstsecondlast
        // 0123456789
        sBuilder.replace(4, 8, "123456789");
        System.out.println(sBuilder);
        // >>> C9: 123456789tsecondlast


        // void setCharAt(int index, char ch)
        sBuilder.setCharAt(1, 'T');
        System.out.println(sBuilder);
        // >>>  CT: 123456789tsecondlast


        // void setLength(int newLength)  保留长度内的字符串,多余的删去
        sBuilder.setLength(3);
        System.out.println(sBuilder);
        // >>> CT:


        // 其他方法
        // capacity (与ArrayList的容量类似, 一般不必理会, 会自动扩容, 空白构造默认16长度的capacity)
        System.out.println(sBuilder.capacity()); // >>>  48
        // void ensureCapacity(int minimumCapacity)  确保容量至少等于指定的最小值
    }
}


class A05c_StringBuffer {

    /*
     * Module java.base
     * Package java.lang
     * Class StringBuffer
     */

    /*
     * 常用方法
     * 来自自身
     * 可以直接打印
     * append                         添加
     * reverse                        自身反转
     * delete(idxA, idxB)             删掉一段
     * insert(idx, Obj)               在一个index插入任何Obj的__str__
     * replace(idxA, idxB, Str)       用一个String替换一个子段落 (不一定要等长)
     * setCharAt(idx, char)           替换单个char
     * setLength(int)                 从头保留长度内的字符串,多余的删去
     * 其他和String类似的方法
     * char charAt(int index)
     * getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
     * int indexOf(String str)
     * int indexOf(String str, int fromIndex)
     * int lastIndexOf(String str)
     * int lastIndexOf(String str, int fromIndex)
     * int length()
     * CharSequence subSequence(int start, int end)
     * String substring(int start)
     * String substring(int start, int end)  // 相当于slice切片
     * String toString()
     */

    public static void main(String[] args) {

        // 构造方法非常类似String
        StringBuffer sBuffer = new StringBuffer("Denis: ");
        // StringBuffer sB2 = "JoJoJo";  这是不允许的, Str和SB二者不是继承关系


        // 可变类型 (append方法)
        sBuffer.append("first");
        sBuffer.append("second");
        sBuffer.append("last");


        // 可以直接打印
        System.out.println(sBuffer);  // >>> Denis: firstsecondlast


        // reverse 反转
        sBuffer.reverse();
        System.out.println(sBuffer);  // >>> tsaldnocestsrif :sineD
        sBuffer.reverse();


        // delete(int start, int end)
        sBuffer.delete(1, 5);
        System.out.println(sBuffer);  // >>>  D enis : firstsecondlast
        //    0 1234 5

        // insert(int offset, int i)  将 int 参数的字符串表示形式插入此序列中
        sBuffer.insert(1, 9);
        System.out.println(sBuffer);  // >>>  D9: firstsecondlast


        // replace(int start, int end, String str) 使用给定 String 中的字符替换此序列的子字符串中的字符
        // D9: firstsecondlast
        // 0123456789
        sBuffer.replace(4, 8, "123456789");
        System.out.println(sBuffer);
        // >>> D9: 123456789tsecondlast


        // void setCharAt(int index, char ch)
        sBuffer.setCharAt(1, 'X');
        System.out.println(sBuffer);
        // >>>  DX: 123456789tsecondlast


        // void setLength(int newLength)  保留长度内的字符串,多余的删去
        sBuffer.setLength(3);
        System.out.println(sBuffer);
        // >>> DX:


        // 其他方法
        // capacity (与ArrayList的容量类似, 一般不必理会, 会自动扩容, 空白构造默认16长度的capacity)
        System.out.println(sBuffer.capacity()); // >>>  48
        // void ensureCapacity(int minimumCapacity)  确保容量至少等于指定的最小值

    }
}
