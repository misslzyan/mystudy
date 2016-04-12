package cn.dwd.algorithm;

import java.util.ArrayList;

/**
 * 描述：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。 已抽签决定比赛名单。有人向队员打听比赛的名单。
 * a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 * 
 * @author weidongduan
 * 
 */
// public class Altorithm_18 {
//
//
// public static void myAnwser(){
//
// }
// }
public class Algorithm_18 {
	String a, b, c;
	
	/**
	 * 思路：列举出所有的组合，然后排除
	 * @param args
	 */
	public static void main(String[] args) {
		String[] op = { "x", "y", "z" };
		ArrayList<Algorithm_18> arrayList = new ArrayList<Algorithm_18>();
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++) {
					Algorithm_18 a = new Algorithm_18(op[i], op[j], op[k]);
					if (!a.a.equals(a.b) && !a.b.equals(a.c)&&!a.c.equals(a.a)
							&& !a.a.equals("x") && !a.c.equals("x")
							&& !a.c.equals("z")) {
						arrayList.add(a);
					}
				}
		for (Object a : arrayList) {
			System.out.println(a);
		}
	}

	public Algorithm_18(String a, String b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "a的对手是" + a + "," + "b的对手是" + b + "," + "c的对手是" + c + "\n";
	}
}
