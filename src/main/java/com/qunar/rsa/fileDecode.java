//package com.qunar.rsa;
//
//import org.apache.commons.io.IOUtils;
//
//import javax.crypto.Cipher;
//import javax.crypto.CipherInputStream;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.*;
//
///**
// * @author shiming.li
// * @version $ v1.0 18-1-19 $
// */
//public class fileDecode {
//    private static final String threeDesKey = "379096883262308065431046";
//    private static final String ALGORITHM = "DESede";
//
//    public static boolean fileDecode(String sourceFileUrl, String distFileUrl, String threeDesKey) {
//        InputStream inputStream = null;
//        CipherInputStream cos = null;
//        try {
//            inputStream = new FileInputStream(sourceFileUrl);
//            cos = decryptMode(inputStream, threeDesKey);
//            IOUtils.copy(cos, new FileOutputStream(distFileUrl));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return false;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            IOUtils.closeQuietly(inputStream);
//            IOUtils.closeQuietly(cos);
//        }
//        return true;
//    }
//
//    public static CipherInputStream decryptMode(InputStream inputStream,String threeDesKey) {
//        try {
//            SecretKey deskey = new SecretKeySpec(threeDesKey.getBytes(), ALGORITHM); // ����
//            Cipher c1 = Cipher.getInstance(ALGORITHM);
//            c1.init(Cipher.DECRYPT_MODE, deskey);
//            return new CipherInputStream(inputStream, c1);
//        } catch (java.security.NoSuchAlgorithmException e1) {
//            e1.printStackTrace();
//        } catch (javax.crypto.NoSuchPaddingException e2) {
//            e2.printStackTrace();
//        } catch (java.lang.Exception e3) {
//            e3.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        String srcUrl = "/home/shimingli/Desktop/CCF_20180119_1.zip";
//        String dscUrl = "/home/shimingli/Desktop/CCF_20180119_2.zip";
//        fileDecode(srcUrl, dscUrl, threeDesKey);
//    }
//}
