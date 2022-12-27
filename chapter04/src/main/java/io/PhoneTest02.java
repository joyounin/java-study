package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneTest02 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			File file = new File("Phone.txt");
			if (!file.exists()) {
				System.out.println("file not found");
				return;
			}

			System.out.println("========= 파일정보 =========");
			System.out.println(file.getAbsolutePath()); // 절대경로
			System.out.println(file.length() + "bytes");

			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));

			System.out.println("========= 전화번호 =========");
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();

				System.out.println(name + ":" + phone1 + "-" + phone2 + "-" + phone3);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
