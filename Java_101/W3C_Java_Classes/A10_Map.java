package W3C_Java_Classes;

// import static java.util.Map.entry;


import java.util.*;

public class A10_Map {

    /*
     * Module java.base
     * Package java.util
     * Interface Map<K,​V>

     * Map接口定义了一个保存key-value的对象
         * 该对象中key值是不存在重复的
         * 每个key值至多对应一个value

     * 常用 接口/类
        * HasMap 类
            * HashMap是实现了Map接口的key-value集合，实现了所有map的操作
            * 允许key和value为null
            * 无序
            * 相当于python的dict, 作为重点学习
        * HashTable 类
            * 几乎和HashMap 相同
            * 它不允许key-value为NULL值，另外一点值得注意的是Hashtable是线程安全的
        * TreeMap 类
            * TreeMap是基于红黑树的实现，也是记录了key-value的映射关系，
            * 该映射根据key的自然排序进行排序或者根据构造方法中传入的比较器进行排序
            * 也就是说TreeMap是有序的key-value集合
     */

    /*
     * Map常用方法
        * 来自Map
            * get              根据Key取Value
            * getOrDefault​     增强型get, 提供一个default值,如果key不存在
            * put              添加新Key和新Value (不能重复Key)
            * replace          修改Key的值
            * clear()          清空

            * containsKey​      k in Map?
            * containsValue    v in Map?

            * CopyOf           inmutable copy
            * entrySet()       提取Key变成Set
            * keySet()         提取Key变成Set

            * hashcode()
            * isEmpty()
     */


}


class A10_Map_Initialization {

    // static initializer
    private static final HashMap<String, Integer> staticMap = new HashMap<>();
    static {
        staticMap.put("Apple", 1);
        staticMap.put("Chocolate", 2);
    }

    // static initializer 2
    private static Map<String, String> staticMap2 = new HashMap<>(Map.ofEntries(
            Map.entry("Banana", "good"),
            Map.entry("Mango", "bad")
    ));


    public static void main(String[] args) {

        // 构造方法 (HashMap为例)
        Map<String, Integer> aMap = new HashMap<>(); // 空
        aMap.put("k1", 1);
        aMap.put("k2", 2);

        // 问题是这样不能创建static或者是final的Map, 因为这些一旦被建立就不能改动
        // 方法参见上面staticMap
        System.out.println(staticMap);  // >>>  {Apple=1, Chocolate=2}
        System.out.println(staticMap2); // >>>  {Mango=bad, Banana=good}

        // 双括号初始化
        // You can use an initializer in an anonymous subclass to make the syntax a little bit shorter
        // However, you should be careful and make sure that you understand the above code
        // (it creates a new class that inherits from HashMap).
        // Therefore, you should read more here: http://www.c2.com/cgi/wiki?DoubleBraceInitialization
        Map<String, Integer> aMap2 = new HashMap<>() {{
            put("k1", 1);
            put("k2", 2);
        }};
        System.out.println(aMap);  // >>> {k1=1, k2=2}
        System.out.println(aMap2); // >>> {k1=1, k2=2}
        System.out.println(aMap.equals(aMap2)); // >>> true

        // Java9 新方法
        // Java 9 a couple of factory methods have been added that simplify the creation of maps
        // STOF: https://stackoverflow.com/a/6802502/8435726

        // this works for up to 10 elements (而List.of没有限制)
        // and also it is inmutable!! 所以同样的附加方法new HashMap<> 来处理
        Map<String, Integer> aMap3 = new HashMap<>(Map.of(
                "a", 1,
                "b", 2   // 注意最后一个不加括号
        ));
        aMap3.put("c", 3);
        System.out.println(aMap3); // >>> {a=1, b=2, c=3}

        // java9新方法
        // this works for any number of elements:
        // and also it is inmutable!! 所以同样的附加方法new HashMap<> 来处理
        // import static java.util.Map.entry;   // 注意不要忘了import!
        Map<String, String> aMap4 = new HashMap<>(Map.ofEntries(
                Map.entry("a", "b"),
                Map.entry("c", "d")
        ));
        aMap4.put("e", "f");
        System.out.println(aMap4); // >>> {a=b, e=f, c=d}


        // Key是不是一定要是Inmutable?
        // 不能重复,但是可以mutable key
        // key不能是基本类型!
        Map<List<String>, Integer> MutaMap = new HashMap<>(Map.ofEntries(
                Map.entry(new ArrayList<>(Arrays.asList("A", "B")), 1),
                Map.entry(new ArrayList<>(Arrays.asList("C", "D")), 2)
                // Map.entry(new ArrayList<>(Arrays.asList("C", "D")), 3)
        ));
        System.out.println(MutaMap);  // >>> {[C, D]=2, [A, B]=1}   竟然是可以

        // 再试mutable key
        List<Integer> IL1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> IL2 = new ArrayList<>(Arrays.asList(2, 3, 4));
        Map<List<Integer>, Integer> MutaMap2 = new HashMap<>(Map.ofEntries(
                Map.entry(IL1, 1),
                Map.entry(IL2, 2)
        ));
        System.out.println(MutaMap2); // >>>  {[1, 2, 3]=1, [2, 3, 4]=2}
        IL1.set(0, 9);  // 变化IL1
        System.out.println(MutaMap2); // >>>  {[9, 2, 3]=1, [2, 3, 4]=2}  // 仍然支持

        // 但如果对象的hashCode 改变了, 那么将找不到原来该 key 所对应的 value
        System.out.println(MutaMap2.get(IL1));                  // >>> null
        System.out.println(MutaMap2.get(Arrays.asList(9, 2, 3))); // >>> null  直接call改变后的List还是不行
        System.out.println(MutaMap2.get(List.of(9, 2, 3)));      // >>> null
        System.out.println(MutaMap2.get(Arrays.asList(1, 2, 3))); // >>> null  直接call原来的List还是不行

        // 所以不要轻易改变Key, 最好是用不能变的Key, 比如用Tuple作为key
        List<Integer> IT1 = List.of(3, 6, 9);
        MutaMap2.put(IT1, 3);
        System.out.println(MutaMap2); // >>> {[9, 2, 3]=1, [3, 6, 9]=3, [2, 3, 4]=2}
        System.out.println(MutaMap2.get(IT1)); // >>> 3
        System.out.println(MutaMap2.get(List.of(3, 6, 9))); // >>> 3

    }
}


class A10_Map_Map_Entry {

    // Map.Entry and entry
    public static void main(String[] args) {


        Map<String, Integer> Map1 = new HashMap<>(Map.ofEntries(
                Map.entry("A", 1),
                Map.entry("B", 2),
                Map.entry("C", 3)
        ));



        // entrySet()
        Set<Map.Entry<String, Integer>> SS1 = Map1.entrySet();
        System.out.println(SS1); // >>>  [A=1, B=2, C=3]

    }

}


class A10_Map_zMethods {

    public static void main(String[] args) {

        // 跳过简单方法
        // clear() 清空
        // isEmpty()
        // hasCode()

        // containsKey​(Object key)
        // containsValue​(Object value)
        Map<String, Integer> Map1 = new HashMap<>(Map.ofEntries(
                Map.entry("A", 1),
                Map.entry("B", 2),
                Map.entry("C", 3)
        ));
        System.out.println(Map1.containsKey("B")); // >>> true
        System.out.println(Map1.containsValue(2)); // >>> true


        // copyOf​(Map<? extends K,​? extends V> map)
        // Returns an unmodifiable Map containing the entries of the given Map (therefore it is kind of DeepCopy)
        Map<String, Integer> Map2 = Map.copyOf(Map1);
        Map1.replace("B", 9);
        System.out.println(Map1);  // >>> {A=1, B=9, C=3}  // modify Map1
        System.out.println(Map2);  // >>> {C=3, B=2, A=1}  // will not impact Map2
        // 复制一个mutable的Map
        Map<String, Integer> Map3 = new HashMap<>(Map.copyOf(Map1));


        // keySet()
        Set<String> SS2 = Map3.keySet();
        System.out.println(SS2);  // >>>  [A, B, C]   提取Key变成Set


        // equals​(Object o)
        System.out.println(Map1.equals(Map3)); // >>> true


        // forEach​(BiConsumer<? super K,​? super V> action)
        // for Loop
        // for (key: Map3) {
        //     System.out.println(key);
        // }


        // get and put and replace
        System.out.println(Map1.get("A")); // >>>  1
        Map1.put("D", 4);
        Map1.replace("C", 9);
        System.out.println(Map1); // >>>  {A=1, B=9, C=9, D=4}
        // getOrDefault​(Object key, V defaultValue)  // 增强型 如果不存在Key则返回default value
        System.out.println(Map1.getOrDefault("X", 0)); // >>>  0





    }
}