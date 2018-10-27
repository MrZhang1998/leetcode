package shortestDepth;

public class Solution
{
	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	int min = 0;
	boolean first = true;
	public static void main(String[] a)
	{
		Solution solution = new Solution();
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(3);
		
		int hh = solution.run(root);
		System.out.println(hh);
	}
	public int run(TreeNode root)
	{
//		if (root == null)
//			return min;
//		look(root, 1);
//		return min;
		return look1(root);
	}

	public void look(TreeNode node, int depth)
	{
		if (node.left == null && node.right == null)
		{

			if (first == true)
			{
				min = depth;
				first = false;
			}
			if (depth < min)
			{
				min = depth;
			}
		} else
		{
			if (node.left != null)
				look(node.left, depth + 1);
			if (node.right != null)
				look(node.right, depth + 1);
		}
	}
	public int look1(TreeNode node)
	{
		if(node==null)
		{
			return 0;
		}
		int left = look1(node.left);
		int right = look1(node.right);
		if(left ==0 || right == 0)
			return left+right+1;
		return left>right?1+right:1+left;
	}
}