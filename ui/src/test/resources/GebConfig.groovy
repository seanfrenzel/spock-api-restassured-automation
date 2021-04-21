import com.aoe.gebspockreports.GebReportingListener
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.RemoteWebDriver

reportingListener = new GebReportingListener()
reportsDir = 'build/geb-spock-reports'

baseUrl = System.getProperty('ui.baseUrl')

atCheckWaiting = true

//autoClearWebStorage = true
//reportOnTestFailureOnly = false

waiting {
    timeout = 10
    retryInterval = 1
    includeCauseInMessage = true

    presets {
        verySlow {
            timeout = 180
            retryInterval = 3.0
            includeCauseInMessage = true
        }
        slow {
            timeout = 60
            retryInterval = 0.50
            includeCauseInMessage = true
        }
        fast {
            timeout = 2
            retryInterval = 0.50
            includeCauseInMessage = true
        }
    }
}

environments {

    chromeRemote {
        ChromeOptions options = new ChromeOptions().setHeadless(true)
                                                   .setAcceptInsecureCerts(true).addArguments()
                                                   .addArguments(["--no-sandbox",
                                                                  'ignore-certificate-errors',
                                                                  'window-size=1920x1080'])
        def url = new URL(System.getProperty('ui.gridUrl'))
        driver = { new RemoteWebDriver(url, options) }
    }

    chrome {
        WebDriverManager.chromedriver().setup()
        def options = new ChromeOptions().addArguments('ignore-certificate-errors')
        driver = { new ChromeDriver(options) }
    }

    chromeFullscreen {
        WebDriverManager.chromedriver().setup()
        def options = new ChromeOptions().addArguments('--kiosk').addArguments('ignore-certificate-errors')
        driver = { new ChromeDriver(options) }
    }

    chromeHeadless {
        WebDriverManager.chromedriver().setup()

        ChromeOptions options = new ChromeOptions().setHeadless(true)
                                                   .addArguments(['ignore-certificate-errors', 'window-size=1920x1080'])

        driver = { new ChromeDriver(options) }
    }

    firefox {
        driver = { new FirefoxDriver() }
    }

}