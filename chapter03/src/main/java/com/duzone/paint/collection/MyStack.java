package com.duzone.paint.collection;

public class MyStack<T> {
	private T[] buffer;
	private int top;

	@SuppressWarnings("unchecked")
	public MyStack(int i) {
		buffer = (T[]) new Object[i];
		this.top = -1;

	}

	@SuppressWarnings("unchecked")
	public void push(T t) {
		if( top == buffer.length - 1) {
			T[] buffer2 = (T[])new Object[buffer.length + 3];
			for(int i =0; i < buffer.length; i++) {
				buffer2[i] = buffer[i];
			}
			buffer = buffer2;
		}
		buffer[++top] = t;
		
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		T result = buffer[top];
		buffer[top--] = null;
		return result;

	}
}
