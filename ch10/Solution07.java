import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution07{
	//In the solution, we create a bit array for all the possible integer, if the integer has shown in the file, we set the bit in corresponding 
	//position to 1, then we scan the array for the position where the value is 0
	//This solution scan runs in O(n) time
	//Follow up: If we only has 10MB memory, we need to cut the numbers into 1000 blocks, first we calculate the numbers that falls in each blocks,
	//And then we choose the blocks that is not full, and create a bit array for numbers in this range, scan through all the number to find the number
	//missing
	//Using this way, we can through the file for two times, runtime complexity is O(n)
	public static int find_missing() throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader("input.txt"));
		long numberofint=(Integer.MAX_VALUE)+1;
		byte[] visited_num=new byte[(int)(numberofint/8)];
		while(sc.hasNextInt()){
			int n=sc.nextInt();
			int index=n/8;
			int index_bit=n%8;
			visited_num[index]|=1<<index_bit;
		}
		int result=0;
		for(int i=0;i<=Integer.MAX_VALUE;i++){
			int index=(int)(i/8);
			int index_bit=(int)(i%8);
			if((visited_num[index] & 1<<index_bit) == 0)
				result=i;
				return result;
		}
		return result;
	}
}
