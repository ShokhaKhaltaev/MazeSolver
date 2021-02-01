import java.util.LinkedList;

public class MazeSolver {
	
	static Maze m = new Maze();	
	
	public static void main(String[] args) {
		int[][] maze = {
				{1, 0, 1, 1}, // 0 - wall, 1 - path, 2 - destination
				{1, 1, 1, 1},
				{1, 0, 2, 1}
		};
		
		m.maze = maze;
		m.start = new Position(0,3);
		m.path = new LinkedList<Position>();
		
		if(solveMaze(m.start)) {
			System.out.println("You won!");
		}else {
			System.out.println("No path");
		}
		
	}
	
	
	public static boolean isValid(int y, int x) {
		if(y < 0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length) {
			return false;
		}
		return true;
	}
	
	private static boolean solveMaze(Position pos) {
		m.path.push(pos);
		
		while(true) {
			int x = m.path.peek().x;
			int y = m.path.peek().y;
			m.maze[y][x] = 0;
			
			// down
			if(isValid(y+1, x)) {
				if(m.maze[y+1][x] == 2) {
					System.out.println("Moved down.");
					return true;
				} else if(m.maze[y+1][x] == 1) {
					System.out.println("Moved Down");
					m.path.push(new Position(y+1, x));
					continue;
				}
			}
			
			//left
			if(isValid(y, x-1)) {
				if(m.maze[y][x-1] == 2) {
					System.out.println("Moved Left.");
					return true;
				} else if(m.maze[y][x-1] == 1) {
					System.out.println("Moved Left");
					m.path.push(new Position(y, x-1));
					continue;
				}
			}
			
			//up
			if(isValid(y-1, x)) {
				if(m.maze[y-1][x] == 2) {
					System.out.println("Moved up.");
					return true;
				} else if(m.maze[y-1][x] == 1) {
					System.out.println("Moved Up");
					m.path.push(new Position(y-1, x));
					continue;
				}
			}
			
			//right
			if(isValid(y, x+1)) {
				if(m.maze[y][x+1] == 2) {
					System.out.println("Moved right.");
					return true;
				} else if(m.maze[y][x+1] == 1) {
					System.out.println("Moved Right");
					m.path.push(new Position(y, x+1));
					continue;
				}	
			}
			
			m.path.pop();
			System.out.println("Moved Back");
			if(m.path.size() <= 0) {
				return false;
			}
		}
	}
}
