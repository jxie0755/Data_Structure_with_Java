package W3C_Java_Advaned_OOP;

public class C08_Interface_2 {
}

// 继续研究多重继承时同名方法的问题

interface InterfaceA {
    void method();
    void methodA();
}

interface InterfaceB {
    void method();
    void methodB();
}


// Subject类实现了InterfaceA和InterfaceB两个接口的方法
// 其中method是InterfaceA和InterfaceB共用的相同方法
class Subject implements InterfaceA, InterfaceB {

    @Override
    public void method() {

    }

    @Override
    public void methodB() {

    }

    @Override
    public void methodA() {

    }
}


// Subject类中实现的该方法是属于哪个接口的呢？
// 答案是既是InterfaceA的也是InterfaceB的

class Test_2 {
    public static void main(String[] args) {
        //我现在认为它是一个InterfaceA实现类, 就把它当做一个InterfaceA接口来使用
        InterfaceA interfaceA = new Subject();  // 生成时安放在A接口
        interfaceA.method();
        interfaceA.methodA();

        //我现在认为它是一个InterfaceB实现类, 就把它当做一个InterfaceB接口来使用
        InterfaceB interfaceB = new Subject();  // 生成时安放在B接口
        interfaceB.method();
        interfaceB.methodB();

        //也可以先生成一个Subject实例
        Subject subject = new Subject();
        subject.method();

        //当成InterfaceA指向到subject
        interfaceA = subject;
        interfaceA.method();
        interfaceA.methodA();

        //当成InterfaceB指向到subject
        interfaceB = subject;
        interfaceB.method();
        interfaceB.methodB();

        //当成InterfaceB用的过程中又可以再当成InterfaceA用
        interfaceA = (InterfaceA) interfaceB;
        interfaceA.method();
        interfaceA.methodA();
        //...随便用...
    }
}
