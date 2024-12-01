/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */
import java.util.LinkedList;

class StackWorklist implements SearchWorklist {

	LinkedList<Square> stack;

	public StackWorklist(){
		this.stack = new LinkedList<Square>();
	}

	@Override
	public void add(Square c){
		stack.push(c);
	}

	@Override
	public Square remove(){
		if(stack.size() == 0) {return null;}
		return stack.pop();
	}

	@Override
	public boolean isEmpty(){
		return (stack.size() == 0);
	}
}

class QueueWorklist implements SearchWorklist {

	LinkedList<Square> queue;

	public QueueWorklist(){
		this.queue = new LinkedList<Square>();
	}

	@Override
	public void add(Square c){
		queue.addLast(c);
	}

	@Override
	public Square remove(){
		return queue.poll();
	}

	@Override
	public boolean isEmpty(){
		return (queue.size() == 0);
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
