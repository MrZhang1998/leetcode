package Permutation_Sequence;

import java.util.Arrays;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String permutation = solution.getPermutation(3, 4);
		System.out.println(permutation);
	}

	public String getPermutation(int n, int k)
	{
		// get n!
		int total = getN(n);
		boolean[] visit = new boolean[n];
		Arrays.fill(visit, false);
		int divide = total / n; // 每组有几种可能
		k--;// 数组下标统一从零开始
		int pos = k / divide; // 当前位置的数组
		k = k % divide;
		int times = n;
		String result = "";
		while (times >= 1)
		{
			int num = 0;
			while (pos >=0)
			{
				if (visit[num])
				{
					num++;
					continue;
				}
				num++;
				pos--;
			}
			visit[num - 1] = true;
			result += num;

			total = divide;
			n--;
			if(n == 0)
				break;
			divide = total / n;
			pos = k /divide;
			k = k%divide;
			times--;
		}
		return result;
	}

	private int getN(int n)
	{
		int result = 1;
		while (n >= 1)
		{
			result *= n;
			n--;
		}
		return result;
	}

}
