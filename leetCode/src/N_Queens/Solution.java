package N_Queens;

import java.util.ArrayList;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		List<List<String>> solveNQueens = solution.solveNQueens(10);
		System.out.println(solveNQueens.size());
	}

	public List<List<String>> solveNQueens(int n)
	{
		boolean[][] flag = new boolean[n][n];
		for(int i = 0; i<n;i++)
			for(int j = 0; j<n; j++)
				flag[i][j] = false;
		List<String> list = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		backTrace(0, flag, n, list, result);
		return result;
	}
	
	private void backTrace(int row ,boolean[][] flag,int n ,List<String> list, List<List<String>> result)
	{
		if(row == n)
		{
			result.add(new ArrayList<String>(list));
			return;
		}
		for(int i = 0; i<n;i++)
		{
			if(!flag[row][i])
			{
				String temp = generate(i, n);
				list.add(temp);
				boolean[][] copy = new boolean[n][n];
				copy(flag,copy);
				changeValue(row, i, flag, true, n);
				backTrace(row+1, flag, n, list, result);
				copy(copy,flag);
				list.remove(list.size()-1);
			}
		}
	}
	private void copy(boolean[][] sourse, boolean[][]des)
	{
		for(int i = 0; i<sourse.length;i++)
		{
			for(int j = 0; j<sourse.length;j++)
			{
				des[i][j] = sourse[i][j];
			}
		}
	}
	
	private void changeValue(int row, int i ,boolean[][]flag, boolean value,int n)
	{
		core(row, i, flag, value, 1, 0, n);
		core(row, i, flag, value, 1, 1, n);
		core(row, i, flag, value, 1, -1, n);
	}
	
	private void core(int row ,int i, boolean[][]flag, boolean value,int x_offset, int y_offset,int n)
	{
		while(row>=0&&row<n && i>=0 && i<n)
		{
			flag[row][i] = value;
			row+=x_offset;
			i+=y_offset;
		}
	}
	private String generate(int i , int n)
	{
		String result = "";
		for(int j = 0; j<n ;j++)
		{
			if(j == i)
				result+="Q";
			else
				result+=".";
		}
		return result;
	}
}
