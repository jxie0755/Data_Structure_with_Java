package java_reference_chapter_01;

public class C04_While_Loop {
    public static void main(String[] args) {

        System.out.println("while loop 1: ");

        int x = 0;
        while (x <= 10) {
            System.out.println(x);
            x = x + 1;
            // >>>
            // while loop
            //0
            //1
            //2
            //3
            //4
            //5
            //6
            //7
            //8
            //9
            //10
        }

        System.out.println();
        System.out.println("while loop break: ");
        x = 0;
        while (x <= 10) {
            if (x == 5) {
                break;
            } else {
                System.out.println(x);
                x = x + 1;
            }
            // >>>
            // while loop
            //0
            //1
            //2
            //3
            //4
        }
    }
}

/*
 * while loop is more like python, define indicator outside
 * java中,int和boolean不同, 所以不能while(0)或者while(1)
 * Use break the same way
 */