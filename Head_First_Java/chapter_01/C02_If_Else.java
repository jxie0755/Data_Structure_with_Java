package chapter_01;

public class C02_If_Else {
    public static void main(String[] args) {

        System.out.println("if then no else: ");
        if (3 < 5) {
            System.out.println("3 < 5!!");
        }
        System.out.println("This should show as it is outside of if loop");


        System.out.println("");
        System.out.println("Simple if else: ");
        if (3 < 5) {
            System.out.println("3 < 5!!");
        } else {
            System.out.println("This should not show");
        }


        System.out.println("");
        System.out.println("if elif else: ");
        if (3 < 5) {
            System.out.println("3 < 5!!");
        } else if (2 < 5){
            System.out.println("elif 2 < 5");
        } else {
            System.out.println("Not showen");
        }

    }
}


/*
* Same if/else, if/elif/else logic as python
* else if will be skipped if first "if" was true
* */