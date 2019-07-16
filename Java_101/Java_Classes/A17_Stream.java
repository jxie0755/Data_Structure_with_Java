package Java_Classes;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A17_Stream {

    /*
     * Module java.base
     * Package java.util.stream
     * Interface Stream<T>
     */

    /*
     * 学习使用Stream
        * http://www.runoob.com/java/java8-streams.html
            * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据
            * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象
            * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等
            * +--------------------+       +------+   +------+   +---+   +-------+
              | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
              +--------------------+       +------+   +------+   +---+   +-------+

        * Stream（流）是一个来自数据源的元素队列并支持聚合操作
            * 元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
            * 数据源   - 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
            * 聚合操作 -  类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。

        * 和以前的Collection操作不同， Stream操作还有两个基础的特征：
            * Pipelining:
                * 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道，
                * 如同流式风格（fluent style）。 这样做可以对操作进行优化
                * 比如延迟执行(laziness)和短路( short-circuiting)。
            * 内部迭代:
                * 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。
                * Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。

        * 流和其它集合具体的区别，可以参照下面的列表：
            * 不存储数据。流是基于数据源的对象，它本身不存储数据元素，而是通过管道将数据源的元素传递给操作。
            * 函数式编程。流的操作不会修改数据源，例如filter不会将数据源中的数据删除。
            * 延迟操作。流的很多操作如filter,map等中间操作是延迟执行的，只有到终点操作才会将操作顺序执行。
            * 可以解绑。对于无限数量的流，有些操作是可以在有限的时间完成的，比如limit(n) 或 findFirst()，这些操作可是实现"短路"(Short-circuiting)，访问到有限的元素后就可以返回。
            * 纯消费。流的元素只能访问一次，类似Iterator，操作没有回头路，如果你想从头重新访问流的元素，对不起，你得重新生成一个新的流。



            * streams have three parts:
                * A data source
                * Zero or more intermediate operations
                * Zero or one terminal operation



        * 常用方法

        * Collection.stream()                生成串行流
        * Collection.parallelStream()        生成并行流
        * parallel()                         将串行流转换成并行流
        * sequential()                       将并行流转换成串行流

        * forEach(Lambda)                    for loop迭代


        * 中间操作 intermediate operations
        * map(Function)                      类似py的map, high order function处理元素     (可能打乱顺序)
        * mapToInt                           转换成int元素
        * mapToDoule                         转换成double元素
        * mapToLong                          转换成long元素

        * filter(Function)                   类似py的filter, high order function过滤元素  (不断乱原顺序)
        * limit(n)                           只保留前n个元素
        * sorted()                           给元素排序
        * unordered()                        不排序, 但是也不打乱
        * distinct()                         类似set命令, 去重
        * peek(Function)                     只看不操作, 用于debug和观察过程


        * 终点操作 terminal operations
        * allMatch(Function)                 类似python的all, 断言全部元素能在Function中返回true
        * anyMatch(Function)                 类似python的any, 断言有没有任何元素能在Function中返回true
        * noneMatch(Function)                断言没有任何元素能在Function中返回true

        * count()                            返回流中元素数目

        * collect(Collectors.toList())       转换回list
        * collect(Collectors.joining(String) 连接成String
        * toArray()                          放到一个Array里

        * findAny()                          可以判断是否能找到任何元素(通常是中间处理流之后), 返回一个Optional对象
        * findFirst()                        可以判断能找到的第一个元素(通常是中间处理流之后), 返回一个Optional对象

        * max(Comparator)                    返回最大值 (装在Optional对象里)
        * min(Comparator)                    返回最小值 (装在Optional对象里)

        * reduce                             类似py的reduce, 高阶函数

        * Statistics
     */


    public static void main(String[] args) {

        // Initiation 通过集合来创造, 有两种方式
        // stream() − 为集合创建串行流。
        // parallelStream() − 为集合创建并行流。
        List<String> lst_1 = new ArrayList<>(Arrays.asList("b", "c", "d", "a"));
        Stream<String> lst_1_stm = lst_1.stream();  // 产生流

        // 通过Arrays来创造 Arrays.stream(Object[])
        Stream<Integer> AS = Arrays.stream(new Integer[]{1, 2, 3});

        // 使用流的静态方法
        // Stream.of(Object[])
        // IntStream.range(int, int)
        // Stream.iterate(Object, UnaryOperator)
        // Stream.iterate(0, n -> n * 2)
        // generate(Supplier<T> s)如 Stream.generate(Math::random)
        // BufferedReader.lines()从文件中获得行的流
        // 随机数流Random.ints()

        // forEach
        lst_1_stm.forEach(System.out::println);
        // >>>
        // b
        // c
        // d
        // a
        // Stream类似迭代器, 被操作后不能复用


        // Intermediate Operation
        // map
        List<String> lst_2 = lst_1.stream()
                .map(i -> i + i)
                .collect(Collectors.toList());
        System.out.println(lst_2); // >>> [bb, cc, dd, aa]


        // filter
        List<String> lst_3 = lst_1.stream()
                .filter(i -> !i.equals("b") && !i.equals("d"))
                .collect(Collectors.toList());
        System.out.println(lst_3); // >>> [c, a]


        // limit
        List<String> lst_4 = lst_1.stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(lst_4); // >>> [b, c]


        // sorted
        List<String> lst_5 = lst_1.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(lst_5); // >>> [a, b, c, d]


        // unordered
        // 这个方法并不是对元素进行排序或者打散，而是返回一个是否encounter order的流
        List<String> lst_6 = lst_1.stream()
                .unordered()
                .collect(Collectors.toList());
        System.out.println(lst_6);
        // >>> [b, c, d, a]


        // distinct
        List<Integer> numbers2 = Arrays.asList(2, 2, 1, 1, 3, 4, 4, 3);
        List<Integer> n2_remove_repeat = numbers2.stream()
                . distinct()
                . collect(Collectors.toList());
        System.out.println(n2_remove_repeat); // >>> [2, 1, 3, 4]


        // peek  只看不consume
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> sn3 = numbers3.stream();
        List<Integer> numbers3_sq = sn3.map(i -> i * i).peek(System.out::println).collect(Collectors.toList());
        System.out.println(numbers3_sq);
        // >>>
        // 1
        // 4
        // 9
        // 16                前面的peek用于debug,观察过程
        // [1, 4, 9, 16]



        // Terminal Operation

        // Match(Function)
        List<Integer> to_match = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        // allMatch
        System.out.println(to_match.stream().allMatch(i -> i % 2 != 0)); // >>> true
        System.out.println(to_match.stream().allMatch(i -> i < 9)); // >>> false

        // anyMatch(Function)
        System.out.println(to_match.stream().anyMatch(i -> i < 4)); // >>> true
        System.out.println(to_match.stream().anyMatch(i -> i < 0)); // >>> false

        // noneMatch(Function)
        System.out.println(to_match.stream().noneMatch(i -> i % 2 == 0)); // >>> true
        System.out.println(to_match.stream().noneMatch(i -> i < 9)); // >>> false

        // count
        System.out.println(to_match.stream().count()); // >>> 5


        // collect(Collectors.toList()) 转换回list
        List<String> list_1_copy = lst_1.stream()
                .collect(Collectors.toList());
        System.out.println(list_1_copy); // >>> [b, c, d, a]

        // Collectors也可以合并
        String list_1_str = lst_1.stream().
                collect(Collectors.joining("-"));
        System.out.println(list_1_str); // >>> b-c-d-a

        // 数字类list怎么join? 先转成string再连接
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        String numbers_str = numbers.stream()
                .map(i -> String.valueOf(i))
                .collect(Collectors.joining("-"));
        System.out.println(numbers_str); // >>> 3-2-2-3-7-3-5

        // toArray()
        List<Integer> to_ary = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        Object[] OA = to_ary.stream().toArray(); // 默认是转为Object[]
        System.out.println(Arrays.toString(OA)); // >>> [1, 3, 5, 7, 9]
        int[] IA = to_ary.stream().mapToInt(i -> i).toArray(); // 必须是int[]
        System.out.println(Arrays.toString(IA)); // >>> [1, 3, 5, 7, 9]




        // findAny()
        // find any element from a Stream.
        // Use it when you are looking for an element without paying an attention to the encounter order
        List<Integer> to_find = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        Optional<Integer> f1 = to_find.stream().filter(i -> i > 5).findAny();
        System.out.println(f1.get()); // >>> 7 找到7, 但是不能保证一定是按顺序找到, 也可能线找到9


        // findFirst()
        Optional<Integer> f2 = to_find.stream().filter(i -> i > 5).findFirst();
        System.out.println(f2.get()); // >>> 7 一定是找到7
        // 如果没有呢?
        Optional<Integer> f3 = to_find.stream().filter(i -> i > 10).findFirst();
        // System.out.println(f3.get()); // >>> error
        System.out.println(f3.isEmpty()); // >>> true       // 确定是否没找到
        System.out.println(f3.isPresent()); // >>> false    // 确定是否找到


        // max(Comparator) and  min(Comparator)
        List<Integer> numbers4 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        System.out.println(numbers4.stream().max(Integer::compareTo)); // >>> Optional[9]
        System.out.println(numbers4.stream().min(Integer::compareTo)); // >>> Optional[1]


        // reduce
        List<Integer> numbers5 = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
        Optional<Integer> factorial = numbers5.stream().reduce((x, y) -> x * y);  // 选择第一个值作为初始值
        System.out.println(factorial); // >>> Optional[384]
        Integer factorial_int = numbers5.stream().reduce(1, (x, y) -> x * y);  // 必须制定初始值, 避免空流
        System.out.println(factorial_int); // >>> 384

        // Statistics
        // 一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果
        List<Integer> numbers_stat = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers_stat.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println(stats.getMax());     // >>> 7
        System.out.println(stats.getMin());     // >>> 2
        System.out.println(stats.getSum());     // >>> 25
        System.out.println(stats.getAverage()); // >>> 3.5714285714285716

    }

}


class A17b_Collectors {

    /*
     * compact1, compact2, compact3
     * java.util.stream
     * Class Collectors
     */

    /*
     * 辅助类Collectors提供了很多的collector
     * 可以满足我们日常的需求，你也可以创建新的collector实现特定的需求。
     * 它是一个值得关注的类，你需要熟悉这些特定的收集器，
     * 如聚合类averagingInt、最大最小值maxBy minBy、
     * 计数counting、分组groupingBy、
     * 字符串连接joining、分区partitioningBy、
     * 汇总summarizingInt、化简reducing、转换toXXX等
     */

}


class A17c_Optional {

    /*
     * Module java.base
     * Package java.util
     * Class Optional<T>
     */


    /*
     * java8 新特性, Java 9 又为 Optional 类增加了三种方法：or()、ifPresentOrElse() 和 stream()
     * 该类主要用来处理几乎每位程序员都碰到过的麻烦问题—— 空指针异常 (NullPointerException)
     * 从本质上来说，该类属于包含可选值的封装类（wrapper class），因此它既可以包含对象也可以仅仅为空
     */

    /*
     * 常用方法

     * Optional.of(item)                创建一个Optional对象,内容不为空
     * Optional.ofNullable(item)        创建一个Optional对象,内容可为空

     * isEmpty()                        检查对象内容是否为空
     * isPresent()                      检查对象内容是否存在

     * ifPresent(Function)              如果 Optional 中有值，则对该值调用一个函数，否则什么也不做
     * orElse(default)                  返回内容, 若为空则返回一个默认值
     * orElseGet(Function)              返回内容, 若为空则通过Function制造一个内容返回
     * orElseThrow                      返回内容, 若为空则抛出一个异常或者自定义异常

     * map(Function)                    若不存在内容则返回Optional.empty不然则返回一个Optional[f(content)]
     *
     */


    public static void main(String[] args) {

        // initiation
        // Optional<String> o1 = Optional.of(null);          // >>> 无法创建
        Optional<String> o_emp = Optional.ofNullable(null);  // >>> 可创建
        // System.out.println(o2.get()); // >>> NoSuchElementException: No value present

        Optional<String> o_good = Optional.ofNullable("D");  // >>> 可创建
        // 为避免空值不能被get, 可先检查 (但是这样就不优雅了, 背离了这个类的意义,还是要先检查)

        Optional<String> o0 = Optional.empty();  // 创建一个空Optional
        System.out.println(o0.isEmpty()); // >>> true


        // get() return the content if not empty else NoSuchElementException
        System.out.println(o_good.get()); // >>> D

        // isPresent()
        // isEmpty()
        System.out.println(o_good.isPresent()); // >>> true
        System.out.println(o_emp.isEmpty());   // >>> true

        // 避免检查空值, 直接操作
        // ifPresent(Function) 如果 Optional 中有值，则对该值调用一个函数，否则什么也不做
        o_emp.ifPresent(i -> System.out.println(i + i + i)); // >>> 无操作
        o_good.ifPresent(i -> System.out.println(i + i + i)); // >>> DDD

        // orElse(item)
        System.out.println(o_good.orElse("X")); // >>> D  若存在就返回内容
        System.out.println(o_emp.orElse("X")); // >>> X  若不存在就返回else内容作为默认

        // orElseGet(Function)
        // orElseGet 与 orElse 方法的区别在于
        // orElseGet 方法传入的参数为一个 Supplier 接口的实现 ——
            // 当 Optional 中有值的时候，返回值；
            // 当 Optional 中没有值的时候，返回从该 Supplier 获得的值
        String x1 = o_emp.orElseGet(() -> "WTF");
        System.out.println(x1); // >>> WTF

        // orElseThrow(Function)
            // 当 Optional 中有值的时候，返回值
            // 没有值的时候会抛出异常，抛出的异常由传入的 exceptionSupplier 提供
        // String x2 = o2.orElseThrow();


        // map
        // 如果当前 Optional 为 Optional.empty，则依旧返回 Optional.empty；
        // 否则返回一个新的  Optional，该 Optional 包含的是：函数 mapper 在以 value 作为输入时的输出值
        System.out.println(o_emp.map(i -> i + i)); // >>> Optional.empty
        System.out.println(o_good.map(i -> i + i)); // >>> Optional[DD]

    }



}
