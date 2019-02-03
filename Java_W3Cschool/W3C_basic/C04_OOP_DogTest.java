package W3C_basic;


// 一个例子来展示Employee和EmployeeTest两个类的联用

public class C04_OOP_DogTest {
    public static void main(String[] args) {
        C04_OOP_Dog dog_01 = new C04_OOP_Dog("Jackie");
        C04_OOP_Dog dog_02 = new C04_OOP_Dog("DiDi");
        System.out.println();

        dog_01.setAge(2);
        dog_01.age = 4;  // 仍然可以跳过set方法强制设定
        dog_01.breed = "Peking Dog";
        dog_02.setAge(3);
        dog_02.breed = "Poodle";
        dog_02.color = "Brown";

        dog_01.printinfo();
        System.out.println();
        dog_02.printinfo();

        // >>>
        // Dog Jackie is created
        // Dog DiDi is created
        //
        // Name: Jackie
        // Age: 2
        // Breed: Peking Dog
        // Color: white
        //
        // Name: DiDi
        // Age: 3
        // Breed: Poodle
        // Color: white
    }
}

