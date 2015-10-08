public class Solution01{
	public static int insert(int m, int n, int i, int j){
		//In this solution, we achieve the insertion in 3 step
		//One clear the i to j bit in m to zeros
		//Two move the binary representation of n
		//Three use | to finish the insertion
		//The code runs in constant time and space
		int clear_one= 1<<(j-i+1);
		clear_one--;
		clear_one=~clear_one;
		m= m& clear_one;
		n=n<<i;
		m=m|n;
		return m;
	}
	public static void print_bit(int num){
		int tmp=1<<30;
		boolean start=false;
		for(int i=0;i<31;i++){
			if(((num & tmp)!=0) || start){
				if((num & tmp)!=0){
					System.out.print('1');
					start=true;
				}
				else{
					System.out.print('0');
				}
			}
			tmp=tmp>>1;
		}
		System.out.println();
	}
	public static void main(String [] args){
		int m= 1040;
		int j= 6;
		int i=2;
		int n=19;
		int result=insert(m,n,i,j);
		print_bit(m);
		print_bit(n);
		print_bit(result);
	}
}
