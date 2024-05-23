# What is this repository about?
This repo contains the end-to-end automation testing framework for OpenCart E-commerce website : [OpenCart](https://naveenautomationlabs.com/opencart/index.php?route=common/home). I have used the `Page Object Model` pattern + `TestNG Dataproviders` for this framework.

## Libraries and Technologies used :
![Static Badge](https://img.shields.io/badge/BuildManagementTool-Maven-Green)              

![Static Badge](https://img.shields.io/badge/Language-Java11-blue)       

![Static Badge](https://img.shields.io/badge/TestingFramework-TestNG-Green)

![Static Badge](https://img.shields.io/badge/Library-Selenium4.20-blue)

![Static Badge](https://img.shields.io/badge/CI-Jenkins-grey)

![Static Badge](https://img.shields.io/badge/Services-Docker-blue)

## Scenario included :
* Register as a new user
* Login as an existing user
* Search a product
* Add products to cart
* Add Checkout details -- for first time users
* Add Checkout details -- for returning users
* Checkout cart 
* Forgot password reset

## Selenium and Java APIs used :
- `WebDriver` `RemoteWebDriver`
- `WebElement` `By` `Select` `WebDriverWait`
- `ArrayList` `HashMap` `LinkedHashSet`

## Cross browser testing :

Tests run on `Chrome`, `Edge` and `Firefox` browsers on both local and remote machines.

## Parallel testing :
I have used `Docker` as a service for configuring the `Selenium GRID` for parallel execution of tests on different browsers.

- Docker GRID running on : `http://localhost:4444/wd/hub`

### Test results :
Below is an example Extent report screenshot for all the tests run :
