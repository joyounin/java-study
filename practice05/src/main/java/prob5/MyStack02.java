package prob5;

public class MyStack02 {
	private Object[] buffer;
	private int top;

	public MyStack02(int i) {
		buffer = new Object[i];
		this.top = -1;

	}

	public void push(Object string) {
		if( top == buffer.length - 1) {
			Object[] buffer2 = new Object[buffer.length + 3];
			for(int i =0; i < buffer.length; i++) {
				buffer2[i] = buffer[i];
			}
			buffer = buffer2;
		}
		buffer[++top] = string;
		
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public Object pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		Object result = buffer[top];
		buffer[top--] = null;
		return result;

	}
}
