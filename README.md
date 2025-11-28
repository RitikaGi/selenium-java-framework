# 🛒 E-Commerce Test Automation Framework

![Build Status](https://github.com/Ritika-Singh/SeleniumFramework/actions/workflows/maven-tests.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-8-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.17.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.9.0-red)
![Maven](https://img.shields.io/badge/Maven-3.x-blue)

A comprehensive end-to-end test automation framework for the Rahul Shetty Academy e-commerce practice website, built using Selenium WebDriver, TestNG, Cucumber BDD, and Maven.

---

## 📋 Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Test Execution Profiles](#test-execution-profiles)
- [Reports](#reports)
- [Test Scenarios](#test-scenarios)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

---

## ✨ Features

- 🎯 **Page Object Model (POM)** - Maintainable and scalable framework design
- 🔄 **Data-Driven Testing** - Parameterized test execution
- 🥒 **Cucumber BDD** - Behavior-driven development support
- ⚡ **Parallel Execution** - Faster test runs with TestNG
- 📊 **ExtentReports** - Beautiful HTML test reports
- 🔧 **WebDriverManager** - Automatic browser driver management
- 🏗️ **Maven Profiles** - Multiple test suite configurations
- 🌐 **Multi-Browser Support** - Chrome, Firefox, Edge
- 📸 **Auto Screenshots** - Captures on test failures
- ♻️ **Reusable Components** - DRY principle implementation

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 1.8 | Programming Language |
| Selenium WebDriver | 4.17.0 | Browser Automation |
| TestNG | 7.9.0 | Testing Framework |
| Cucumber | 7.22.0 | BDD Framework |
| Maven | 3.x | Build Tool |
| ExtentReports | 5.1.2 | Reporting |
| WebDriverManager | 5.6.3 | Driver Management |

---

## 📁 Project Structure
```
SeleniumFramework/
│
├── src/
│   ├── main/java/              # Page Objects, Utilities, Base Classes
│   │   └── pageObjects/        # POM classes
│   │   └── resources/          # Config files, test data
│   │   └── utilities/          # Helper classes
│   │
│   └── test/java/              # Test Classes
│       └── tests/              # TestNG test cases
│       └── stepDefinitions/    # Cucumber step definitions
│       └── testRunner/         # Cucumber test runners
│
├── testSuites/                 # TestNG XML files
│   ├── testng.xml              # Main regression suite
│   ├── Purchase.xml            # Purchase flow tests
│   └── ErrorValidation.xml     # Negative scenarios
│
├── reports/                    # ExtentReports output
├── screenshots/                # Test failure screenshots
├── target/                     # Maven build output
├── pom.xml                     # Maven configuration
└── README.md                   # This file
```

---

## 📦 Prerequisites

Ensure you have the following installed:

### Required
- **Java JDK** 8 or higher
```bash
  java -version
```

- **Apache Maven** 3.x
```bash
  mvn -version
```

- **Git**
```bash
  git --version
```

### Optional
- IDE (Eclipse/IntelliJ IDEA)
- Browsers (Chrome/Firefox/Edge)

---

## 🚀 Installation

### Step 1: Clone the Repository
```bash
git clone https://github.com/Ritika-Singh/SeleniumFramework.git
cd SeleniumFramework
```

### Step 2: Install Dependencies
```bash
mvn clean install -DskipTests
```

### Step 3: Verify Setup
```bash
mvn test -Dtest=SampleTest
```

---

## ▶️ Running Tests

### Basic Execution
```bash
# Run all tests
mvn clean test

# Run with specific profile
mvn clean test -P Regression
```

### Profile-Based Execution
```bash
# Regression Suite
mvn clean test -P Regression

# Purchase Flow Tests
mvn clean test -P Purchase

# Error Validation Tests
mvn clean test -P ErrorValidation

# Cucumber BDD Tests
mvn clean test -P CucumberTests
```

### Advanced Options
```bash
# Run specific test class
mvn test -Dtest=LoginTest

# Run specific test method
mvn test -Dtest=LoginTest#testValidLogin

# Run with specific browser
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox

# Run in headless mode
mvn test -Dheadless=true

# Parallel execution
mvn test -DthreadCount=3
```

---

## 🎯 Test Execution Profiles

| Profile Name | Description | Command |
|--------------|-------------|---------|
| **Regression** | Full regression test suite | `mvn test -P Regression` |
| **Purchase** | End-to-end purchase workflows | `mvn test -P Purchase` |
| **ErrorValidation** | Negative testing scenarios | `mvn test -P ErrorValidation` |
| **CucumberTests** | BDD feature file execution | `mvn test -P CucumberTests` |

### Profile Configuration
All profiles are configured in `pom.xml` using Maven Surefire Plugin.

---

## 📊 Reports

### ExtentReports (Primary)
Generated after every test execution:
```
Location: reports/ExtentReport.html
```

**Open Report:**
```bash
# Windows
start reports/ExtentReport.html

# Mac
open reports/ExtentReport.html

# Linux
xdg-open reports/ExtentReport.html
```

**Report Features:**
- Test execution summary
- Pass/Fail statistics
- Test duration metrics
- Screenshots for failures
- Exception stack traces
- Browser and environment details

### TestNG Default Reports
```
Location: test-output/index.html
```

### Failure Screenshots
Automatically captured screenshots:
```
Location: screenshots/
Format: TestName_timestamp.png
```

---

## 🧪 Test Scenarios

### ✅ Login Module
- Valid login with correct credentials
- Invalid login attempts
- Password field validations
- Remember me functionality
- Forgot password flow

### ✅ Product Catalog
- Product search functionality
- Filter by category
- Sort by price/name
- Product details page
- Add to cart

### ✅ Shopping Cart
- Add/Remove products
- Update quantity
- Cart total calculation
- Empty cart handling
- Continue shopping

### ✅ Checkout Process
- Billing information
- Shipping address
- Payment details
- Order review
- Order confirmation

### ✅ Negative Scenarios
- Empty field submissions
- Invalid data inputs
- Network timeout handling
- Payment failures
- Session timeout

---

## 🐛 Troubleshooting

### Common Issues & Solutions

#### Issue 1: WebDriver Not Found
```bash
Error: WebDriver executable not found
Solution: WebDriverManager handles this automatically. Check internet connection.
```

#### Issue 2: Element Not Found
```bash
Error: NoSuchElementException
Solution: Increase wait times or check element locators
```

#### Issue 3: Maven Dependencies
```bash
Error: Cannot resolve dependencies
Solution: 
mvn clean install -U
# or delete .m2 repository
rm -rf ~/.m2/repository
mvn clean install
```

#### Issue 4: Port Already in Use
```bash
Error: Port 4444 already in use
Solution: Kill existing processes or change port
```

#### Issue 5: Tests Failing Randomly
```bash
Reason: Flaky tests due to timing issues
Solution: Review explicit waits, avoid Thread.sleep()
```

### Debug Mode
```bash
# Run with debug logs
mvn test -X

# Run single test with detailed output
mvn test -Dtest=LoginTest -Dsurefire.printSummary=true
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

### How to Contribute

1. **Fork the repository**

2. **Create a feature branch**
```bash
   git checkout -b feature/amazing-feature
```

3. **Make your changes**
   - Follow existing code style
   - Add comments for complex logic
   - Update tests if needed

4. **Commit your changes**
```bash
   git commit -m "Add: Brief description of changes"
```

5. **Push to your fork**
```bash
   git push origin feature/amazing-feature
```

6. **Open a Pull Request**

### Coding Standards
- Use Page Object Model pattern
- Write meaningful test names
- Add proper assertions
- Handle exceptions appropriately
- Avoid hardcoded waits (Thread.sleep)

---

## 📚 Resources

### Official Documentation
- [Selenium WebDriver](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Cucumber Docs](https://cucumber.io/docs/cucumber/)
- [Maven Guide](https://maven.apache.org/guides/)

### Practice Website
- [Rahul Shetty Academy](https://rahulshettyacademy.com/client)

### Tutorials
- [Selenium Tutorial](https://www.selenium.dev/documentation/webdriver/)
- [TestNG Tutorial](https://testng.org/doc/documentation-main.html)
- [Maven Tutorial](https://maven.apache.org/guides/getting-started/)

---

## 📝 License

This project is licensed under the MIT License - see below for details:
```
MIT License

Copyright (c) 2024 Ritika Singh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 👨‍💻 Author

**Your Name**

- 📧 Email: ritikarajput055@gmail.com
- 💼 LinkedIn: [Your Profile](https://linkedin.com/in/ritikasingh-software-test-engineer/)
- 🐙 GitHub: [@Ritika-Singh](https://github.com/RitikaGi)

---

## ⭐ Show Your Support

If this project helped you, please consider giving it a ⭐️!

---

## 🔮 Future Enhancements

- [ ] Docker containerization for consistent test environment
- [ ] Allure reporting integration
- [ ] API testing module with REST Assured
- [ ] Database validation layer
- [ ] Performance testing with JMeter
- [ ] CI/CD pipeline with Jenkins
- [ ] Cloud execution on BrowserStack/Sauce Labs
- [ ] Mobile testing integration with Appium
- [ ] Email notifications for test results
- [ ] Slack integration for CI/CD alerts

---

## 📊 Project Statistics

![GitHub stars](https://img.shields.io/github/stars/Ritika-Singh/SeleniumFramework?style=social)
![GitHub forks](https://img.shields.io/github/forks/Ritika-Singh/SeleniumFramework?style=social)
![GitHub issues](https://img.shields.io/github/issues/Ritika-Singh/SeleniumFramework)
![GitHub pull requests](https://img.shields.io/github/issues-pr/Ritika-Singh/SeleniumFramework)

---

## 🙏 Acknowledgments

- [Rahul Shetty Academy](https://rahulshettyacademy.com/) for the practice website
- Selenium Community for excellent documentation
- All contributors who help improve this framework

---

**Last Updated:** November 2025

**Version:** 1.0.0
