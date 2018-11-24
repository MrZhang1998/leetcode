package Search_in_Rotated_Array_II;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] nums = new int[] { 2, 2, 2, 0, 2, 2 };
		int findIndex = solution.findIndex(nums);
		System.out.println(findIndex);
	}

	private int findIndex(int[] nums)
	{
		int right = nums.length - 1;
		int left = 0;
		while (left < right)
		{
			// remove the duplicates
			while(left<right && nums[left] == nums[left+1])
				left++;
			while(left<right && nums[right] == nums[right-1])
				right--;
			int mid = (left + right) / 2;
			System.out.print("left=" + left + " mid=" + mid + " right=" + right);
			System.out.println();
			if (nums[mid] > nums[right])
			{
				left = mid + 1;
			} else
			{
				right = mid;
			}
		}
		return left;
	}

	public boolean search(int[] nums, int target)
	{
		int l = 0, r = nums.length - 1;

		while (l <= r)
		{
			while (l < r && nums[l] == nums[l + 1])
				l++; // skip duplicates from the left
			while (r > l && nums[r] == nums[r - 1])
				r--; // skip duplicates from the right

			int mid = (l + r) / 2;

			if (target == nums[mid])
				return true;

			// there exists rotation; the middle element is in the left part of
			// the PIVOT
			if (nums[mid] > nums[r])
			{
				if (target < nums[mid] && target >= nums[l])
					r = mid - 1;
				else
					l = mid + 1;
			}
			// there exists rotation; the middle element is in the right part of
			// the PIVOT
			else if (nums[mid] < nums[l])
			{
				if (target > nums[mid] && target <= nums[r])
					l = mid + 1;
				else
					r = mid - 1;
			}
			// there is no rotation; just like normal binary search
			else
			{
				if (target < nums[mid])
					r = mid - 1;
				else
					l = mid + 1;
			}
		}
		return false;
	}
}
