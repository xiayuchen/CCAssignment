public class Solution01{
	//we use a constant array for storing the appearance of each ascii character, the code will take O(1) space since the length of s should be no longer than 256, it also takes O(1) time
	public static boolean if_all_unique(String s){
		if(s.length()>256)
			return false;
		int [] used= new int[256];
		for(int i=0; i<s.length(); i++){
			int tmp=(int)(s.charAt(i));
			if(used[tmp]==1)
				return false;
			else
				used[tmp]=1;
		}
		return true;
	}
	public static void main(String [] args){
		String test_string="*!&1!";
		boolean result=if_all_unique(test_string);
		System.out.println(result);
	}
}
