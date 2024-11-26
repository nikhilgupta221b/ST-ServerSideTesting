# Blogging Application Testing

This README provides a detailed overview of the testing process for the Blogging application, including links to the code repository, the testing strategy used, designed test cases, tools employed, and results of the testing process.

## Table of Contents
1. [Code Repository](#code-repository)
2. [Testing Strategy](#testing-strategy)
3. [Designed Test Cases](#designed-test-cases)
4. [Testing Tools Used](#testing-tools-used)
5. [Test Results and Screenshots](#test-results-and-screenshots)
6. [Execution Instructions](#execution-instructions)

---

## Code Repository

The complete code repository used for testing can be accessed via the following link:

[Complete Code Repository](https://github.com/your-repo-link)

---

## Testing Strategy

The testing strategy for this project focuses on server-side service layer testing in the Spring application. The approach ensures that the core business logic is thoroughly tested for accuracy and reliability.

### 1. Manual Modeling of Service Layer
- *Component Interaction Model (CIM):*
  - Represents interactions between the service layer and dependent components like repositories and external APIs.
  
- *Application Transition Graph (ATG):*
  - Models the state transitions in the service layer during critical operations.

### 2. Test Case Design for Services
Service layer testing focused on verifying the following:
- *Business Logic*:
  - Ensuring all methods in services perform expected operations.
  - Validating inputs and outputs for correctness.
- *Repository Interactions*:
  - Mocking repository calls to verify proper data persistence and retrieval.
- *Error Handling*:
  - Testing scenarios that trigger exceptions (e.g., ResourceNotFoundException for invalid IDs).
- *Boundary Cases*:
  - Ensuring services handle edge cases, like empty inputs or extremely large payloads.

### 3. Coverage Analysis
We used *JaCoCo* to measure coverage for the service layer. The metrics include:
- *Lines of Code*: Ensuring each line in the service layer is executed during testing.
- *Branches*: Ensuring all branches in conditional logic are covered.
- *Methods and Classes*: Ensuring each service method and class is tested.

---

## Designed Test Cases

The following test cases were designed for the service layer:
1. *Create User*: Verify that a valid user can be created, persisted in the database, and returned as a response.
2. *Update User*: Ensure existing user details can be updated successfully.
3. *Get User by ID*: Validate the retrieval of a specific user by their unique ID.
4. *Get All Users*: Confirm that the service can return a list of all users in the system.
5. *Delete User*: Verify that a user can be successfully deleted and removed from the database.
6. *Exception Handling*: Test cases to ensure proper handling of invalid IDs, empty inputs, and other edge cases.

Complete test case details and methodologies are documented in the test-cases directory.

---

## Testing Tools Used

The following tools were used to perform service-layer testing:

- *JUnit 5*: For writing and running test cases.
- *Mockito*: For mocking dependencies like repositories.
- *JaCoCo*: For analyzing code coverage.

---

## Test Results and Screenshots

### Code Coverage Report
A code coverage report was generated using JaCoCo. Below is the summary of the coverage:
- *Lines Covered*: 85%
- *Branches Covered*: 80%
- *Methods Covered*: 90%

### Screenshots
#### 1. JaCoCo Coverage Report
![JaCoCo Coverage Report](images/jacoco-report.png)

#### 2. Test Case Execution Results
![Test Case Results](images/test-results.png)

---

## Execution Instructions

Follow these steps to execute the tests and view the coverage report:

1. *Run Tests*:
   - For Maven:
     bash
     mvn clean verify
     
   - For Gradle:
     bash
     ./gradlew test jacocoTestReport
     

2. *View Coverage Report*:
   - Maven: target/site/jacoco/index.html
   - Gradle: build/reports/jacoco/test/html/index.html

3. *View Screenshots*:
   - Navigate to the images directory in the project to view detailed screenshots of test results and coverage.

---
