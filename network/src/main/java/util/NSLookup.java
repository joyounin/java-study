package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class NSLookup {

	public static void main(String[] args) {
		InetAddress[] inetAddresses = null;
		try {
			while(true) {
			Scanner s = new Scanner(System.in);
			System.out.print("> ");
			String str = s.nextLine();
			if(str.equals("exit")) {
				break;
			}
			inetAddresses = InetAddress.getAllByName(str);
			
			for(InetAddress IpAddress : inetAddresses) {
				System.out.println(IpAddress.getHostName() + " : " + IpAddress.getHostAddress());
			}	
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
