package cn.hoover.practice.tcpip;

public class BruteForceCoding {

	private static byte byteVal = 101;
	private static short shortVal = 10001;
	private static int intVal = 100000001;
	private static long longVal = 1000000000001l;
	
	//8
	private final static int BSIZE = Byte.SIZE / Byte.SIZE;
	//16
	private final static int SSIZE = Short.SIZE  / Byte.SIZE;
	//32
	private final static int ISIZE = Integer.SIZE  / Byte.SIZE;
	//64
	private final static int LSIZE = Long.SIZE  / Byte.SIZE;
	
	private static final int BYTEMASK = 0xFF;
	
	public static int encodeIntBigEndian(byte [] dst, long val, int offset, int size) {
		for (int i = 0; i < size; i++) {
			dst[offset++] = (byte) (val >> ((size - i -1) * Byte.SIZE));
		}
		return offset;
	}
	
	private static long decodeIntBigEndian(byte [] val, int offset, int size) {
		long rtn = 0;
		for (int i = 0; i < size; i++) {
			rtn = (rtn << Byte.SIZE) | ((long)val[offset + i] & BYTEMASK);
		}
		return rtn;
	}
	
	private static String byteArrayToBecimalString(byte [] barray) {
		StringBuilder rtn = new StringBuilder();
		for (byte b : barray) {
			rtn.append(b & BYTEMASK).append(" ");
		}
		return rtn.toString();
	}
	
	public static void main(String[] args) {
		byte [] message = new byte[BSIZE + SSIZE + ISIZE + LSIZE];
		
		int offset = encodeIntBigEndian(message, byteVal, 0, BSIZE);
		System.out.println("byte offset = " + offset);
		
		offset = encodeIntBigEndian(message, shortVal, offset, SSIZE);
		System.out.println("short offset = " + offset);
		
		offset = encodeIntBigEndian(message, intVal, offset, ISIZE);
		System.out.println("int offset = " + offset);
		
		offset = encodeIntBigEndian(message, longVal, offset, LSIZE);
		System.out.println("long offset = " + offset);
		
		System.out.println("Encoded message: " + byteArrayToBecimalString(message));
		
		long value = decodeIntBigEndian(message, BSIZE, SSIZE);
		System.out.println("Decoded short = " + value);
		
		value = decodeIntBigEndian(message, BSIZE + SSIZE + ISIZE, LSIZE);
		System.out.println("Decoded long = " + value);
		
		offset = 4;
		value = decodeIntBigEndian(message, offset, BSIZE);
		System.out.println("Decoded value (offset" +offset+ ", size" + BSIZE + ") = " + value);
		
		byte bVal = (byte) decodeIntBigEndian(message, offset, BSIZE);
		System.out.println("Same value as byte = " + bVal);
	}
	
}
