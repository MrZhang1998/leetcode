package Spiral_Matrix;
import java.util.ArrayList;
import java.util.List;
public class Solution
{
	public static void main(String[] args)
	{
		int[][] matrix = new int[3][3];
		int index = 1;
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				matrix[i][j] = index++;
			}
		}

		Solution solution = new Solution();
		List<Integer> spiralOrder = solution.spiralOrder(matrix);
		System.out.println(spiralOrder);
	}
	public List<Integer> spiralOrder(int[][] matrix)
	{
		List<Integer> list = new ArrayList<Integer>();
		int row = matrix.length;
		if(row==0)
			return list;
		int col = matrix[0].length;
		if(col == 0)
			return list;
		if (row == 1 || col == 1)
		{
			for (int i = 0; i < matrix.length; i++)
				for (int j = 0; j < matrix[0].length; j++)
					list.add(matrix[i][j]);
			return list;
		}
		int init_row = 0;
		int row_edge = row - 1;
		int col_edge = col - 1;
		while (init_row <= row_edge && init_row <= col_edge)
		{
			int x = init_row;
			int y = init_row;
			core(matrix, x, y, 0, 1, list, row_edge, col_edge, init_row);
			core(matrix, x + 1, y + col_edge - init_row, 1, 0, list, row_edge, col_edge, init_row);
			if(row_edge!=init_row)
				core(matrix, x + row_edge - init_row, col_edge - 1, 0, -1, list, row_edge, col_edge, init_row);
			if(col_edge!=init_row)
				core(matrix, row_edge - 1, y, -1, 0, list, row_edge, col_edge, init_row);
			if(row_edge!=init_row&&col_edge!=init_row)
				list.remove(list.size() - 1); 
			row_edge--;
			col_edge--;
			init_row++;
		}
		return list;
	}
	private void core(int[][] matrix, int x, int y, int x_offset, int y_offset, List<Integer> list, int x_edge,
			int y_edge, int init_row)
	{
		while (x >= init_row && x <= x_edge && y >= init_row && y <= y_edge)
		{
			list.add(matrix[x][y]);
			x += x_offset;
			y += y_offset;
		}
	}
}
