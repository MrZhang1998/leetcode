package FirstAndLastPosition;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public int[] searchRange(int[] nums, int target)
	{
		if (nums.length == 0)
			return new int[] { -1, -1 };
		int start = 0;
		int end = nums.length - 1;
		while (start <= end)
		{
			int mid = (start + end) / 2;
			if (nums[mid] == target)
			{
				int left = mid;
				int right = mid;
				while (left >= 0 && nums[left] == target)
				{
					left--;
				}
				left++;
				while (right < nums.length && nums[right] == target)
				{
					right++;
				}
				right--;
				return new int[] { left, right };

			} else if (nums[mid] > target)
			{
				end = mid - 1;
			} else
			{
				start = mid + 1;
			}
		}

		return new int[] { -1, -1 };
	}

}
