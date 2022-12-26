package prob01;

public class Printer {

//	public void println(int number) {
//		System.out.println(number);
//	}
//
//	public void println(boolean on) {
//		System.out.println(on);
//	}
//
//	public void println(double dnumber) {
//		System.out.println(dnumber);
//	}
//
//	public void println(String name) {
//		System.out.println(name);
//		
//	}

	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public int sum(Integer... nums)  {	// 가변 파라미터 nums는 배열
		int s = 0;
		for(Integer n:nums) {
			s += n;
		}
		return s;
	}		
	
	public <T> void println(T... ts) {
		for(T t:ts) {
		System.out.println(t);
		}
	}
}
