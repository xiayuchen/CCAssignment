public class Solution05{
	//In this algorithm, we use the binary search for searching the target string, the only difference is that when we find that the string in the mid
	//is empty, we find the nearest non-empty string to compare
	public static int search_sparse(String target, String [] words){
		int low=0;
		int high=words.length-1;
		while(low<=high){
			int mid=(high+low)/2;
			if(words[mid]==""){
				int left=mid-1;
				int right=mid+1;
				while( words[left]=="" && words[right]==""){
					if(left==low && right==high)
						return -1;
					left=(left==low)?left:left-1;
					right=(right==high)?right:right-1;
				}
				if(words[left]!=""){
					if(words[left].compareTo(target)==0)
						return left;
					else if(words[left].compareTo(target)<0){
						low=mid+1;
					}
					else{
						high=left-1;
					}
				}
				else if(words[right]!=""){
					int compare=words[right].compareTo(target);
					if(compare==0)
						return right;
					else if(compare<0)
						low=right+1;
					else
						high=mid-1;
				}
			}
			else{
				int compare=words[mid].compareTo(target);
				if(compare==0)
					return mid;
				else if(compare<0)
					low=mid+1;
				else
					high=mid-1;
			}
		}
		return -1;
	}
	public static void main(String [] args){
		String [] test={"at","","","","ball","","","","cat","","","dad","",""};
		System.out.println(search_sparse("cat",test));
	}
}
