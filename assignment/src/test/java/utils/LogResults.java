package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import tests.TestCases;

/**
 * <h1>Log Results class</h1>
 * The class has methods to write logs to log file
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-12
 */
public class LogResults {
    public static Logger logMe;

    /**
     * Default constructor for LogResults class
     */
    public LogResults() {
        logMe = Logger.getLogger(TestCases.class);
        String log4jConfigFile = System.getProperty("user.dir") + "\\properties\\log4j.properties";
        String logFile = System.getProperty("user.dir") + "\\results\\applogs.log";
        System.setProperty("logpath", logFile);
        PropertyConfigurator.configure(log4jConfigFile);
    }

    /**
     * This is to print log for the beginning of the test case
     */
    public static void startTestCase(String strTestCaseName) {
        logMe.info("-----------------------------------------------------------------------------------------");
        logMe.info("------------------------------------" + strTestCaseName + "---------------------------------");
        logMe.info("-----------------------------------------------------------------------------------------");
    }

    /**
     * This is to print log for the ending of the test case
     */
    public static void endTestCase(String strTestCaseName) {

        logMe.info("-----------------------------------------------------------------------------------------");
        logMe.info("-------------------------------- END" + strTestCaseName + " END --------------------------");
        logMe.info("-----------------------------------------------------------------------------------------");

    }

    /**
     * This is to print info level message in log file
     */
    public static void info(String message) {
        logMe.info(message);
    }

    /**
     * This is to print warning level message in log file
     */
    public static void warn(String message) {
        logMe.warn(message);
    }

    /**
     * This is to print error level message in log file
     */
    public static void error(String message) {
        logMe.error(message);
    }
}
