package com.yunkouan.test.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {
	public static void s() {
		ByteBuffer buf = ByteBuffer.allocate(10);
		for(int i = 0; i < buf.capacity(); i++) {
			buf.put((byte)i);
		}
		
		buf.position(3);
		buf.limit(7);
		
		ByteBuffer slice = buf.slice();
		
		for(int i =0; i < slice.capacity(); i++) {
			byte b = slice.get();
			b *= 11;
			slice.put(i, b);
		}
		
		buf.position(0);
		buf.limit(buf.capacity());
//		for(int i =0; i < buf.capacity(); i++) {
		while(buf.remaining() > 0) {
			int b = buf.get();
			System.out.println(b);
		}
	}
 	
	public static void copy(File src, File dest) throws IOException{
		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(dest);
		FileChannel fin = in.getChannel();
		FileChannel fout = out.getChannel();
		
		byte[] bytes = new byte[8];
//		ByteBuffer buf = ByteBuffer.allocate(8); // 创建缓冲区对象
		ByteBuffer buf = ByteBuffer.wrap(bytes);// 将字节数组包装成缓冲区对象
		
		while(true) {
			buf.clear();
			int r = fin.read(buf);
			if(r == -1) {
				break;
			}
			
			buf.flip();
			fout.write(buf);
		}
		
		in.close();
		out.close();
	}
	public static void main(String[] args) throws IOException {
		s();
		/*
		copy(new File("D:\\1.txt"),new File("E:\\1.txt"));
		System.out.println("over!");
		*/
	}
}
