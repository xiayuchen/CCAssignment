import java.util.Random;

public class Solution11{
	static class R_TreeNode{
		//In this solution, in each node of the tree, we store the number of node in its left subtree and right subtree, 
		//And in the getRandom() function, in each node, we generate a random number in the range of 0~right_node+left_node, if the value equals
		//to 0, return the current node, if it is smaller the left_node, we go to  the left subtree, else we go to the right subtree, and repeat for the node
		//To achieve such solution, when we are insert or delete a node from the tree, we should update the left_node and right_node of the tree
		//The insert is a demo of how to do that
		int value;
		int left_node;
		int right_node;
		R_TreeNode left, right;
		public R_TreeNode(int x){
			value=x;
		}
	}
	static class random_bst{
		static R_TreeNode root;
		public random_bst(){
			root=null;
		}
		public void insert(int x){
			if(root==null)
				root=new R_TreeNode(x);
			else{
				R_TreeNode cur=root;
				while(true){
					if(x<cur.value){
						cur.left_node++;
						if(cur.left!=null){
							cur=cur.left;
						}
						else{
							cur.left=new R_TreeNode(x);
							return;
						}
					}
					else{
						cur.right_node++;
						if(cur.right!=null){
							cur=cur.right;
						}
						else{
							cur.right=new R_TreeNode(x);
							return;
						}
					}
				}
			}
		}
		public static R_TreeNode getRandom(){
			R_TreeNode cur=root;
			while(cur!=null){
				int left=cur.left_node;
				int right=cur.right_node;
				Random ra= new Random();
				int random_num=ra.nextInt(left+right+1)-1;
				if(random_num==0)
					return cur;
				else if(random_num<left)
					cur=cur.left;
				else
					cur=cur.right;
			}
			return null;
		}
		public static void main(String [] args){
			random_bst test = new random_bst();
			for(int i=0;i<100;i++){
				test.insert(i);
			}
			for(int i=0;i<10;i++){
				R_TreeNode tmp= test.getRandom();
				if(tmp!=null)
					System.out.println("select one random node from tree "+tmp.value);
			}
		}
	}
	
}
