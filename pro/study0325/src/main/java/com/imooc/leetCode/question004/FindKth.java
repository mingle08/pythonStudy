package com.imooc.leetCode.question004;

/**
 * 首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。这两个元素比较共有三种情况：>、<和=。如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。

	当A[k/2-1]>B[k/2-1]时存在类似的结论。
	
	当A[k/2-1]=B[k/2-1]时，我们已经找到了第k小的数，也即这个相等的元素.
	
	如果A或者B为空，则直接返回B[k-1]或者A[k-1]；
	如果k为1，我们只需要返回A[0]和B[0]中的较小值；
	如果A[k/2-1]=B[k/2-1]，返回其中一个；
 * @author Administrator
 *
 */
public class FindKth {

	public static void main(String[] args) {
		int[] x = {2,8};
		int[] y = {4};
		double mid = findMedianSortedArrays(x, y);
		System.out.println(mid);

	}

	public static double findKth(int a[], int begina, int m, int b[], int beginb, int n, int k) {
		if(m > n) // 确保大的数在后面
			return findKth(b, beginb, n, a, begina, m, k);
		
		if(m == 0)
			return b[beginb + k - 1];
		
		if(k == 1)
			return Math.min(a[begina], b[beginb]);
		
		int ma = Math.min(k/2, m), mb = k - ma;  // 把k分成两部分
		/**
		 * 1. 把a数组前面ma个元素去掉，第k小的元素不在这里
		 * 2. 把b数组前面mb个元素去掉，第k小的元素不在这里
		 * 3. 相等时就是它
		 */
		if(a[begina + ma - 1] < b[beginb + mb - 1])  // 1
			return findKth(a, begina + ma, m - ma, b, beginb, n, k - ma);
		else if(a[begina + ma - 1] > b[beginb + mb - 1])  // 2
			return findKth(a, begina, m, b, beginb + mb, n - mb, k - mb);
		else  // 3
			return a[begina + ma -1];
			
	}
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int totalLength = m + n;
		if(totalLength % 2 == 1) {
			return findKth(A, 0, m, B, 0, n, totalLength/2+1);
		}else {
			return (findKth(A, 0, m, B, 0, n, totalLength/2) + findKth(A, 0, m, B, 0, n, totalLength/2 + 1)) / 2;
		}
	}
}
