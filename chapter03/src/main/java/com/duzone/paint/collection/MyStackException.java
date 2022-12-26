package com.duzone.paint.collection;

public class MyStackException extends Exception {
	public MyStackException() {
		super();
    }
	
	MyStackException(String ex) {
        super(ex); // MyStackException 클래스의 생성자를 호출합니다.
    }
}
