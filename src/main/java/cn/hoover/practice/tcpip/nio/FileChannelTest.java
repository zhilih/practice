package cn.hoover.practice.tcpip.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

	public static void main(String[] args) throws Exception {
		RandomAccessFile aFile = new RandomAccessFile("D:/nio.txt", "rw");
		FileChannel fChannel = aFile.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(48);
		int bytesRead = fChannel.read(buffer);
		
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			buffer.flip();
			
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());
			}
			
			buffer.clear();
			bytesRead = fChannel.read(buffer);
		}
		
		aFile.close();
	}

}
