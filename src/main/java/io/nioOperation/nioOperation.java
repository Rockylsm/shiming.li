package io.nioOperation;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author shiming.li
 * @version $ v1.0 19-3-26 $
 */
public class nioOperation {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("/tmp/11031000_20180923.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = channel.read(byteBuffer);
        while (read != -1){
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.println((char)byteBuffer.get());
            }
            byteBuffer.compact();
            read = channel.read(byteBuffer);
        }
    }
}
