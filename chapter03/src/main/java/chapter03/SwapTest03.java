package chapter03;

import mypackage.Value;

public class SwapTest03 {

	public static void main(String[] args) {
		Value a = new Value(10);
		Value b = new Value(20);

		
		System.out.println("a:" + a.val + ", b:" + b.val);

		swap(a, b);
		// stack은 지역변수 관리 용도로 사용
		System.out.println("a:" + a.val + ", b:" + b.val);

	}
	public static void swap(Value m, Value n) { //call by value a 호출
	    int c = m.val;
		m.val = n.val;
		n.val = c;
	}

}
