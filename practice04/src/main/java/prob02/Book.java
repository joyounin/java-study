package prob02;

public class Book {
	int bookNo; // 번호
	String title; // 제목
	String author; // 작가
	int stateCode; // 상태코드(대여유무를 나타내는 상태코드)

	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		stateCode = 1;
	}

	public void rent() {
		stateCode = 0;
		System.out.println(title + "이(가) 대여 됐습니다.");

	}

	public void print() {
			System.out.println(bookNo + "." + "책 제목:" + title + ", " + "작가:" + author + ", "
					+ (stateCode == 0 ? "대여중":"재고있음"));

		
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

	public void stateCode() {
		stateCode = 1;
	}
}
