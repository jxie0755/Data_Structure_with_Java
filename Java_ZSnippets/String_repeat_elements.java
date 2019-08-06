public class String_repeat_elements {

    /*
     * This is to learn how to create a string with repeating elements
     * In python it is easy to create: str = 5 * "i" >>> "iiiii"
     */

    public static void main(String[] args) {
        String S = new String(new char[5]).replace("\0", "i");
        System.out.println(S);
        // >>> iiiii
        System.out.println(S + "123");
        // >>> iiiii123

        // 就算是0也要replace
        String S2 = new String(new char[5]);
        System.out.println(S2);
        // >>> empty
        String S3 = new String(new char[5]).replace("\0", "0");
        System.out.println(S3);
        // >>> 00000
    }
}

