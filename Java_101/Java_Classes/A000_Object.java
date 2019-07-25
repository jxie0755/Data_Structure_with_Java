package Java_Classes;

public class A000_Object {

    /*
     * Module java.base
     * Package java.lang
     *Class Object
     */

    /*
     * 最基本的Object方法
     * toString方法 类似 python __str__, 返回字符串代表
     * 如果没有覆盖toString()方法， 默认的字符串是“类名@对象的十六进制哈希码
     * equals
     * ==运算符是比较两个引用变量是否指向同一个实例
     * equals()方法是比较两个对象的内容是否相等
     * 问题是比较的规则是什么? 关键是需要指定相等的规则，
     * 就是要指定比较的是哪些属性相等， 所以为了比较两个Person对象相等， 则需要覆盖equals()方法
     */

}


class ObjectPerson {
    String name;
    int age;

    public ObjectPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ObjectPerson [name=" + name + ", age=" + age + "]";
    }

    @Override
    public boolean equals(Object otherObject) {
        //判断比较的参数也是Person类型
        if (otherObject instanceof ObjectPerson) {
            ObjectPerson otherPerson = (ObjectPerson) otherObject;  // 转型比较
            // 这里用年龄作为比较规则
            if (this.age == otherPerson.age) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ObjectPerson p1 = new ObjectPerson("Denis", 30);
        ObjectPerson p2 = new ObjectPerson("Cindy", 30);

        System.out.println(p1); // >>>  ObjectPerson [name=Denis, age=30]
        System.out.println(p1.equals(p2)); // >>>  true
    }
}
