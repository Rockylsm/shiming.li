package file;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author shiming.li
 * @version $ v1.0 19-1-8 $
 */
public class fileTest {
    public static void main(String[] args) {
        File file = new File("/tmp/a.txt");
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8"));
            for(int i = 0;i<100;i++) {
                writer.write("aaa");
                if(i == 55){
                    
                }
            }
            for(int i = 0;i<100;i++) {
                writer.write("bbb");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
