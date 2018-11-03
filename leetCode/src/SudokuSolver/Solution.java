package SudokuSolver;

public class Solution
{
	public static void main(String[] args)
	{
		
	}
	
	private static void set(char[][] board, int row ,int col,int value)
	{
		board[row][col] = (char) ('0'+value);
	}

	public void solveSudoku(char[][] board)
	{
		solve(board);
	}
	
	private boolean solve(char[][] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				char temp = board[i][j];
				if(temp == '.')
				{
					for(char c = '1'; c<='9'; c++)
					{
						if(valid(board, i, j, c))
						{
							board[i][j] = c;
							if(solve(board))	
								return true;
							else
								board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean valid(char[][] board,int row, int col,char temp)
	{
		for(int i = 0; i<9; i++)
		{
			if(board[row][i] == temp) 
				return false;
			if(board[i][col] == temp)
				return false;
			if(board[(row/3)*3+i/3][(col/3)*3+i%3]== temp)
				return false;
		}
		return true;
	}
	

}
