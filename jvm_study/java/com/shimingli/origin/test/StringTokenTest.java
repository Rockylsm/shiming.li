package com.shimingli.origin.test;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author shiming.li
 * @version $ v1.0 20-4-29 $
 */
public class StringTokenTest {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("path.separator"));
        String property = System.getProperty("java.class.path");
        StringTokenizer st = new StringTokenizer(property, File.pathSeparator);
        int stCount = st.countTokens();
        File[] files = new File[stCount];

        for(int i = 0 ; i < stCount; i ++){
            files[i] = new File(st.nextToken());
        }
        System.out.println(files);
        File canonicalFile = files[0].getCanonicalFile();
        System.out.println(canonicalFile);
    }
}
