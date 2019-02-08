package W3C_Java_Advaned_OOP;

public class C08_Interface_2 {
}

// 继续研究多重继承时同名方法的问题
// Subject类实现了InterfaceA和InterfaceB两个接口的方法
// 其中method是InterfaceA和InterfaceB共用的相同方法
class InterfaceTest {

    // 两个接口都有present方法
    interface Gift  { void present(); }
    interface Guest { void present(); }

    interface Presentable extends Gift, Guest { }

    public static void main(String[] args) {
        Presentable johnny = new Presentable() {
            @Override
            public void present() {
                System.out.println("Heeeereee's Johnny!!!");
            }
        };

        johnny.present();                     // "Heeeereee's Johnny!!!"

        ((Gift) johnny).present();            // "Heeeereee's Johnny!!!"
        ((Guest) johnny).present();           // "Heeeereee's Johnny!!!"

        Gift johnnyAsGift = (Gift) johnny;
        johnnyAsGift.present();               // "Heeeereee's Johnny!!!"

        Guest johnnyAsGuest = (Guest) johnny;
        johnnyAsGuest.present();              // "Heeeereee's Johnny!!!"
    }
}