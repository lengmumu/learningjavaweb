package com.log4jv1;

import org.apache.log4j.Logger;

public class HelloLog4j {
	private static Logger logger = Logger.getLogger("HelloLog4j.class");
	public static void main(String[] args) {
		logger.debug("这是一个debug信息");
		logger.info("这是信息级别信息");
		logger.error("这是错误级别信息");

	}

}
