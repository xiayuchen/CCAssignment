public class Solution03{
	public static void replace_space(char [] s, int true_len){
		//the length of space and "%20" is different
		//If we start from the left side of the string, every time when we replace a space with "%20" the characters after will need to be moved 
		//to the right by 2, which is inefficient, so we start from the right of the string
		//code runs in constant space and O(n) time
		int num_space=0;
		for(int i=0;i<true_len;i++)
			if(s[i]==' ')
				num_space++;  // calculate the number of space in the original string to calculate the length of the new string
		int po_new=true_len+num_space*2-1; // it is the current position for us to write the value of the new string
		int po_ori=true_len-1; //it is the current position for us to visit all the character in the original string
		while(po_ori>=0){
			char tmp=s[po_ori];
			if(tmp==' '){
				s[po_new]='0';
				po_new--;
				s[po_new]='2';
				po_new--;
				s[po_new]='%';
				po_new--;
			}
			else if((tmp>='a' && tmp<='z')||(tmp>='A' && tmp<='Z')){
				s[po_new]=tmp;
				po_new--;
			}
			po_ori--;
		}
	}
	public static void main(String [] args){
	String s="Mr John Smith";
	char [] c_s= new char[100];
	for(int i=0; i<s.length();i++)
		c_s[i]=s.charAt(i);
	int len=13;
	replace_space(c_s, len);
	System.out.println(c_s);
}
}
