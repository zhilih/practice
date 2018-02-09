package cn.hoover.practice.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {

	private int port;

	public DiscardServer(int port) {
		super();
		this.port = port;
	}
	
	
	public void run() throws InterruptedException {
		
		/**
         * NioEventLoopGroup 是用来处理I/O操作的多线程事件循环器，
         * Netty提供了许多不同的EventLoopGroup的实现用来处理不同传输协议。 在这个例子中我们实现了一个服务端的应用，
         * 因此会有2个NioEventLoopGroup会被使用。 第一个经常被叫做‘boss’，用来接收进来的连接。
         * 第二个经常被叫做‘worker’，用来处理已经被接收的连接， 一旦‘boss’接收到连接，就会把连接信息注册到‘worker’上。
         * 如何知道多少个线程已经被使用，如何映射到已经创建的Channels上都需要依赖于EventLoopGroup的实现，
         * 并且可以通过构造函数来配置他们的关系。
         */
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		System.out.println("运行端口号 ：" + port);
		
		try {
			/**
			 * ServerBootstrap 是一个启动NIO服务的辅助启动类
			 */
			ServerBootstrap bootstrap = new ServerBootstrap();
			
			bootstrap = bootstrap.group(bossGroup, workerGroup);
			
			/***
			 * ServerSocketChannel以NIO的selector为基础进行实现的，用来接收新的连接
			 * 这里告诉Channel如何获取新的连接.
			 */
			bootstrap = bootstrap.channel(NioServerSocketChannel.class);
			
			bootstrap = bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel sc) throws Exception {
					sc.pipeline().addLast(new DiscardServerHandler());
				}
			});
			
			bootstrap = bootstrap.option(ChannelOption.SO_BACKLOG, 128);
			
			bootstrap = bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
			
			ChannelFuture future = bootstrap.bind(port).sync();
			future.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int port = 23;
		
		DiscardServer server = new DiscardServer(port);
		server.run();
	}
}
