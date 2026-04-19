# Problem Statement 6: InternetBot – Selenium-Java Test Automation Framework for an Advanced Selenium Challenges Site

## Project Overview

**ElementMaster** is a Selenium-based automation testing framework built using **Java, TestNG, and Maven**.
The framework is designed to automate and validate different web elements and user interactions on the practice site:


## Application Under Test

👉 https://the-internet.herokuapp.com

This project demonstrates a **scalable, reusable, and maintainable automation framework** using the **Page Object Model (POM)** design pattern.

---

## Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Framework:** TestNG
* **Build Tool:** Maven
* **Reporting:** Extent Reports
* **Driver Management:** WebDriverManager

---

## Project Structure

```
ElementMaster/
│
├── src/
│   └── test/
│       │
│       ├── java/
│       │   │
│       │   ├── base/
│       │   │   ├── BaseTest.java        
│       │   │   │   → Handles browser setup & teardown using @BeforeMethod and @AfterMethod
│       │   │   │   → Initializes WebDriver using DriverFactory
│       │   │   │   → Opens base URL from config.properties
│       │   │   │
│       │   │   └── BasePage.java        
│       │   │       → Contains reusable methods like click(), type(), getText()
│       │   │       → Implements WebDriverWait (NO Thread.sleep)
│       │   │       → Parent class for all Page classes
│       │   │
│       │   ├── pages/
│       │   │   ├── LoginPage.java       
│       │   │   │   → Locators for login page elements
│       │   │   │   → Methods: login(), getMessage(), clickLogout()
│       │   │   │   → Returns data for verification (NO assertions here)
│       │   │   │
│       │   │   ├── AlertsPage.java      
│       │   │   │   → Handles JS Alert, Confirm, Prompt
│       │   │   │   → Methods: acceptAlert(), dismissAlert(), enterText()
│       │   │   │   → Returns alert result text
│       │   │   │
│       │   │   ├── CheckBoxPage.java    
│       │   │   │   → Handles checkbox interactions
│       │   │   │   → Methods: clickCheckbox1(), isSelected()
│       │   │   │
│       │   │   ├── DropdownPage.java    
│       │   │   │   → Handles dropdown using Select class
│       │   │   │   → Methods: selectOption(), getSelectedOption(), getOptionsCount()
│       │   │   │
│       │   │   ├── UploadPage.java      
│       │   │   │   → Handles file upload functionality
│       │   │   │   → Methods: uploadFile(), getUploadedFileName()
│       │   │   │   → Verifies UI elements before upload
│       │   │   │
│       │   │   └── DynamicPage.java     
│       │   │       → Handles dynamic loading elements
│       │   │       → Uses WebDriverWait for visibility
│       │   │       → Methods: clickStart(), getLoadedText()
│       │   │
│       │   ├── tests/
│       │   │   ├── LoginTest.java       
│       │   │   │   → Test cases for authentication
│       │   │   │   → Verifies valid login, invalid login, logout
│       │   │   │   → Uses assertions + console logs
│       │   │   │
│       │   │   ├── AlertsTest.java      
│       │   │   │   → Tests JS alerts functionality
│       │   │   │   → Verifies alert accept, dismiss, prompt input
│       │   │   │
│       │   │   ├── CheckboxTest.java    
│       │   │   │   → Tests checkbox selection & toggle behavior
│       │   │   │
│       │   │   ├── DropdownTest.java    
│       │   │   │   → Tests dropdown selection and option count
│       │   │   │
│       │   │   ├── UploadTest.java      
│       │   │   │   → Tests file upload functionality
│       │   │   │   → Verifies uploaded filename and UI
│       │   │   │
│       │   │   └── DynamicTest.java     
│       │   │       → Tests dynamic loading elements
│       │   │       → Verifies "Hello World!" text after wait
│       │   │       → Handles disappearing elements
│       │   │
│       │   ├── utils/
│       │   │   ├── ConfigReader.java    
│       │   │   │   → Reads values from config.properties
│       │   │   │   → Provides browser, URL, timeout values
│       │   │   │
│       │   │   ├── DriverFactory.java   
│       │   │   │   → Initializes WebDriver using WebDriverManager
│       │   │   │   → Supports Chrome/Firefox based on config
│       │   │   │
│       │   │   ├── ExtentManager.java   
│       │   │   │   → Creates ExtentReports instance
│       │   │   │   → Configures report name, title, system info
│       │   │   │
│       │   │   ├── ScreenshotUtil.java  
│       │   │   │   → Captures screenshot using TakesScreenshot
│       │   │   │   → Saves file in reports/screenshots/
│       │   │   │
│       │   │   └── TestListener.java    
│       │   │       → Implements ITestListener
│       │   │       → Captures screenshot on failure
│       │   │       → Logs results in Extent Report
│       │
│       └── resources/
│           ├── config.properties       
│           │   → Stores browser, base URL, timeout, credentials
│           │
│           ├── testng.xml              
│           │   → Defines test suite
│           │   → Includes all test classes
│           │   → Configures Listener
│           │
│           └── test-data/              
│               ├── sample.txt          
│               │   → Valid file for upload testing
│               │
│               └── sample.exe          
│                   → Fake invalid file (renamed) for testing
│
├── reports/
│   ├── ExtentReport.html              
│   │   → HTML report showing test results
│   │
│   └── screenshots/                  
│       → Stores screenshots for failed tests
│
├── test-output/                      
│   → Auto-generated TestNG reports
│   → Contains index.html and summary
│
├── pom.xml                           
│   → Maven dependencies (Selenium, TestNG, ExtentReports)
│
└── README.md                         
    → Project documentation and usage guide
```

---

##  Test Modules Covered

###  Module 1: Authentication

* Valid login verification
* Invalid login handling
* Success message validation
* Logout functionality

---

###  Module 2: JavaScript Alerts

* JS Alert handling
* JS Confirm (dismiss)
* JS Prompt (input validation)
* Result text verification

---

###  Module 3: Checkbox & Dropdown

* Checkbox selection & toggle validation
* Dropdown selection verification
* Dropdown options count validation

---

### Module 4: File Upload

* File upload verification
* Unsupported file handling
* UI validation before upload

---

### Module 5: Dynamic Loading

* Dynamic element handling using waits
* Loaded text verification
* Disappearing elements validation

---

##  Must-Have Requirements Implemented

✔ Page Object Model (POM)
✔ TestNG framework with annotations
✔ Data-driven testing using @DataProvider
✔ WebDriverManager (no manual driver setup)
✔ Configuration using `config.properties`
✔ Explicit waits using `WebDriverWait`
✔ No usage of `Thread.sleep()`
✔ Screenshot capture using `ITestListener`
✔ Extent Report generation

---

##  Good-to-Have Features Implemented

✔ Parallel Test Execution (TestNG)
✔ Clean reusable methods (BasePage utilities)
✔ Organized folder structure
✔ Meaningful logging using `System.out.println()`
✔ Dynamic test handling
✔ Modular and scalable framework

---

##  Screenshot on Failure

* Screenshots are automatically captured using **ITestListener** whenever a test fails
* Stored in:

```
reports/screenshots/
```

---

## Extent Report

After execution, a detailed HTML report is generated:

```
reports/ExtentReport.html
```

### Report includes:

* Test name
* Pass/Fail status
* Error details
* Screenshots (on failure)

---

## Configuration

### config.properties

```
browser=chrome
baseUrl=https://the-internet.herokuapp.com/login
timeout=10
```

---

##  How to Run the Project

### 🔹 Using Maven

```bash
mvn clean test
```

### 🔹 Using TestNG

Right Click on `testng.xml` and select run as and choose TestNGSuite

---

##  Parallel Execution

Parallel testing is enabled using TestNG:

```xml
<suite name="ElementMaster Suite" parallel="tests" thread-count="5">
```

This allows multiple test modules to run simultaneously, improving execution speed.

---

##  Key Highlights

* Clean and maintainable framework design
* Strong use of POM architecture
* Robust synchronization using explicit waits
* Automated reporting with screenshots
* Scalable for real-world applications

---

##  Author

**Bhavya Sree Kasa**

---

##  Conclusion

This project demonstrates a **complete Selenium automation framework** with real-world features such as reporting, failure handling, and modular design, making it suitable for both **learning and professional use**.

---
