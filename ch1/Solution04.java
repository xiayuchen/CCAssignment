public class Solution04{
	public static boolean palin_permu(String s){
		//If a string is a permutation of a palindrome, there should be at most one char that has odd frequency
		//Here we assume that the string s only contains spaces and 'a-z', and 'A-Z'
		int num_odd_freq=0;
		int [] char_freq= new int [26];
		for(int i=0; i<s.length(); i++){ 
			if(s.charAt(i)<='z' && s.charAt(i)>='a'){
				int tmp=s.charAt(i)-'a';
				char_freq[tmp]++;
			}
			else if(s.charAt(i)<='Z' && s.charAt(i)>='A'){
				int tmp=s.charAt(i)-'A';
				char_freq[tmp]++;
			}
		}
		for(int i=0; i<26; i++){
			if(char_freq[i]%2==1)
				num_odd_freq++;
		}
		return (num_odd_freq<2);
	}
	public static void main(String [] args){
		String s="Tact Coa";
		boolean result=palin_permu(s);
		System.out.println(result);
	}
}
