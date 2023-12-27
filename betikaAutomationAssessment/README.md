 Duplo QA Assessment
---

# Selenium Automation with Java and Maven 

This repository contains a BETIKA QA Assessment solution using Selenium WebDriver with Java and Maven. This README will guide you through setting up the project, writing test scripts, and running them.

## Prerequisites

Before you begin, make sure you have the following installed on your system:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (JDK 8 or higher)
- [Maven](https://maven.apache.org/download.cgi)
- Your favorite Integrated Development Environment (IDE). We recommend [Eclipse](https://www.eclipse.org/downloads/) or [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).
- A compatible web browser (e.g., Chrome, Firefox) and its corresponding WebDriver (download and configure WebDriver for your browser).

## Project Setup

1. Clone this repository to your local machine:

2. Open the project in your IDE.

3. Navigate to the project root directory and update the `pom.xml` file with the necessary dependencies in case you have dependencies preference . You can add WebDriver dependencies for the browsers you intend to automate.

4. Add other test cases, page objects and utilities to the appropriate package under the `src/test/java`to accommodate other future needs

## Running Tests

Access the CLI of your operating system (e.g., iTerm for macOS or PowerShell for Windows) and navigate to the project directory. Then, run the following command to execute the features: mvn clean test. By default, this command will invoke the chrome browser and execute the tests.

You can run your tests using Maven and TestNG. Execute the following command from the project root directory:

```bash
mvn test
```

This will run all the test classes in the project.


## Reporting
TestNG generates test reports in the `reports/` directory. You can view these reports to check the test execution results.
Logs generated can be seen at the `logs/` directory. You can view the log reports to check the test execution logs.
## Contributing
Contributions are welcome! Feel free to open issues or pull requests if you have suggestions or improvements to make.

## Additional Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/en/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)

