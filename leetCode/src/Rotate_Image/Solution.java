package Rotate_Image;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[][] matrix = new int[5][5];
		int index = 1;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				matrix[i][j] = index++;

		Solution solution = new Solution();
		solution.rotate(matrix);
	}

	public void rotate(int[][] matrix)
	{
		int n = matrix.length;
		int times = n / 2;
		int cur_row = 0;
		int edge = n - 1;
		while (times > 0)
		{
			int first_col = cur_row;
			while (first_col < edge)
			{
				int step = edge - cur_row;
				// up right
				int last = matrix[cur_row][first_col];
				int i = cur_row;
				int j = first_col;
				while (step > 0)
				{
					if (j < edge)
					{
						j++;
						step--;
					} else
					{
						i++;
						step--;
					}
				}
				int now = matrix[i][j];
				matrix[i][j] = last;
				last = now;
				// down right
				step = edge - cur_row;
				while (step > 0)
				{
					if (i < edge)
					{
						i++;
						step--;
					} else
					{
						j--;
						step--;
					}
				}
				now = matrix[i][j];
				matrix[i][j] = last;
				last = now;
				// left down
				step = edge - cur_row;
				while (step > 0)
				{
					if (j > cur_row)
					{
						j--;
						step--;
					} else
					{
						i--;
						step--;
					}
				}
				now = matrix[i][j];
				matrix[i][j] = last;
				last = now;
				// up left
				step = edge - cur_row;
				while (step > 0)
				{
					if (i > cur_row)
					{
						i--;
						step--;
					} else
					{
						j++;
						step--;
					}
				}
				now = matrix[i][j];
				matrix[i][j] = last;
				last = now;
				first_col++;
			}
			cur_row++;
			edge--;
			times--;
		}
	}

}
