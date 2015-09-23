mport java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution02{
//In this solution we use recursive approach, the time complexity of the algorithm is O(lgn) and space complexity is O(n)
	static class TreeNode{
		public int value;
		public TreeNode left, right;
		public TreeNode(int x){
			value=x;
		}
	}
	public static void print_tree(TreeNode r){
		Queue<TreeNode> store_node= new LinkedList<TreeNode>();
		store_node.add(r);
		int count_null=0;
		while(!store_node.isEmpty()){
			count_null=0;
			int size=store_node.size();
			for(int i=0;i<size;i++){
				TreeNode cur=store_node.poll();
				if(cur==null)
					System.out.print("null"+"\t");
				else
					System.out.print(cur.value+"\t");
				if(cur==null){
					count_null++;
					store_node.add(null);
					store_node.add(null);
				}	
				else{
					store_node.add(cur.left);
					store_node.add(cur.right);
				}
			}
			System.out.print('\n');
			if(count_null==size)
				break;
		}
	}
	public static TreeNode min_height(int [] nums, int low, int high){
		if(low>high)
			return null;
		if(low==high){
			return new TreeNode(nums[low]);
		}
		int median=(low+high)/2;
		TreeNode root= new TreeNode(nums[median]);
		root.left=min_height(nums,low,median-1);
		root.right=min_height(nums,median+1,high);
		return root;
	}
	public static TreeNode generate_min_tree(int [] nums){
		return min_height(nums,0, nums.length-1);
	}
	public static void main(String [] args){
		int [] nums={1,2,3,4,5,6,7,8};
		TreeNode root=generate_min_tree(nums);
		print_tree(root);
	}
}
