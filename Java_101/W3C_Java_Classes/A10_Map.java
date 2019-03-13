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
             * get                   根据Key取Value
             * getOrDefault​          增强型get, 提供一个default值,如果key不存在
             * put                   添加新Key和新Value (不能重复Key)
             * putAll                批量添加(合并一个Map进来)
             * putIfAbsent           安全型添加, 添加后, 存在key就返回原value, 不存在就返回null

             * remove​(key)           删除并返回Value
             * remove​(key, value)    增强版remove          带boolean确认

             * replace               修改Key的值
             * replace​(K key, Vold, Vnew)   增强型replace  带boolean确认

             * clear()               清空
             * isEmpty()

             * containsKey​           k in Map?
             * containsValue         v in Map?

             * CopyOf                inmutable copy
             * entrySet()            生成Map.Entry集合, 便于iteration

             * keySet()              提取Key变成Set     (for iteration)
             * values()              提取Values变成集合  (for iteration)

             * hashcode()

             * of                   quick inmutable Map (up to 10 pairs)
             * (static) ofEntries   根据一个Map.Entry的集合实例创造一个相应的Map
             * (static) entry       为Map.ofEntry添加新的键值对,以创建Map        为initializatin设计, 不限数目
     */
}


class A10_Map_Initialization {

    // static initializer
    private static final HashMap<String, Integer> staticMap = new HashMap<>();
    static {
        staticMap.put("Apple", 1);
        staticMap.put("Chocolate", 2);
    }

    // static initializer 2  (works for any number of elements)
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


class A10_Map_Entry {

    /*
     * Module java.base
     * Package java.util
     * Interface Map.Entry<K,​V>

     * Map的子接口(注意不是继承, 是内部接口)
     * 这个接口就是用于遍历Map的
     * 也可以不用Map.Entry完成键值的遍历, 参见A10_Map_simple_iteration
     */

    /*
     * 重要方法
         * getKey()
         * getValue()
         * setValue()
     */

    // Map.Entry and entry
    public static void main(String[] args) {


        Map<String, Integer> Map1 = new HashMap<>(Map.ofEntries(
                Map.entry("A", 1),
                Map.entry("B", 2),
                Map.entry("C", 3)
        ));

        // Map.Entry相当于python的dict.items(), 实际是Map中一个一个的独立键值pair
        // 构造方法通过Map中的entrySet()
        // 这个Set中就成了Map中所有键值对的集合
        Set<Map.Entry<String, Integer>> SS1 = Map1.entrySet();


        // 利用Map.Entry遍历Map
        // 方案A: 造一个iterator然后用for loop和while loop
        Iterator iter1 = Map1.entrySet().iterator();
        // while loop
        while(iter1.hasNext()){
            Map.Entry<String, Integer> entry= (Map.Entry<String, Integer>) iter1.next();  // 注意转型安全
            System.out.println("key:"+entry.getKey()+" value"+entry.getValue());
        }
        // >>>
        // key:A value1
        // key:B value2
        // key:C value3

        // for loop
        for (Iterator iter2 = Map1.entrySet().iterator(); iter2.hasNext();) {
            Map.Entry<String, Integer> entry= (Map.Entry<String, Integer>) iter2.next();  // 注意转型安全
            System.out.println("key:"+entry.getKey()+" value"+entry.getValue());
        }
        // >>> 与上相同


        // 方案B: 不用iterator, 直接遍历entrySet()那个, 只能用for-each loop
        // 这样不用转型, 更安全
        // 推荐，尤其是Map容量大时
        for (Map.Entry<String, Integer> entry : Map1.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        // >>>
        // Key = A, Value = 1
        // Key = B, Value = 2
        // Key = C, Value = 3


        // setValue  根据key当场修改源Map中的value值
        for (Map.Entry<String, Integer> entry : Map1.entrySet()) {
            if (entry.getKey().equals("B")) {
                entry.setValue(9);
            }
        }
        System.out.println(Map1); // >>>  {A=1, B=9, C=3}
    }

}


class A10_Map_simple_iteration {

    // 要想遍历整个Map的键值对,必须用Map.Entry, 参见A10_Map_Entry
    // 研究怎么遍历一个Map的keys和values
    public static void main(String[] args) {

        Map<String, Integer> Map1 = new HashMap<>(Map.ofEntries(
                Map.entry("A", 4),
                Map.entry("B", 6),
                Map.entry("C", 8)
        ));


        // keys
        for (String k: Map1.keySet()) {
            System.out.println(k);
        }
        // >>>
        // A
        // B
        // C


        // values
        for (Integer v: Map1.values()) {
            System.out.println(v);
        }
        // >>>
        // 4
        // 6
        // 8


        // 不通过Map.Entry遍历Key和Value也行
        // 只遍历keySet, 但是靠Map.get(key)来取value 或者 Map.replace(key)来换值
        for (String key : Map1.keySet()) {
            System.out.println("key= "+ key + " and value= " + Map1.get(key));
            Map1.replace(key, 9);  // 也可以修改Key的value
            // 注意for-loop期间不要删key
        }
        // >>>
        // key= A and value= 4
        // key= B and value= 6
        // key= C and value= 8
        System.out.println(Map1); // >>>  {A=9, B=9, C=9}
    }

}


class A10_Map_zMethods {

    public static void main(String[] args) {

        // 跳过简单方法
        // clear()    清空
        // isEmpty()  判断为空
        // hasCode()  返回哈希值
        // size()     长度
        // values()   Collection view of values

        // containsKey​(Object key)
        // containsValue​(Object value)
        Map<String, Integer> Map1 = new HashMap<>(Map.ofEntries(
                Map.entry("A", 1),
                Map.entry("B", 2),
                Map.entry("C", 3)
        ));
        System.out.println(Map1.containsKey("B")); // >>> true
        System.out.println(Map1.containsValue(2)); // >>> true


        // entrySet()
        // The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
        // 详见zLearnings.Java_View
        // 返回一个实现Map.Entry接口的对象集合。集合中每个对象都是底层Map中一个特定的(键:值)对
        Set<Map.Entry<String, Integer>> SS1 = Map1.entrySet();
        System.out.println(SS1); // >>>  [A=1, B=2, C=3]
        // A10_Map_Map_Entry


        // copyOf​(Map<? extends K,​? extends V> map)
        // Returns an unmodifiable Map containing the entries of the given Map (therefore it is kind of DeepCopy)
        Map<String, Integer> Map2 = Map.copyOf(Map1);
        Map1.replace("B", 9);
        System.out.println(Map1);  // >>> {A=1, B=9, C=3}  // modify Map1
        System.out.println(Map2);  // >>> {C=3, B=2, A=1}  // will not impact Map2
        // 复制一个mutable的Map
        Map<String, Integer> Map3 = new HashMap<>(Map.copyOf(Map1));


        // keySet()
        //  The collection is backed by the map, so changes to the map are reflected in the collection,
        //  and vice-versa.
        // 详见zLearnings.Java_View
        Set<String> SS2 = Map3.keySet();
        System.out.println(SS2);  // >>>  [A, B, C]   提取Key变成Set
        // 之后改变Map也会同时改变view, 改变view(比如去掉key)也会改变Map, 但是不能增加key,因为没有对应值


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


        // putAll
        Map<String, Integer> Map4 = new HashMap<>(Map.ofEntries(
                Map.entry("A", 1),
                Map.entry("B", 2),
                Map.entry("C", 3)
        ));
        Map<String, Integer> Map_add = new HashMap<>(Map.ofEntries(
                Map.entry("X", 10),
                Map.entry("Y", 20),
                Map.entry("Z", 30)
        ));
        Map4.putAll(Map_add);
        System.out.println(Map4); // >>>  {X=10, A=1, Y=20, B=2, Z=30, C=3}


        // putIfAbsent​(K key, V value)   // 安全型put
        System.out.println(Map4.putIfAbsent("X", 40)); // >>>  10 (若已经存在Key,则返回!原!value
        System.out.println(Map4.putIfAbsent("Q", 40)); // >>>  10 (若不存在key, 则添加参数pair,返回null)
        System.out.println(Map4); // >>> {A=1, Q=40, B=2, C=3, X=10, Y=20, Z=30}
        Map4.put("K", null);
        System.out.println(Map4); // >>>  {A=1, Q=40, B=2, C=3, X=10, Y=20, Z=30, K=null}
        // 即使value指定Intger也可以用null作为value
        System.out.println(Map4.putIfAbsent("K", 50));  // >>>  null  也是返回null, 因为K本身就map to null
        System.out.println(Map4); // >>>  {A=1, Q=40, B=2, C=3, X=10, Y=20, Z=30, K=50}


        // of (Map.of)
        // quickly create an inmutable Map with from 0 up to 10 (K,V) pair
        // Does not allow unlimited like List.of
        Map<String, Integer> Map5 = Map.of("a", 10, "b", 20);
        // 如果new HashMap<>() 可以变成Mutable 详见initialization


        // remove
        // 被重载了, 有普通和增强型(确认删除)
        Map<String, Integer> Map6 = new HashMap<>(Map.ofEntries(
                Map.entry("A", 1),
                Map.entry("B", 2),
                Map.entry("C", 3)
        ));
        System.out.println(Map6.remove("A"));  // >>> 1  // 删除并返回Value
        System.out.println(Map6.remove("B", 5));
        // >>>  false // 存在key "B" 但是value不是5, 所以没有操作
        System.out.println(Map6);   // >>> {B=2, C=3}


        // replace
        // 被重载了, 有普通和增强型(确认替换)
        Map<String, Integer> Map7 = new HashMap<>(Map.ofEntries(
                Map.entry("A", 4),
                Map.entry("B", 6),
                Map.entry("C", 8)
        ));
        System.out.println(Map7.replace("A", 9));  // >>> 4  // 替换并返回!原!Value
        System.out.println(Map7.replace("B", 5, 9));
        // >>>  false // 存在key "B" 但是value不是5, 所以没有操作
        System.out.println(Map7);   // >>> {A=9, B=6, C=8}


        // values()
        //  The collection is backed by the map, so changes to the map are reflected in the collection,
        //  and vice-versa.
        // 详见zLearnings.Java_View
        Collection<Integer> v7 =Map7.values();
        System.out.println(v7); // >>>  [9, 6, 8]


        // ofEntries
        // 参见initializatin
    }
}