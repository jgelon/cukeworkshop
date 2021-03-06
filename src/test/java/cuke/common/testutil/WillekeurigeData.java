package cuke.common.testutil;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

import static junit.framework.TestCase.fail;

/**
 * Created on 1/12/2017.
 */
public class WillekeurigeData {

    private static final Logger logger = LoggerFactory.getLogger(WillekeurigeData.class);

    private static final Faker faker = new Faker(new Locale("nl"));

    /**
     * Een methode om een x aantal willekeurige getallen te genereren. Het eerste getal is nooit 0.
     *
     * @param aantalGetallen het aantal gewenste getallen.
     * @return het x aantal gewenste willekeurige getallen
     */
    public static String willekeurigeGetallen(int aantalGetallen) {
        return faker.number().digits(aantalGetallen);
    }

    public static String willekeurigeNaam() {
        return faker.lordOfTheRings().character();
    }

    /**
     * Met deze methode wordt een willekeurig item uit een List gekozen. Deze wordt bijvoorbeeld gebruikt bij het ophalen van meerdere regels uit een database tabel en daar 1 van uitkiezen om verder te gebruiken.
     *
     * @param listSize de list.size() van de lijst waare een item uitgekozen moet worden.
     * @return Een willekeurig getal waarmee een item uit een lijst gekozen kan worden. Dit getal zit tussen de 0 en de listSize-1 (listsize is altijd 1 groter dan de hoogste index in de list, omdat de index begint bij 0).
     */
    public static int kiesNummerUitListMetListSize(int listSize) {
        if (listSize == 0) {
            fail("De opgegeven lijst is leeg.");
        }
        return willekeurigGetalTussen(0, listSize - 1);
    }

    /**
     * Met deze methode wordt een willekeurig getal teruggegeven tussen een minimum en een maximum.
     * <p>
     * LET OP! Er wordt niet gecontroleerd of het minimum lager is dan het maximum, dit is de verantwoordelijkheid van de aanroeper. Er wordt alleen een line geprint wanneer dit het gval is.
     * Wanneer min en max gelijk zijn, dan wordt datzelfde getal gewoon teruggegeven.
     *
     * @param min de ondergrens van het te kiezen getal
     * @param max de bovengrens van het te kiezen getal
     * @return een waarde tussen de min en max, wanneer het minimum lager is dan het maximum.
     */
    public static int willekeurigGetalTussen(int min, int max) {
        if (min > max) {
            logger.info(String.format("Het gewenste willekeurige getal zal niet tussen het minimum %d en maximum %d liggen, want het minimum is groter dan het maximum.", min, max));
        }
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
