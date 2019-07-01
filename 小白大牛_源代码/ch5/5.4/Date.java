
public class Date extends java.util.Date {

    int longName1 = 0;
    int longName2 = 0;

    boolean boolName1 = true;

    public String getString() {

        int year = super.getYear() + 1900; // 计算年份
        int month = super.getMonth() + 1; /* 计算月份 */
        int day = super.getDate();
        
        return null;
    }

    public void setString() {}

}