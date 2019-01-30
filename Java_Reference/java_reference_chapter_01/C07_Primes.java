package java_reference_chapter_01;

public class C07_Primes {

    /**Print all prime numbers smaller than x*/
    public static String primes (int x) {
        for (int i=2; i <= x; i = i + 1) {
            inner: {
                for (int j = 2; j < (int)Math.pow(x, 0.5) + 1; j = j + 1) {
                    if (i % j == 0) {
                        break inner;
                    }

                }
                System.out.print(i + " ");
            }
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i=2; i <= 20; i = i + 1) {
            inner: {
                for (int j = 2; j < (int)Math.pow(i, 0.5) + 1; j = j + 1) {
                    if (i % j == 0) {
                        break inner;
                    }

                }
                System.out.print(i + " ");
            }
        }

        // Above will work to print out a sequence of numbers 2 3 5 7 11 13 17 19 when x = 20


    }
}

