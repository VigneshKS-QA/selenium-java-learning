# Books to Scrape – E2E Automation Project

This is a self-made automation framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**, designed to test the [Books to Scrape](http://books.toscrape.com/) demo site.

---

## Features

- Page Object Model design
- Multi-browser support (Chrome, Edge, Firefox)
- Retry mechanism for flaky tests
- Screenshot capture on failure
- Parallel test execution
- Extent & TestNG reports generation

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- ExtentReports

---

## How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/VigneshKS-QA/selenium-java-learning.git
   cd selenium-java-learning/Project_BooksScrapeAutomation

2. Choose your browser: "Edit src/test/resources/GetDriver.properties:" browser=chrome (Supported: chrome, firefox, edge)

3. mvn clean test

Test Reports: Open reports/index.html

##Project Structure:
Project_BooksScrapeAutomation/
├── src/
│   └── test/
│       ├── java/
│       │   ├── AbstractComponents/
│       │   ├── PageObject/
│       │   ├── Test/
│       │   └── Base/
│       └── resources/
│           └── GetDriver.properties
├── reports/
├── test-output/
├── pom.xml
└── README.md
	