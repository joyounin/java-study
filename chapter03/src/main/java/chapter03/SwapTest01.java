package chapter03;

public class SwapTest01 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = a;
		
		System.out.println("a:" + a + ", b:" + b);

		a = b;
		b = c;
		
		System.out.println("a:" + a + ", b:" + b);

	}

}
