# JaCoCo Coverage Demo – Unit vs Integration Tests

This project is an **educational Spring Boot example** that demonstrates how **JaCoCo code coverage reports are generated based on real code execution**.

It shows, in a very explicit and observable way, how **unit tests and integration tests contribute differently to coverage**, and how **commenting or removing tests immediately changes the generated reports**.

The goal is **learning and experimentation**, not business logic complexity.

---

## 🎯 Project Goal

This project exists to demonstrate one core principle:

> **JaCoCo only measures code that is actually executed by tests.**

Using a minimal Spring Boot application, this repository allows you to:

- See how unit tests contribute to coverage
- See how integration tests affect controller coverage
- Observe how coverage changes when tests are commented or removed
- Understand why some classes appear (or disappear) from reports

---

## 🧩 Project Structure

### Production Code

- **`Calculator`**
  - Simple utility class with basic math operations
  - Covered exclusively by **unit tests**

- **`CustomController`**
  - Spring MVC `@RestController`
  - Exposes `POST /api/v1/test`
  - Covered only when an **HTTP request is executed** via integration tests

---

### Tests

#### ✅ Unit Test

**`CalculatorUnitTest`**
- Uses JUnit Jupiter (JUnit 5)
- Tests business logic directly
- Executed using `maven-surefire-plugin`
- Generates JaCoCo coverage for `Calculator`

---

#### ✅ Integration Test

**`JacocoIT`**
- Uses `@SpringBootTest` and `MockMvc`
- Performs a real (mocked) HTTP request
- Executes the Spring MVC pipeline
- Executed using `maven-failsafe-plugin`
- Responsible for covering the `CustomController`

---

## 🧪 Unit Tests vs Integration Tests

| Test Type | What is executed | What gets covered |
|---------|-----------------|------------------|
| Unit Tests | Plain Java logic | Utility / service classes |
| Integration Tests | Spring context + HTTP | Controllers and web layer |

⚠️ **Important:**  
A class being present in the project **does not guarantee coverage**.  
JaCoCo only records **executed bytecode**, not compiled or loaded code.

---

## 📊 JaCoCo Reports Generated

The project is configured to generate:

1. **Unit Test Coverage Report**
   - From unit tests only
   - Uses a dedicated `.exec` file

2. **Integration Test Coverage Report**
   - From integration tests only
   - Uses a separate `.exec` file

3. **Aggregated Coverage Report**
   - Merges unit + integration coverage
   - Represents total executed code

All reports are generated automatically during the Maven build.

---

## 🚀 How to Run

Run the full build (unit + integration tests + coverage):

```bash
mvn clean verify


JaCoCo Learning Experiments
==========================

This project was created as a learning tool to help understand how
JaCoCo code coverage works in practice.

IMPORTANT:
JaCoCo measures ONLY code that is actually executed by tests.
It does NOT measure:
- Existing classes
- Compiled code
- Loaded beans
- Application startup

It measures executed bytecode only.

The experiments below are designed to be simple, safe, and repeatable.
Run them in any order and observe how the coverage reports change.

--------------------------------------------------
HOW TO RUN THE PROJECT
--------------------------------------------------

Run the full build:

mvn clean verify

This will:
- Run unit tests (Surefire)
- Run integration tests (Failsafe)
- Generate JaCoCo execution files
- Merge coverage data
- Generate HTML reports

Reports are generated under the target directory.

--------------------------------------------------
EXPERIMENT 1 – REMOVE INTEGRATION TEST
--------------------------------------------------

Action:
Comment or remove the following class:

JacocoIT

Then run:

mvn clean verify

Expected Result:
- CustomController disappears from coverage reports
- Only unit-tested classes remain covered

What You Learn:
Controllers are only covered when an HTTP request is executed,
even if the controller exists and the application starts correctly.

--------------------------------------------------
EXPERIMENT 2 – COMMENT A UNIT TEST METHOD
--------------------------------------------------

Action:
In CalculatorUnitTest, comment a test method, for example:

multiply()

Then run:

mvn clean verify

Expected Result:
- Coverage for the multiply method changes
- The report reflects exactly what was not executed

What You Learn:
Coverage is tied to execution, not to method existence.

--------------------------------------------------
EXPERIMENT 3 – ADD A NEW ENDPOINT WITHOUT TESTS
--------------------------------------------------

Action:
1. Add a new endpoint to CustomController
2. Do NOT create any test for it
3. Run:

   mvn clean verify

Expected Result:
- The new endpoint appears with zero coverage
- The build still succeeds

What You Learn:
JaCoCo does not assume that code is used.
Execution is required for coverage.

--------------------------------------------------
EXPERIMENT 4 – REMOVE ALL INTEGRATION TESTS
--------------------------------------------------

Action:
Remove or comment all classes matching:

*IT.java

Then run:

mvn clean verify

Expected Result:
- Controllers are no longer covered
- Aggregated coverage drops

What You Learn:
Working applications are not necessarily covered applications.

--------------------------------------------------
EXPERIMENT 5 – RUN ONLY UNIT TESTS
--------------------------------------------------

Action:
Run only the test phase:

mvn clean test

Expected Result:
- Only unit-test coverage is available
- Controller is not covered

What You Learn:
Different Maven phases produce different coverage results.

--------------------------------------------------
FINAL CONCEPT
--------------------------------------------------

If something does NOT appear in the coverage report,
the correct question is NOT:

"Why is JaCoCo not covering this code?"

The correct question is:

"Which test actually executed this code?"

No execution = No coverage.
