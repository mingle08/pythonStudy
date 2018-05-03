package com.sort;
/**
 * insertSort
 * @author huxm
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,23,22,76,1,5,8,2,0,-1};
		
		sort2(a);

		for(int i = 0; i < a.length; i++ ) {
			System.out.println(" " + a[i]);
		}
	}
	
	/**
	 * first method
	 */
	public static void sort1(int[] a) {
		for(int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j;
			for(j = i - 1; j >= 0; j--) {// move forward
				// the num which greater than temp will move to behind
				if(a[j] > temp) {
					a[j+1] = a[j];
				}else {
					break;
				}
			}
			a[j+1] = temp;
		}
	}
	
	/**
	 * second method
	 */
	public static void sort2(int[] a) {
		int tmp;  
        for (int i = 1; i < a.length; i++) {  
            for (int j = i; j > 0; j--) {  
                if (a[j] < a[j - 1]) {  
                    tmp = a[j - 1];  
                    a[j - 1] = a[j];  
                    a[j] = tmp;  
                }  
            }  
        }  
	}

}
