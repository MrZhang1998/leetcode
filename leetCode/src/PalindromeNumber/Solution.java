package PalindromeNumber;

import java.util.ArrayList;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		boolean result = solution.isPalindrome(12221);
		System.out.println(result);
	}

	public boolean isPalindrome(int x)
	{	
		if(x<0)
			return false;
		int sum = 0;
		int copy = x;
		while(x>0)
		{
			sum = sum*10+x%10;
			x/=10;
		}
		return copy == sum;
		
	}

}
