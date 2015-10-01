import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Solution08{
	//With 4 kilobytes, we have approximately 32k bits, for the number is from 1 to N where N<32000, so we could create a bitset to storing if
	//a number has shown or not
	//In this solution, we assume that if a duplicate has shown 3 times in the array, we should print out it twice, that means we do not 
	//store if we have already printed out a duplicate
	//This alogithm runs in O(n) time, and only use the 4 kilobytes
	public static void duplicate(int [] n){
		BitSet store= new BitSet(32000);
		for(int i:n){
			if(store.get(i-1))
				System.out.println(i);
			else
				store.set(i-1);
		}
		return;
	}
	public static void main(String [] args){
		int []nums= new int [32000];
		for(int i=0;i<31998;i++){
			nums[i]=i+1;
		}
		nums[31998]=3;
		nums[31999]=5;
		duplicate(nums);
	}
}
