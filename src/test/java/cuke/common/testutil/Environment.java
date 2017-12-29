package cuke.common.testutil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import static java.lang.System.getProperty;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created on 09-01-2017.
 */
public class Environment {

    private static final Logger logger = LoggerFactory.getLogger(Environment.class);
    public static boolean isWindows() {
        return System.getProperty("os.name").contains("Windows");
    }

    public static String getComputerName() {
        String computerName;
        try {
            computerName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.info("Could not determine computer name");
            computerName = "UNKNOWN";
        }
        return computerName;
    }
}
