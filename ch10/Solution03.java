public class Solution03{
	static public int search_in_rotate(int target, int [] nums){
		//In this solution we find the index of the smallest number, and use it to calculate the index of each number before rotating
		//and search the target using binary search, the complexity of this algorithm is O(log n)
		int pivot_index=-1;
		int low=0;
		int high=nums.length-1;
		while(high>low){
			int median=(low+high)/2;
			if(nums[median]<nums[low]){
				if(median==low || nums[median]<nums[median-1]){
					pivot_index=median;
					break;
				}
				else{
					high=median-1;
				}
			}
			else{
				low=median+1;
			}
		}
		if(pivot_index==-1)
			pivot_index=low;
		low=0;
		high=nums.length-1;
		while(high>=low){
			int median=(low+high)/2;
			int r_median=(median+pivot_index)%nums.length;
			if(nums[r_median]==target)
				return r_median;
			else if(nums[r_median]<target)
				low=median+1;
			else
				high=median-1;
		}
		return -1;
	}
	public static void main(String [] args){
		int [] test={15,16,19,25,1,2,3,4,5,7,14};
		System.out.println(search_in_rotate(5,test));
	}
}
