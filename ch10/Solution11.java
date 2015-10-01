public class Solution11{
	public  static void peak_and_vally(int [] nums){
		//In this algorithm we fisrt use partial quick sort to make the first half of the array to be all smaller than the rest half 
		//Then we switch the element in the first and second half every other one
		//In the worst case the sort_half algorithm will runs in O(n^2) but speaking of average cases, the solution runs in O(nlogn)
		sort_half(nums,0 ,nums.length-1);
		int low=0;
		int high=nums.length-1;
		if(high%2==0)
			high--;
		while(low<high){
			int tmp=nums[low];
			nums[low]=nums[high];
			nums[high]=tmp;
			low+=2;
			high-=2;
		}
		return;
	}
	public static void sort_half(int [] nums, int low, int high){
		if(low>=high || high>=nums.length || low<0)
			return;
		int median = (low+high)/2;
		median=nums[median];
		int left=low;
		int right=high;
		while(left<=right){
			while(left<=high && nums[left]<median)
				left++;
			while(right>=low && nums[right]>median)
				right--;
			if(left<=right){
				int tmp=nums[left];
				nums[left]=nums[right];
				nums[right]=tmp;
				left++;
				right--;
			}
		}
		int middle=(left+right)/2;
		if(middle==nums.length/2)
			return;
		else if (middle> nums.length/2){
			sort_half(nums, low, (left+high)/2-1);
		}
		else
			sort_half(nums, middle+1, high);
	}
	public static void  main(String [] args){
		int [] nums={5,3,1,2,3};//{3,5,2,1,6,4};
		peak_and_vally(nums);
		for(int i: nums){
			System.out.println(i);
		}
		return ;
	}
}
