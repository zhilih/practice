package cn.hoover.practice.classloader;

public class ClassLoaderTest {

	public static void main(String[] args) {
		ClassLoader cl = Test.class.getClassLoader();

		System.out.println("ClassLoader is:"+cl.toString());
		System.out.println("ClassLoader\'s parent is:"+cl.getParent().toString());
		System.out.println("ClassLoader\'s grand father is:"+cl.getParent().getParent().toString());

//        cl = int.class.getClassLoader();
//
//        System.out.println("ClassLoader is:"+cl.toString());

	}
}
