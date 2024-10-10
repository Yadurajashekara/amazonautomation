# Amazon Automation - Selenium Task (Java)

This project automates tasks on Amazon India using Java and Selenium WebDriver with Chrome. The script searches for wristwatches, applies filters, navigates pages, and adds a product to the cart.

## Table of Contents

1.Overview
2.Technologies
3.Setup
4.Usage
5.Code
6.Contributing

### OVERVIEW

This automation script performs the following tasks:

1.Searches for "Wrist Watches" on Amazon India.
2.Filters by "Leather" under Watch Band Material.
3.Selects "Fastrack" as the brand.
4.Navigates to the 2nd page of results.
5.Adds the first product in the 1st row to the cart.

#### TECNOLOGIES

1.Java (JDK 8 or later)
2.Selenium WebDriver
3.ChromeDriver
4.Maven (for dependency management)
5.JUnit/TestNG (optional for testing)

##### SETUP

Prerequisites

1.Java JDK installed
2.Chrome browser installed
3.ChromeDriver installed and added to PATH

###### INSTALLATION

1.Clone the repository:

bash
git clone <repository-url>

2.Import the project into an IDE (like IntelliJ IDEA or Eclipse).

Add the following dependencies to pom.xml (if using Maven):

<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.x.x</version>
    </dependency>
</dependencies>

4.Ensure ChromeDriver is set up correctly or adjust the path in your script:

System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

### Usage

1.Compile and run the Java class AmazonAutomationWithExplicitWait:

javac AmazonAutomationWithExplicitWait.java
java AmazonAutomationWithExplicitWait

2.The script will open Chrome, search for wristwatches, apply the required filters, and add a product to the cart.

######## EXAMPLE CODE

WebDriver driver = new ChromeDriver();
driver.get("https://www.amazon.in");

// Search for "Wrist Watches"
WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
searchBox.sendKeys("Wrist Watches");
searchBox.submit();

######### CODE

The key part of the Selenium script is the use of explicit waits to ensure that the page elements are interactable before performing actions:

java

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement leatherFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Leather']")));
leatherFilter.click();

######### CONTRIBUTING

1.Fork the repository.
2.Create a branch (feature-branch).
3.Commit your changes (git commit -m 'Add feature').
4.Push to the branch (git push origin feature-branch).
5.Open a pull request.
