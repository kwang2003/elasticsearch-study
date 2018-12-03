package com.github.kwang2003.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取测试目录下的文本文件内容
 * @author wangxuzheng
 *
 */
public class TestResourceFileReader {
	public static String readTextFromFile(String filename) throws IOException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream in = loader.getResourceAsStream(filename);
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
	    int bufferSize = 100;
        byte[] buff = new byte[bufferSize];  
        int rc = 0;  
        while ((rc = in.read(buff, 0, bufferSize)) > 0) {  
            swapStream.write(buff, 0, rc);  
        }  
        byte[] bytes = swapStream.toByteArray();  
        in.close();
        swapStream.close();
        String text = new String(bytes);
        return text;
	}
}