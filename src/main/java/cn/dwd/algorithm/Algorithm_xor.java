package cn.dwd.algorithm;

/**
 * 描述：异或相关的一个题目
 * 有一个很大的数组，里面有两个数出现一次，其他的数都出现两次。
 * @author weidongduan
 *
 */
public class Algorithm_xor {

	public static Item extract(int[] a){
		//一个数跟0一会是这个数本身
		int result = 0;
		for(int i=0;i<a.length;i++){
			result^=a[i];
		}
		//result中，含有1的位表示这两个不同的数在这个地方有一位是不一样的。
		int pos = 0;
		while(true){
			//该位置不同。
			if((result>>pos&1)==1){
				break;
			}else{
				pos++;
			}
		}
		int a1 = 0;
		int b1 = 0;
		for(int i=0;i<a.length;i++){
			if((a[i]>>pos&1)==1){
				a1^=a[i];
			}else{
				b1^=a[i];
			}
		}
		return new Item(a1,b1);
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,7,6,5,4,3,2,1};
		Item item = extract(a);
		System.out.println(item.a);
		System.out.println(item.b);
	}
	
	static class Item{
		
		private int a;
		private int b;
		
		public Item(int a,int b){
			this.a = a;
			this.b = b;
		}
	}
}
