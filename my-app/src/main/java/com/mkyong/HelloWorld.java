package com.mkyong;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        /* Run honeypot*/
	
    	/*
         * StrSubstitute strings to test 
         * ${env:USER}
         * ${sys:os.name}
         * ${sys:os.version}
         */
        
	System.out.println("This is before from println");
        logger.info("This is before from log4j");
	Scanner sc = new Scanner(System.in);
	while(sc.hasNextLine()) logger.info(sc.nextLine());
        logger.info("This is after from log4j");
        System.out.println("This is after from println");
    }
}
