package prob5;

public class MyStackException extends Exception {
	public MyStackException() {

    }
	
	MyStackException(String ex) {
        super(ex); // MyStackException 클래스의 생성자를 호출합니다.
    }
}
