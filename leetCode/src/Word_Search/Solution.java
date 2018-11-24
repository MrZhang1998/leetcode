package Word_Search;

class Solution
{
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		char[][] board = new char[][] {{'a'},{'a'}};
		String word = "aaa";
		boolean exist = solution.exist(board, word);
		System.out.println(exist);
	}
	public boolean exist(char[][] board, String word)
	{
		if (word == null || word.equals(""))
			return false;
		int row = board.length;
		int col = board[0].length;
		boolean[][] visit = new boolean[row][col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (core(board, word, 0, i, j,visit))
					return true;
			}
		}
		return false;
	}

	private boolean core(char[][] board, String word, int index, int i, int j,boolean[][]visit)
	{
		if (index >= word.length())
			return true;
		if (i >= board.length || i < 0 || j < 0 || j >= board[0].length)
			return false;
		if (!visit[i][j]&&board[i][j] == word.charAt(index))
		{
			visit[i][j] = true;
			boolean result = core(board, word, index + 1, i + 1, j,visit)
			||core(board, word, index + 1, i, j + 1,visit)
			||core(board, word, index + 1, i - 1, j,visit)
			||core(board, word, index + 1, i, j - 1,visit);
			visit[i][j] = false;
			return result;
		} else
		{
			return false;
		}

	}
}