public class Solution09{
	public static boolean string_rotation(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		String concate=s1+s1;
		if(concate.contains(s2))
			return true;
		else
			return false;
	}
	public static void main(String [] args){
		String s1="waterloobridge";
		String s2="obridgewaterlo";
		boolean result=string_rotation(s1,s2);
		System.out.println(result);
	}
}
