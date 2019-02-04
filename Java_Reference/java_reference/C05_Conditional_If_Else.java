package java_reference;// 1.4

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
        } else {
            System.out.println("Not showen");
        }


        // 1.4.2
        // Another Conditional Expressions (Not commonly used)
        System.out.println(3 < 4 ? "Less" : "More"); // Prints Less
        System.out.println(4 < 3 ? "Less" : "More"); // Prints More
        System.out.println(3 > 4 ? 1 : "WTF");  // avoid using, check bottom comments

        System.out.println(1 < 0 ? 1.1 : 1 > 2 ? 2.1 : 3.1);
        System.out.println(1 < 0 ? 1.1 : (1 > 2 ? 2.1 : 3.1));
        // The above two mean the same, and print 3.1 (multiple if/else if/else)


        // 1.4.3
        // Use of {} in conditional 2
        System.out.println("\nif elif else (with no {}): ");
        if (3 > 5)
            System.out.println("3 > 5!!");
        else if (2 < 5) {
            System.out.println("elif 2 < 5");
            System.out.println("Double line needs {}!!");
        } else if (2 < 10)  // start after }
            System.out.println("hmmmm");
        else  // back to no indent
            System.out.println("Not showen");


        char grade = 'A';
        switch (grade) {
            case 'A':
                System.out.println("优秀");
                // break;
            case 'B':
                System.out.println("还行");
                break;
            case 'C':
                System.out.println("良好");
                break;
            case 'D':
                System.out.println("及格");
            case 'F':
                System.out.println("你需要继续努力");
                break;
            default:
                System.out.println("无效等级");   // default放最后,这样可以免去一个break

        }
        System.out.println("你的等级是 " + grade);
        // >>>
        // 优秀
        // 还行           // 如果没有 break则分析完会进入下一个case
        // 你的等级是 A
    }
}



/*
* Same if/else, if/elif/else logic as python
* else if will be skipped if first "if" was true
* the else if and else actually does not need {} (can also have)
* The expressions after ‘?’ and ‘:’ must be the same type of thing; 3<4 ? 1 : "Hello" is erroneous.
* Single line skip {}, multiline needs {}
* Skip {} does not allow variable statement, as this involves scopes structure
* Google Java style guide: Braces are used with if, else, for, do and while statements, even when the body is empty or contains only a single statement.
* Blocks: https://stackoverflow.com/questions/15786949/is-there-a-difference-in-removing-the-curly-braces-from-if-statements-in-java
* Blacks: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/expressions.html
* */

/*
 * switch语句
 * switch语句判断一个变量与一系列值中某个值是否相等，每个值称为一个分支。
    * switch语句中的变量类型只能为byte、short、int或者char。
    * switch语句可以拥有多个case语句。每个case后面跟一个要比较的值和冒号。
    * case语句中的值的数据类型必须与变量的数据类型相同，而且只能是常量或者字面常量。
    * 当变量的值与case语句的值相等时，那么case语句之后的语句开始执行，直到break语句出现才会跳出switch语句。
    * 当遇到break语句时，switch语句终止。程序跳转到switch语句后面的语句执行。case语句不必须要包含break语句。如果没有break语句出现，程序会继续执行下一条case语句，直到出现break语句。
    * switch语句可以包含一个default分支，该分支必须是switch语句的最后一个分支。default在没有case语句的值和变量值相等的时候执行。default分支不需要break语句。
 */