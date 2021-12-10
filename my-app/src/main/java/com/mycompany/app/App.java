package com.mycompany.app;
import org.apache.log4j.Logger;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
	final Logger log = Logger.getLogger("Mylogger");
        System.out.println("Println has started");
        log.info("Logging has started");
        log.info("${jndi:ldap://localhost/a}");
        log.info("${env:user}");
    }
}
