package cuke.common.testutil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 23-1-2017.
 */
public class Wacht {
    private static final Logger logger = LoggerFactory.getLogger(Wacht.class);

    public static void milliseconden(int milliseconden) {
        for (int i = milliseconden; i > 0; i--) {
            slaap(1);
        }
    }

    public static void seconden(int seconden) {
        for (int i = seconden; i > 0; i--) {
            if (i % 10 == 0) {
                logger.info(String.format("Nog %s seconden wachten.", i));
            }
            slaap(1000);
        }
    }

    public static void minuten(int minuten) {
        for (int i = minuten; i > 0; i--) {
            logger.info(String.format("Nog %s minuten wachten.", i));
            slaap(60000);
        }
    }

    private static void slaap(int milliseconden) {
        try {
            Thread.sleep(milliseconden);
        } catch (InterruptedException e) {
            logger.info("Kon niet slapen.");
        }
    }
}
