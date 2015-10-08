public class Solution05{
	//The change to the bit represnetation of n by minus 1 is that 
	//The least significant 1 will flip to 0, and the initial 0s will became 1, and the rest stay the same
	//If the (n)&(n-1) ==0 that means there is no overlapping in the position of 1 in binary representation of n and n-1
	//Thus means that n atmost will has only 1 instance of 1 in its binary representation, so n should be pow of 2 or 0
}
