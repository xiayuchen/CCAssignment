public class Solution05{
	//This solution takes O(logn) time complexity and O(n) space
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode(int x){
			value=x;
		}
	}
	public static boolean Validate_sub(TreeNode root, int min, int max){
		if(root==null)
			return true;
		if(root.value>max || root.value<min)
			return false;
		return Validate_sub(root.left, min, root.value)&& Validate_sub(root.right,root.value,max);
	}
	public static boolean Validate_BST(TreeNode root){
		return Validate_sub(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	public static void main(String [] args){
		TreeNode root = new TreeNode(6);
		TreeNode cur=root;
		cur.left=new TreeNode(4);
		cur.right=new TreeNode(8);
		cur=cur.left;
		cur.left=new TreeNode (1);
		cur.right=new TreeNode (5);
		cur=cur.left;
		cur.right=new TreeNode(3);
		cur=cur.right;
		cur.left=new TreeNode(2);
		cur=root.right;
		cur.right=new TreeNode(9);
		cur.left= new TreeNode (7);
		System.out.println("If the whole tree is BST? "+ Validate_BST(root));
	}
}
