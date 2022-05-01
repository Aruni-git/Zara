package com.Zhara;


import org.apache.log4j.Logger;

public class Log {

	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());

	// This is to print log at the beginning of the test case
	public static void startTestCase() {
		Log.info("************** Start of the test case ******************");
	}

	// This is to print log at the end of the test case
	public static void endTestCase() {
		Log.info("************** End of the test case ******************");
		Log.info(" ");
	}

	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message, Exception e) {
		Log.error(message, e.getCause());
	}

	public static void debug(String message) {
		Log.debug(message);
	}

	public static void setData(String message) {
		Log.info(message);
	}

	public static void error(String message) {
		Log.error(message);
	}
}
