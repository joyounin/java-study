package prob5;

public class MyStack {
	private String[] buffer;
	private int top;
	
	public MyStack(int i) {
		this.top = i;
	}

	public void push(String string) {
		if(buffer.length < top) {
			top += 1;
		} else if(buffer.length > top) {
			top -= 1;
		}
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		
		return null;
	}
}