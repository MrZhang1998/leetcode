package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public boolean isValidSudoku(char[][] board)
	{
		Set<Character> row_set = new HashSet<Character>();
		Set<Character> col_set = new HashSet<Character>();
		Set<Character> set_1 = new HashSet<Character>();
		Set<Character> set_2 = new HashSet<Character>();
		Set<Character> set_3 = new HashSet<Character>();
		for (int i = 0; i < 9; i++)
		{
			row_set.clear();
			col_set.clear();
			if (i % 3 == 0)
			{
				set_1.clear();
				set_2.clear();
				set_3.clear();
			}
			for (int j = 0; j < 9; j++)
			{
				if (board[i][j] != '.')
				{
					// detect row
					if (!row_set.contains(board[i][j]))
						row_set.add(board[i][j]);
					else
						return false;

					// detect sub-boxes
					if (j / 3 == 0)
					{
						if (!set_1.contains(board[i][j]))
							set_1.add(board[i][j]);
						else
							return false;
					} else if (j / 3 == 1)
					{
						if (!set_2.contains(board[i][j]))
							set_2.add(board[i][j]);
						else
							return false;
					} else
					{
						if (!set_3.contains(board[i][j]))
							set_3.add(board[i][j]);
						else
							return false;
					}
				}
				if (board[j][i] != '.')
				{
					if (!col_set.contains(board[j][i]))
						col_set.add(board[j][i]);
					else
						return false;

				}
			}
		}
		return true;
	}

}
