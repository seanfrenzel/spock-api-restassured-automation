# UI QA Automation
UI QA Automation project using geb and spock.

---
Resources
- [Spock](http://spockframework.org/spock/docs/1.3/all_in_one.html)
- [Groovy](https://groovy-lang.org/single-page-documentation.html)
- [Geb](https://gebish.org/manual/current/#introduction)
- [Selenium](https://www.selenium.dev/documentation/en/)
- [Docker](https://docs.docker.com/get-docker/)
    - [Docker selenium project handles container use with selenium](https://github.com/SeleniumHQ/docker-selenium)
---
## Setup
1. [Install Git For Windows Here](https://git-scm.com/download)
    - Use default options or set them as preferred.
    - NOTE: You can get intellij to handle this for you. 
2. [Install IntelliJ Here](https://www.jetbrains.com/idea/download/)
   - [Setup project with Git](https://www.jetbrains.com/help/idea/set-up-a-git-repository.html)
      - For newer versions of IntelliJ I suggest making sure this is unchecked so you can see local changes easily
         - `Settings -> Version Control -> Commit  -> Use non-modal commit interface`
3. Install Java 8 & Groovy 3.0.4
    - for `Mac` [recommend using sdkman here](https://sdkman.io/usage)
        - command with sdkman installed to install java `sdk install java 8.0.265-amzn`
        - command with sdkman installed to install java `sdk install groovy 3.0.4`
    - for `Windows` you can [install java manually with instructions here](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/windows-7-install.html) and install groovy [here](https://groovy.jfrog.io/artifactory/dist-release-local/groovy-windows-installer/groovy-3.0.4/)
    - you can also just use intellij to setup the sdk [as explained here](https://www.jetbrains.com/help/idea/sdk.html)
        - when in `project structure` click the `+` icon and download the `amazon corretto 1.8 JDK`
    
#### **Gradle Properties**:
1. Set properties from `gradle.properties` file or use the command line `-Pproperty=valueHere` as needed
    - ex: `./gradlew ui:test --tests gfy.tests.*woah* -PbaseUrl=ValueHere -Pusername=ValueHere -Ppassword=ValueHere`
---
## Running Tests
You can run tests from the CLI and choose to exclude tests and more. Make sure to have properties filled in `gradle.properties` or through CLI
- ex: `./gradlew ui:test --tests gfy.tests.SearchGifExampleSpec.*woah*`
    - the * character acts as a wildcard.
         - *woah will run any test that ends in woah
         - woah* will run any test that starts with woah
         - \*woah\* will run any test containing woah
    - replace **woah** with the desired test name. You can also just run all sims under the **test** package with **`*`** like so `gfy.tests.*`

To run remote tests you would use a command like this to spin up and teardown a docker container used to run tests in\
    - `You need to have docker setup on the system for this to work`

- ex: `./gradlew ui:dockerStart ; ./gradlew ui:test --tests gfy.tests.*woah* ; ./gradlew ui:dockerstop`
    - dockerStart task spins up a container
    - dockerStop stops and removes the container
    - you will need to make your own tasks as needed for different containers and more
    
---
## Reports
After running a test go to the following location and open `index.html` in the desired browser to view report.
- `spock-api-ui-automation-with-geb-restassured-template/ui/build/geb-spock-reports`
---
### CheatSheet/Misc Info
- If properties are set to desired values in `gradle.properties` you **don't** have to set them with `-Pproperty=propValue` in the Command Line!
- make sure you have **ui:** to designate the subproject or **api:** subproject tests might get ran!
- Do not commit sensitive information (credentials) in any files
- `GebConfig.groovy` handles the driver setup. When you use `-Pdriver` or set it in properties it uses the defined drivers there
---
#### Command Line Examples:
    -- Run Tests --
    ./gradlew ui:clean ui:test --tests "gfy.tests.SearchGifExampleSpec.*woah*"

#### Project Properties
    baseUrl
    gridUrl
    driver
    username
    password
    testEnvs
    






