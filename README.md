
# E2E UI Test Framework

This project is an End-to-End (E2E) UI testing framework built with a combination of several powerful tools to ensure robust and reliable testing for web applications. The framework leverages modern testing practices and tools.

## Tools Used

- **Java**: The primary programming language for writing test scripts.
- **Maven**: A build automation tool used to manage dependencies and the project's lifecycle.
- **Selenide**: A concise and powerful library for writing UI tests in Java.
- **JUnit 5**: The testing framework for running and organizing tests.
- **Cucumber**: A tool for Behavior-Driven Development (BDD), allowing you to write tests in Gherkin syntax.
- **Allure**: A reporting framework to generate attractive, user-friendly reports for test execution results.
- **Logback**: A logging framework for outputting logs during the test execution.
- **Lombok**: A Java library to reduce boilerplate code by auto-generating getters, setters, and other methods.
- **GitHub Actions**: A CI/CD tool for automating the testing process.
- **Selenium Grid**: A tool for running tests in parallel across multiple machines and browsers.

## Features

- **End-to-End Testing**: Verifies the full workflow of the application by simulating real user interactions.
- **Parallel Test Execution**: Utilizes Selenium Grid for running tests in parallel across different browsers.
- **BDD Support**: Integration of Cucumber to write human-readable tests using Gherkin syntax.
- **Detailed Reporting**: Allure generates detailed and user-friendly reports after test execution.
- **Centralized Logging**: Logback handles application logs, making it easier to debug and track test execution.
- **CI/CD Pipeline**: GitHub Actions automates the running of tests with every code change.
- **Multiple Environment Support**: You can maintain different `.properties` files (e.g., dev, QA, staging) to target various test environments.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6+ or higher
- GitHub account (for CI/CD integration)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/e2e-ui-test-framework.git
   cd e2e-ui-test-framework
   ```

2. Install dependencies using Maven:

   ```bash
   mvn clean install
   ```

### Configuration

You can configure the test environment by modifying the `src/test/resources/config/test.properties` file. Here are some commonly used variables:

- **base.url**: The base URL of the application under test.
- **browser**: The default browser (e.g., `chrome`, `firefox`) for running the tests.
- **selenide.remote**: The URL of the Selenium Grid Hub, if you're running tests on a remote Grid.

Adjust these values as needed to match your environment before running the tests.

### Build and Run Tests

To build the project and run all tests, use the following Maven commands:

```bash
mvn clean install -DskipTests
mvn test
```

#### Running Specific Test Suites Using Tags

You can specify which test suite(s) to run by tagging your scenarios in Cucumber. For example:

```bash
mvn clean test -Dcucumber.filter.tags="@SmokeTest"
```
This command runs only the tests tagged with `@SmokeTest`.

If you’re using GitHub Actions for CI/CD, you can also specify tags as part of the workflow configuration to filter which tests are executed during the pipeline.

### Running Tests in Parallel

The framework is configured to run tests in parallel across multiple browsers using **Selenium Grid**. Ensure that the Selenium Grid is set up and running, then specify the correct Hub URL in the `selenide.remote` variable within the `src/test/resources/config/test.properties` file. Once configured, you can run your tests in a default way.

### Generating and Viewing Allure Reports

This project uses **Allure** to generate comprehensive and user-friendly test reports. Allure reports provide detailed insights into test execution, including test results, logs, and visualizations. **Screenshots and `pageSource` files** are also included in the report for any steps that fail, helping with fast and thorough debugging.

#### Viewing the Allure Report

The latest Allure report for this project can be viewed online at the following link:

[View Allure Report Results](https://donesvad.github.io/java-ui-test-github/)

This report includes:

- **Test Results**: Summary and details of passed, failed, and skipped tests
- **Test Suites**: Breakdown of test suites and their execution results
- **Test History**: Insights into test execution history and trends over time
- **Logs and Attachments**: Detailed logs, screenshots, and `pageSource` files for failed steps
#### How to Generate Allure Report Locally

To generate and view Allure reports locally, follow these steps:

- Serve the Allure report:
   ```bash
   allure serve
   ```

This will start a local server and display the Allure report in your default web browser.

This command will start a local server and open the Allure report in your default web browser, allowing you to visualize the test results with detailed
insights.

Ensure that the Allure CLI is installed on your machine. If not, you can install it using the following commands:

```bash
brew install allure    # For macOS users using Homebrew
scoop install allure    # For Windows users using Scoop
```

Or follow the [installation instructions](https://allurereport.org/docs/install/) from the Allure documentation for other operating systems.

### CI/CD Integration

This project is integrated with GitHub Actions for CI/CD. Every push to the repository triggers automated test runs. The results will be available in the GitHub Actions tab.

> **TODO**: Add the ability to choose which browser to use for tests via CI (this feature is already implemented for local execution).
