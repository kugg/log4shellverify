package com.mkyong;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.filter.NoMarkerFilter;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.appender.OutputStreamAppender;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.config.LoggerConfig;


import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Tests {@link OutputStreamAppender}.
 */

public class HelloWorldTest {
    private static final String TEST_MSG = "${::-a}";
    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    @Rule
    public TestName testName = new TestName();

    private String getName(final OutputStream out) {
        return out.getClass().getSimpleName() + "." + testName.getMethodName();
    }

    @Test
    public void testVulnerable() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final OutputStream os = new BufferedOutputStream(out);
        final String name = getName(out);
        final Logger logger = LogManager.getLogger(name);
        addAppender(os, name);
        logger.error(TEST_MSG);
        final String actual = out.toString();
        Assert.assertFalse(actual, actual.contains(TEST_MSG));
    }

    private void addAppender(final OutputStream outputStream, final String outputStreamName) {
        final LoggerContext context = LoggerContext.getContext(false);
        final Configuration config = context.getConfiguration();
        final PatternLayout layout = PatternLayout.createDefaultLayout(config);
        final Appender appender = OutputStreamAppender.createAppender(layout, null, outputStream, outputStreamName, false, true);
        appender.start();
        config.addAppender(appender);
        ConfigurationTestUtils.updateLoggers(appender, config);
    }

    public static class ConfigurationTestUtils {

        static void updateLoggers(final Appender appender, final Configuration config) {
            final Level level = null;
            final Filter filter = null;
            for (final LoggerConfig loggerConfig : config.getLoggers().values()) {
                loggerConfig.addAppender(appender, level, filter);
            }
            config.getRootLogger().addAppender(appender, level, filter);
        }

}


}
