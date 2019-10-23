package Java_OOP;

class C05_Encapsulation {
    // Java封装

    /*
     * 在面向对象程式设计方法中，Encapsulation是指，一种将抽象性函式接口的实作细节部份包装、隐藏起来的方法。
     * 封装可以被认为是一个保护屏障，防止该类的代码和数据被外部类定义的代码随机访问。
     * 要访问该类的代码和数据，必须通过严格的接口控制。
     * 封装最主要的功能在于我们能修改自己的实现代码，而不用修改那些调用我们代码的程序片段。
     * 适当的封装可以让程式码更容易理解与维护，也加强了程式码的安全性。
     */


    // 封装方式: 只允许通过get和set来访问private变量
}

class EncapTest {

    // 参数本身为private防止被直接访问
    private String name;
    private String idNum;
    private int age;


    // get和set方法设为public以供外部访问
    // get and set age
    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    // get and set name
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    // get and set ID
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String newId) {
        idNum = newId;
    }
}


class RunEncap {

    public static void main(String args[]) {

        EncapTest encap = new EncapTest();
        encap.setName("James");
        encap.setAge(20);
        encap.setIdNum("12343ms");

        System.out.println("Name : " + encap.getName() + " Age : " + encap.getAge() + " ID: " + encap.getIdNum());
        // >>> Name : James Age : 20 ID: 12343ms
    }
}
