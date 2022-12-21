package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = a;
		
		System.out.println("a:" + a + ", b:" + b);

		swap(a, b);
		// stack은 지역변수 관리 용도로 사용
		System.out.println("a:" + a + ", b:" + b);

	}
	public static void swap(int m, int n) { //call by value a 호출
	    int c = m;
		m = n;
		n = c;
		System.out.println("m:" + m + ", n:" + n);
	}

}
