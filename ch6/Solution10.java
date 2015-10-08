public class Solution10{
public static void main(String[] args) throws IOException {
		int [] bottles= new int [1000];
		bottles[579]=1;
		int low=0;
		int high=1000;
		boolean find=false;
		int date=0;
		int number_of_strip=10;
		int next_low=0;
		int next_high=0;
		while(!find){
			int step=(high-low)/number_of_strip;
			for(int i=0;i<number_of_strip;i++){
				if(i==number_of_strip-1){
					if(sum(bottles,low+i*step,high)>0){
						next_low=low+i*step;
						next_high=high;
					}
				}
				else{
					if(sum(bottles,low+i*step,low+(i+1)*step)>0){
						next_low=low+i*step;
						next_high=low+(i+1)*step;
					}
				}
			}
			date=date+7;
			low=next_low;
			high=next_high;
			number_of_strip--;
			if(high-low==1){
				System.out.println(low);
				find=true;
			}
		}
		System.out.println(date);
	}
}
