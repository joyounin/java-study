package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		int t_len = text.length();

		for (int i = 1; i <= t_len; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(text.charAt(j));
			}
			System.out.println();
		}
	}

}
