public class Solution01{
	//We assume that array A, B are sorted and we know the number of element in the two array are len1 and len2
	//In this solution, I use two pointer in the A and B, and another pointer in the merged array, this algorithm runs in O(len1+len2)
	public static void merge_sorted(int [] A, int [] B, int len1, int len2){
		int cur_1=len1-1;
		int cur_2=len2-1;
		int cur_f=len1+len2-1;
		while(cur_f>=0){
			if(cur_1<0){
				B[cur_f]=B[cur_2];
				cur_2--;
			}
			else if(cur_2<0){
				B[cur_f]=A[cur_1];
				cur_1--;
			}
			else if(A[cur_1]<B[cur_2]){
				B[cur_f]=B[cur_2];
				cur_2--;
			}
			else{
				B[cur_f]=A[cur_1];
				cur_1--;
			}
			cur_f--;
		}
		return;
	}
	public static void main(String [] args){
		int [] a={1,3,5,9,14,17,20};
		int [] b={6,8,15,33,0,0,0,0,0,0,0,0,0};
		merge_sorted(a,b,7,4);
		for(int i=0;i<11;i++)
			System.out.print(b[i]+"\t");
	}
}
