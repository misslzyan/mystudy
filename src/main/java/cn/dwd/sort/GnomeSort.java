package cn.dwd.sort;

/**
 * 
 * 地精排序（GnomeSort）
 * @author weidongduan
 *
 */
public class GnomeSort {

	
	public static void gnomeSort(int a[]){
		
		int pos = 0;
		while(pos<a.length){
			if(pos==0||a[pos]>=a[pos-1]){
				pos++;
			}else{
				int temp = a[pos];
				a[pos]=a[pos-1];
				a[pos-1]=temp;
				pos--;
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] = {9,8,7,6,5,4,3,2,1};
		gnomeSort(a);
		SortUtil.print(a);
	}
}

