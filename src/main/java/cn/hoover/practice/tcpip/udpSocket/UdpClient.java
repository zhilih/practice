 package cn.hoover.practice.tcpip.udpSocket;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

	//http://blog.csdn.net/ns_code/article/details/14128987
	private static final int TIMEOUT = 5000; // 设置接收数据的超时时间
	private static final int MAXNUM = 5; // 设置重发数据的最多次数

	public static void main(String args[]) throws IOException {
		String str_send = "Hello, UDPServer. I'm UDPClient.";
		byte [] buf = new byte[1024];
		// 客户端在9000端口监听接收到的数据
		DatagramSocket ds = new DatagramSocket(9000);
		InetAddress loc = InetAddress.getLocalHost(); 
		// 定义用来发送数据的DatagramPacket实例
		DatagramPacket dp_send = new DatagramPacket(str_send.getBytes(), str_send.length(), loc, 3000);
		// 定义用来接收数据的DatagramPacket实例
		DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
		ds.setSoTimeout(TIMEOUT);
		//重发数据的次数
		int tries = 0;
		// 是否接收到数据的标志位
		boolean receivedResponse = false;
		
		// 直到接收到数据，或者重发次数达到预定值，则退出循环
		while (!receivedResponse && tries < MAXNUM) {
			// 发送数据
			ds.send(dp_send);
			try {
				// 接收从服务端发送回来的数据
				ds.receive(dp_receive);
				// 如果接收到的数据不是来自目标地址，则抛出异常
				if (dp_receive.getAddress().equals(loc)) {
					throw new IOException("Received packet from an umknown source");
				}
				receivedResponse = true;
			} catch (InterruptedIOException e) {
				tries += 1;
				System.out.println("Time out," + (MAXNUM - tries) + " more tries...");
			}
		}

		if (receivedResponse) {
			// 如果收到数据，则打印出来
			System.out.println("client received data from server：");
			String str_receive = new String(dp_receive.getData(), 0, dp_receive.getLength()) + " from "
					+ dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();
			System.out.println(str_receive);
			// 由于dp_receive在接收了数据之后，其内部消息长度值会变为实际接收的消息的字节数，
			// 所以这里要将dp_receive的内部消息长度重新置为1024
			dp_receive.setLength(1024);
		} else {
			// 如果重发MAXNUM次数据后，仍未获得服务器发送回来的数据，则打印如下信息
			System.out.println("No response -- give up.");
		}
		ds.close();
	}
}
