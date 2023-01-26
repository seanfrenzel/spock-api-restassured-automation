package typicode.utils

import groovy.time.TimeCategory
import groovy.util.logging.Log4j2
import org.apache.commons.lang3.RandomStringUtils
import spock.util.concurrent.PollingConditions

import java.text.SimpleDateFormat

@Log4j2
class SpecUtil {

    SpecUtil() {
        throw new IllegalAccessException('Utility Class')
    }

    def static randomString(Integer length) {
        String charset = (('A'..'Z') + ('0'..'9')).join()
        RandomStringUtils.random(length, charset.toCharArray())
    }

    def static getDate(String format = 'yyyy-MM-dd', int plusDays = 0) {
        new SimpleDateFormat(format).format(use(TimeCategory) { new Date() + plusDays.days })
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
        List<String> testEnvs = System.getProperty('api.testEnvs').toLowerCase().split(',')
        String host = System.getProperty('api.baseUri').toLowerCase()

        testEnvs.stream().anyMatch({ host.contains(it) })
    }
}
