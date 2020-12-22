package com.charset;

import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Map.Entry;

public class ValidateCharset {

	public static void main(String[] args) {
		
		ValidateCharset c = new ValidateCharset();
		String a = "ï¼Ÿ";
		byte[] bts = a.getBytes();
		c.displayCharSet(bts);
	}
	public void displayCharSet(byte[] bts) {  
	    Set<Entry<String, Charset>> set = Charset.availableCharsets().entrySet();  
	    for (Entry<String, Charset> entry : set) {  
	        ByteBuffer buff = ByteBuffer.allocate(bts.length);  
	        for (byte c : bts) {  
	            buff.put(c);  
	        }  
	        buff.flip();  
	        Charset charset = entry.getValue();  
	        String str = charset.decode(buff).toString();  
	        System.out.println(entry.getKey() + " " + str);  
	    }  
	} 
}
