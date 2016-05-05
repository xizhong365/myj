package wky.java.base.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestLogger {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) {
		LOGGER.setLevel(Level.FINEST);
		//---
		// http://stackoverflow.com/questions/6315699/why-are-the-level-fine-logging-messages-not-showing
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		LOGGER.addHandler(handler);
		//---
		LOGGER.info("info");
		LOGGER.severe("severe");
		LOGGER.fine("fine");
		LOGGER.finest("finest");

	}

}
