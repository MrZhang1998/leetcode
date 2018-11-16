package Count_of_Range_Sum;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] nums = new int[] { 50,-50,-1,1};
		Solution solution = new Solution();
		int countRangeSum = solution.countRangeSum(nums, -2, 2);
		System.out.println(countRangeSum);
	}

	public int countRangeSum(int[] nums, int lower, int upper)
	{
		if (nums == null || nums.length == 0)
			return 0;
		long[] sums = new long[nums.length+1];
		sums[0] = 0;
		for (int i = 1; i < sums.length; i++)
		{
			sums[i] = sums[i - 1] + nums[i-1];
		}

		return countWhileMerge(sums, 0, nums.length, lower, upper);
	}

	private int countWhileMerge(long[] sums, int start, int end, int lower, int upper)
	{
		if (start >= end)
			return 0;
		int mid = (start + end) >>> 1;
		int count = countWhileMerge(sums, start, mid, lower, upper) + countWhileMerge(sums, mid + 1, end, lower, upper);
		int k = mid + 1;
		int j = mid + 1;
		int t = mid + 1;
		int index = 0;
		long[] cache = new long[end - start + 1];
		for (int i = start; i <= mid; i++, index++)
		{
			while (k <= end && sums[k] - sums[i] < lower)
				k++;
			while (j <= end && sums[j] - sums[i] <= upper)
				j++;
 			while (t <= end && sums[t] < sums[i])
				cache[index++] = sums[t++];
			cache[index] = sums[i];
			count += (j - k);
		}
		while(t<=end)
		{
			cache[index++] = sums[t++];
		}
		System.arraycopy(cache, 0, sums, start, cache.length);
		return count;
	}

}
