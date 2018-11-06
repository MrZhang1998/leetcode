package Wildcard_Matching;

public class Solution1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution1 solution = new Solution1();
		boolean match = solution.isMatch("", "*");
		System.out.println(match);
	}

	public boolean isMatch(String s, String p)
	{
		if (s == null || p == null)
			return false;
		int row = s.length();
		int col = p.length();
		
		boolean[][] dp = new boolean[row+1][col+1];
		dp[0][0] = true;
		for (int i = 1; i < dp[0].length; i++)
		{
			if(p.charAt(i-1)=='*')
				dp[0][i] = dp[0][i-1];
		}
		
		for (int i = 1; i < dp.length; i++)
		{
			for (int j = 1; j < dp[0].length; j++)
			{
				char char_s = s.charAt(i-1);
				char char_p = p.charAt(j-1);
				if(char_p == '?' || char_p == char_s)
				{
					dp[i][j] = dp[i-1][j-1];
				}else if(char_p == '*')
				{
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}else 
				{
					return dp[i][j] = false;
				}
			}
		}
		return dp[s.length()][p.length()];
	}

}
