public class Solution02{
	public static String double_to_binary(double num){
		//In this solution every time we have remaining part that have not been represented in the binary representation saved as remain
		//And every time we have the remain times 2, if the remain is bigger or equal to 1 then a digit 1 is added
		//This solution runs in constant time and space
		if(num<=0 || num>=1)
			return "ERROR";
		String result=".";
		double remain=num;
		while(remain>0){
			if(result.length()>32)
				return "ERROR";
			remain=remain*2;
			if(remain>=1){
				result=result+"1";
				remain=remain-1;
			}
			else{
				result=result+"0";
			}
		}
		return result;
	}
	public static void main(String [] args){
		double test=0.875;
		System.out.println(double_to_binary(test));
	}
}
