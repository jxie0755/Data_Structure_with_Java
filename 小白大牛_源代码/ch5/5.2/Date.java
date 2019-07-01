/*
* 版权所有 2015 北京智捷东方科技有限公司
* 许可信息查看LICENSE.txt文件
* 描述:
*   实现日期基本功能
* 历史版本:
*   2015-7-22: 创建 关东升
*   2015-8-20: 添加socket库
*   2015-8-22: 添加math库
*/

package com.a51work6;

/**
 * 自定义的日期类，具有日期基本功能，继承java.util.Date
 * <p>实现日期对象和字符串之间的转换</p>
 * @author 关东升
 */
public class Date extends java.util.Date {

	// 默认的容量，是一个常量
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 容量
     */
    public int size;

    /**
     * 将字符串转换为Date日期对象
     * @param s 要转换的字符串
     * @return Date日期对象
     */
    public static Date valueOf(String s) {

        final int YEAR_LENGTH = 4;
        final int MONTH_LENGTH = 2;
		
        int firstDash;
        int secondDash;

		Date d = null;
		//...
		
		/*
		* 判断d是否为空，
		* 如果为空抛出异常IllegalArgumentException，否则返回d。
		*/
		if (d == null) {
            throw new java.lang.IllegalArgumentException();
        }

        return d;
    }

    /**
     * 将日期转换为yyyy-mm-dd格式的字符串
     * @return yyyy-mm-dd格式的字符串
     */
    public String toString () {
        int year = super.getYear() + 1900; //计算年份
        int month = super.getMonth() + 1; /*计算月份*/
        int day = super.getDate();
		//...
    }
}
