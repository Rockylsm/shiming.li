package com.qunar.rsa;

public class FileEncryptDecryptToolsTest {
	public static void main(String[] args) {
		try {
			//�ļ�����
			FileEncryptDecryptTools.generateEncryptedFile("I:/CARD_NO.txt", "CARD_NO.txt", "I:/CARD_NO.zip",
					"123456789012345678901234");
			//�ļ�����
			FileEncryptDecryptTools.decryptEncryptedFile("I:/CARD_NO.zip", "I:/CARD_NO1.txt",
					"123456789012345678901234");
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
