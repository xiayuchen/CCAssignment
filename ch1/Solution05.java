public class Solution05{
	public static boolean one_away(String s1, String s2){
		// This algorithm is visit all the characters in s1 and s2, when there is a difference for the first time, move the index of the longer string
		//if there is a second difference, one_away should return false
		//The runtime is O(n), and takes O(1) space
		if(Math.abs(s1.length()-s2.length())>1)
			return false;
		int i=0;
		int j=0;
		boolean one_difference=false;
		while(i<s1.length() && j<s2.length()){
			if(s1.charAt(i)==s2.charAt(j)){
				i++;
				j++;
			}
			else{
				if(one_difference==true)
					return false;
				if(s1.length()==s2.length()){
					one_difference=true;
					i++;
					j++;
				}
				else if(s1.length()<s2.length()){
					one_difference=true;
					j++;
				}
				else{
					one_difference=true;
					i++;
				}
			}
		}
		return true;
	}
	public static void main(String [] args){
		String [] s1={"pale","pales","pale","pale","pale"};
		String [] s2={"ple","pale","bale","bake","le"};
		for(int i=0; i<s1.length; i++){
			System.out.println("Compare "+s1[i]+" with "+s2[i]+" result: "+one_away(s1[i],s2[i]));
		}
	}
}
