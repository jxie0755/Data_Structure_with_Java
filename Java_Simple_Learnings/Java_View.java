import java.util.*;

class Java_View {

    /*
     * Java中的视图
     * 常见
     * Arrays.asList
     * 支持Arrays get和set
     * List.subList​(idx, idx)
     * 可以双向修改和单向view删除
     * List增加和修改导致subList作废
     * 多段subList存在互相干涉,引发冲突的情况
     * (以后直接新建避免问题) 修改只在原List上改动
     * Map.entrySet()
     * 可以单向View删除,单向Map增加
     * Map.values()
     * 可以双向删除, 单向Map添加
     * 双向不能修改(Collection,Map没有修改Key的概念)
     * Map.keySet()
     * 单向Map增加
     * 单向View不能删除,因为没法访问那个pair, 可以clear()
     * 双向不能修改(Map没有修改Key的概念)
     */

    /*
     * 个人总结
     * View就是一种视图, 一种特殊的角度去看一个Object, 并没有实体
     * 举例: 汽车
     * 一个特殊的view就是每个车轮外放一个摄像机,拍摄车轮, 把4个车轮的画面放在一个屏幕上
     * (相当于一个有4个轮子的集合)
     * 这个view可以提供独特信息, 因为平时无法同时看4个轮子
     * 比如观察磨损
     * 比如对比大小
     * 比如检查轮胎品牌
     * 比如检查轮毂
     * 但是这个view是不能被随便改变的, 因为它只是摄像机拍摄的画面
     * 无法加一个不存在的车轮进入到这个集合里
     * 无法去掉一个车轮
     * 同理就是HashMap中的Map.values()
     * 它把一个HashMap中的所有键值提取出来放到一个集合
     * (想当于给Map加了一个滤镜, 只看values)
     * 显然, 你可以对比这些values.
     * 可以遍历
     * 但是不能增加和减少, 因为你看到的仍然是这个Map object,只不过过滤掉了你不看的信息
     * 有时可以修改, 因为相当于修改原object
     * 视图对象可以说是具有限制的集合对象. 
     * 不同视图具有不同的操作权限
     * 但是如果调用越权的方法就会抛出异常. 
     */

    public static void main(String[] args) {

        // Arrays.asList
        System.out.println();
        String[] strArray = new String[]{"GetClassExample", "GetB", "C"};
        List<String> strL1 = Arrays.asList(strArray);
        // 这里就是把一个数组, 当做一个List来看, 这个stringList是一个"把ArraysPS得像一个list的画面"
        // 所以如果改动这个List
        // strL1.add("X");  就会报错
        strL1.set(0, "X");
        System.out.println(strL1); // >>> [X, GetB, C]  但是它可以修改内容?
        // 这个对象带有底层数组的get和set方法, 也就是Arrays的方法, 此时再看原Array:
        System.out.println(Arrays.toString(strArray)); // >>> [X, GetB, C] 也被改变了!!


        // List.subList  (与python中的切片不同,python切片是新建一个全新的list)
        System.out.println();
        List<String> strL3 = new ArrayList<>(Arrays.asList("GetClassExample", "GetB", "C"));
        List<String> strL3_sub = strL3.subList(0, 2);   // 这个List支持原List的一切改动, 也就是增改删除

        // 创建view之后如果structural改原List(增加或删除), 则会让之前建立的subList作废 (python同样没这个问题)
        // strL3.remove(1);
        // strL3.add(1, "W");
        strL3.set(1, "W");

        System.out.println(strL3_sub); // >>>  [GetClassExample, W]
        strL3_sub.remove(1);           // [GetClassExample]
        strL3_sub.add("X");                 //  [GetClassExample]
        strL3_sub.set(1, "Y");              //  [GetClassExample, Y]
        System.out.println(strL3);     // >>>  [GetClassExample, Y, C]

        // 如果再生成子subList呢
        List<String> strL3_sub_sub = strL3_sub.subList(0, 2);
        strL3_sub_sub.remove(1);
        System.out.println(strL3); // >>>  [GetClassExample, C] 链式关联, 可以追溯到源头被改变
        // strL3.add("N");   // 就不行了, 因为这个subList已经作为另一个subsubList的原List了, 所以原List操作被禁止增加

        // 再试两端重叠的subList
        System.out.println();
        List<String> strL4 = new ArrayList<>(Arrays.asList("GetClassExample", "GetB", "C", "D", "E"));
        List<String> strL4_sub = strL4.subList(0, 3);   // ["GetClassExample", "GetB", "C"]
        List<String> strL4_sub2 = strL4.subList(1, 4);  // ["GetB", "C", "D"]
        strL4_sub2.remove(0);
        strL4_sub2.add(1, "Z");
        strL4_sub2.set(0, "P");
        System.out.println(strL4_sub2);   // >>> [P, Z, D]
        System.out.println(strL4);        // >>> [GetClassExample, P, Z, D, E]
        // System.out.println(strL4_sub);  // 由于一个subList的改动干涉到了另一个subList, 所以那个subList被作废了
        strL4.add(0, "X");
        // System.out.println(strL4_sub2);   // 作废, 即使这一段没有被干涉, index整体变化了
        // strL4_sub2.add(1, "X"); // 不能加


        // Map.keySet()
        System.out.println();
        Map<String, Integer> Map1 = new HashMap<>(Map.ofEntries(
                Map.entry("GetClassExample", 1),
                Map.entry("GetB", 2),
                Map.entry("C", 3)
        ));

        Set<String> kL = Map1.keySet();
        kL.remove("GetB");
        System.out.println(Map1); // >>> {GetClassExample=1, C=3}  // 移除View的key也是移除了Map中的key
        // kL.add("X");  不能添加因为没有新键没有对应值,不会默认为null
        // 改变Map也会改变这个view
        Map1.put("X", 99);
        System.out.println(kL); // >>>  [X, GetClassExample, C]


        // Map.values()
        System.out.println();
        Map<String, Integer> Map2 = new HashMap<>(Map.ofEntries(
                Map.entry("GetClassExample", 1),
                Map.entry("GetB", 2),
                Map.entry("C", 3)
        ));
        Collection<Integer> vL = Map2.values();  // Collection没有index的概念

        // 增加一个key和value
        Map2.put("D", 4);
        Map2.remove("GetClassExample");
        System.out.println(vL); // >>> //  [2, 3, 4]
        vL.remove(2);
        System.out.println(Map2); // >>> {C=3, D=4}


        // Map.entrySet()
        Map<String, Integer> Map3 = new HashMap<>(Map.ofEntries(
                Map.entry("GetClassExample", 1),
                Map.entry("GetB", 2),
                Map.entry("C", 3)
        ));
        Set<Map.Entry<String, Integer>> S1 = Map3.entrySet();
        System.out.println(S1); // >>> [GetClassExample=1, GetB=2, C=3]
        // 原Map改动
        Map3.put("D", 4);
        Map3.remove("GetClassExample");
        System.out.println(S1); // >>> [GetB=2, C=3, D=4]
        S1.clear();
        System.out.println(Map3); // >>>  {}
    }
}
