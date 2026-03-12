# Selenium TestNG Automation Framework

A Java-based UI automation framework using Selenium WebDriver, TestNG, Maven, and GitHub Actions.

## Project Structure

This project contains two main test suites:

- `another.com.ecommerce.tests` → main portfolio suite
- `another.com.demoqa.tests` → practice / experimental suite

The **ecommerce suite** is the primary suite used for CI by default.

---

## Tech Stack

- Java 21
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- GitHub Actions

---

## Prerequisites

Before running this project locally, make sure you have:

- Java 21 installed
- Git installed
- Maven Wrapper files present in the project root:
    - `mvnw`
    - `mvnw.cmd`
    - `.mvn/`

> On Windows, use `mvnw.cmd` or `.\mvnw`
>
> On Mac/Linux, use `./mvnw`

---

## How to Run Tests Locally

### Run the ecommerce suite

#### Windows PowerShell

```powershell
.\mvnw clean test -Dtest="another.com.ecommerce.tests.**"