package cn.hoover.practice.tcpip.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class SocketClientNonblocking {

	public static void main(String[] args) throws Exception {
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readline = br.readLine();
		byte [] argument = readline.getBytes();
		if (!channel.connect(new InetSocketAddress("127.0.0.1", 8888))) {
			while (!channel.finishConnect()) {
				System.out.println(".");
			}
		}
		
		ByteBuffer writeBuf = ByteBuffer.wrap(argument);
		ByteBuffer readBuf = ByteBuffer.allocate(argument.length);
		
		int totalByteRced = 0;
		int byteRced;
		
		while (totalByteRced < argument.length) {
			if (writeBuf.hasRemaining()) {
				channel.write(writeBuf);
			}
			
			if ((byteRced = channel.read(readBuf)) == -1) {
				throw new SocketException("Connection is closed.");
			}
			
			totalByteRced += byteRced;
			System.out.println(".");
		}
		
		System.out.println("Received: " + new String(readBuf.array(), 0, totalByteRced));
		channel.close();
	}
	
}
