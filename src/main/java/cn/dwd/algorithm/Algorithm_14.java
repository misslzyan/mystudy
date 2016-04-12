package cn.dwd.algorithm;

import java.util.Calendar;

/**
 * 描述：输入某年某月某日，判断这一天是这一年的第几天？
 * 
 * @author weidongduan
 * 
 */
public class Algorithm_14 {

	public static void myAnswer(int year, int month, int day) {
		int sum = 0;
		// 1.首先判断是不是闰年
		if((year%400==0)||(year%4==0&&year%100!=0)){
			if(month>2)
			  sum+=1;
		}
		sum+=day(month-1);
		sum+=day;
		System.out.println(sum);
	}

	// 1,3,5,7,8,10,12
	public static int day(int month) {
		int sum = 0;
		switch (month) {
		case 12:
			sum += 31;
		case 11:
			sum += 30;
		case 10:
			sum += 31;
		case 9:
			sum += 30;
		case 8:
			sum += 31;
		case 7:
			sum += 31;
		case 6:
			sum += 30;
		case 5:
			sum += 31;
		case 4:
			sum += 30;
		case 3:
			sum += 31;
		case 2:
			sum += 28;
		case 1:
			sum += 31;
		default:
			break;
		}
		return sum;
	}
	public static void main(String[] args) {
		myAnswer(2016, 10, 31);
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2016);
		c.set(Calendar.MONTH, 9);
		c.set(Calendar.DAY_OF_MONTH,31);
		System.out.println(c.getTime());
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
	}
}
