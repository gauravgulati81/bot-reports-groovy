# bot-reports-groovy
Generate csv and html test reports for groovy based (e.g. Katalon Studio) automation scripts

Usage:

For Katalon Studio:

1. Launch the project, and right click on "Keywords".

2. Create new package (e.g. customReports).

3. Right click on the package and create a new keyword (e.g. Reporting).

4. Paste the content of Reporting.groovy from the repository into the new keyword created.


Methods:
- validateCondition(boolean condition, String reportsDirectory, String testSummary): Mark a test PASS/FAIL based on a condition. Returns nothing.

-- condition: Test condition to be validated. PASS will be marked in the report if the condition if true. FAIL will be marked in the report if the condition is false.

-- reportsDirectory: Directory where the csv report will be generated.

-- testSummary: String entered here will be will be used for test summary in the report.


- setTestCasePass(String reportsDirectory, String testSummary): Explicitly mark a test PASS. Returns nothing.

-- reportsDirectory: Directory where the csv report will be generated.

-- testSummary: String entered here will be will be used for test summary in the report.


- setTestCaseFail(String reportsDirectory, String testSummary): Explicitly mark a test FAIL. Returns nothing.

-- reportsDirectory: Directory where the csv report will be generated.

-- testSummary: String entered here will be will be used for test summary in the report.


- setTestCaseBlocked(String reportsDirectory, String testSummary): Explicitly mark a test BLOCKED. Returns nothing.

-- reportsDirectory: Directory where the csv report will be generated.

-- testSummary: String entered here will be will be used for test summary in the report.


Executing any/all of the above methods will write the results in a csv file.


- generateHTMLReport(String reportsDirectory): Call this method after the above methods have been executed, to generate the html report. Returns nothing.

-- reportsDirectory: Directory where the html report will be generated.


Refer SampleTestCase.groovy for sample implementation.

Refer SampleCSVReport.csv and SampleHTMLReport.html for sample reports.
