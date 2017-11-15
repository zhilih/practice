package cn.hoover.practice.tcpip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IntAddressDemo {

	public static void main(String[] args) throws SocketException, UnknownHostException {
		Enumeration<NetworkInterface> faceList = NetworkInterface.getNetworkInterfaces();
		if (!faceList.hasMoreElements()) {
			System.out.println("No interface find");
		} else {
			while (faceList.hasMoreElements()) {
				NetworkInterface networkInterface = (NetworkInterface) faceList.nextElement();
				System.out.println("Interface " + networkInterface.getName());
				
				Enumeration<InetAddress> addressList = networkInterface.getInetAddresses();
				if (!addressList.hasMoreElements()) {
					System.out.println("No inetAddress find");
				} else {
					while (addressList.hasMoreElements()) {
						InetAddress inetAddres = (InetAddress) addressList.nextElement();
						System.out.println("HostAddress " + inetAddres.getHostAddress());
						System.out.println("HostName " + inetAddres.getHostName());
					}
				}
			}
		}
		
		String hoString = "www.baidu.com";
		InetAddress[] addressList = InetAddress.getAllByName(hoString);
		for (InetAddress inetAddress : addressList) {
			System.out.println("\t" + inetAddress.getHostName() + "/" + inetAddress.getHostAddress());
		}
		
		System.out.println(InetAddress.getByName("www.google.com"));
		System.out.println(InetAddress.getLocalHost());
	}


}
