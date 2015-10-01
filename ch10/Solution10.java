public class Solution10{
	static class Node{
		//In this solution we use a binary tree to store the stream data, and in each node of the binary tree, there is a left_sub storing 
		//the number of nodes in the left subtree of the current node
		//When the get rank of function is called, we use this left_sub to calculate number of nodes smaller or equal to the target value
		//This solution runs in O(logn) time for track and getRankOfNumber
		int value;
		int left_sub;
		Node left,right;
		public Node(int v){
			value=v;
			left_sub=0;
		}
	}
	static class RankTree{
		Node root;
		public RankTree(){
			root=null;
		}
		public void insert(int x){
			if(root==null){
				root=new Node(x);
			}
			else{
				Node cur=root;
				while(cur!=null){
					if(x>cur.value){
						if(cur.right==null){
							cur.right=new Node(x);
							break;
						}
						else
							cur=cur.right;
					}
					else if(x<cur.value){
						if(cur.left==null){
							cur.left=new Node(x);
							cur.left_sub++;
							break;
						}
						else{
							cur.left_sub++;
							cur=cur.left;
						}
					}
					else{
						cur.left_sub++;
						break;
					}
				}
			}
			return;
		}
		public int get_rank(int target){
			Node cur=root;
			int result=0;
			while(cur!=null){
				if(target<cur.value){
					cur=cur.left;
				}
				else if(target>cur.value){
					result=result+1+cur.left_sub;
					cur=cur.right;
				}
				else if(target==cur.value){
					result=result+cur.left_sub;
					break;
				}
			}
			return result;
		}
	}
	static RankTree store_stream= new RankTree();
	public static void track(int n){
		store_stream.insert(n);
		return;
	}
	public static int getRankOfNumber(int x){
		int result=store_stream.get_rank(x);
		return result;
	}
	public static void main(String [] args){
		int [] nums={5,1,4,4,5,9,7,13,3};
		for(int i : nums){
			track(i);
		}
		System.out.println("Get Rank of 1: "+getRankOfNumber(1));
		System.out.println("Get Rank of 3: "+getRankOfNumber(3));
		System.out.println("Get Rank of 4: "+getRankOfNumber(4));
		System.out.println("Get Rank of 5: "+getRankOfNumber(5));
	}
}
