package Spiral_Matrix_II;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[][] generateMatrix = solution.generateMatrix(4);
		solution.print(generateMatrix);
	}

	private void print(int[][]generateMatrix)
	{
		for(int i = 0; i<generateMatrix.length;i++)
		{
			System.out.println();
			for(int j = 0; j<generateMatrix[0].length;j++)
			{
				System.out.print(generateMatrix[i][j]+" ");
			}
		}
	}
	public int[][] generateMatrix(int n)
	{
		if(n<=0)
			return null;
		int[][] matrix = new int[n][n];
		int init_row = 0;
		int row_edge = n - 1;
		int col_edge = n - 1;
		int value = 1;
		while (init_row <= row_edge && init_row <= col_edge)
		{
			int x = init_row;
			int y = init_row;
			int value_copy = value;
			value = core(matrix, x, y, 0, 1, row_edge, col_edge, init_row,value);
			value = core(matrix, x + 1, y + col_edge - init_row, 1, 0,  row_edge, col_edge, init_row,value);
			if(row_edge!=init_row)
				value = core(matrix, x + row_edge - init_row, col_edge - 1, 0, -1, row_edge, col_edge, init_row,value);
			if(col_edge!=init_row)
			{
				value = core(matrix, row_edge - 1, y, -1, 0,  row_edge, col_edge, init_row,value);
				value--;
			}
			matrix[init_row][init_row] = value_copy;
			row_edge--;
			col_edge--;
			init_row++;
		}
		return matrix;
	}
	
	private int core(int[][] matrix, int x, int y, int x_offset, int y_offset, int x_edge,int y_edge, int init_row,int value)
	{
		while (x >= init_row && x <= x_edge && y >= init_row && y <= y_edge)
		{
			matrix[x][y] = value++;
			x += x_offset;
			y += y_offset;
		}
		return value;
	}

}
