# QA Automation Project
Framework for API QA Automation testing using Groovy, Spock, and RestAssured.
### Resources
- [Spock](http://spockframework.org/spock/docs/1.3/all_in_one.html)
- [Groovy](https://groovy-lang.org/single-page-documentation.html)
- [RestAssured](https://github.com/rest-assured/rest-assured/wiki/Usage)
- [Intellij](https://www.jetbrains.com/idea/)
    - Suggested Intellij Plugins:
        - [Rainbow Brackets](https://plugins.jetbrains.com/plugin/10080-rainbow-brackets)
        - [String Manipulation](https://plugins.jetbrains.com/plugin/2162-string-manipulation)
        - [Key Promoter](https://plugins.jetbrains.com/plugin/9792-key-promoter-x)
        - [Git Tool Box](https://plugins.jetbrains.com/plugin/7499-gittoolbox)
---
## Setup
1. [Install Git For Windows Here](https://git-scm.com/download)
    - Use default options or set them as preferred.
    - NOTE: You can get intellij to handle this for you.
2. [Install Intellij Here](https://www.jetbrains.com/idea/download/)
    - [Setup project with Git](https://www.jetbrains.com/help/idea/set-up-a-git-repository.html)
        - For newer versions of intellij I suggest making sure this is unchecked so you can see local changes easily
            - `Settings -> Version Control -> Commit  -> Use non-modal commit interface`
3. Install Java 8 & Groovy 3.0.4
    - for `Mac` [recommend using sdkman here](https://sdkman.io/usage)
        - install java `sdk install java 8.0.265-amzn`
        - install groovy `sdk install groovy 3.0.4`
    - for `Windows` you can [install java manually with instructions here](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/windows-7-install.html) and install groovy [here](https://groovy.jfrog.io/artifactory/dist-release-local/groovy-windows-installer/groovy-3.0.4/)
    - you can also just use intellij to setup the sdk [as explained here](https://www.jetbrains.com/help/idea/sdk.html)
        - when in `project structure` click the `+` icon and download the `amazon corretto 1.8 JDK`
#### **Gradle Properties**:
1. Set properties from `gradle.properties` file or use the command line `-Pproperty=valueHere` as needed
    - ex: `./gradlew api:test --tests "typicode.tests.ExampleApiSpec.Get Example" -PbaseUrl=ValueHere -Pusername=ValueHere -Ppassword=ValueHere`
---
## Running Tests
You can run tests from the CLI and choose to exclude tests and more. Make sure to have properties filled in `gradle.properties` or through CLI
- ex: `./gradlew api:test --tests "typicode.tests.ExampleApiSpec.Get Example" -PbaseUri=ValueHere"`
    - the * character acts as a wildcard.
        - *Example will run any test that ends in Example
        - Example* will run any test that starts with Example
        - \*Example\* will run any test containing Example
    - replace **Example** with the desired test name. You can also just run all sims under the **test** package with **`*`** like so `typicode.tests.*`
---
## Reports
After running a test go to the following location and open `index.html` in the desired browser to view report.
- `spock-api-automation-with-geb-restassured-template/api/build/geb-spock-reports`
---
### CheatSheet
- If properties are set to desired values in `gradle.properties` you **don't** have to set them with `-Pproperty=propValue` in the Command Line!
- make sure you have **api:** to designate the subproject or **ui:** subproject tests might get ran!
- look in the `gradle.properties` file for property descriptions
- Do not commit sensitive information (credentials) in any files
---
#### Command Line Examples:
    -- Run Tests --
    ./gradlew api:clean api:test --tests "typicode.tests.ExampleApiSpec.Get Example"

#### Project Properties
    baseUri
    username
    password
    testEnvs
