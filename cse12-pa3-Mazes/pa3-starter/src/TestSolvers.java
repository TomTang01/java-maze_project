import java.util.ArrayList;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */
	
	@Test
	public void randomTest1() {
		Maze m = new Maze(new String[] {
            "#_#_",
            "__F_",
            "_##_",
            "S___"
        });
		SearchWorklist queue = new QueueWorklist();
		String[] expected = new String[] {
            "#_#_",
            "**F_",
            "*##_",
            "S___"
        };
		checkMaze(queue, m, expected);
	}

    @Test
	public void randomTest2() {
		Maze m = new Maze(new String[] {
            "#_#_",
            "__F_",
            "_##_",
            "S___"
        });
		SearchWorklist stack = new StackWorklist();
		String[] expected = new String[] {
            "#_#_",
            "__F*",
            "_##*",
            "S***"
        };
		checkMaze(stack, m, expected);
	}

    @Test
	public void randomTest3() {
		Maze m = new Maze(new String[] {
            "#_#_",
            "F___",
            "_##_",
            "S___"
        });
		SearchWorklist stack = new StackWorklist();
		String[] expected = new String[] {
            "#_#_",
            "F***",
            "_##*",
            "S***"
        };
		checkMaze(stack, m, expected);
	}

	@Test
	public void aroundTheWorldTest1() {
		Maze m = new Maze(new String[] {
            "F___",
            "#___",
            "S##_",
            "____"
        });
		SearchWorklist queue = new QueueWorklist();
		String[] expected = new String[] {
            "F***",
            "#__*",
            "S##*",
            "****"
        };
		checkMaze(queue, m, expected);
	}

	@Test
	public void diagonalTest1() {
		Maze m = new Maze(new String[] {
            "___F",
            "#___",
            "__#_",
            "S___"
        });
		SearchWorklist queue = new QueueWorklist();
		String[] expected = new String[] {
            "_**F",
            "#*__",
            "**#_",
            "S___"
        };
		checkMaze(queue, m, expected);
	}

	@Test
	public void diagonalTest2() {
		Maze m = new Maze(new String[] {
            "S___",
            "#___",
            "__#_",
            "___F"
        });
		SearchWorklist stack = new StackWorklist();
		String[] expected = new String[] {
            "S***",
            "#__*",
            "__#*",
            "___F"
        };
		checkMaze(stack, m, expected);
	}

	@Test
	public void noPathTest1() {
		Maze m = new Maze(new String[] {
            "S__#",
            "###_",
            "__#_",
            "___F"
        });
		SearchWorklist queue = new QueueWorklist();
		String[] expected = new String[] {
            "S__#",
            "###_",
            "__#_",
            "___F"
        };
		checkMaze(queue, m, expected);
	}

	@Test
	public void noPathTest2() {
		Maze m = new Maze(new String[] {
            "S__#",
            "#___",
            "___#",
            "__#F"
        });
		SearchWorklist stack = new StackWorklist();
		String[] expected = new String[] {
            "S__#",
            "#___",
            "___#",
            "__#F"
        };
		checkMaze(stack, m, expected);
	}

	@Test
	public void sideBySideTest1() {
		Maze m = new Maze(new String[] {
            "____",
            "_SF_",
            "____",
            "__#_"
        });
		SearchWorklist queue = new QueueWorklist();
		String[] expected = new String[] {
            "____",
            "_SF_",
            "____",
            "__#_"
        };
		checkMaze(queue, m, expected);
	}

	@Test
	public void sideBySideTest2() {
		Maze m = new Maze(new String[] {
            "_F__",
            "_S__",
            "____",
            "__#_"
        });
		SearchWorklist stack = new StackWorklist();
		String[] expected = new String[] {
            "_F__",
            "_S__",
            "____",
            "__#_"
        };
		checkMaze(stack, m, expected);
	}

	@Test
	public void noWallsTest1() {
		Maze m = new Maze(new String[] {
            "_S__",
            "____",
            "___F",
            "____"
        });
		SearchWorklist queue = new QueueWorklist();
		String[] expected = new String[] {
            "_S__",
            "_*__",
            "_**F",
            "____"
        };
		checkMaze(queue, m, expected);
	}

	@Test
	public void manyWallsTest1() {
		Maze m = new Maze(new String[] {
            "#S##",
            "__##",
            "_#_F",
            "___#"
        });
		SearchWorklist queue = new QueueWorklist();
		String[] expected = new String[] {
            "#S##",
            "**##",
            "*#*F",
            "***#"
        };
		checkMaze(queue, m, expected);
	}
}



