# Selenium Java Demo

### Description:
A suite of End-to-End tests which uses Selenium, Java, and JUnit for a web application. All tests are running automatically in CI via GitHub actions. Tests can also be run and debugged locally following the steps below.

### Prerequisites:
- Java is installed (I am using Java 17).
- IntelliJ IDEA (or similar) is installed for running the tests, or you can run tests directly from your terminal.
- Google Chrome, Microsoft Edge, and Firefox are installed on your machine. You can modify which browser you want tests to run on by changing the `BROWSER` constant in [Constants.java](./src/test/java/constants/Constants.java).

### How to Run Tests Manually:
- Option 1: From IntelliJ IDE
  - Open the project in the IntelliJ IDEA
  - Right-click on the project and select `Run Tests in 'SeleniumJavaDemo'`
  - Then the tests will run, and you can view the results in the Test Results pane that opens up.

- Option 2: From terminal using gradle
  - Run this command to run all tests:
    ```
    ./gradlew test
    ```
