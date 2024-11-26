# Blogging Application Testing

This README provides a detailed overview of the testing process for the Blogging application, including links to the code repository, the testing strategy used, designed test cases, tools employed, and results of the testing process.

## Table of Contents
1. [Code Repository](#code-repository)
2. [Testing Strategy](#testing-strategy)
3. [Testing Tools Used](#testing-tools-used)
4. [Designed Test Cases](#designed-test-cases)
5. [Test Results and Screenshots](#test-results-and-screenshots)
6. [Execution Instructions](#execution-instructions)

---

## Code Repository

The complete code repository used for testing can be accessed via the following link:

[Complete Code Repository](https://github.com/nikhilgupta221b/ST-ServerSideTesting)

---

## Testing Strategy

The testing strategy for this project focuses on server-side controller layer and service layer testing in the Spring application. The approach ensures that the core business logic is thoroughly tested for accuracy and reliability also testing for controllers' working.

---

## Testing Tools Used

The following tools were used to perform service-layer testing:

- *JUnit 5*: For writing and running test cases.
- *Mockito*: For mocking dependencies like repositories.
- *JaCoCo*: For analyzing code coverage.

---

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
![image](https://github.com/user-attachments/assets/c0b77ae4-0352-482f-8b89-850de9926139)
---

# Designed Test Cases

## Service Layer Test Cases




### User

#### 1. Create User
- Validates successful user creation and handles server errors (`500`).
- [Flow Diagram](./1.%20Create%20User%20ATG.png)

#### 2. Update User
- Tests user update functionality, missing user errors (`404`), and server errors (`500`).
- [Flow Diagram](./2.%20Update%20User%20ATG.png)

#### 3. Delete User
- Ensures user deletion, handles non-existent user errors (`404`), and server errors (`500`).
- [Flow Diagram](./3.%20Delete%20User%20ATG.png)

#### 4. Get User by ID
- Validates retrieval of a user by ID, missing user errors (`404`), and server errors (`500`).
- [Flow Diagram](./4.%20Get%20User%20by%20Id%20ATG.png)

#### 5. Get All Users
- Confirms fetching all users and handles server errors (`500`).
- [Flow Diagram](./5.%20Get%20all%20Users%20ATG.png)


# Service Layer Test Cases

<details>
<summary><strong>Post</strong></summary>

### 1. Create Post
<details>
<summary>Details</summary>

- Validates successful post creation, user existence, category existence, and handles server errors (`500`).
- [Flow Diagram](./1.%20Create%20Post%20ATG.png)

</details>

### 2. Update Post
<details>
<summary>Details</summary>

- Tests post update functionality, validates post existence, category existence, and handles errors (`404`, `500`).
- [Flow Diagram](./2.%20Update%20Post%20ATG.png)

</details>

### 3. Delete Post
<details>
<summary>Details</summary>

- Ensures post deletion, validates post existence (`404`), and handles server errors (`500`).
- [Flow Diagram](./3.%20Delete%20Post%20ATG.png)

</details>

### 4. Get Post by ID
<details>
<summary>Details</summary>

- Validates retrieval of a specific post by ID, handles missing post errors (`404`), and server errors (`500`).
- [Flow Diagram](./4.%20Get%20Post%20by%20Id%20ATG.png)

</details>

### 5. Get Posts by User
<details>
<summary>Details</summary>

- Confirms fetching posts for a specific user, handles missing user errors (`404`), and server errors (`500`).
- [Flow Diagram](./5.%20Get%20Post%20by%20User%20ATG.png)

</details>

### 6. Get Posts by Category
<details>
<summary>Details</summary>

- Validates retrieval of posts under a category, handles missing category errors (`404`), and server errors (`500`).
- [Flow Diagram](./6.%20Get%20Post%20By%20Category.png)

</details>

### 7. Search Posts by Title
<details>
<summary>Details</summary>

- Ensures retrieval of posts matching a title keyword and handles server errors (`500`).
- [Flow Diagram](./8.%20Search%20Post%20by%20Title%20ATG.png)

</details>

### 8. Get All Posts
<details>
<summary>Details</summary>

- Confirms successful retrieval of all posts with pagination and handles server errors (`500`).
- [Flow Diagram](./7.%20Get%20All%20Posts%20ATG.png)

</details>

</details>





Complete test case details and methodologies are documented in the test-cases directory.





---


  

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
