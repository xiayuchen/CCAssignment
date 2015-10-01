import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution02{
	public static void group_ana(String [] input){
		//In this solution we create a hashmap storing the character frequency and the different anagram as a list
		//The code runs in O(n) time and use O(n) space
		HashMap<String, List<String> > anagrams= new HashMap<String,List<String>>();
		for(String s:input){
			String freq=char_f(s);
			if(anagrams.containsKey(freq)){
				anagrams.get(freq).add(s);
			}
			else{
				List<String> new_list= new ArrayList<String> ();
				new_list.add(s);
				anagrams.put(freq, new_list);
			}
		}
		int cur=0;
		for(Map.Entry<String, List<String>> entry:anagrams.entrySet()){
			List<String> ana=entry.getValue();
			for(String s : ana){
				input[cur]=s;
				cur++;
			}
		}
		return;
	}
	public static String char_f(String s){
		s=s.toLowerCase();
		int [] char_f= new int [26];
		char [] c_s= s.toCharArray();
		for(int i=0;i<c_s.length;i++){
			int tmp=c_s[i]-'a';
			char_f[tmp]++;
		}
		String result="";
		for(int i=0;i<26;i++){
			if(char_f[i]>0){
				char tmp=(char) (i+'a');
				result=result+tmp+char_f[i];
			}	 
		}
		return result;
	}
	public static void main(String [] args){
		String [] input={"arce","care","aerc","dog","ogd","animal"};
		group_ana(input);
		for(String s:input)
			System.out.print(s+"\t");
	}
}
