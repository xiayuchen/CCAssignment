public class Solution01{
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
