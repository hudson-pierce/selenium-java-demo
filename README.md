# Selenium Java Demo

### This project assumes you have the following prerequisites setup:
- Java is installed (I am using Java 17).
- IntelliJ IDE (or similar) is installed for running the tests or you can run tests directly from your terminal.
- Google Chrome, Microsoft Edge, and Firefox are installed on your machine. 
- ChromeDriver, EdgeDriver, and GeckoDriver are downloaded to your machine and the paths are added as described in the [Selenium docs](https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/).

### How to run tests:
- Option 1: From IntelliJ IDE
  - Open the project in the IntelliJ IDE
  - Right click on the project and select `Run Tests in 'SeleniumJavaDemo'`
  - Then the tests will run and you can view the results in the Test Results pane that opens up.

- Option 2: From terminal using gradle
  - Run this command to run all tests:
    ```
    ./gradlew test
    ```
