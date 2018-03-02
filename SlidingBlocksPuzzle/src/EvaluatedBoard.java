
public class EvaluatedBoard implements Comparable<EvaluatedBoard>
{
	private Board board;
	private int g;
	private EvaluatedBoard previous;

	public EvaluatedBoard(EvaluatedBoard prev, Board b) 
	{
		this.board = b;
		if (prev != null) 
		{
			this.previous = prev;
			this.g = prev.getg() + 1;
		} 
		else 
		{
			this.g = 0;
		}
	}

	public Board getBoard() 
	{
		return board;
	}

	public int getg() 
	{
		return g;
	}

	public EvaluatedBoard getPrevious() 
	{
		return previous;
	}
	
	public int getf() 
	{
		return h(board) + getg();
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if (other instanceof EvaluatedBoard) 
		{
			return this.getBoard().equals(((EvaluatedBoard) other).getBoard());
		} 
		return false;
	}

	@Override
	public int compareTo(EvaluatedBoard eb) 
	{
		int a = this.getf();
		int b = eb.getf();
		return a - b;
	}

	public int h(Board b) 
	{
		int[][] board = b.getBoard();
		int size = b.getSize();
		int md = 0;
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				int num = board[i][j];
				if (num == 0) 
				{
					md += Math.abs(size - 1 - j);
					md += Math.abs(size - 1 - i);
				} 
				else 
				{
					md += Math.abs(((num - 1) / size) - i);
					md += Math.abs(Math.abs((num - 1)) % size - j);	
				}
			}
		}
		return md;
	}
}
