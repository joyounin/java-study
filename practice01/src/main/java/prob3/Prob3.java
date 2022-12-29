package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;

		/* 코드 작성 */
		while(true) {
			System.out.print("숫자를 입력 하세요 : ");
			int number = scanner.nextInt();
			for (int i = 0; i <= number; i++) {
				if(i % 2 == 0) {
					num1 += i;
					}
				else{
					num2 += i;
					
				}
			}
			if (number % 2 == 0) {
				System.out.println("결과 값 : " + num1);
				num1 = 0;
				num2 = 0;
			}
			else {
				System.out.println("결과 값 : " + num2);
				num1 = 0;
				num2 = 0;
			}
		}
	}
			
}

