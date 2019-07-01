public class Date extends java.util.Date {

    // 默认的容量，是一个常量
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 容量
     */
    public int size;
    
    int longName1 = 0, longName2 = 0, longName3 = 0, longName4 = 0, longName5 = 0;
    
    boolean boolName1 = true;

    public String getString() {

        int year = super.getYear() + 1900; // 计算年份
        int month = super.getMonth() + 1; /* 计算月份 */
        int day = super.getDate();
        // ...

        if ((longName1 == longName2)
                || (longName3 == longName4) && (longName3 > longName4) 
                && (longName2 > longName5)) {

        }
                 
        return null;
    }
}