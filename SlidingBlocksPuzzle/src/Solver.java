import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solver 
{
	public static int[][] makeFinalBoard(int[][] bd, int size)
	{
		int k = 1;
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if((k == 9 && size == 3) || (k == 16 && size == 4))
				{
					bd[i][j] = 0;
				}
				else
				{
					bd[i][j] = k;
					k++;
				}
			}
		}
		return bd;
	}
	
	public static void solve(Board begin, Map<Board, Board> cameFrom, HashMap<Board, 
			EvaluatedBoard> st, PriorityQueue<EvaluatedBoard> pq, Board fin)
	{
		EvaluatedBoard eb = new EvaluatedBoard(null, begin);
		pq.add(eb);
		st.put(eb.getBoard(), eb);
		cameFrom.put(eb.getBoard(), null);
		List<Board> nxt = new ArrayList<Board>();
		while(!pq.isEmpty())
		{
			EvaluatedBoard curr = pq.remove();
			//System.out.println(pq.size());
			Board b = curr.getBoard();
			nxt = b.getNextMoves(b);
			if(curr.getBoard().equals(fin))
			{
				reconstructPath(cameFrom, curr.getBoard());
				break;
			}
			for(int i = 0; i < nxt.size(); i++)
			{
				EvaluatedBoard next = new EvaluatedBoard(curr, nxt.get(i));
				EvaluatedBoard prev = next.getPrevious();
				if(!st.containsKey(next.getBoard())) 
				{
					pq.add(next);
					st.put(next.getBoard(), next);
					cameFrom.put(next.getBoard(), prev.getBoard());
				}
				if(st.containsKey(next.getBoard())) 
				{
					if(st.get(next.getBoard()).getf() > next.getf()) 
					{
						st.remove(next.getBoard());
						st.put(next.getBoard(), next);
						pq.remove(next);
						pq.add(next);
						cameFrom.replace(next.getBoard(), prev.getBoard());
					}
				}
			}
		}
	}

	private static void reconstructPath(Map<Board, Board> cameFrom, Board board) 
	{
		int steps = 0;
		Stack<Board> path = new Stack<Board>();
		path.push(board);
		while(board != null)
		{
			board = cameFrom.get(board);
			if(board != null)
			{
				path.push(board);
				steps++;
			}
		}
		System.out.println("The number of steps is: " + steps);
		while(!path.empty())
		{
			for(int i = 0; i < path.peek().getSize(); i++)
			{
				for(int j = 0; j < path.peek().getSize(); j++)
				{
					System.out.print(path.peek().getBoard()[i][j] + " ");
				}
			}
			System.out.println();
			path.pop();
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("Enter a number: ");
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[][] bd = new int[size][size];
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				bd[i][j] = s.nextInt();
			}
		}
		Board begin = new Board(bd, size);
		int[][] finBd = new int[size][size];
		int[][] f = makeFinalBoard(finBd, size);
		Board fin = new Board(f, size);
		HashMap<Board, EvaluatedBoard> states = new HashMap<Board, EvaluatedBoard>();
		Map<Board, Board> cameFrom = new HashMap<Board, Board>();
		PriorityQueue<EvaluatedBoard> pq = new PriorityQueue<EvaluatedBoard>();
		solve(begin, cameFrom, states, pq, fin);
	}
}
