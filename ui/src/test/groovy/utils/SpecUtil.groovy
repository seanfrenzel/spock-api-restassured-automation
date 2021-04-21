package utils

import groovy.time.TimeCategory
import groovy.util.logging.Log4j2
import org.apache.commons.lang3.RandomStringUtils
import org.openqa.selenium.Keys
import spock.util.concurrent.PollingConditions

import java.text.SimpleDateFormat

@Log4j2
class SpecUtil {

    SpecUtil() {
        throw new IllegalAccessException('Utility Class')
    }

    def static loggedIn = false

    static ArrayList<String> dataSetNames = []
    static String dataSetName = null
    static final String dataSetNamePrefix = 'Auto Set'

    /**
     * retruns a random string with given length
     * @param length Size of random string
     * @return
     */
    def static randomString(Integer length) {
        String charset = (('A'..'Z') + ('0'..'9')).join()
        RandomStringUtils.random(length, charset.toCharArray())
    }

    /**
     * clear element value with key commands
     * @param elem
     */
    def static clearText(elem) {
        boolean MACOS = System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0
        Keys ctrlKey = MACOS ? Keys.COMMAND : Keys.LEFT_CONTROL

        elem << Keys.chord(ctrlKey, 'a')
        elem << Keys.DELETE
    }

    /**
     * clear multiple elements value with key commands
     * @param elems [element1, element2]
     */
    def static clearText(ArrayList elems) {
        elems.each {
            boolean MACOS = System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0
            Keys ctrlKey = MACOS ? Keys.COMMAND : Keys.LEFT_CONTROL

            it << Keys.chord(ctrlKey, 'a')
            it << Keys.DELETE
        }
    }

    def static getDate(String format = 'yyyy-MM-dd', int plusDays = 0) {
        new SimpleDateFormat(format).format(use(TimeCategory) { new Date() + plusDays.days})
    }

    /**
     * Polling conditions to wait for an expected result
     */
    def static poll(def timeout = 10, def initialDelay = 1, def factor = 1.25, def delay = 1) {
        new PollingConditions(timeout: timeout, initialDelay: initialDelay, factor: factor, delay: delay)
    }

    /**
     * Checks to see if a test environment is being used
     * @return
     */
    static boolean isTestEnv() {
        List<String> testEnvs = System.getProperty('ui.testEnvs').toLowerCase().split(',')
        String host = System.getProperty('ui.baseUrl').toLowerCase()

        testEnvs.stream().anyMatch({ host.contains(it) })
    }
}
