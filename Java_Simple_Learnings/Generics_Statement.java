import java.util.List;

// This is to learn the difference of the generic type claim

class Car {
    void foo() {
        System.out.println("!!!!!!!!!");
    }
}

public class Generics_Statement {

    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();

        List<Car> carList = List.of(c1,c2,c3);
        System.out.println(carList.get(0).getClass());      // >>> class Car
        System.out.println(carList.get(0) instanceof Car);  // >>> true

        carList.get(0).foo();

        List<Object> objList = List.of(c1,c2,c3);
        System.out.println(objList.get(0).getClass());      // >>> class Car
        System.out.println(objList.get(0) instanceof Car);  // >>> true
        // objList.get(0).foo();


        List rawList = List.of(c1,c2,c3);
        System.out.println(rawList.get(0).getClass());      // >>> class Car
        System.out.println(rawList.get(0) instanceof Car);  // >>> true
        // rawList.get(0).foo();

    }
}

