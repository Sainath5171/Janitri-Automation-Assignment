# Janitri Dashboard - Login Page Automation

This project is a QA automation framework built to test the login functionality of the Janitri Development Dashboard, as part of a QA Internship assignment.

It uses Java, Selenium WebDriver, and TestNG to automate test scenarios based on the Page Object Model (POM) design pattern.

## Technologies Used

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Runner:** TestNG
* **Build & Dependency Management:** Apache Maven
* **Browser Driver Management:** WebDriverManager

## Automated Test Scenarios

This framework covers the following test cases for the login page:

* `testPageElementsPresence`: Validates that the User ID and Password fields are visible on page load.
* `testLoginButtonIsEnabled`: Confirms that the login button is enabled by default.
* `testInvalidLogin`: Verifies that an invalid login attempt does not navigate the user away from the login page. It also captures and prints any error messages shown.
* `testPasswordMaskingToggle`: Checks that the password input is masked by default and that the visibility toggle works correctly.

## How to Run the Tests

1.  **Prerequisites:**
    * Java (JDK) installed.
    * Apache Maven installed.
    * Google Chrome installed.

2.  **Execution:**
    * Clone this repository to your local machine.
    * Open a terminal or command prompt and navigate to the root directory of the project.
    * Run the following Maven command:

        ```sh
        mvn clean test
        ```
    * Maven will download all necessary dependencies and execute the TestNG test suite. Test results will be available in the `/target/surefire-reports` directory.

## Output

<img width="1810" height="437" alt="Screenshot 2025-08-03 121951" src="https://github.com/user-attachments/assets/9ec6a43b-2cb6-4ae1-aafe-3d4b0cac889b" />

