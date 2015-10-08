public class Solution04{
	public static void print_bit(int num){
		//In this solution we use bit manipulation, first we find the position of the first non-trailing bit that should flip from 1 to 0 or 0 to 1, that makes the 
		//Then we process the rest 1s or 0s to make the number to be the largest or smallest.
		//The code runs in contant time and space
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
	public static int next_bigger (int num){
		int count_of_one=0;
		int cur_bit=0;
		boolean onebit_visited=false;
		boolean rightmost_zero=false;
		int tmp=1;
		while(rightmost_zero==false && cur_bit<32){
			if((num & tmp)!=0){
				onebit_visited=true;
				count_of_one++;
			}
			else{
				if(onebit_visited)
					rightmost_zero=true;
			}
			cur_bit++;
			tmp=tmp<<1;
		} // In this while loop, we find the right most non-trailing zero, and count the number of ones 
		if(cur_bit==32)
			return -1; //If the number consist of consecutive 1s in the significant bits and consecutive 0s in the rest position, then there is no
		              //next bigger number
		num=num | (1<<(cur_bit-1));
		num=num & (~((1<<(cur_bit-1))-1));
		num|=(1<<(count_of_one-1))-1;
		return num;
	}
	public static int next_smaller(int num){
		int bit_ope=1;
		boolean zero_found=false;
		int count_of_ones=0;
		int ntrail_one_id=0;
		int cur_i=0;
		for(;cur_i<32; cur_i++){
			if((num &bit_ope)==0){
				zero_found=true;
			}
			else {
				if(zero_found){
					ntrail_one_id=cur_i;
					break;
				}
				count_of_ones++;
			}
			bit_ope=bit_ope<<1;
		}
		if(cur_i==32)
			return -1;
		num=num&(~(1<<ntrail_one_id));  // Set the first non-trailing 1 to 0
		num=num &(~(1<<ntrail_one_id -1)); //Set the bits after non-trailing  to 0s
		int rest_ones= (1<<(count_of_ones+1) -1) <<(ntrail_one_id-count_of_ones-1);
		num=num | rest_ones;
		return num;
	}
	public static void main(String[] args){
		int num=13948;
		int next_biggest=next_bigger(num);
		int next_smallest=next_smaller(num);
		print_bit(num);
		print_bit(next_biggest);
		print_bit(next_smallest);
	}
}
