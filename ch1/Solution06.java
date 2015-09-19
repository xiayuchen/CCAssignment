public class Solution06{
	public static String compress(String s){
		//For this question, We assume that adjacent character c, no matter where they are upper or lower class should be compressed together
		//for example AaaaA should be compressed as a5
		// the code use constant space and O(n) time
		String lowered_s=s.toLowerCase();
		String result="";
		int count=0;
		if(s.length()<2)
			return s;
		for(int i=0;i<lowered_s.length();i++){
			count++;
			if(i==lowered_s.length()-1 || lowered_s.charAt(i)!=lowered_s.charAt(i+1)){
				result=result+lowered_s.charAt(i)+count;
				count=0;
			}
		}
		if(result.length()<s.length())
			return result;
		else 
			return s;
	}
	public static void main(String [] args){
		String s="aabcCcccAaa";
		String result=compress(s);
		System.out.println(result);
	}
}
