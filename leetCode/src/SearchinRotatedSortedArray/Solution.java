package SearchinRotatedSortedArray;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] nums = new int[] { 1, 3 };
		int target = 3;
		int search = solution.search(nums, target);
		System.out.println(search);
	}

	public int search(int[] nums, int target)
	{
		if (nums.length == 0)
			return -1;
		if (nums.length == 1 && nums[0] == target)
			return 0;
		if (nums.length == 1 && nums[0] != target)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		while (start < end)
		{
			int mid = (start + end) / 2;
			if (nums[mid] > nums[end])
			{
				start = mid + 1;
			} else
			{
				end = mid;
			}
		}
		int divide = start;
		if (target >= nums[0])
		{
			start = 0;
			end = divide == 0 ? nums.length - 1 : divide - 1;
		} else
		{
			start = divide;
			end = nums.length - 1;
		}
		while (start <= end)
		{
			int mid = (start + end) / 2;
			if (nums[mid] == target)
			{
				return mid;
			} else if (nums[mid] > target)
			{
				end = mid - 1;
			} else if (nums[mid] < target)
			{
				start = mid + 1;
			}
		}
		return -1;

	}

}
