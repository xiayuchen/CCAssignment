public class Solution06{
	public static int numberofSwap(int a, int b){
		//In this solution we use XOR to find the difference in the binary representation of the two number
		//This solution will solve the problem in constant time and space
		int diff_b=a ^b;
		int count_of_change=0;
		while(diff_b!=0){
			if((diff_b & 1) ==1)
				count_of_change++;
			diff_b=diff_b >> 1;
		}
		return count_of_change;
	}
	public static void main(String [] args){
		System.out.println(numberofSwap(0,2));
		System.out.println(numberofSwap(0,4));
		System.out.println(numberofSwap(0,100));
		System.out.println(numberofSwap(1000,1000));
	}
}
