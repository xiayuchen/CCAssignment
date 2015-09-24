public class Solution10{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode(int x){
			value=x;
		}
	}
	//We assume that t1 is the bigger tree and t2 is the smaller tree
	//In this solution, we check each node in the t1, when it is equals to root of t2, we check the subtree starting from t1, return if it 
	//equals to t2
	//The time complexity of this algorithm is O(n+k*m) where n is size of the t1, m is size of t2, k is the frequency of the root of t2 in t1
	public static boolean contains_sub(TreeNode t1, TreeNode t2){
		if(t2==null)
			return true;
		if(t1==null)
			return false;
		if(t1.value==t2.value){
			if(equal_tree(t1,t2))
				return true;
		}
		return contains_sub(t1.left,t2)||contains_sub(t1.right,t2);
	}
	public static boolean equal_tree(TreeNode t1, TreeNode t2){
		if(t1==null && t2==null)
			return true;
		if(t1==null || t2==null)
			return false;
		if(t1.value!=t2.value)
			return false;
		else 
			return equal_tree(t1.left,t2.left)&&equal_tree(t1.right,t2.right);
			
	}
	public static void main(String [] args){
		TreeNode root1 = new TreeNode(6);
		TreeNode cur=root1;
		cur.left=new TreeNode(4);
		cur.right=new TreeNode(8);
		cur=cur.left;
		cur.left=new TreeNode (1);
		cur.right=new TreeNode (5);
		TreeNode root2 = new TreeNode(6);
		root2.left=new TreeNode(6);
		cur=root2.left;
		cur.left=new TreeNode(4);
		cur.right=new TreeNode(8);
		cur=cur.left;
		cur.left=new TreeNode (1);
		cur.right=new TreeNode (5);
		System.out.println(contains_sub(root2,root1));
	}
}
