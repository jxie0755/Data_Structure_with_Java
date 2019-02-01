package head_first_java_chapter_01;

public class C02_BeerSong {
    public static void main(String[] args) {
        int beerNum = 5;
        String word = "bottles";
        while (beerNum > 0) {
            if (beerNum == 1) {
                word = "bottle"; // 单数的瓶子
            }

            System.out.println(beerNum + " " + word + "of beer on the wall");
            System.out.println("Take one down.");
            System.out.println("Pass it around.");
            beerNum = beerNum - 1;
            if (beerNum == 0) {
                System.out.println("No more bottles of beer on the wall");
            }//else end

        } //while loop end
    } //main݆ end
} //class end

