package algorithm.leetCode;

public class TwoSum {

	public static void main(String[] args) {
		int[] input = {3,2,4};
		int target = 6;
		
		int[] arr = comp(input, target);

		System.out.println();
		System.out.println(arr[0] + " " + arr[1]);
	}
	
	public static void selectSort(int[] arr) {
		for(int x = 0; x < arr.length -1; x++) {
			for(int y = x + 1; y < arr.length; y++) {
				if(arr[x] > arr[y]) {
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
			}
		}
	}
	
	public static int[] comp(int[] nums, int target) {
		
		int[] arr = new int[2];
		for(int x = 0; x < nums.length -1; x++) {
			for(int y = x + 1; y < nums.length; y++) {
				int sum = nums[x] + nums[y];
				if(target == sum) {
					arr[0] = x;
					arr[1] = y;
				}
			}
		}
		return arr;
	}

}
