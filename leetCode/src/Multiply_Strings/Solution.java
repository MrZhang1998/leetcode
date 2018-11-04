package Multiply_Strings;

import java.util.ArrayList;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String multiply = solution.multiply("999", "999");
		System.out.println(multiply);

	}

	public String multiply(String num1, String num2)
	{
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = num1.length() - 1; i >= 0; i--)
		{
			int temp = num1.charAt(i) - '0';
			int c = 0;
			ArrayList<Integer> list_temp = new ArrayList<Integer>();
			for (int j = num2.length() - 1; j >= 0; j--)
			{
				int temp_ = num2.charAt(j) - '0';
				int mutiply = temp * temp_ + c;
				c = mutiply / 10;
				mutiply = mutiply % 10;
				list_temp.add(0, mutiply);

			}
			if (c != 0)
				list_temp.add(0, c);
			int zero_nums = num1.length() - 1 - i;
			while (zero_nums > 0)
			{
				list_temp.add(0);
				zero_nums--;
			}
			list.add(list_temp);
		}
		String add = add(list);
		return add;
	}

	private String add(ArrayList<ArrayList<Integer>> list)
	{
		String result = "0";
		for (ArrayList<Integer> temp : list)
		{
			int i = temp.size() - 1;
			int j = result.length() - 1;
			int c = 0;
			String cur = "";
			while (i >= 0 && j >= 0)
			{
				int num1 = temp.get(i);
				int num2 = result.charAt(j) - '0';
				int add = num1 + num2 + c;
				c = add / 10;
				add = add % 10;
				cur = add + cur;
				i--;
				j--;
			}
			while (i >= 0)
			{
				int add = temp.get(i--) + c;
				c = add / 10;
				add = add % 10;
				cur = add + cur;
			}
			while (j >= 0)
			{
				int add = result.charAt(j--) - '0' + c;
				c = add / 10;
				add = add % 10;
				cur = add + cur;
			}
			if (c != 0)
				cur = c + cur;
			result = cur;
		}
		return result;
	}

}
