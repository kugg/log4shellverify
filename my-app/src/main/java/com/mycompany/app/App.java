package com.mycompany.app;
/*
        System.out.println( "Hello World!" );
	private static Logger log = Logger.getLogger("Mylogger");
        System.out.println("Println has started");
        log.info("Logging has started");
        log.info("${jndi:ldap://localhost/a}");
        log.info("${env:user}");
*/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        logger.debug("Hello from Log4j 2");

        // in old days, we need to check the log level to increase performance
        /*if (logger.isDebugEnabled()) {
            logger.debug("{}", getNumber());
        }*/

        // with Java 8, we can do this, no need to check the log level
        logger.debug("{}", () -> getNumber());

    }

    static int getNumber() {
        return 5;
    }

}
