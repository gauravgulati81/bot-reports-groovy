import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def reportsDirectory = "/Users/username/Documents/AutomationReports/"

Mobile.startApplication('/Users/username/Desktop/app-universal-release.apk', false)

if (Mobile.verifyElementVisible(findTestObject('splash screen'), 10, FailureHandling.CONTINUE_ON_FAILURE)){
	CustomKeywords.'customReports.Reporting.setTestCasePass'(reportsDirectory, "Validating visibility of splash screen")
}
else {
	CustomKeywords.'customReports.Reporting.setTestCaseFail'(reportsDirectory, "Validating visibility of splash screen")
}


if (Mobile.verifyElementVisible(findTestObject('Update available - CANCEL button'), 30, FailureHandling.OPTIONAL)){
	Mobile.tap(findTestObject('Update available - CANCEL button'), 10)
}

CustomKeywords.'customReports.Reporting.validateCondition'(Mobile.verifyElementVisible(findTestObject('Search icon'), 5, FailureHandling.CONTINUE_ON_FAILURE), reportsDirectory, "Validating presence of search icon")

CustomKeywords.'customReports.Reporting.validateCondition'(Mobile.verifyElementVisible(findTestObject('bottom nav movies icon'), 5, FailureHandling.CONTINUE_ON_FAILURE), reportsDirectory, "Validating presence of the Movies icon")

CustomKeywords.'customReports.Reporting.validateCondition'(Mobile.verifyElementVisible(findTestObject('bottom nav news icon'), 5, FailureHandling.CONTINUE_ON_FAILURE), reportsDirectory, "Validating presence of the News icon")

if (Mobile.verifyElementVisible(findTestObject('bottom nav more icon'), 10, FailureHandling.CONTINUE_ON_FAILURE)){
	CustomKeywords.'customReports.Reporting.setTestCasePass'(reportsDirectory, "Validating presence of the More icon")
}
else {
	CustomKeywords.'customReports.Reporting.setTestCaseBlocked'(reportsDirectory, "Validating presence of the More icon")
}

CustomKeywords.'customReports.Reporting.generateHTMLReport'(reportsDirectory)
