package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();
			String hostIpAdress = inetAddress.getHostAddress();
			
			
			System.out.println(hostName);
			System.out.println(hostIpAdress);
			
			byte[] hostIpAdresss = inetAddress.getAddress();
			for(byte IpAddress : hostIpAdresss) {
				//System.out.print((int)IpAddress);
				System.out.print(IpAddress & 0x000000ff);
				System.out.print(".");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
