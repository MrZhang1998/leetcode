package Sqrt_x;

public class Solution
{
	
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		int mySqrt = solution.mySqrt(Integer.MAX_VALUE);
		System.out.println(mySqrt);
	}
	public int mySqrt(int x)
	{
		if (x == 0)
			return 0;
		int left = 1;
		int right = x;
		while (left <= right)
		{
			int mid = left + (right - left) / 2;
			if (mid>x/mid)
			{
				right = mid - 1;
			} else
			{
				if (mid+1>x/(mid+1))
				{
					return mid;
				}
				left = mid + 1;
			}
		}
		return left;
	}
}
