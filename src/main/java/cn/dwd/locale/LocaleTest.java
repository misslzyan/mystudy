package cn.dwd.locale;

import java.util.Locale;

/**
 * 
 * @author weidongduan
 *
 */
public class LocaleTest {
	
	public static void main(String[] args) {
		Locale locale = new Locale("zh");
		System.out.println(locale);
		System.out.println(locale.getDisplayCountry());
	}
}
