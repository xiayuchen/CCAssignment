public class Solution09{
	public static int [] search_matrix(int [][] matrix, int target){
		//We start the searching from right upper side of the matrix, every time when we compare the value of element in the matrix 
		//with the target, and narrow the range of search by one row or one column
		//The time complexity of this solution is O(m+n) where the matrix is of size m*n
		int len1=matrix.length;
		int len2=matrix[0].length;
		int i=0;
		int j=len2-1;
		int [] result =new int [2];
		result[0]=-1;
		result[1]=-1;
		while(i<len1 && j>=0){
			if(matrix[i][j]==target){
				result[0]=i;
				result[1]=j;
				break;
			}
			else if(matrix[i][j]<target){
				i++;
			}
			else{
				j--;
			}
		}
		return result;
	}
	public static void main(String [] args){
		int [][] test= new int [4][4];
		test[0]=new int [] {15,20,40,85};
		test[1]=new int [] {20,35,80,95};
		test[2]=new int [] {30,55,95,105};
		test[3]=new int [] {40,80,100,120};
		int target=55;
		int [] result=search_matrix(test,target);
	    System.out.println("The number "+(target)+" is in row "+result[0]+" col "+result[1]);
	}
}
