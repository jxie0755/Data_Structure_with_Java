package zsnippets;

import java.util.ArrayList;
import java.util.List;

public class List_and_ArrayList {

    public static void main(String[] args) {
        /*
         * List是一个接口，而ListArray是一个类。
            * ListArray继承并实现了List。 \
            * 所以List不能被构造，但可以向上面那样为List创建一个引用，而ListArray就可以被构造。
         */

        // List<Object> list;     //正确   list=null;
        // List<Object> list2=new List();    //   是错误的用法



        /*
         * 创建List还是ArrayList?

            * List list<Object> = new ArrayList();
                * 这句创建了一个ArrayList的对象后把上溯到了List
                * 此时它是一个List对象了，有些ArrayList有但是List没有的属性和方法，它就不能再用了

            * ArrayList<Object> list=new ArrayList();
                * 创建一对象则保留了ArrayList的所有属性
         */
        List list = new ArrayList();
        ArrayList arrayList = new ArrayList();
        // list.trimToSize(); //错误，没有该方法。
        arrayList.trimToSize();   //ArrayList里有该方法。

        /*
         * 如果 List a=new ArrayList();
            * 则a拥有List与ArrayList的所有属性和方法，不会减少
            * 如果List与ArrayList中有相同的属性（如int i), 则a.i是调用了List中的i
            * 如果List与ArrayList中有相同的方法（如void f()),a.f()是调用了ArrayList中的f()
         */

    }
}

