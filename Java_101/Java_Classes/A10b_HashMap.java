package Java_Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A10b_HashMap {

     /*
      * HashMap常用方法
         * 来自Map
             * get                   根据Key取Value
             * getOrDefault​          增强型get, 提供一个default值,如果key不存在
             * put                   添加新Key和新Value (不能重复Key)
             * putIfAbsent           安全型添加, 添加后, 存在key就返回原value, 不存在就返回null
             * putAll                批量添加(合并一个Map进来)

             * remove​(key)           删除并返回Value
             * remove​(key, value)    增强版remove          带boolean确认

             * replace                      修改Key的值
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

         * 来自HashMap
            * clone()               shallow copy
     */

    public static void main(String[] args) {

        HashMap<String, List<Integer>> HM1 = new HashMap<>(Map.ofEntries(
                Map.entry("A", new ArrayList<>(List.of(1,2,3))),
                Map.entry("B", new ArrayList<>(List.of(4,5,6))),
                Map.entry("C", new ArrayList<>(List.of(7,8,9)))
        ));

        // clone() return an Object as a shallow copy  // 注意正确使用转型.
        HashMap<String, List<Integer>> HM1_copy = (HashMap<String, List<Integer>>) HM1.clone();
        HM1.get("A").add(999);  // 改变value List的值, 而不是将key指引到其他List

        System.out.println(HM1);       // >>>  {A=[1, 2, 3, 999], B=[4, 5, 6], C=[7, 8, 9]}
        System.out.println(HM1_copy);  // >>>  {A=[1, 2, 3, 999], B=[4, 5, 6], C=[7, 8, 9]}
    }

}
