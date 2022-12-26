package prob5;

import java.util.Arrays;

public class MyStack {
	private String[] buffer;
	private int top;

	public MyStack(int i) {
		buffer = new String[i];
		this.top = -1;

	}

	public void push(String string) {
		if( top == buffer.length - 1) {
			String[] buffer2 = new String[buffer.length + 3];
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

	public String pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		String result = buffer[top];
		buffer[top--] = null;
		return result;

	}
}