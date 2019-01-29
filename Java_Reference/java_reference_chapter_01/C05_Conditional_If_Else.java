package java_reference_chapter_01;

// 1.4

public class C05_Conditional_If_Else {
    public static void main(String[] args) {

        // 1.4.1
        System.out.println("if then no else: ");
        if (3 < 5) {
            System.out.println("3 < 5!!");
        }
        System.out.println("This should show as it is outside of if loop");


        System.out.println("");
        System.out.println("Simple if else: ");
        if (3 < 5) {
            System.out.println("3 < 5!!");
        } else
            System.out.println("This should not show");



        System.out.println("");
        System.out.println("if elif else: ");
        if (3 < 5) {
            System.out.println("3 < 5!!");
        } else if (2 < 5) {
            System.out.println("elif 2 < 5");
        } else
            System.out.println("Not showen");

        // 1.4.2
        // Another Conditional Expressions (Not commonly used)
        System.out.println (3 < 4 ? "Less" : "More"); // Prints Less
        System.out.println (4 < 3 ? "Less" : "More"); // Prints More
        System.out.println (3 > 4 ? 1 : "WTF");  // avoid using, check bottom comments

        System.out.println (1 < 0 ? 1.1 : 1 > 2 ? 2.1 : 3.1);
        System.out.println (1 < 0 ? 1.1 : (1 > 2 ? 2.1 : 3.1));
        // The above two mean the same, and print 3.1 (multiple if/else if/else)


        // 1.4.3
        // Use of {} in conditional 2
        System.out.println("\nif elif else (with no {}): ");
        if (3 > 5)
            System.out.println("3 > 5!!");
        else if (2 < 5) {
            System.out.println("elif 2 < 5");
            System.out.println("Double line needs {}!!");
        } else if (2 <10)  // start after }
            System.out.println("hmmmm");
        else  // back to no indent
            System.out.println("Not showen");


        // Special form if condition is always if (E = ...)
        //        if (action == PICK_UP)
        //            acquireObject ();
        //        else if (action == DROP)
        //            releaseObject ();
        //        else if (action == ENTER || action == EXIT)
        //            changeRooms (action);
        //        else if (action == QUIT) {
        //            cleanUp ();
        //            return;
        //        } else if (action == CLIMB)
        //            ...
        //        else
        //            ERROR ();

        //   static final int // ’final’ means ’constant’
        //       QUIT = 0,
        //       PICK_UP = 1,
        //       DROP = 2,
        //       ENTER = 3,
        //       EXIT = 4,
        //       CLIMB = 5,
        //       etc.

        // switch (action) {
        //  case PICK_UP:
        //      acquireObject ();
        //      break;
        //  case DROP:
        //      releaseObject ();
        //      break;
        //  case ENTER: case EXIT:
        //      changeRooms (action);
        //      reak;
        //  case QUIT:
        //      cleanUp ();
        //      return;
        //  case CLIMB:
        //      ...
        //  default:
        //      ERROR ();
        // }


    }
}


/*
* Same if/else, if/elif/else logic as python
* else if will be skipped if first "if" was true
* the else if and else actually does not need {} (can also have)
* The expressions after ‘?’ and ‘:’ must be the same type of thing; 3<4 ? 1 : "Hello" is erroneous.
* Single line skip {}, multiline needs {}
* */