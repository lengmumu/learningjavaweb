package com.utiltool;

public class StringUtil {
	public static String filterHtml(String input) {
		if(input==null) return null;
		if(input.length() == 0) return input;
		input = input.replaceAll("<", "&lt;");
		input = input.replaceAll(">", "&gt;");
		input = input.replaceAll("&", "&amp;");
		input = input.replaceAll(" ", "&nbsp;");
		input = input.replaceAll("\n", "<br/>");
		input = input.replaceAll("\"", "&quot;");
		input = input.replaceAll("\'", "&#39;");
		return input;
	}
	public static String filterHtml2(String input) {
		if(input==null) return null;
		if(input.length() == 0) return input;
		input = input.replaceAll("<", "<");
		input = input.replaceAll(">", ">");
		input = input.replaceAll("&", "&");
		input = input.replaceAll(" ", " ");
		input = input.replaceAll("\n", "<br/>");
		input = input.replaceAll("\"", "\"");
		input = input.replaceAll("\'", "\'");
		return input;
	}
}
