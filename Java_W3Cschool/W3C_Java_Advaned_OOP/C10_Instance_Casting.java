package W3C_Java_Advaned_OOP;

public class C10_Instance_Casting {
}

// This is to leanr why we put (ClassName) before an instance


class AAA {
    void foo() {
        System.out.println("Foo A");
    }
}

class BBB extends AAA {

    void bar() {
        System.out.println("Bar B");
    }

    public static void main(String[] args) {
        BBB bb = new BBB();

        System.out.println(bb.equals((AAA) bb));  // true
        System.out.println(bb.equals((BBB) bb));  // true

        bb.foo();  // >>> Foo A
        bb.bar();  // >>> Bar B

        ((BBB)bb).foo();      // >>> Foo A
        ((BBB)bb).bar();      // >>> Bar B

        ((AAA)bb).foo();      // >>> Foo A
        // ((AAA)bb).bar();   // can't run

        System.out.println(((AAA)bb) instanceof AAA);  // >>> true
        System.out.println(((AAA)bb) instanceof BBB);  // >>> true


        AAA aa = new AAA();
        aa.foo();
        // ((BBB) aa).foo();   // cannot reversely cast
        // ((BBB) aa).bar();


    }
}


/*
 * So ((AAA)bb) is forcing bb only using AAA's method, so that bar() can't be run, because bar is defined in BBB.
 * ((BBB)bb) is exactly the same as bb, it will have both methods of AAA and BBB.
 */

/*
 * Casting
 *https://stackoverflow.com/questions/54599447/what-is-the-use-of-classname-instancename-in-java/54599576#54599576
     * What are you seeing here is Casting, in this case, explicit casting,
     * because you are telling the compiler that "bb" will be an instance of class "AAA".
     * This let you call specific "AAA" class methods even when "bb" is instanciated as a "BBB" class.
     * If you want more information you can read oracle docs about "Polymorphism" and "Casting".
 * https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
 */