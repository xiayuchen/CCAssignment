public class Solution08{
	//In this solution, we first set bits in the start and end of the range which do not take the full byte to 1,
	//And then we set the full bytes in between to value 0xff
	public static void drawLine(byte [] screen, int width, int x1, int x2, int y){
		int start_bit=x1%8;
		int end_bit=x2%8;
		int start_index=x1/8;
		int end_index=x2/8;
		if(start_bit!=0){
			byte tmp=(byte)0xff;
			tmp=(byte) (tmp>>start_index);
			screen[start_index]|=tmp;
			start_index++;
		}
		if(end_index!=7){
			byte tmp=(byte)0xff;
			tmp=(byte)(tmp<<(7-end_index));
			screen[end_index]|=tmp;
			end_index--;
		}
		for(int i=width/8*y+start_index;i<=width/8*y+end_index;i++){
			screen[i]=(byte)0xff;
		}
		return;
	}
}
