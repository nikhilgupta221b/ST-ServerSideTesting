# Blogging Application Testing

This README provides a detailed overview of the testing process used for server side testing of a SpringBoot based Blogging application.

## Table of Contents
1. [Code Repository](#code-repository)
2. [Testing Tools Used](#testing-tools-used)
3. [Testing Strategy](#testing-strategy)
4. [Test Results](#test-results)
5. [Execution Instructions](#execution-instructions)
6. [Designed Test Cases](#designed-test-cases)

---

# Code Repository

The complete code repository used for testing can be accessed via the following link:

[Complete Code Repository](https://github.com/nikhilgupta221b/ST-ServerSideTesting)

---

# Testing Tools Used

The following tools were used to perform server-side testing:

- *JUnit 5*: For writing and running test cases.
- *Mockito*: For mocking dependencies like repositories.
- *JaCoCo*: For analyzing code coverage.

---

# Testing Strategy

The testing strategy for this project emphasizes comprehensive server-side testing of the service layer in the Spring Boot application. It ensures that the core business logic is thoroughly validated for accuracy, reliability, and seamless interaction with dependent components. The approach includes manual modeling, automated testing, and coverage analysis.

First CIM and ATG were made. Later using ATG, test cases were formed to cover all aspects of the graph.

## 1. Manual Modeling of Service Layer

- **Component Interaction Model (CIM)**:
  - Represents interactions between the service layer and dependent components like repositories and external APIs.
  - Helps identify key dependencies and points of interaction for effective test case design.

- **Application Transition Graph (ATG)**:
  - Models state transitions in the service layer during critical operations.
  - Provides a visual representation of application flow to ensure complete test coverage.

## 2. Test Case Design for Services

Service layer testing focused on verifying the following aspects:

- **Business Logic**:
  - Ensured that all service methods perform expected operations.
  - Validated inputs and outputs for correctness under different scenarios.

- **Repository Interactions**:
  - Used **Mockito** to mock repository calls.
  - Verified proper data persistence and retrieval processes.

- **Error Handling**:
  - Tested scenarios that trigger exceptions (e.g., `ResourceNotFoundException` for invalid IDs).
  - Ensured the application responds gracefully to unexpected inputs.

- **Boundary Cases**:
  - Designed test cases for edge scenarios like empty inputs, null values, and extremely large payloads.

## 3. Coverage Analysis

- **Tool Used**: **JaCoCo** was utilized to measure code coverage metrics for the service layer.
- **Coverage Metrics**:
  - **Lines of Code**: Ensured that each line in the service layer was executed during testing.
  - **Branches**: Verified that all branches in conditional logic were tested.
  - **Methods and Classes**: Ensured each method and class in the service layer was tested for functionality.

---

# Test Results

  ![image](https://github.com/user-attachments/assets/f4aa8290-0313-4416-be34-01005d22d123)

  - **Overall Coverage**:
  - Achieved **100% coverage** for all classes and methods in the `com.example.blogs.services.implementations` package.

- **Key Metrics**:
  - **Missed Instructions**: 0 of 899 instructions were missed, indicating all code paths were executed during testing.
  - **Missed Branches**: 0 of 6 branches were missed, confirming all conditional statements were tested.
  - **Missed Lines**: All 155 lines were tested, with no gaps in execution.
  - **Missed Methods**: None of the 56 methods were left untested.
  - **Classes**: Tested all 5 classes within the package.

- **Class-Specific Insights**:
  - **PostImplementation**:
    - Coverage: **100% for both instructions and branches**.
    - Lines of Code: Tested all 67 lines and 22 methods effectively.
  - **UserImplementation**:
    - Coverage: **100% for both instructions and branches**.
    - Lines of Code: Successfully tested all 49 lines and 16 methods.
  - **CategoryImplementation**:
    - Coverage: **100% instructions** (branches not applicable).
    - Lines of Code: All 17 lines and 10 methods tested.
  - **CommentImplementation**:
    - Coverage: **100% instructions** (branches not applicable).
    - Lines of Code: Covered all 9 lines and 5 methods.
  - **FileImplementation**:
    - Coverage: **100% for both instructions and branches**.
    - Lines of Code: Tested all 13 lines and 3 methods.

- **Complexity Analysis**:
  - The **Cyclomatic Complexity (Cxty)** across all classes totals to 59, indicating moderate complexity and well-structured code.

- **Conclusion**:
  - The report demonstrates comprehensive testing with no missed areas, ensuring robust validation of the service layer's functionality.

---

# Execution Instructions

Follow these steps to execute the tests and view the coverage report:

1. *Run Tests*:
   - For Maven:
     bash
     mvn clean verify
     
2. *View Coverage Report*:
   - Maven: target/site/jacoco/index.html

---

# Designed Test Cases

## **User**

#### **Contents:**
1. Create User  
2. Update User  
3. Delete User  
4. Get User by ID  
5. Get All Users  



#### **1. Create User**

- **Validations**:  
  Validates successful user creation and handles server errors (`500`).

- **CIM**  
  ![1. Create User CIM](https://github.com/user-attachments/assets/b0295abf-3c6e-46fe-98e9-5c7f6561c315)

- **ATG**  
  ![1. Create User ATG](https://github.com/user-attachments/assets/7fe2de66-6ece-4d97-8d09-7928ccddf557)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/a316ff8b-521b-4a81-9d76-1baa453008d7)



#### **2. Update User**

- **Validations**:  
  Tests user update functionality, missing user errors (`404`), and server errors (`500`).

- **CIM**  
  ![2. Update User CIM](https://github.com/user-attachments/assets/4961613f-f054-43f6-bae9-6d6843fb9768)

- **ATG**  
  ![2. Update User ATG](https://github.com/user-attachments/assets/a6c0916d-5227-42aa-a68f-e9bb5d781cae)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/ed1172c7-f056-4c90-b196-1cc9c333de2a)



#### **3. Delete User**

- **Validations**:  
  Ensures user deletion, handles non-existent user errors (`404`), and server errors (`500`).

- **CIM**  
  ![3. Delete User CIM](https://github.com/user-attachments/assets/8c610625-3e0e-425c-b46f-2d7afbcd6b81)

- **ATG**  
  ![3. Delete User ATG](https://github.com/user-attachments/assets/1b991804-a2b9-481a-aac1-43bd9bc350e6)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/38d474d7-62ca-4851-bd09-1f2cc3a4d2d1)



#### **4. Get User by ID**

- **Validations**:  
  Validates retrieval of a user by ID, missing user errors (`404`), and server errors (`500`).

- **CIM**  
  ![4. Get User by Id CIM](https://github.com/user-attachments/assets/504257c8-f2fa-4561-8261-b84d9fcf9978)

- **ATG**  
  ![4. Get User by Id ATG](https://github.com/user-attachments/assets/5a4af6f8-5ca2-46b3-97f2-9e203fb29dfb)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/2381a51f-0529-471a-a491-4f935bad3da8)



#### **5. Get All Users**

- **Validations**:  
  Confirms fetching all users and handles server errors (`500`).

- **CIM**  
  ![5. Get all Users CIM](https://github.com/user-attachments/assets/df8d8957-3fbf-42f3-bb8c-8fe6716ea60b)

- **ATG**  
  ![5. Get all Users ATG](https://github.com/user-attachments/assets/cada7b62-9c6e-43ce-b885-b57e70e776c7)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/531abc76-017c-4017-8a4b-e84b2ebf8100)



## **Post**

#### **Contents:**
1. Create Post  
2. Update Post  
3. Delete Post  
4. Get Post by ID  
5. Get Posts by User  
6. Get Posts by Category  
7. Get All Posts  
8. Search Posts by Title  



#### **1. Create Post**

- **Validations**:  
  Validates successful post creation, user existence, category existence, and handles server errors (`500`).

- **CIM**  
  ![1. Create Post CIM](https://github.com/user-attachments/assets/702953bd-a74c-4998-a5db-371896e6f08d)

- **ATG**  
  ![1. Create Post ATG](https://github.com/user-attachments/assets/0f88232a-300e-4846-a5b4-ab5226c5ea2d)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/b89c88a4-070b-4f1f-a4e6-77d7891d1a52)



#### **2. Update Post**

- **Validations**:  
  Tests post update functionality, validates post existence, category existence, and handles errors (`404`, `500`).

- **CIM**  
  ![2. Update Post CIM](https://github.com/user-attachments/assets/7e5e142d-0f56-4091-9805-3b2b220bf15d)

- **ATG**  
  ![2. Update Post ATG](https://github.com/user-attachments/assets/e34cf6f4-2cb4-4914-9e9a-c806337e589c)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/b8dc081a-c844-472f-948a-11dfb0147b9e)
  ![image](https://github.com/user-attachments/assets/75f2b8ac-7299-482f-8f37-0a689a689aac)



#### **3. Delete Post**

- **Validations**:  
  Ensures post deletion, validates post existence (`404`), and handles server errors (`500`).

- **CIM**  
  ![3. Delete Post CIM](https://github.com/user-attachments/assets/4dc433f1-c75f-41aa-ba7b-454c45bcf1af)

- **ATG**  
  ![3. Delete Post ATG](https://github.com/user-attachments/assets/a82fb939-c851-46ba-9d0f-4eea6b776119)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/0e9d8150-8816-4f8d-99df-d7f4f310007e)



#### **4. Get Post by ID**

- **Validations**:  
  Validates retrieval of a post by ID, ensures post existence, and handles errors (`404`, `500`).

- **CIM**  
  ![4. Get Post by ID CIM](https://github.com/user-attachments/assets/7ad586ab-110f-42a1-84ba-a2557c04a6c3)

- **ATG**  
  ![4. Get Post by ID ATG](https://github.com/user-attachments/assets/b8e46232-f300-4aa0-b3d0-475854f210fc)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/4cf43a32-5352-4c7b-890f-6d387f36f789)



#### **5. Get Posts by User**

- **Validations**:  
  Fetches posts associated with a user and handles errors (`404`, `500`).

- **CIM**  
  ![5. Get Posts by User CIM](https://github.com/user-attachments/assets/678f0cc7-6e6d-434a-aec0-9bc03a74a1a0)

- **ATG**  
  ![5. Get Posts by User ATG](https://github.com/user-attachments/assets/440a721e-1775-4d6e-8945-bad3d0c1d961)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/8fb4f63f-29a0-4d62-80cf-9252a60076be)



#### **6. Get Posts by Category**

- **Validations**:  
  Fetches posts by category and handles errors (`404`, `500`).

- **CIM**  
  ![6. Get Posts by Category CIM](https://github.com/user-attachments/assets/fee2a814-fcd8-47c7-81d3-a80b3b39b838)

- **ATG**  
  ![6. Get Posts by Category ATG](https://github.com/user-attachments/assets/a8098085-5a5a-4610-afa8-652c9d0a1d54)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/bc4a07ce-9433-4adc-86d9-e6c4398c94f0)



#### **7. Get All Posts**

- **Validations**:  
  Fetches all posts and handles server errors (`500`).

- **CIM**  
  ![7. Get All Posts CIM](https://github.com/user-attachments/assets/f69103c6-e17a-403a-8cd6-cb3544c37083)

- **ATG**  
  ![7. Get All Posts ATG](https://github.com/user-attachments/assets/ea3f7258-313a-4eac-8375-5b2d11b4bcd2)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/56954b7d-efb6-4aba-b24f-7d0fbc694c83)



#### **8. Search Posts by Title**

- **Validations**:  
  Searches for posts by title and handles errors (`500`).

- **CIM**  
  ![8. Search Post by Title CIM](https://github.com/user-attachments/assets/ecb45de1-c2ef-4cdb-b2a3-cb3324878a80)

- **ATG**  
  ![8. Search Post by Title ATG](https://github.com/user-attachments/assets/c44f26d0-1581-4034-a4e4-39949bc093a7)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/e97f263b-50e9-4655-bf20-fb3ee4786443)



## **Category**

#### **Contents:**
1. Create Category  
2. Update Category  
3. Delete Category  
4. Get Category by ID  
5. Get All Categories  



#### **1. Create Category**

- **Validations**:  
  Validates successful category creation and handles validation errors or server issues (`400`, `500`).

- **CIM**  
  ![1. Create Category CIM](https://github.com/user-attachments/assets/09d6ee0f-12e1-41fe-8915-23972aef89f9)

- **ATG**  
  ![1. Create Category ATG](https://github.com/user-attachments/assets/bc9756ac-7d67-4aa0-8b5b-cdfc7f9b1da4)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/d8432dc6-f876-4188-9651-a030cacb1736)



#### **2. Update Category**

- **Validations**:  
  Validates category existence and updates details; handles errors (`404`, `400`, `500`).

- **CIM**  
  ![2. Update Category CIM](https://github.com/user-attachments/assets/75f93c0a-0b1a-4997-9899-2d5e977727df)

- **ATG**  
  ![2. Update Category ATG](https://github.com/user-attachments/assets/1faa20af-bd9f-4cab-9c64-08a7de6a738e)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/e051f9b2-e8a9-49ef-96f8-7d1fa61501ab)
  ![image](https://github.com/user-attachments/assets/c69ec9eb-3fa8-4594-a094-db56bda025d9)



#### **3. Delete Category**

- **Validations**:  
  Validates category existence and ensures successful deletion; handles errors (`404`, `500`).

- **CIM**  
  ![3. Delete Category CIM](https://github.com/user-attachments/assets/9a64a9ed-3416-419e-b057-e021313ad119)

- **ATG**  
  ![3. Delete Category ATG](https://github.com/user-attachments/assets/80252a68-d73b-4775-ac76-84a35aeef5b4)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/83e0b2c0-72a8-46fd-874a-9638c60b5e5a)



#### **4. Get Category by ID**

- **Validations**:  
  Retrieves category by ID; validates existence and handles errors (`404`, `500`).

- **CIM**  
  ![4. Get Category by ID CIM](https://github.com/user-attachments/assets/62209042-9433-4031-a391-da992fea212b)

- **ATG**  
  ![4. Get Category by ID ATG](https://github.com/user-attachments/assets/88498b28-598b-4da6-92a5-3526387044d8)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/60af0bd7-3066-42db-842f-6ecabe3999c3)



#### **5. Get All Categories**

- **Validations**:  
  Fetches all categories; ensures successful retrieval (`200`) or handles errors (`500`).

- **CIM**  
  ![5. Get All Categories CIM](https://github.com/user-attachments/assets/9a5836ef-d0fd-4e1e-9c32-117d7d5348bc)

- **ATG**  
  ![5. Get All Categories ATG](https://github.com/user-attachments/assets/7ed9c8e9-a63e-4b68-a81c-cb8adb1ebb0d)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/1888bfe5-7847-42a2-98fd-2c2c98dca0e8)



## **Comment**

#### **Contents:**
1. Create Comment  
2. Delete Comment  



#### **1. Create Comment**

- **Validations**:  
  Validates post existence and saves the comment; handles errors (`404`, `500`).

- **CIM**  
  ![1. Create Comment CIM](https://github.com/user-attachments/assets/8e3768e5-47f0-47cd-bbc3-0b4a1a36ccf4)

- **ATG**  
  ![1. Create Comment ATG](https://github.com/user-attachments/assets/243c2005-de74-4411-9525-4109d285c66c)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/7b6f7b8b-d8bd-4598-a3a2-c5fa445aa001)



#### **2. Delete Comment**

- **Validations**:  
  Validates comment existence and deletes it successfully; handles errors (`404`, `500`).

- **CIM**  
  ![2. Delete Comment CIM](https://github.com/user-attachments/assets/33c5d212-894b-48fc-8f7d-de964f69e84e)

- **ATG**  
  ![2. Delete Comment ATG](https://github.com/user-attachments/assets/4613c245-d9ba-4d00-8db6-c2108189dcc5)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/bf8d7622-b4fb-4450-b9cc-9b6805f31280)



## **Image**

#### **Contents:**
1. Upload Image  
2. Download Image  



#### **1. Upload Image**

- **Validations**:  
  Validates post existence and uploads the image to the server; handles errors (`404`, `500`).

- **CIM**  
  ![1. Upload Image CIM](https://github.com/user-attachments/assets/9bfd71d4-8d75-45e4-933b-4fd6e5e7473a)

- **ATG**  
  ![1. Upload Image ATG](https://github.com/user-attachments/assets/cc36305f-149d-4a50-8e3f-8dc4635191c8)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/7596ad9b-ffd2-454a-87e1-f522c3938f68)
  ![image](https://github.com/user-attachments/assets/335144ef-3751-4fc7-a705-ec0524fa89b8)



#### **2. Download Image**

- **Validations**:  
  Validates image existence and retrieves the image from the server; handles errors (`404`, `500`).

- **CIM**  
  ![2. Download Image CIM](https://github.com/user-attachments/assets/47eb7e23-3f30-462c-a112-e63e665f4842)

- **ATG**  
  ![2. Download Image ATG](https://github.com/user-attachments/assets/028cc8ed-f3af-40ab-bb6e-ec2d2f4088b6)

- **Test Cases**  
  ![image](https://github.com/user-attachments/assets/48ebc025-aa09-42b3-a6a2-138f7646a0d4)

---
