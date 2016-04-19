package cn.dwd.locale;

import java.text.NumberFormat;
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
		Locale l = Locale.getDefault();
		System.out.println(l);
		NumberFormat.getAvailableLocales();
		System.out.println("========================");
		for(Locale temp : NumberFormat.getAvailableLocales()){
			System.out.println(temp);
		}
		NumberFormat nf = NumberFormat.getPercentInstance();

		String percentStr = nf.format(0.546);
		System.out.println(percentStr);
		Integer.valueOf("3");
	}
}
