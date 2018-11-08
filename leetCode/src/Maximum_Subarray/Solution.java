package Maximum_Subarray;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		Solution solution = new Solution();
		int maxSubArray = solution.maxSubArray(nums);
		System.out.println(maxSubArray);
	}

	public int maxSubArray(int[] nums)
	{
		if(nums.length == 1)
			return nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for(int i = 1; i<nums.length ;i++)
		{
			dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
			max = max>dp[i]?max:dp[i];
		}
		return max;
	}

}
