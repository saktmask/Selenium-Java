package week7.assignments;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LearnLogger {

	final static Logger logger=Logger.getLogger(LearnLogger.class);
		
	public void init()
	{
		BasicConfigurator.configure();
	}
}
