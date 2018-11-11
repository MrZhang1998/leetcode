package Unique_Paths;

public class Solution
{
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		int uniquePaths = solution.uniquePaths(23, 12);
		System.out.println(uniquePaths);
	}
	public int uniquePaths(int m, int n)
	{
		return backTrace(0, 0, m-1, n-1);
	}
	
	private int backTrace(int x, int y,int x_edge,int y_edge)
	{
		if(x<0||x>x_edge||y<0||y>y_edge)
			return 0;
		if(x == x_edge && y == y_edge)
			return 1;
		int down = backTrace(x+1, y, x_edge, y_edge);
		int right = backTrace(x, y+1, x_edge, y_edge);
		return down + right;
	}
}
