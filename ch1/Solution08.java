public class Solution08{
	public static void set_zero(int [][] matrix){
	// To implement algorithm that do not use extra space, when we find a element that is zero, we mark the row and coloumn it belongs to by set the head of the row/coloumn to zero
	// As set the matrix[0][0] will lead to ambiguity about whether there should be a all zero row or all zero coloumn, we create two boolean
	// first_r_zero and first_c_zero to store it
	//The code runs in O(1) space and O(m*n) time
		int len1=matrix.length;
		int len2=matrix[0].length;
		if(len1==0 || len2==0)
			return;
		boolean first_r_zero=false;
		boolean first_c_zero=false;
		for(int i=0; i<len1; i++){
			for (int j=0; j<len2; j++){
				if(matrix[i][j]==0){
					if(i==0 || j==0){
						if (i==0)
							first_r_zero=true;
						if(j==0)
							first_c_zero=true;
					}
					else{
						matrix[0][j]=0;
						matrix[i][0]=0;
					}
				}
			}
		}
		for(int i=1;i<len1;i++){
			for(int j=1;j<len2; j++){
				if(matrix[i][0]==0 || matrix[0][j]==0)
					matrix[i][j]=0;
			}
		}
		if(first_r_zero){
			for(int j=0;j<len2;j++)
				matrix[0][j]=0;
		}
		if(first_c_zero){
			for(int i=0; i<len1; i++)
				matrix[i][0]=0;
		}
		return;
	}
	public static void main(String [] args){
		int [][] test={{1,2,0,4},{0,1,0,1},{1,2,3,4}};
		System.out.println("matrix before set to zero");
		for(int i=0;i<test.length; i++){
			for(int j=0; j<test[i].length; j++){
				System.out.print(test[i][j]+" ");
			}
			System.out.print('\n');
		}
		set_zero(test);
		System.out.println("matrix after set to zero");
		for(int i=0;i<test.length; i++){
			for(int j=0; j<test[i].length; j++){
				System.out.print(test[i][j]+" ");
			}
			System.out.print('\n');
		}
	}
}
