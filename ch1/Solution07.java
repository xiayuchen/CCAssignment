public class Solution07{
	public static void rotate_matrix(int [][] nums){
	// To implement the rotate without using extra space, we first rotate num[i][j] with num[j][i], than flip the matrix upside down
	//it takes constant space and O(n*n) time when the matrix is n*n
		if(nums.length<2)
			return;
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums[0].length; j++){
				int tmp= nums[i][j];
				nums[i][j]=nums[j][i];
				nums[j][i]=tmp;
			}
		}
		for(int i=0; 2*i<nums.length; i++){
			for(int j=0; j<nums[0].length; j++){
				int tmp=nums[i][j];
				nums[i][j]=nums[nums.length-1-i][j];
				nums[nums.length-i-1][j]=tmp;
			}
		}
		return;
	}
	public static void main(String [] args){
		int [][] test={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Matrix before rotation");
		for(int i=0;i<test.length; i++){
			for(int j=0; j<test.length; j++){
				System.out.print(test[i][j]+" ");
			}
			System.out.print('\n');
		}
		rotate_matrix(test);
		System.out.println("Matrix after rotation");
		for(int i=0;i<test.length; i++){
			for(int j=0; j<test.length; j++){
				System.out.print(test[i][j]+" ");
			}
			System.out.print('\n');
		}
	}
}
