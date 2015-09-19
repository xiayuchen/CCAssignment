public class Solution02{
	//calculate the frequency of each character, for s1, each character appears, frequency ++, in s2 if character appears, frequency --
	//the code runs in constant space and O(n) time, n means the length of the string
	public static boolean if_permutation(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		if(s1.length()==0 && s2.length()==0)
			return true;
		int [] char_freq= new int [256];
		for(int i=0; i<s1.length(); i++){
			int tmp=(int) (s1.charAt(i));
			char_freq[tmp]++;
		}
		for(int i=0; i<s2.length();i++){
			int tmp=(int) (s2.charAt(i));
			char_freq[tmp]--;
			if(char_freq[tmp]<0)
				return false;
		}
		return true;
	}
	public static void main(String [] args){
	  String s1="*!&1!";
	  String s2="&&7";
	  boolean result=if_permutation(s1,s2);
	  System.out.println(result);
  }
}
