import java.util.ArrayList;
import java.util.List;


public class List_Array {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList(3);   // Initial capacity 只是内存占用,并不影响实际长度

        l1.add(5);
        l1.add(6);
        System.out.println(l1);  // >>> [5, 6]
        System.out.println(l1.size());  // >>> 2    not full length

        l1.add(7);
        l1.add(8);    // 虽然起始长度是3, 但是可以随时添加
        l1.add(9);

        System.out.println(l1);  // >>> [5, 6, 7, 8, 9]
        System.out.println(l1.size());  // >>> 5    not full length

        List<String> l2 = new ArrayList(3);   // String list原理完全相同



    }
}

