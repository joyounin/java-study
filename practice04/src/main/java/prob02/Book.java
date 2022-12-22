package prob02;

public class Book {
	int bookNo; // 번호
	String title; // 제목
	String author; // 작가
	int stateCode; // 상태코드(대여유무를 나타내는 상태코드)
	
	public Book(int bookNo, String title, String author) {
		
	}
	public void rent() {
		
	}
	public void print() {
		
	}
	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
