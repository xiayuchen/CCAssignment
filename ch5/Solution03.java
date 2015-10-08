public class Solution03{
	public static int max_len_one(int num){
		//In this solution, we try the flip of 0 to 1 in each position where the bit is 0, and see if the current sequence of 1 lead to a longer 
		//sequence of 1s
	    //This solution runs in constant time and space
		int prev_one=-1;
		int max_len=1;
		int cur_len=0;
		int bit_ope=1;
		for(int i=0;i<32;i++){
			if((num & bit_ope)!=0){
				cur_len++;
			}
			else{
				if(prev_one<0){
					prev_one=i;
					cur_len++;
				}
				else{
					cur_len=i-prev_one;
					prev_one=i;
				}
			}
			bit_ope=bit_ope<<1;
			if(cur_len>max_len)
				max_len=cur_len;
		}
		return max_len;
	}
	public static void main(String [] args){
		int num=1775;
		System.out.println(max_len_one(num));
	}
}
