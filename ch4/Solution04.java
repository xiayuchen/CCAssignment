public class Solution04{
	//The recursive approach solve the problem is O(logn) time complexity and O(n) space complexity
	static class TreeNode{
		int value;
		TreeNode left, right;
		public TreeNode(int x){
			value=x;
		}
	}
	public static int balanced_height(TreeNode root){
		if(root==null)
			return 0;
		int height_l=balanced_height(root.left);
		int height_r=balanced_height(root.right);
		if(height_l==-1 || height_r==-1)
			return -1;
		if(Math.abs(height_l-height_r)>1)
			return -1;
		else
			return Math.max(height_l,height_r)+1;
	}
	public static boolean if_balanced(TreeNode root){
		if(root==null)
			return true;
		if(balanced_height(root)>=0)
			return true;
		else
			return false;
	}
	public static void main(String [] args){
		TreeNode root = new TreeNode(1);
		TreeNode cur=root;
		cur.left=new TreeNode(2);
		cur.right=new TreeNode(3);
		cur=cur.left;
		cur.left=new TreeNode (4);
		cur.right=new TreeNode (8);
		cur=cur.left;
		cur.right=new TreeNode(5);
		cur=cur.right;
		cur.left=new TreeNode(9);
		cur=root.right;
		cur.right=new TreeNode(6);
		cur.left= new TreeNode (7);
		System.out.println("If the whole tree is balanced? "+ if_balanced(root));
		System.out.println("If the left sub tree is balanced? "+ if_balanced(root.left));
		System.out.println("If the right sub tree is balanced? "+ if_balanced(root.right));
	}
}
