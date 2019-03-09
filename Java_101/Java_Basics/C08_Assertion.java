package Java_Basics;

public class C08_Assertion {
    /*
     *  assert关键字用法简单，但是使用assert往往会让你陷入越来越深的陷阱中。应避免使用。笔者经过研究，总结了以下原因：

          1、 assert关键字需要在运行时候显式开启才能生效，否则你的断言就没有任何意义。而现在主流的Java IDE工具默认都没有开启-ea断言检查功能。这就意味着你如果使用IDE工具编码，调试运行时候会有一定的麻烦。并且，对于Java Web应用，程序代码都是部署在容器里面，你没法直接去控制程序的运行，如果一定要开启-ea的开关，则需要更改Web容器的运行配置参数。这对程序的移 植和部署都带来很大的不便。

         2、用assert代替if是陷阱之二。assert的判断和if语句差不多，但两者的作用有着本质的区别：assert关键字本意上是为测试 调试程序时使用的，但如果不小心用assert来控制了程序的业务流程，那在测试调试结束后去掉assert关键字就意味着修改了程序的正常的逻辑。

         3、assert断言失败将面临程序的退出。这在一个生产环境下的应用是绝不能容忍的。一般都是通过异常处理来解决程序中潜在的错误。但是使用断言就很危险，一旦失败系统就挂了。
     */



    /*
     * assert既然是为了调试测试程序用，不在正式生产环境下用，那应该考虑更好的测试JUint来代替其做用，JUint相对assert关键的所提供的功能是有过之而无不及。当然完全可以通过IDE debug来进行调试测试。在此看来，assert的前途一片昏暗。

     * 因此，应当避免在Java中使用assert关键字，除非哪一天Java默认支持开启-ea的开关，这时候可以考虑。对比一下，assert能给你带来多少好处，多少麻烦，这是我们选择是否使用的的原则

     */

    /*
     * 在IDE中可以通过调整VM的option来使用发现assertion错误
        * Intellij中, 顶部菜单Run -> Edit Configuration -> 左侧菜单
        * 可以单独在Application中添加"-ea"命令
        * 也可以在下面Template中的application模板中添加"-ea"命令到整个project
     */
}


class Solution {
    static int Fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fib(n - 1) + Fib(n - 2);
        }
    }

    public static void main(String[] args) {
        assert Fib(0) == 0;
        assert Fib(1) == 1;
        assert Fib(2) == 1;
        System.out.println(Fib(5));
        assert Fib(5) == 5;
        assert Fib(5 ) == 10: "WTF???";  // 这里不会报错, 只有在console中运行 java -ea Solution才会
    }
}


