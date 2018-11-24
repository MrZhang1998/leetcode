package Burst_Balloons;

class Solution
{
	public int maxCoins(int[] nums)
	{
		// corner case
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		int n = nums.length;
		int[] newNums = new int[n + 2];
		for (int i = 0; i < n; i++)
			newNums[i + 1] = nums[i];
		newNums[0] = 1;
		newNums[n + 1] = 1;

		int[][] M = new int[n + 2][n + 2];
		// M[i][j] represents the maximum number of coins we can get to break
		// the ballon from nums[i] to nums[j](i <= j)
		// induction rule: M[i][j] = max(nums[k]*nums[i - 1]* nums[j + 1] +
		// M[i][k - 1] + M[k + 1][j]) for k from i to j
		// according the positions of M[i][k - 1] and M[k + 1][j], we update the
		// matrix value from left to right, from bottom to top
		for (int j = 1; j <= n; j++)
		{
			for (int i = j; i >= 1; i--)
			{
				for (int k = i; k <= j; k++)
				{
					M[i][j] = Math.max(M[i][j],
							newNums[i - 1] * newNums[k] * newNums[j + 1] + M[i][k - 1] + M[k + 1][j]);
				}
			}
		}

		return M[1][n];
	}
}
