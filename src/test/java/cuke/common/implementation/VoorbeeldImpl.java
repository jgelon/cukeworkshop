package cuke.common.implementation;

import cuke.common.browser.BrowserHelper;
import cuke.common.model.Lening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created on 1-3-2017.
 */
public class VoorbeeldImpl {

    private static final Logger logger = LoggerFactory.getLogger(VoorbeeldImpl.class);

    public static void printEenGegevensVanEenLeningLijst(List<Lening> leningen) {
        for (Lening lening : leningen) {
            logger.info("Leningtype: " + lening.getLeningtype());
            logger.info("Leenbedrag: " + lening.getBedrag());
        }
    }

    public static void printString(String var) {
        logger.info("De variabele wordt nu geprint:\n");
        logger.info(var);
    }

    public static void startBrowserMetUrl(String url) {
        BrowserHelper.gaNaarUrl(url);
    }

    public static void klikOpKnopMetId(String knopId) {
        BrowserHelper.klikOpKnop(knopId);
    }

    public static void tekstIsZichtbaar(String tekst) {
        BrowserHelper.controleerTekstVanOnderdeelMetId("tekstScherm2", tekst);
    }
}
