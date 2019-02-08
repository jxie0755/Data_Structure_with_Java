package W3C_Java_Advaned_OOP;

public class C10_Instance_Casting {
}

// This is to leanr why we put (ClassName) before an instance


class Animal_6 {
	public String name;
	Animal_6(String name) {
		this.name = name;
	}

	void foo(){
	    System.out.println("Foo ANIMAL");
    }

}
class Cat_6 extends Animal_6 {
	public String eyesColor;
	Cat_6(String n,String c) {
		super(n);
		eyesColor = c;
	}

	void foo(){
	    System.out.println("Foo CAT");
    }

}
class Dog_6 extends Animal_6 {
	public String furColor;
	Dog_6(String n,String c) {
		super(n);
		furColor = c;
	}

	void foo(){
	    System.out.println("Foo Dog");
    }

}

class TestAnimal_6 {
	public static void main(String[] args) {
		Animal_6 animal_6 = new Animal_6("animal_name");
		Cat_6 cat_6 = new Cat_6("cat_name", "blue");
		Dog_6 dog_6 = new Dog_6("dog_name", "black");
		System.out.println(animal_6.getClass()); // >>> Animal_6

		// Dog_6 animal_6 = new Dog_6("big_yellow", "yellow");  // this will not be allowed as animal_6 is already created
		// That is why we need casting:
		// Originally animal_6 is just Animal instance, now we change it into Dog instance under the same name
		animal_6 = new Dog_6("big_yellow", "yellow");  // in such way animal_6 is now like a Dog_6 instance, the subclass instance
		System.out.println(animal_6.getClass()); // >>> Dog_6

		Dog_6 d1 = (Dog_6) animal_6;  // another new instance of Dog_6, d1, does not need to be created as a new instance but to cast
		System.out.println(d1.getClass());  // Dog_6

		System.out.println(animal_6.name);  // >>> big_yellow
		// System.out.println(animal_6.furColor);  // but animal_6 is really still an animal istance that does not have furColor

		// It will be like a copy of animal_6
		System.out.println(d1.name);  // >>> big_yellow
		System.out.println(d1.furColor); // >>> yellow

		((Dog_6) dog_6).foo();     // >>> Foo Dog
		// ((Cat_6) dog_6).foo();  not allowed
		((Animal_6) dog_6).foo();  // >>> Foo Dog  does not impact
	}
}


class AAA {

}

class BBB extends AAA {


    public static void main(String[] args) {
        BBB bb = new BBB();
        System.out.println(bb.equals((AAA) bb));  // true
        System.out.println(bb.equals((BBB) bb));  // true
    }
}

/*
 * So ((AAA)bb) is forcing bb only using AAA's method, so that bar() can't be run, because bar is defined in BBB.
 * ((BBB)bb) is exactly the same as bb, it will have both methods of AAA and BBB.
 */


/*
 * Casting
 * https://stackoverflow.com/questions/54599447/what-is-the-use-of-classname-instancename-in-java/54599576#54599576
     * What are you seeing here is Casting, in this case, explicit casting,
     * because you are telling the compiler that "bb" will be an instance of class "AAA".
     * This let you call specific "AAA" class methods even when "bb" is instanciated as a "BBB" class.
     * If you want more information you can read oracle docs about "Polymorphism" and "Casting".
 * more in:
 	* https://stackoverflow.com/questions/5289393/casting-variables-in-java
 */



// Oracle example
// https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html



