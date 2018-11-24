package Valid_Permutations_for_DI_Sequence;

public class Solution
{
	public int numPermsDISequence(String S)
	{
		int MOD = (int) (1e9 + 7);
		int N = S.length() + 1;
		int[][] dp = new int[N + 1][N + 1];
		dp[1][1] = 1;
		for (int i = 2; i <= N; ++i)
		{
			// length is i
			for (int j = 1; j <= i; ++j)
			{
				// end with j
				if (S.charAt(i - 2) == 'D')
				{
					// decrease to j
					// add all string with length i - 1 and last digit is
					// greater than or equal to j
					for (int k = j; k <= i; ++k)
					{
						dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
					}
				} else
				{
					// increase to j
					// add all string with length i - 1 and last digit is
					// smaller than j
					for (int k = 1; k < j; ++k)
					{
						dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
					}
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= N; ++i)
			ans = (ans + dp[N][i]) % MOD;
		return ans;
	}
}
