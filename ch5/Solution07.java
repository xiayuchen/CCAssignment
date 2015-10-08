public class Solution07{
	public static void print_bit(int num){
		//In this solution we have the num move to the left by bit and select the bit in the odd position, and have the num move to the right by
		//one bit and selectthe even position, and combine them as result;
		//This solution runs in constant space and time
		int tmp=1<<30;
		boolean start=false;
		for(int i=0;i<31;i++){
			if((num & tmp)!=0){
				System.out.print('1');
				start=true;
			}
			else{
				System.out.print('0');
			}
			tmp=tmp>>1;
		}
		System.out.println();
	}
	public static int swap_bit(int num){
		int tmp=1;
		int new_odd=0;
		for(int i=1;i<=32;i++){
			if(i%2==1){
				new_odd=new_odd|tmp;
			}
			tmp=tmp<<1;
		}
		int odd_set=(num>>1) & new_odd;
		int new_even=new_odd<<1;
		int even_set=(num<<1) & new_even;
		int result=even_set|odd_set;
		print_bit(odd_set);
		print_bit(even_set);
		return result;
	}
	public static void main(String [] args){
		int num=13975;
		print_bit(num);
		print_bit(swap_bit(num));
	}
}
