package otherTest.io.ioOperation;

import java.io.File;
import java.io.IOException;

/**
 * @author shiming.li
 * @version $ v1.0 18-9-25 $
 */
public class StrTest {
    public static void main(String[] args) {
        File inputFile = new File ("/tmp/11031000_20180923.txt");
        if(inputFile.exists()){
            try {
                System.out.println(inputFile.getAbsolutePath());
                System.out.println(inputFile.getParentFile());
                System.out.println(inputFile.getParent());
                System.out.println(inputFile.getPath());
                System.out.println(inputFile.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("please touch it first.");
        }
    }
}
