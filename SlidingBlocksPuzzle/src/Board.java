import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board 
{
	private int size;
	private int[][] board;
		
	public Board(int[][] board, int size) 
	{
		this.size = size;
		this.board = board;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public int[][] getBoard()
	{
		return this.board;
	}
	
	public List<Board> getNextMoves(Board b)
	{
		int s = b.getSize();
		int row = 0;
		int col = 0;
		for(int i = 0; i < s; i++)
		{
			for(int j = 0; j < s; j++)
			{
				if(b.getBoard()[i][j] != 0)
				{
					continue;
				}
				else
				{
					row = i;
					col = j;
				}
			}
		}
		List<Board> next = new ArrayList<Board>();
		int temp = 0;
		if(row == 0 && col == 0)
		{
			int[][] m1 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m1[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m1[0][0];
			m1[0][0] = m1[0][1];
			m1[0][1] = temp;
			Board b1 = new Board(m1, size);
			next.add(b1);
			int[][] m2 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m2[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m2[0][0];
			m2[0][0] = m2[1][0];
			m2[1][0] = temp;
			Board b2 = new Board(m2, size);
			next.add(b2);
		}
		if(row == 0 && col == s - 1)
		{
			int[][] m3 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m3[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m3[0][s-1];
			m3[0][s-1] = m3[1][s-1];
			m3[1][s-1] = temp;
			Board b3 = new Board(m3, size);
			next.add(b3);
			int[][] m4 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m4[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m4[0][s-1];
			m4[0][s-1] = m4[0][s-2];
			m4[0][s-2] = temp;
			Board b4 = new Board(m4, size);
			next.add(b4);
		}
		if(row == 0 && col != 0 && col != s - 1)
		{
			int[][] m5 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m5[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m5[row][col];
			m5[row][col] = m5[row+1][col];
			m5[row+1][col] = temp;
			Board b5 = new Board(m5, size);
			next.add(b5);
			int[][] m6 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m6[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m6[row][col];
			m6[row][col] = m6[row][col-1];
			m6[row][col-1] = temp;
			Board b6 = new Board(m6, size);
			next.add(b6);
			int[][] m7 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m7[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m7[row][col];
			m7[row][col] = m7[row][col+1];
			m7[row][col+1] = temp;
			Board b7 = new Board(m7, size);
			next.add(b7);
		}
		if(row == s-1 && col == 0)
		{
			int[][] m8 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m8[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m8[row][0];
			m8[row][0] = m8[row][1];
			m8[row][1] = temp;
			Board b8 = new Board(m8, size);
			next.add(b8);
			int[][] m9 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m9[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m9[row][0];
			m9[row][0] = m9[row-1][0];
			m9[row-1][0] = temp;
			Board b9 = new Board(m9, size);
			next.add(b9);
		}
		if(row == s-1 && col == s-1)
		{
			int[][] m10 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m10[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m10[s-1][s-1];
			m10[s-1][s-1] = m10[s-2][s-1];
			m10[s-2][s-1] = temp;
			Board b10 = new Board(m10, size);
			/*temp = b10.board[s-1][s-1];
			b10.board[s-1][s-1] = b10.board[s-2][s-1];
			b10.board[s-2][s-1] = temp;*/
			next.add(b10);
			int[][] m11 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m11[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m11[s-1][s-1];
			m11[s-1][s-1] = m11[s-1][s-2];
			m11[s-1][s-2] = temp;
			Board b11 = new Board(m11, size);
			next.add(b11);
		}
		if(row == s-1 && col != 0 && col != s - 1)
		{
			int[][] m12 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m12[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m12[row][col];
			m12[row][col] = m12[row-1][col];
			m12[row-1][col] = temp;
			Board b12 = new Board(m12, size);
			next.add(b12);
			/*for(int r = 0; r < b12.getSize(); r++)
			{
				for(int c = 0; c < b12.getSize(); c++)
				{
					System.out.print(b12.getBoard()[r][c]);
				}
			}
			System.out.println();*/
			int[][] m13 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m13[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m13[row][col];
			m13[row][col] = m13[row][col-1];
			m13[row][col-1] = temp;
			Board b13 = new Board(m13, size);
			next.add(b13);
			/*for(int r = 0; r < b13.getSize(); r++)
			{
				for(int c = 0; c < b13.getSize(); c++)
				{
					System.out.print(b13.getBoard()[r][c]);
				}
			}
			System.out.println();*/
			int[][] m14 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m14[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m14[row][col];
			m14[row][col] = m14[row][col+1];
			m14[row][col+1] = temp;
			Board b14 = new Board(m14, size);
			next.add(b14);
			/*for(int r = 0; r < b14.getSize(); r++)
			{
				for(int c = 0; c < b14.getSize(); c++)
				{
					System.out.print(b14.getBoard()[r][c]);
				}
			}
			System.out.println();*/
		}
		if(row > 0 && row < s-1 && col > 0 && col < s-1)
		{
			int[][] m15 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m15[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m15[row][col];
			m15[row][col] = m15[row-1][col];
			m15[row-1][col] = temp;
			Board b15 = new Board(m15, size);
			next.add(b15);
			int[][] m16 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m16[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m16[row][col];
			m16[row][col] = m16[row][col-1];
			m16[row][col-1] = temp;
			Board b16 = new Board(m16, size);
			next.add(b16);
			int[][] m17 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m17[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m17[row][col];
			m17[row][col] = m17[row][col+1];
			m17[row][col+1] = temp;
			Board b17 = new Board(m17, size);
			next.add(b17);
			int[][] m18 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m18[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m18[row][col];
			m18[row][col] = m18[row+1][col];
			m18[row+1][col] = temp;
			Board b18 = new Board(m18, size);
			next.add(b18);
		}
		if(row > 0 && row < s-1 && col == 0)
		{
			int[][] m19 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m19[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m19[row][col];
			m19[row][col] = m19[row-1][col];
			m19[row-1][col] = temp;
			Board b19 = new Board(m19, size);
			next.add(b19);
			int[][] m20 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m20[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m20[row][col];
			m20[row][col] = m20[row][col+1];
			m20[row][col+1] = temp;
			Board b20 = new Board(m20, size);
			next.add(b20);
			int[][] m21 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m21[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m21[row][col];
			m21[row][col] = m21[row+1][col];
			m21[row+1][col] = temp;
			Board b21 = new Board(m21, size);
			next.add(b21);
		}
		if(row > 0 && row < s-1 && col == s-1)
		{
			int[][] m22 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m22[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m22[row][col];
			m22[row][col] = m22[row-1][col];
			m22[row-1][col] = temp;
			Board b22 = new Board(m22, size);
			next.add(b22);
			int[][] m23 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m23[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m23[row][col];
			m23[row][col] = m23[row][col-1];
			m23[row][col-1] = temp;
			Board b23 = new Board(m23, size);
			next.add(b23);
			int[][] m24 = new int[size][size];
			for(int i = 0; i < size; i++)
			{
				for(int j = 0; j < size; j++)
				{
					m24[i][j] = b.getBoard()[i][j];
				}
			}
			temp = m24[row][col];
			m24[row][col] = m24[row+1][col];
			m24[row+1][col] = temp;
			Board b24 = new Board(m24, size);
			next.add(b24);
		}
		return next;
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if (other instanceof Board) 
		{
			return Arrays.deepEquals(this.getBoard(), ((Board) other).getBoard());
		}
		return false;
	}

	
	@Override
	public int hashCode() 
	{
		String code = "";
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				code += board[i][j] + "";
			}
		}
		return new BigInteger(code).hashCode();
	}
}
