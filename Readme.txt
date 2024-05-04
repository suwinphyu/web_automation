<Version 1.0>

Project Name - assignment
version - 1.0.0 RELEASE 
Java Version - Oracle Open JDK version 11.0.2

Test automation framework based on:
 - Selenium WebDriver (v 4.14.1)
 - TestNG (v 6.14.2)
 - Maven (v 3.10.1)
 - ExtentReports (v 5.0.8)
 - Log4j2 (v 2.20.0)



Configuration
-------------
assignment\src\test\resources\TestData.json => All test data are setup in TestData.json
assignment\src\test\resources\Config.properties => All test url are put in Config.properties
assignment\src\test\resources\RunSetup.csv => All testable methods are configured in RunSetup.csv


Run Steps
----------
1. To start project, please run this file - assignment\testng.xml
Able to change browser value in <parameter name="browser"  value="edge"> of testng.xml

2. To check screenshot for FAILED case in assignment\Screenshots

3. To check report - assignment\ExtentReports


Web Driver Version
-------------------
msedgedriverVersion: 118.0.2088.57
chromedriverVersion: 118.0.5993.70
geckodriverVersion: 0.33.0