
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 加密工具类
 * @author YangLi
 */
public class Encrypt {
	private static String src;
	private static String dest;
	private static char[] keys;
	private static int type ;
	private static final String[] message = {"加密成功！","解密成功！"};

	/**
	 * 把原文件转换(加密/解密)成目标文件
	 * @return
	 * @throws IOException
	 */
	private static boolean transform() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(src);
		FileOutputStream fileOutputStream = new FileOutputStream(dest);
		
		FileChannel inChannel = fileInputStream.getChannel();
		FileChannel outChannel = fileOutputStream.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(10);
		
		while(true) {
			buffer.clear();
			int r = inChannel.read(buffer);
			if(r == -1) {
				break;
			}
			buffer.flip();
			
			outChannel.write(getNewBuffer(buffer));
		}
		
		inChannel.close();
		outChannel.close();
		
		return true;
	} 
	
	/**
	 * 取得加密/解密后的缓冲区
	 * @param buffer
	 * @return
	 */
	private static ByteBuffer getNewBuffer(ByteBuffer buffer){
		for(int i = 0; i < buffer.limit(); i++) {
			byte b = buffer.get(i);
			for(char key : keys) {
				if(type == 1) {
					b = (byte)(b - key);
				} else if(type == -1) {
					b = (byte)(b + key);
				}
			}
			buffer.put(i, b);
		}
		return buffer;
	}
	
	public static void main(String[] args) throws IOException {
		if(args.length != 4) {
			System.out.println("///////////////////////////////////////////////////////////");
			System.out.println("下面4个参数分别表示：原文件、目标文件、密钥字符串、类型(1：加密；-1：解密)");
			System.out.println("----------------------------------------------------------");
			System.out.println("文件加密:");
			System.out.println("\tC:/1.txt  C:/2.txt 123456 1");
			System.out.println("文件解密:");
			System.out.println("\tC:/1.txt  C:/2.txt 123456 -1");
			System.out.println("///////////////////////////////////////////////////////////");
			System.exit(-1);
		}
		
		// 原文件
		src = args[0];
		// 目标文件
		dest = args[1];
		// 密钥
		String secretKeys = args[2];
		keys = secretKeys.toCharArray();
		// 指令类型(1:加密;-1:解密)
		try {
			type = Integer.valueOf(args[3]); 
		} catch(Exception e) {
			System.err.println("指令错误，加密指令是1解密指令是-1，请重新输入！");
			System.exit(-1);
		}
		
		if(type != 1 && type != -1) {
			System.err.println("指令错误，加密指令是1解密指令是-1，请重新输入！");
			System.exit(-1);
		}
		
		transform();
		
		System.out.println((type == 1) ? message[0] : message[1]);
	}
}
