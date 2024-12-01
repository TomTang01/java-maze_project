/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		Square current;
		Square above;
		Square below;
		Square left;
		Square right;
		
		maze.start.visit();
		wl.add(maze.start);
		while(!wl.isEmpty()){
			current = wl.remove();
			if(current.getRow() == maze.finish.getRow()
				&& current.getCol() == maze.finish.getCol()) {
					return current;
				}
			if(current.getRow()-1 >= 0){
				above = maze.contents[current.getRow()-1][current.getCol()];
				if(!above.getIsWall() && !above.isVisited()){
					above.visit();
					above.setPrevious(current);
					wl.add(above);
				}
			}
			if(current.getRow()+1 < maze.rows){
				below = maze.contents[current.getRow()+1][current.getCol()];
				if(!below.getIsWall() && !below.isVisited()){
					below.visit();
					below.setPrevious(current);
					wl.add(below);
				}
			}
 			if(current.getCol()+1 < maze.cols){
				right = maze.contents[current.getRow()][current.getCol()+1];
				if(!right.getIsWall() && !right.isVisited()){
					right.visit();
					right.setPrevious(current);
					wl.add(right);
				}
			}
			if(current.getCol()-1 >= 0){
				left = maze.contents[current.getRow()][current.getCol()-1];
				if(!left.getIsWall() && !left.isVisited()){
					left.visit();
					left.setPrevious(current);
					wl.add(left);
				}
			}
		}
		return null;
	}

	/* Add any helper methods you want */
}
