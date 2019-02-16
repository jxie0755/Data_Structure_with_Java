package Java_Basics;// 1.6

public class C01b_Primes {

    /**Print all prime numbers smaller than x*/
               // void means do not return anything
    public static void primes_1(int x) {
        for (int i=2; i <= x; i += 1) {
            inner: {
                for (int j = 2; j < (int)Math.pow(i, 0.5) + 1; j += 1) {
                    if (i % j == 0) {
                        break inner;
                    }
                }
                System.out.print(i + " ");
            }
        }

    }

    // Use of two methods
    public static boolean isPrime(int x) {
        if (x == 2) {
            return true;
        } else {
            for (int i=2; i <= (int)Math.pow(x, 0.5) +1; i += 1) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void primes_2 (int x) {
        for (int i = 2; i <= x; i = i + 1) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }


    // Main
    public static void main(String[] args) {

        System.out.println("From loop in main: ");
        for (int i=2; i <= 20; i += 1) {
            inner: {
                for (int j = 2; j < (int)Math.pow(i, 0.5) + 1; j += 1) {
                    if (i % j == 0) {
                        break inner;
                    }
                }
                System.out.print(i + " ");
            }
        }

        // Above will work to print_class out a sequence of numbers 2 3 5 7 11 13 17 19 when x = 20

        System.out.println("\nFrom primes_1 method: ");
        primes_1(20);

        System.out.println("Test isPrime: ");
        System.out.println(isPrime(2));
        System.out.println(isPrime(4));
        System.out.println(isPrime(7));

        primes_2(20);
        // like python, check all method under class first then execute, so the sequence of two methods does not matter

    }
}

