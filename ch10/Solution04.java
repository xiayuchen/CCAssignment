public class Solution04{
	public static int sort_nosize(int target, int [] nums){
		//As we do not know the size of the array, the initial range of the binary search cannot be decided, we use index cur_po to find the range
		//and value of cur_po will be twice of its previous value
		//The complexity of the algorithm is O(logn)
		int cur_po=2;
		int prev_po=0;
		while(nums[cur_po]<target && nums[cur_po]!=-1){
			prev_po=cur_po;
			cur_po=cur_po*2;
		}
		int low=prev_po;
		int high=cur_po;
		while(high>=low){
			int median=(low+high)/2;
			if(nums[median]==target)
				return median;
			else if(nums[median]==-1)
				high=median-1;
			else if(nums[median]<target){
				low=median+1;
			}
			else{
				high=median-1;
			}
		}
		return -1;
	}
	public static void main(String [] args){
		int [] nums={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,21,22,23,24,26,27,28,29,30};
		int [] test= new int [256];
		for(int i=0;i<test.length;i++){
			if (i<nums.length)
				test[i]=nums[i];
			else
				test[i]=-1;
		}
		System.out.println(sort_nosize(29,test));
	}
}
